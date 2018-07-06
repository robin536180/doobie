// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless.async

import cats.effect.Sync
import doobie.tagless.RTS
import doobie.tagless.jdbc._
import org.slf4j.Logger
import java.io.InputStream
import java.io.OutputStream
import java.sql.Blob

/**
 * Implementation of JdbcBlob that wraps a Blob and lifts its primitive operations into any F
 * given a Sync instance.
 */
@SuppressWarnings(Array("org.wartremover.warts.Overloading"))
class AsyncBlob[F[_]: Sync](value: Blob, rts: RTS[F], log: Logger) extends JdbcBlob[F] {

  val id: String =
    s"${System.identityHashCode(value).toHexString.padTo(8, ' ')} Blob".padTo(28, ' ')

  val free: F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id free()")
        value.free()
      }
    }

  val getBinaryStream: F[InputStream] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getBinaryStream()")
        value.getBinaryStream()
      }
    }

  def getBinaryStream(a: Long, b: Long): F[InputStream] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getBinaryStream($a, $b)")
        value.getBinaryStream(a, b)
      }
    }

  def getBytes(a: Long, b: Int): F[Array[Byte]] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getBytes($a, $b)")
        value.getBytes(a, b)
      }
    }

  val length: F[Long] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id length()")
        value.length()
      }
    }

  def position(a: Array[Byte], b: Long): F[Long] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id position($a, $b)")
        value.position(a, b)
      }
    }

  def position(a: Blob, b: Long): F[Long] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id position($a, $b)")
        value.position(a, b)
      }
    }

  def setBinaryStream(a: Long): F[OutputStream] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setBinaryStream($a)")
        value.setBinaryStream(a)
      }
    }

  def setBytes(a: Long, b: Array[Byte]): F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setBytes($a, $b)")
        value.setBytes(a, b)
      }
    }

  def setBytes(a: Long, b: Array[Byte], c: Int, d: Int): F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setBytes($a, $b, $c, $d)")
        value.setBytes(a, b, c, d)
      }
    }

  def truncate(a: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id truncate($a)")
        value.truncate(a)
      }
    }

}

