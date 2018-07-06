// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless

import cats._
import cats.effect._
import cats.implicits._
import doobie.tagless.async._
import fs2.Stream
import fs2.Stream.eval_
import org.slf4j.LoggerFactory
import java.sql

@SuppressWarnings(Array("org.wartremover.warts.Overloading"))
final case class Transactor[F[_]](
  interp:   Interpreter[F],
  strategy: Strategy[F],
  source:   F[java.sql.Connection],
) {

  def connect(implicit ev: Functor[F]): Resource[F, Connection[F]] =
    Resource.make(source.map(interp.forConnection))(_.jdbc.close)

  /**
   * Apply a `Connection[F]` to `f`, with transaction handling as defined by `strategy`, yielding a
   * computation `F[A]` that will execute on `rts.io`, shifting back to `rts.cpu` on exit.
   */
  def transact[A](f: Connection[F] => F[A])(implicit ev: Bracket[F, _]): F[A] =
    connect.use { c =>
      strategy.before(c) *> f(c) <* strategy.after(c)
    }

  /**
   * Apply a `Connection[F]` to `f`, with transaction handling as defined by `strategy`, yielding a
   * `Stream[F, A]` that will execute on `rts.io`, shifting back to `rts.cpu` on termination.
   */
  def transact[A](f: Connection[F] => Stream[F, A])(implicit ev: Functor[F]): Stream[F, A] =
    Stream.resource(connect).flatMap { c =>
      eval_(strategy.before(c)) ++ f(c) ++ eval_(strategy.after(c))
    }

}

object Transactor {

    @SuppressWarnings(Array("org.wartremover.warts.Overloading"))
    object fromDriverManager {

      @SuppressWarnings(Array("org.wartremover.warts.NonUnitStatements"))
      private def create[M[_]: Async](driver: String, conn: => sql.Connection): Transactor[M] =
        Transactor(
          Interpreter.default[M],
          Strategy.default[M],
          Sync[M].delay { Class.forName(driver); conn }
        )

      def apply[M[_]: Async](driver: String, url: String): Transactor[M] =
        create(driver, sql.DriverManager.getConnection(url))

      def apply[M[_]: Async](driver: String, url: String, user: String, pass: String): Transactor[M] =
        create(driver, sql.DriverManager.getConnection(url, user, pass))

      def apply[M[_]: Async](driver: String, url: String, info: java.util.Properties): Transactor[M] =
        create(driver, sql.DriverManager.getConnection(url, info))

    }

}