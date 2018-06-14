// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless

import cats._
import cats.effect.Sync
import cats.implicits._
import doobie.{ Query0, Update }
import doobie.tagless.jdbc._
import doobie.enum._
import fs2.{ Sink, Stream }

final case class Connection[F[_]](jdbc: JdbcConnection[F], interp: Interpreter[F]) {

  /** Prepare a statement, yielding a PreparedStatement[F] that will be cleaned up. */
  @SuppressWarnings(Array("org.wartremover.warts.DefaultArguments"))
  def prepareStatement(
    sql: String,
    resultSetType:        ResultSetType        = ResultSetType.TypeForwardOnly,
    resultSetConcurrency: ResultSetConcurrency = ResultSetConcurrency.ConcurReadOnly,
    resultSetHoldability: Holdability          = Holdability.CloseCursorsAtCommit
  )(
    implicit ev: Functor[F]
  ): Stream[F, PreparedStatement[F]] =   // ok in cats-effect/fs2 1.0 this will be Resource[F, PreparedStatement[F]]
    Stream.bracket(jdbc.prepareStatement(
      sql,
      resultSetType.toInt,
      resultSetConcurrency.toInt,
      resultSetHoldability.toInt
    ).map(interp.forPreparedStatement))(Stream(_), _.jdbc.close)

  /** Stream the results of the specified `Query0`, reading a `chunkSize` rows at a time. */
  def stream[A](q: Query0[A], chunkSize: Int)(
    implicit ev: Sync[F]
  ): Stream[F, A] =
    for {
      ps <- prepareStatement(q.sql)
      // doh! we're not setting the params!
      _  <- Stream.eval(ps.jdbc.setFetchSize(chunkSize))
      rs <- ps.executeQuery
      b  <- rs.stream[A](chunkSize)(q.read, ev)
    } yield b

  /** A sink that consumes values of type `A`. */
  def sink[A](u: Update[A])(
    implicit ev: Sync[F]
  ): Sink[F, A] = sa =>
    prepareStatement(u.sql).flatMap(_.sink(u.write, ev)(sa))

}
