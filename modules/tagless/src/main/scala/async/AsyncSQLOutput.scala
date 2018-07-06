// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless.async

import cats.effect.Sync
import doobie.tagless.RTS
import doobie.tagless.jdbc._
import org.slf4j.Logger
import java.io.InputStream
import java.io.Reader
import java.lang.String
import java.math.BigDecimal
import java.net.URL
import java.sql.Blob
import java.sql.Clob
import java.sql.Date
import java.sql.NClob
import java.sql.Ref
import java.sql.RowId
import java.sql.SQLData
import java.sql.SQLOutput
import java.sql.SQLType
import java.sql.SQLXML
import java.sql.Struct
import java.sql.Time
import java.sql.Timestamp
import java.sql.{ Array => SqlArray }

/**
 * Implementation of JdbcSQLOutput that wraps a SQLOutput and lifts its primitive operations into any F
 * given a Sync instance.
 */
@SuppressWarnings(Array("org.wartremover.warts.Overloading"))
class AsyncSQLOutput[F[_]: Sync](value: SQLOutput, rts: RTS[F], log: Logger) extends JdbcSQLOutput[F] {

  val id: String =
    s"${System.identityHashCode(value).toHexString.padTo(8, ' ')} SQLOutput".padTo(28, ' ')

  def writeArray(a: SqlArray): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id writeArray($a)")
        value.writeArray(a)
      }
    }

  def writeAsciiStream(a: InputStream): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id writeAsciiStream($a)")
        value.writeAsciiStream(a)
      }
    }

  def writeBigDecimal(a: BigDecimal): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id writeBigDecimal($a)")
        value.writeBigDecimal(a)
      }
    }

  def writeBinaryStream(a: InputStream): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id writeBinaryStream($a)")
        value.writeBinaryStream(a)
      }
    }

  def writeBlob(a: Blob): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id writeBlob($a)")
        value.writeBlob(a)
      }
    }

  def writeBoolean(a: Boolean): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id writeBoolean($a)")
        value.writeBoolean(a)
      }
    }

  def writeByte(a: Byte): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id writeByte($a)")
        value.writeByte(a)
      }
    }

  def writeBytes(a: Array[Byte]): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id writeBytes($a)")
        value.writeBytes(a)
      }
    }

  def writeCharacterStream(a: Reader): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id writeCharacterStream($a)")
        value.writeCharacterStream(a)
      }
    }

  def writeClob(a: Clob): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id writeClob($a)")
        value.writeClob(a)
      }
    }

  def writeDate(a: Date): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id writeDate($a)")
        value.writeDate(a)
      }
    }

  def writeDouble(a: Double): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id writeDouble($a)")
        value.writeDouble(a)
      }
    }

  def writeFloat(a: Float): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id writeFloat($a)")
        value.writeFloat(a)
      }
    }

  def writeInt(a: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id writeInt($a)")
        value.writeInt(a)
      }
    }

  def writeLong(a: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id writeLong($a)")
        value.writeLong(a)
      }
    }

  def writeNClob(a: NClob): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id writeNClob($a)")
        value.writeNClob(a)
      }
    }

  def writeNString(a: String): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id writeNString($a)")
        value.writeNString(a)
      }
    }

  def writeObject(a: AnyRef, b: SQLType): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id writeObject($a, $b)")
        value.writeObject(a, b)
      }
    }

  def writeObject(a: SQLData): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id writeObject($a)")
        value.writeObject(a)
      }
    }

  def writeRef(a: Ref): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id writeRef($a)")
        value.writeRef(a)
      }
    }

  def writeRowId(a: RowId): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id writeRowId($a)")
        value.writeRowId(a)
      }
    }

  def writeSQLXML(a: SQLXML): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id writeSQLXML($a)")
        value.writeSQLXML(a)
      }
    }

  def writeShort(a: Short): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id writeShort($a)")
        value.writeShort(a)
      }
    }

  def writeString(a: String): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id writeString($a)")
        value.writeString(a)
      }
    }

  def writeStruct(a: Struct): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id writeStruct($a)")
        value.writeStruct(a)
      }
    }

  def writeTime(a: Time): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id writeTime($a)")
        value.writeTime(a)
      }
    }

  def writeTimestamp(a: Timestamp): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id writeTimestamp($a)")
        value.writeTimestamp(a)
      }
    }

  def writeURL(a: URL): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id writeURL($a)")
        value.writeURL(a)
      }
    }

}

