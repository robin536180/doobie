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
import java.lang.Class
import java.lang.String
import java.math.BigDecimal
import java.net.URL
import java.sql.Blob
import java.sql.Clob
import java.sql.Date
import java.sql.NClob
import java.sql.Ref
import java.sql.RowId
import java.sql.SQLInput
import java.sql.SQLXML
import java.sql.Time
import java.sql.Timestamp
import java.sql.{ Array => SqlArray }

/**
 * Implementation of JdbcSQLInput that wraps a SQLInput and lifts its primitive operations into any F
 * given a Sync instance.
 */
@SuppressWarnings(Array("org.wartremover.warts.Overloading"))
class AsyncSQLInput[F[_]: Sync](value: SQLInput, rts: RTS[F], log: Logger) extends JdbcSQLInput[F] {

  val id: String =
    s"${System.identityHashCode(value).toHexString.padTo(8, ' ')} SQLInput".padTo(28, ' ')

  val readArray: F[SqlArray] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id readArray()")
        value.readArray()
      }
    }

  val readAsciiStream: F[InputStream] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id readAsciiStream()")
        value.readAsciiStream()
      }
    }

  val readBigDecimal: F[BigDecimal] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id readBigDecimal()")
        value.readBigDecimal()
      }
    }

  val readBinaryStream: F[InputStream] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id readBinaryStream()")
        value.readBinaryStream()
      }
    }

  val readBlob: F[Blob] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id readBlob()")
        value.readBlob()
      }
    }

  val readBoolean: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id readBoolean()")
        value.readBoolean()
      }
    }

  val readByte: F[Byte] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id readByte()")
        value.readByte()
      }
    }

  val readBytes: F[Array[Byte]] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id readBytes()")
        value.readBytes()
      }
    }

  val readCharacterStream: F[Reader] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id readCharacterStream()")
        value.readCharacterStream()
      }
    }

  val readClob: F[Clob] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id readClob()")
        value.readClob()
      }
    }

  val readDate: F[Date] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id readDate()")
        value.readDate()
      }
    }

  val readDouble: F[Double] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id readDouble()")
        value.readDouble()
      }
    }

  val readFloat: F[Float] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id readFloat()")
        value.readFloat()
      }
    }

  val readInt: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id readInt()")
        value.readInt()
      }
    }

  val readLong: F[Long] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id readLong()")
        value.readLong()
      }
    }

  val readNClob: F[NClob] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id readNClob()")
        value.readNClob()
      }
    }

  val readNString: F[String] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id readNString()")
        value.readNString()
      }
    }

  val readObject: F[AnyRef] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id readObject()")
        value.readObject()
      }
    }

  def readObject[T](a: Class[T]): F[T] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id readObject($a)")
        value.readObject(a)
      }
    }

  val readRef: F[Ref] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id readRef()")
        value.readRef()
      }
    }

  val readRowId: F[RowId] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id readRowId()")
        value.readRowId()
      }
    }

  val readSQLXML: F[SQLXML] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id readSQLXML()")
        value.readSQLXML()
      }
    }

  val readShort: F[Short] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id readShort()")
        value.readShort()
      }
    }

  val readString: F[String] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id readString()")
        value.readString()
      }
    }

  val readTime: F[Time] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id readTime()")
        value.readTime()
      }
    }

  val readTimestamp: F[Timestamp] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id readTimestamp()")
        value.readTimestamp()
      }
    }

  val readURL: F[URL] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id readURL()")
        value.readURL()
      }
    }

  val wasNull: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id wasNull()")
        value.wasNull()
      }
    }

}

