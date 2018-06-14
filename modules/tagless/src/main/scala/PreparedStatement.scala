// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless

import cats._
import cats.effect.Sync
import cats.implicits._
import doobie.Write
import doobie.tagless.jdbc._
import fs2.{ Pipe, Sink, Stream }
import java.sql

final case class PreparedStatement[F[_]](jdbc: JdbcPreparedStatement[F], interp: Interpreter[F]) {

  private val raw: F[sql.PreparedStatement] =
    jdbc.unwrap(Predef.classOf[sql.PreparedStatement])

  /** Execute this statement as a query, yielding a ResultSet[F] that will be cleaned up. */
  def executeQuery(
    implicit ev: Functor[F]
  ): Stream[F, ResultSet[F]] =
    Stream.bracket(jdbc.executeQuery.map(interp.forResultSet))(Stream(_), _.jdbc.close)

  /**
   * Set the statement parameters using `A` flattened to a column vector, starting at the given
   * offset.
   */
  def set[A](a: A, offset: Int)(
    implicit ca: Write[A],
             sf: Sync[F]
  ): F[Unit] =
    raw.flatMap { ps =>
      sf.delay(ca.unsafeSet(ps, offset, a))
    }

  /**
   * Construct a sink for batch update, discarding update counts. Note that the result array will
   * be computed by JDBC and then discarded, so this call has the same cost as `rawPipe`.
   */
  @SuppressWarnings(Array("org.wartremover.warts.Var"))
  def sink[A](
    implicit ca: Write[A],
             sf: Sync[F]
  ): Sink[F, A] = as =>
    as.through(rawPipe[A]).drain

  /**
   * Construct a pipe for batch update, translating each input value into its update count. Unless
   * you're inspecting the results it's cheaper to use `sink`.
   */
  def pipe[A](
    implicit ca: Write[A],
             sf: Sync[F]
  ): Pipe[F, A, BatchResult] = as =>
    as.through(rawPipe[A]).flatMap(a => Stream.emits(a)).map(BatchResult.fromJdbc)

  /** Construct a pipe for batch update, emitting a single array containing raw JDBC update counts. */
  @SuppressWarnings(Array("org.wartremover.warts.Var"))
  private def rawPipe[A](
    implicit ca: Write[A],
             sf: Sync[F]
  ): Pipe[F, A, Array[Int]] = as =>
    as.segments.evalMap { segment =>
      raw.flatMap { ps =>
        sf.delay {
          val f = segment.force
          var n = 0
          f.foreach { a =>
            ca.unsafeSet(ps, 1, a)
            ps.addBatch
            n += 1
          }
          Console.println(s"PreparedStatement.sink: got a segment of $n")
        }
      }
    } .drain ++ Stream.eval(jdbc.executeBatch)

}