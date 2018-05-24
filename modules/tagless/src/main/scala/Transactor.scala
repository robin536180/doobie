// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless

import cats._
import cats.effect._
import cats.implicits._
import doobie.tagless.sync._
import fs2.Stream
import fs2.Stream.{ bracket, emit, eval_ }
import java.sql

@SuppressWarnings(Array("org.wartremover.warts.Overloading"))
final case class Transactor[F[_]](
  interp:   Interpreter[F],
  strategy: Strategy[F],
  source:   F[java.sql.Connection]
) {

  def connect(implicit ev: FlatMap[F]): Stream[F, Connection[F]] =
    bracket(source.map(interp.forConnection))(
      c => eval_(strategy.before(c)) ++ emit(c) ++ eval_(strategy.after(c)),
      strategy.always
    )

  def transact[A](f: Connection[F] => F[A])(
    implicit ev: Sync[F]
  ): F[A] =
    connect.evalMap(f).compile.last.map(_.getOrElse(sys.error("unpossible")))

  def transact[A](f: Connection[F] => Stream[F, A])(
    implicit ev: FlatMap[F]
  ): Stream[F, A] =
    connect.flatMap(f)

}

object Transactor {

    @SuppressWarnings(Array("org.wartremover.warts.Overloading"))
    object fromDriverManager {

      @SuppressWarnings(Array("org.wartremover.warts.NonUnitStatements"))
      private def create[M[_]: Sync](driver: String, conn: => sql.Connection): Transactor[M] =
        Transactor(
          Interpreter(SyncInterpreter[M]),
          Strategy.default[M],
          Sync[M].delay { Class.forName(driver); conn }
        )

      def apply[M[_]: Sync](driver: String, url: String): Transactor[M] =
        create(driver, sql.DriverManager.getConnection(url))

      def apply[M[_]: Sync](driver: String, url: String, user: String, pass: String): Transactor[M] =
        create(driver, sql.DriverManager.getConnection(url, user, pass))

      def apply[M[_]: Sync](driver: String, url: String, info: java.util.Properties): Transactor[M] =
        create(driver, sql.DriverManager.getConnection(url, info))

    }

}