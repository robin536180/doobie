// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless

import cats.Alternative
import cats.effect.Sync
import cats.implicits._
import doobie.Read
import doobie.tagless.jdbc._
import fs2.Stream
import java.sql
import scala.annotation.tailrec
import scala.collection.generic.CanBuildFrom
import scala.collection.mutable.Builder

final case class ResultSet[F[_]](jdbc: JdbcResultSet[F], interp: Interpreter[F]) {

  private val raw: F[sql.ResultSet] =
    jdbc.unwrap(Predef.classOf[sql.ResultSet])

  /**
   * Stream the resultset, setting fetch size to `chunkSize`, interpreting rows as type `A`,
   * reading `chunkSize` rows at a time.
   */
  def stream[A: Read](chunkSize: Int)(
    implicit sf: Sync[F]
  ): Stream[F, A] =
    Stream.eval_(jdbc.setFetchSize(chunkSize)) ++
    Stream.repeatEval(chunk[Vector, A](chunkSize.toLong))
          .takeThrough(_.length === chunkSize)
          .flatMap((c: Vector[A]) =>
            Stream.eval_(sf.delay(Console.println(s"ResultSet.stream: enqueuing ${c.length}"))) ++
            Stream.emits(c)
          ) ++
    Stream.eval_(sf.delay(Console.println(s"ResultSet.stream: done")))

  /**
   * Accumulate up to `chunkSize` rows, interpreting rows as type `A`, into a collection `C`,
   * using `CanBuildFrom`, which is very fast.
   */
  def chunk[C[_], A: Read](chunkSize: Long)(
    implicit sf: Sync[F],
            cbf: CanBuildFrom[Nothing, A, C[A]]
  ): F[C[A]] =
    chunkMap[C, A, A](chunkSize, Predef.identity)

  /**
   * Accumulate up to `chunkSize` rows, interpreting rows as type `A`, into a collection `C`,
   * using `Alternative`, which is not as fast as `CanBuildFrom`; prefer `chunk` when possible.
   */
  def chunkA[C[_]: Alternative, A: Read](chunkSize: Long)(
    implicit sf: Sync[F]
  ): F[C[A]] =
    chunkMapA[C, A, A](chunkSize, Predef.identity)

  /**
   * Accumulate up to `chunkSize` rows, interpreting rows as type `A`, mapping into `B`, into a
   * collection `C`, using `CanBuildFrom`, which is very fast.
   */
  def chunkMap[C[_], A, B](chunkSize: Long, f: A => B)(
    implicit ca: Read[A],
             sf: Sync[F],
            cbf: CanBuildFrom[Nothing, B, C[B]]
  ): F[C[B]] =
    sf.delay(Console.println(s"ResultSet.chunkMap: reading $chunkSize (max)")) *>
    raw.flatMap { rs =>
      sf.delay {
        @tailrec
        def go(accum: Builder[B, C[B]], n: Long): C[B] =
          if (n > 0 && rs.next) {
            val b = f(ca.unsafeGet(rs, 1))
            go(accum += b, n - 1)
          } else accum.result
        go(cbf(), chunkSize)
      }
    }

  /**
   * Accumulate up to `chunkSize` rows, interpreting rows as type `A`, mapping into `B`, into a
   * collection `C`, using `Alternative`, which is not as fast as `CanBuildFrom`; prefer `chunkMap`
   * when possible.
   */
  def chunkMapA[C[_], A, B](chunkSize: Long, f: A => B)(
    implicit ca: Read[A],
             sf: Sync[F],
             ac: Alternative[C]
  ): F[C[B]] =
    raw.flatMap { rs =>
      sf.delay {
        @tailrec
        def go(accum: C[B], n: Long): C[B] =
          if (n > 0 && rs.next) {
            val b = f(ca.unsafeGet(rs, 1))
            go(accum <+> ac.pure(b), n - 1)
          } else accum
        go(ac.empty, chunkSize)
      }
    }

}
