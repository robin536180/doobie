// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless

import cats._
import cats.effect.{ Resource, Sync }
import cats.implicits._
import doobie.{ Query0, Update }
import doobie.tagless.jdbc._
import doobie.enum._
import fs2.{ Sink, Stream }

final case class Connection[F[_]](jdbc: JdbcConnection[F], interp: Interpreter[F]) {

  /** Prepare a statement. */
  @SuppressWarnings(Array("org.wartremover.warts.DefaultArguments"))
  def prepareStatement(
    sql: String,
    resultSetType:        ResultSetType        = ResultSetType.TypeForwardOnly,
    resultSetConcurrency: ResultSetConcurrency = ResultSetConcurrency.ConcurReadOnly,
    resultSetHoldability: Holdability          = Holdability.CloseCursorsAtCommit
  )(implicit ev: Functor[F]): Resource[F, PreparedStatement[F]] =
    Resource.make(jdbc.prepareStatement(
      sql,
      resultSetType.toInt,
      resultSetConcurrency.toInt,
      resultSetHoldability.toInt
    ).map(interp.forPreparedStatement))(_.jdbc.close)

  /** Stream the results of the specified `Query0`, reading a `chunkSize` rows at a time. */
  def stream[A](q: Query0[A], chunkSize: Int)(implicit ev: Sync[F]): Stream[F, A] =
    for {
      ps <- Stream.resource(prepareStatement(q.sql))
      // doh! we're not setting the params!
      _  <- Stream.eval(ps.jdbc.setFetchSize(chunkSize))
      rs <- Stream.resource(ps.executeQuery)
      b  <- rs.stream[A](chunkSize)(q.read, ev)
    } yield b

  /** A sink that consumes values of type `A`. */
  def sink[A](u: Update[A])(implicit ev: Sync[F]): Sink[F, A] = sa =>
    Stream.resource(prepareStatement(u.sql)).flatMap(_.sink(u.write, ev)(sa))

}
