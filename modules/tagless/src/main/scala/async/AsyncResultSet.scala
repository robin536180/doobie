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
import java.sql.ResultSet
import java.sql.ResultSetMetaData
import java.sql.RowId
import java.sql.SQLType
import java.sql.SQLWarning
import java.sql.SQLXML
import java.sql.Statement
import java.sql.Time
import java.sql.Timestamp
import java.sql.{ Array => SqlArray }
import java.util.Calendar
import java.util.Map

/**
 * Implementation of JdbcResultSet that wraps a ResultSet and lifts its primitive operations into any F
 * given a Sync instance.
 */
@SuppressWarnings(Array("org.wartremover.warts.Overloading"))
class AsyncResultSet[F[_]: Sync](value: ResultSet, rts: RTS[F], log: Logger) extends JdbcResultSet[F] {

  val id: String =
    s"${System.identityHashCode(value).toHexString.padTo(8, ' ')} ResultSet".padTo(28, ' ')

  def absolute(a: Int): F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id absolute($a)")
        value.absolute(a)
      }
    }

  val afterLast: F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id afterLast()")
        value.afterLast()
      }
    }

  val beforeFirst: F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id beforeFirst()")
        value.beforeFirst()
      }
    }

  val cancelRowUpdates: F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id cancelRowUpdates()")
        value.cancelRowUpdates()
      }
    }

  val clearWarnings: F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id clearWarnings()")
        value.clearWarnings()
      }
    }

  val close: F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id close()")
        value.close()
      }
    }

  val deleteRow: F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id deleteRow()")
        value.deleteRow()
      }
    }

  def findColumn(a: String): F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id findColumn($a)")
        value.findColumn(a)
      }
    }

  val first: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id first()")
        value.first()
      }
    }

  def getArray(a: Int): F[SqlArray] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getArray($a)")
        value.getArray(a)
      }
    }

  def getArray(a: String): F[SqlArray] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getArray($a)")
        value.getArray(a)
      }
    }

  def getAsciiStream(a: Int): F[InputStream] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getAsciiStream($a)")
        value.getAsciiStream(a)
      }
    }

  def getAsciiStream(a: String): F[InputStream] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getAsciiStream($a)")
        value.getAsciiStream(a)
      }
    }

  def getBigDecimal(a: Int): F[BigDecimal] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getBigDecimal($a)")
        value.getBigDecimal(a)
      }
    }

  def getBigDecimal(a: Int, b: Int): F[BigDecimal] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getBigDecimal($a, $b)")
        value.getBigDecimal(a, b)
      }
    }

  def getBigDecimal(a: String): F[BigDecimal] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getBigDecimal($a)")
        value.getBigDecimal(a)
      }
    }

  def getBigDecimal(a: String, b: Int): F[BigDecimal] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getBigDecimal($a, $b)")
        value.getBigDecimal(a, b)
      }
    }

  def getBinaryStream(a: Int): F[InputStream] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getBinaryStream($a)")
        value.getBinaryStream(a)
      }
    }

  def getBinaryStream(a: String): F[InputStream] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getBinaryStream($a)")
        value.getBinaryStream(a)
      }
    }

  def getBlob(a: Int): F[Blob] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getBlob($a)")
        value.getBlob(a)
      }
    }

  def getBlob(a: String): F[Blob] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getBlob($a)")
        value.getBlob(a)
      }
    }

  def getBoolean(a: Int): F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getBoolean($a)")
        value.getBoolean(a)
      }
    }

  def getBoolean(a: String): F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getBoolean($a)")
        value.getBoolean(a)
      }
    }

  def getByte(a: Int): F[Byte] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getByte($a)")
        value.getByte(a)
      }
    }

  def getByte(a: String): F[Byte] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getByte($a)")
        value.getByte(a)
      }
    }

  def getBytes(a: Int): F[Array[Byte]] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getBytes($a)")
        value.getBytes(a)
      }
    }

  def getBytes(a: String): F[Array[Byte]] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getBytes($a)")
        value.getBytes(a)
      }
    }

  def getCharacterStream(a: Int): F[Reader] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getCharacterStream($a)")
        value.getCharacterStream(a)
      }
    }

  def getCharacterStream(a: String): F[Reader] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getCharacterStream($a)")
        value.getCharacterStream(a)
      }
    }

  def getClob(a: Int): F[Clob] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getClob($a)")
        value.getClob(a)
      }
    }

  def getClob(a: String): F[Clob] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getClob($a)")
        value.getClob(a)
      }
    }

  val getConcurrency: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getConcurrency()")
        value.getConcurrency()
      }
    }

  val getCursorName: F[String] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getCursorName()")
        value.getCursorName()
      }
    }

  def getDate(a: Int): F[Date] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getDate($a)")
        value.getDate(a)
      }
    }

  def getDate(a: Int, b: Calendar): F[Date] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getDate($a, $b)")
        value.getDate(a, b)
      }
    }

  def getDate(a: String): F[Date] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getDate($a)")
        value.getDate(a)
      }
    }

  def getDate(a: String, b: Calendar): F[Date] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getDate($a, $b)")
        value.getDate(a, b)
      }
    }

  def getDouble(a: Int): F[Double] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getDouble($a)")
        value.getDouble(a)
      }
    }

  def getDouble(a: String): F[Double] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getDouble($a)")
        value.getDouble(a)
      }
    }

  val getFetchDirection: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getFetchDirection()")
        value.getFetchDirection()
      }
    }

  val getFetchSize: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getFetchSize()")
        value.getFetchSize()
      }
    }

  def getFloat(a: Int): F[Float] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getFloat($a)")
        value.getFloat(a)
      }
    }

  def getFloat(a: String): F[Float] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getFloat($a)")
        value.getFloat(a)
      }
    }

  val getHoldability: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getHoldability()")
        value.getHoldability()
      }
    }

  def getInt(a: Int): F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getInt($a)")
        value.getInt(a)
      }
    }

  def getInt(a: String): F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getInt($a)")
        value.getInt(a)
      }
    }

  def getLong(a: Int): F[Long] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getLong($a)")
        value.getLong(a)
      }
    }

  def getLong(a: String): F[Long] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getLong($a)")
        value.getLong(a)
      }
    }

  val getMetaData: F[ResultSetMetaData] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getMetaData()")
        value.getMetaData()
      }
    }

  def getNCharacterStream(a: Int): F[Reader] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getNCharacterStream($a)")
        value.getNCharacterStream(a)
      }
    }

  def getNCharacterStream(a: String): F[Reader] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getNCharacterStream($a)")
        value.getNCharacterStream(a)
      }
    }

  def getNClob(a: Int): F[NClob] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getNClob($a)")
        value.getNClob(a)
      }
    }

  def getNClob(a: String): F[NClob] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getNClob($a)")
        value.getNClob(a)
      }
    }

  def getNString(a: Int): F[String] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getNString($a)")
        value.getNString(a)
      }
    }

  def getNString(a: String): F[String] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getNString($a)")
        value.getNString(a)
      }
    }

  def getObject(a: Int): F[AnyRef] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getObject($a)")
        value.getObject(a)
      }
    }

  def getObject[T](a: Int, b: Class[T]): F[T] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getObject($a, $b)")
        value.getObject(a, b)
      }
    }

  def getObject(a: Int, b: Map[String, Class[_]]): F[AnyRef] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getObject($a, $b)")
        value.getObject(a, b)
      }
    }

  def getObject(a: String): F[AnyRef] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getObject($a)")
        value.getObject(a)
      }
    }

  def getObject[T](a: String, b: Class[T]): F[T] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getObject($a, $b)")
        value.getObject(a, b)
      }
    }

  def getObject(a: String, b: Map[String, Class[_]]): F[AnyRef] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getObject($a, $b)")
        value.getObject(a, b)
      }
    }

  def getRef(a: Int): F[Ref] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getRef($a)")
        value.getRef(a)
      }
    }

  def getRef(a: String): F[Ref] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getRef($a)")
        value.getRef(a)
      }
    }

  val getRow: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getRow()")
        value.getRow()
      }
    }

  def getRowId(a: Int): F[RowId] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getRowId($a)")
        value.getRowId(a)
      }
    }

  def getRowId(a: String): F[RowId] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getRowId($a)")
        value.getRowId(a)
      }
    }

  def getSQLXML(a: Int): F[SQLXML] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getSQLXML($a)")
        value.getSQLXML(a)
      }
    }

  def getSQLXML(a: String): F[SQLXML] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getSQLXML($a)")
        value.getSQLXML(a)
      }
    }

  def getShort(a: Int): F[Short] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getShort($a)")
        value.getShort(a)
      }
    }

  def getShort(a: String): F[Short] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getShort($a)")
        value.getShort(a)
      }
    }

  val getStatement: F[Statement] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getStatement()")
        value.getStatement()
      }
    }

  def getString(a: Int): F[String] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getString($a)")
        value.getString(a)
      }
    }

  def getString(a: String): F[String] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getString($a)")
        value.getString(a)
      }
    }

  def getTime(a: Int): F[Time] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getTime($a)")
        value.getTime(a)
      }
    }

  def getTime(a: Int, b: Calendar): F[Time] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getTime($a, $b)")
        value.getTime(a, b)
      }
    }

  def getTime(a: String): F[Time] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getTime($a)")
        value.getTime(a)
      }
    }

  def getTime(a: String, b: Calendar): F[Time] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getTime($a, $b)")
        value.getTime(a, b)
      }
    }

  def getTimestamp(a: Int): F[Timestamp] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getTimestamp($a)")
        value.getTimestamp(a)
      }
    }

  def getTimestamp(a: Int, b: Calendar): F[Timestamp] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getTimestamp($a, $b)")
        value.getTimestamp(a, b)
      }
    }

  def getTimestamp(a: String): F[Timestamp] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getTimestamp($a)")
        value.getTimestamp(a)
      }
    }

  def getTimestamp(a: String, b: Calendar): F[Timestamp] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getTimestamp($a, $b)")
        value.getTimestamp(a, b)
      }
    }

  val getType: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getType()")
        value.getType()
      }
    }

  def getURL(a: Int): F[URL] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getURL($a)")
        value.getURL(a)
      }
    }

  def getURL(a: String): F[URL] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getURL($a)")
        value.getURL(a)
      }
    }

  def getUnicodeStream(a: Int): F[InputStream] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getUnicodeStream($a)")
        value.getUnicodeStream(a)
      }
    }

  def getUnicodeStream(a: String): F[InputStream] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getUnicodeStream($a)")
        value.getUnicodeStream(a)
      }
    }

  val getWarnings: F[SQLWarning] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getWarnings()")
        value.getWarnings()
      }
    }

  val insertRow: F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id insertRow()")
        value.insertRow()
      }
    }

  val isAfterLast: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id isAfterLast()")
        value.isAfterLast()
      }
    }

  val isBeforeFirst: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id isBeforeFirst()")
        value.isBeforeFirst()
      }
    }

  val isClosed: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id isClosed()")
        value.isClosed()
      }
    }

  val isFirst: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id isFirst()")
        value.isFirst()
      }
    }

  val isLast: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id isLast()")
        value.isLast()
      }
    }

  def isWrapperFor(a: Class[_]): F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id isWrapperFor($a)")
        value.isWrapperFor(a)
      }
    }

  val last: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id last()")
        value.last()
      }
    }

  val moveToCurrentRow: F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id moveToCurrentRow()")
        value.moveToCurrentRow()
      }
    }

  val moveToInsertRow: F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id moveToInsertRow()")
        value.moveToInsertRow()
      }
    }

  val next: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id next()")
        value.next()
      }
    }

  val previous: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id previous()")
        value.previous()
      }
    }

  val refreshRow: F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id refreshRow()")
        value.refreshRow()
      }
    }

  def relative(a: Int): F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id relative($a)")
        value.relative(a)
      }
    }

  val rowDeleted: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id rowDeleted()")
        value.rowDeleted()
      }
    }

  val rowInserted: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id rowInserted()")
        value.rowInserted()
      }
    }

  val rowUpdated: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id rowUpdated()")
        value.rowUpdated()
      }
    }

  def setFetchDirection(a: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setFetchDirection($a)")
        value.setFetchDirection(a)
      }
    }

  def setFetchSize(a: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setFetchSize($a)")
        value.setFetchSize(a)
      }
    }

  def unwrap[T](a: Class[T]): F[T] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id unwrap($a)")
        value.unwrap(a)
      }
    }

  def updateArray(a: Int, b: SqlArray): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateArray($a, $b)")
        value.updateArray(a, b)
      }
    }

  def updateArray(a: String, b: SqlArray): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateArray($a, $b)")
        value.updateArray(a, b)
      }
    }

  def updateAsciiStream(a: Int, b: InputStream): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateAsciiStream($a, $b)")
        value.updateAsciiStream(a, b)
      }
    }

  def updateAsciiStream(a: Int, b: InputStream, c: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateAsciiStream($a, $b, $c)")
        value.updateAsciiStream(a, b, c)
      }
    }

  def updateAsciiStream(a: Int, b: InputStream, c: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateAsciiStream($a, $b, $c)")
        value.updateAsciiStream(a, b, c)
      }
    }

  def updateAsciiStream(a: String, b: InputStream): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateAsciiStream($a, $b)")
        value.updateAsciiStream(a, b)
      }
    }

  def updateAsciiStream(a: String, b: InputStream, c: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateAsciiStream($a, $b, $c)")
        value.updateAsciiStream(a, b, c)
      }
    }

  def updateAsciiStream(a: String, b: InputStream, c: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateAsciiStream($a, $b, $c)")
        value.updateAsciiStream(a, b, c)
      }
    }

  def updateBigDecimal(a: Int, b: BigDecimal): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateBigDecimal($a, $b)")
        value.updateBigDecimal(a, b)
      }
    }

  def updateBigDecimal(a: String, b: BigDecimal): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateBigDecimal($a, $b)")
        value.updateBigDecimal(a, b)
      }
    }

  def updateBinaryStream(a: Int, b: InputStream): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateBinaryStream($a, $b)")
        value.updateBinaryStream(a, b)
      }
    }

  def updateBinaryStream(a: Int, b: InputStream, c: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateBinaryStream($a, $b, $c)")
        value.updateBinaryStream(a, b, c)
      }
    }

  def updateBinaryStream(a: Int, b: InputStream, c: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateBinaryStream($a, $b, $c)")
        value.updateBinaryStream(a, b, c)
      }
    }

  def updateBinaryStream(a: String, b: InputStream): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateBinaryStream($a, $b)")
        value.updateBinaryStream(a, b)
      }
    }

  def updateBinaryStream(a: String, b: InputStream, c: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateBinaryStream($a, $b, $c)")
        value.updateBinaryStream(a, b, c)
      }
    }

  def updateBinaryStream(a: String, b: InputStream, c: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateBinaryStream($a, $b, $c)")
        value.updateBinaryStream(a, b, c)
      }
    }

  def updateBlob(a: Int, b: Blob): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateBlob($a, $b)")
        value.updateBlob(a, b)
      }
    }

  def updateBlob(a: Int, b: InputStream): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateBlob($a, $b)")
        value.updateBlob(a, b)
      }
    }

  def updateBlob(a: Int, b: InputStream, c: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateBlob($a, $b, $c)")
        value.updateBlob(a, b, c)
      }
    }

  def updateBlob(a: String, b: Blob): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateBlob($a, $b)")
        value.updateBlob(a, b)
      }
    }

  def updateBlob(a: String, b: InputStream): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateBlob($a, $b)")
        value.updateBlob(a, b)
      }
    }

  def updateBlob(a: String, b: InputStream, c: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateBlob($a, $b, $c)")
        value.updateBlob(a, b, c)
      }
    }

  def updateBoolean(a: Int, b: Boolean): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateBoolean($a, $b)")
        value.updateBoolean(a, b)
      }
    }

  def updateBoolean(a: String, b: Boolean): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateBoolean($a, $b)")
        value.updateBoolean(a, b)
      }
    }

  def updateByte(a: Int, b: Byte): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateByte($a, $b)")
        value.updateByte(a, b)
      }
    }

  def updateByte(a: String, b: Byte): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateByte($a, $b)")
        value.updateByte(a, b)
      }
    }

  def updateBytes(a: Int, b: Array[Byte]): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateBytes($a, $b)")
        value.updateBytes(a, b)
      }
    }

  def updateBytes(a: String, b: Array[Byte]): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateBytes($a, $b)")
        value.updateBytes(a, b)
      }
    }

  def updateCharacterStream(a: Int, b: Reader): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateCharacterStream($a, $b)")
        value.updateCharacterStream(a, b)
      }
    }

  def updateCharacterStream(a: Int, b: Reader, c: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateCharacterStream($a, $b, $c)")
        value.updateCharacterStream(a, b, c)
      }
    }

  def updateCharacterStream(a: Int, b: Reader, c: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateCharacterStream($a, $b, $c)")
        value.updateCharacterStream(a, b, c)
      }
    }

  def updateCharacterStream(a: String, b: Reader): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateCharacterStream($a, $b)")
        value.updateCharacterStream(a, b)
      }
    }

  def updateCharacterStream(a: String, b: Reader, c: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateCharacterStream($a, $b, $c)")
        value.updateCharacterStream(a, b, c)
      }
    }

  def updateCharacterStream(a: String, b: Reader, c: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateCharacterStream($a, $b, $c)")
        value.updateCharacterStream(a, b, c)
      }
    }

  def updateClob(a: Int, b: Clob): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateClob($a, $b)")
        value.updateClob(a, b)
      }
    }

  def updateClob(a: Int, b: Reader): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateClob($a, $b)")
        value.updateClob(a, b)
      }
    }

  def updateClob(a: Int, b: Reader, c: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateClob($a, $b, $c)")
        value.updateClob(a, b, c)
      }
    }

  def updateClob(a: String, b: Clob): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateClob($a, $b)")
        value.updateClob(a, b)
      }
    }

  def updateClob(a: String, b: Reader): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateClob($a, $b)")
        value.updateClob(a, b)
      }
    }

  def updateClob(a: String, b: Reader, c: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateClob($a, $b, $c)")
        value.updateClob(a, b, c)
      }
    }

  def updateDate(a: Int, b: Date): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateDate($a, $b)")
        value.updateDate(a, b)
      }
    }

  def updateDate(a: String, b: Date): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateDate($a, $b)")
        value.updateDate(a, b)
      }
    }

  def updateDouble(a: Int, b: Double): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateDouble($a, $b)")
        value.updateDouble(a, b)
      }
    }

  def updateDouble(a: String, b: Double): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateDouble($a, $b)")
        value.updateDouble(a, b)
      }
    }

  def updateFloat(a: Int, b: Float): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateFloat($a, $b)")
        value.updateFloat(a, b)
      }
    }

  def updateFloat(a: String, b: Float): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateFloat($a, $b)")
        value.updateFloat(a, b)
      }
    }

  def updateInt(a: Int, b: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateInt($a, $b)")
        value.updateInt(a, b)
      }
    }

  def updateInt(a: String, b: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateInt($a, $b)")
        value.updateInt(a, b)
      }
    }

  def updateLong(a: Int, b: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateLong($a, $b)")
        value.updateLong(a, b)
      }
    }

  def updateLong(a: String, b: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateLong($a, $b)")
        value.updateLong(a, b)
      }
    }

  def updateNCharacterStream(a: Int, b: Reader): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateNCharacterStream($a, $b)")
        value.updateNCharacterStream(a, b)
      }
    }

  def updateNCharacterStream(a: Int, b: Reader, c: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateNCharacterStream($a, $b, $c)")
        value.updateNCharacterStream(a, b, c)
      }
    }

  def updateNCharacterStream(a: String, b: Reader): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateNCharacterStream($a, $b)")
        value.updateNCharacterStream(a, b)
      }
    }

  def updateNCharacterStream(a: String, b: Reader, c: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateNCharacterStream($a, $b, $c)")
        value.updateNCharacterStream(a, b, c)
      }
    }

  def updateNClob(a: Int, b: NClob): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateNClob($a, $b)")
        value.updateNClob(a, b)
      }
    }

  def updateNClob(a: Int, b: Reader): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateNClob($a, $b)")
        value.updateNClob(a, b)
      }
    }

  def updateNClob(a: Int, b: Reader, c: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateNClob($a, $b, $c)")
        value.updateNClob(a, b, c)
      }
    }

  def updateNClob(a: String, b: NClob): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateNClob($a, $b)")
        value.updateNClob(a, b)
      }
    }

  def updateNClob(a: String, b: Reader): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateNClob($a, $b)")
        value.updateNClob(a, b)
      }
    }

  def updateNClob(a: String, b: Reader, c: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateNClob($a, $b, $c)")
        value.updateNClob(a, b, c)
      }
    }

  def updateNString(a: Int, b: String): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateNString($a, $b)")
        value.updateNString(a, b)
      }
    }

  def updateNString(a: String, b: String): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateNString($a, $b)")
        value.updateNString(a, b)
      }
    }

  def updateNull(a: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateNull($a)")
        value.updateNull(a)
      }
    }

  def updateNull(a: String): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateNull($a)")
        value.updateNull(a)
      }
    }

  def updateObject(a: Int, b: AnyRef): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateObject($a, $b)")
        value.updateObject(a, b)
      }
    }

  def updateObject(a: Int, b: AnyRef, c: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateObject($a, $b, $c)")
        value.updateObject(a, b, c)
      }
    }

  def updateObject(a: Int, b: AnyRef, c: SQLType): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateObject($a, $b, $c)")
        value.updateObject(a, b, c)
      }
    }

  def updateObject(a: Int, b: AnyRef, c: SQLType, d: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateObject($a, $b, $c, $d)")
        value.updateObject(a, b, c, d)
      }
    }

  def updateObject(a: String, b: AnyRef): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateObject($a, $b)")
        value.updateObject(a, b)
      }
    }

  def updateObject(a: String, b: AnyRef, c: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateObject($a, $b, $c)")
        value.updateObject(a, b, c)
      }
    }

  def updateObject(a: String, b: AnyRef, c: SQLType): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateObject($a, $b, $c)")
        value.updateObject(a, b, c)
      }
    }

  def updateObject(a: String, b: AnyRef, c: SQLType, d: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateObject($a, $b, $c, $d)")
        value.updateObject(a, b, c, d)
      }
    }

  def updateRef(a: Int, b: Ref): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateRef($a, $b)")
        value.updateRef(a, b)
      }
    }

  def updateRef(a: String, b: Ref): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateRef($a, $b)")
        value.updateRef(a, b)
      }
    }

  val updateRow: F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateRow()")
        value.updateRow()
      }
    }

  def updateRowId(a: Int, b: RowId): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateRowId($a, $b)")
        value.updateRowId(a, b)
      }
    }

  def updateRowId(a: String, b: RowId): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateRowId($a, $b)")
        value.updateRowId(a, b)
      }
    }

  def updateSQLXML(a: Int, b: SQLXML): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateSQLXML($a, $b)")
        value.updateSQLXML(a, b)
      }
    }

  def updateSQLXML(a: String, b: SQLXML): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateSQLXML($a, $b)")
        value.updateSQLXML(a, b)
      }
    }

  def updateShort(a: Int, b: Short): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateShort($a, $b)")
        value.updateShort(a, b)
      }
    }

  def updateShort(a: String, b: Short): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateShort($a, $b)")
        value.updateShort(a, b)
      }
    }

  def updateString(a: Int, b: String): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateString($a, $b)")
        value.updateString(a, b)
      }
    }

  def updateString(a: String, b: String): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateString($a, $b)")
        value.updateString(a, b)
      }
    }

  def updateTime(a: Int, b: Time): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateTime($a, $b)")
        value.updateTime(a, b)
      }
    }

  def updateTime(a: String, b: Time): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateTime($a, $b)")
        value.updateTime(a, b)
      }
    }

  def updateTimestamp(a: Int, b: Timestamp): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateTimestamp($a, $b)")
        value.updateTimestamp(a, b)
      }
    }

  def updateTimestamp(a: String, b: Timestamp): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id updateTimestamp($a, $b)")
        value.updateTimestamp(a, b)
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

