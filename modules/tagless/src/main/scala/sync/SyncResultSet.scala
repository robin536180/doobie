// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless.sync

import cats.effect.Sync
import cats.implicits._
import doobie.tagless.jdbc._
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
class SyncResultSet[F[_]](value: ResultSet)(implicit F: Sync[F]) extends JdbcResultSet[F] {

  def absolute(a: Int): F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.absolute($a)")) *>
    F.delay(value.absolute(a))

  val afterLast: F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.afterLast()")) *>
    F.delay(value.afterLast())

  val beforeFirst: F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.beforeFirst()")) *>
    F.delay(value.beforeFirst())

  val cancelRowUpdates: F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.cancelRowUpdates()")) *>
    F.delay(value.cancelRowUpdates())

  val clearWarnings: F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.clearWarnings()")) *>
    F.delay(value.clearWarnings())

  val close: F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.close()")) *>
    F.delay(value.close())

  val deleteRow: F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.deleteRow()")) *>
    F.delay(value.deleteRow())

  def findColumn(a: String): F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.findColumn($a)")) *>
    F.delay(value.findColumn(a))

  val first: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.first()")) *>
    F.delay(value.first())

  def getArray(a: Int): F[SqlArray] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getArray($a)")) *>
    F.delay(value.getArray(a))

  def getArray(a: String): F[SqlArray] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getArray($a)")) *>
    F.delay(value.getArray(a))

  def getAsciiStream(a: Int): F[InputStream] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getAsciiStream($a)")) *>
    F.delay(value.getAsciiStream(a))

  def getAsciiStream(a: String): F[InputStream] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getAsciiStream($a)")) *>
    F.delay(value.getAsciiStream(a))

  def getBigDecimal(a: Int): F[BigDecimal] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getBigDecimal($a)")) *>
    F.delay(value.getBigDecimal(a))

  def getBigDecimal(a: Int, b: Int): F[BigDecimal] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getBigDecimal($a, $b)")) *>
    F.delay(value.getBigDecimal(a, b))

  def getBigDecimal(a: String): F[BigDecimal] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getBigDecimal($a)")) *>
    F.delay(value.getBigDecimal(a))

  def getBigDecimal(a: String, b: Int): F[BigDecimal] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getBigDecimal($a, $b)")) *>
    F.delay(value.getBigDecimal(a, b))

  def getBinaryStream(a: Int): F[InputStream] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getBinaryStream($a)")) *>
    F.delay(value.getBinaryStream(a))

  def getBinaryStream(a: String): F[InputStream] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getBinaryStream($a)")) *>
    F.delay(value.getBinaryStream(a))

  def getBlob(a: Int): F[Blob] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getBlob($a)")) *>
    F.delay(value.getBlob(a))

  def getBlob(a: String): F[Blob] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getBlob($a)")) *>
    F.delay(value.getBlob(a))

  def getBoolean(a: Int): F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getBoolean($a)")) *>
    F.delay(value.getBoolean(a))

  def getBoolean(a: String): F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getBoolean($a)")) *>
    F.delay(value.getBoolean(a))

  def getByte(a: Int): F[Byte] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getByte($a)")) *>
    F.delay(value.getByte(a))

  def getByte(a: String): F[Byte] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getByte($a)")) *>
    F.delay(value.getByte(a))

  def getBytes(a: Int): F[Array[Byte]] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getBytes($a)")) *>
    F.delay(value.getBytes(a))

  def getBytes(a: String): F[Array[Byte]] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getBytes($a)")) *>
    F.delay(value.getBytes(a))

  def getCharacterStream(a: Int): F[Reader] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getCharacterStream($a)")) *>
    F.delay(value.getCharacterStream(a))

  def getCharacterStream(a: String): F[Reader] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getCharacterStream($a)")) *>
    F.delay(value.getCharacterStream(a))

  def getClob(a: Int): F[Clob] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getClob($a)")) *>
    F.delay(value.getClob(a))

  def getClob(a: String): F[Clob] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getClob($a)")) *>
    F.delay(value.getClob(a))

  val getConcurrency: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getConcurrency()")) *>
    F.delay(value.getConcurrency())

  val getCursorName: F[String] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getCursorName()")) *>
    F.delay(value.getCursorName())

  def getDate(a: Int): F[Date] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getDate($a)")) *>
    F.delay(value.getDate(a))

  def getDate(a: Int, b: Calendar): F[Date] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getDate($a, $b)")) *>
    F.delay(value.getDate(a, b))

  def getDate(a: String): F[Date] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getDate($a)")) *>
    F.delay(value.getDate(a))

  def getDate(a: String, b: Calendar): F[Date] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getDate($a, $b)")) *>
    F.delay(value.getDate(a, b))

  def getDouble(a: Int): F[Double] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getDouble($a)")) *>
    F.delay(value.getDouble(a))

  def getDouble(a: String): F[Double] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getDouble($a)")) *>
    F.delay(value.getDouble(a))

  val getFetchDirection: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getFetchDirection()")) *>
    F.delay(value.getFetchDirection())

  val getFetchSize: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getFetchSize()")) *>
    F.delay(value.getFetchSize())

  def getFloat(a: Int): F[Float] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getFloat($a)")) *>
    F.delay(value.getFloat(a))

  def getFloat(a: String): F[Float] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getFloat($a)")) *>
    F.delay(value.getFloat(a))

  val getHoldability: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getHoldability()")) *>
    F.delay(value.getHoldability())

  def getInt(a: Int): F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getInt($a)")) *>
    F.delay(value.getInt(a))

  def getInt(a: String): F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getInt($a)")) *>
    F.delay(value.getInt(a))

  def getLong(a: Int): F[Long] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getLong($a)")) *>
    F.delay(value.getLong(a))

  def getLong(a: String): F[Long] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getLong($a)")) *>
    F.delay(value.getLong(a))

  val getMetaData: F[ResultSetMetaData] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getMetaData()")) *>
    F.delay(value.getMetaData())

  def getNCharacterStream(a: Int): F[Reader] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getNCharacterStream($a)")) *>
    F.delay(value.getNCharacterStream(a))

  def getNCharacterStream(a: String): F[Reader] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getNCharacterStream($a)")) *>
    F.delay(value.getNCharacterStream(a))

  def getNClob(a: Int): F[NClob] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getNClob($a)")) *>
    F.delay(value.getNClob(a))

  def getNClob(a: String): F[NClob] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getNClob($a)")) *>
    F.delay(value.getNClob(a))

  def getNString(a: Int): F[String] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getNString($a)")) *>
    F.delay(value.getNString(a))

  def getNString(a: String): F[String] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getNString($a)")) *>
    F.delay(value.getNString(a))

  def getObject(a: Int): F[AnyRef] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getObject($a)")) *>
    F.delay(value.getObject(a))

  def getObject[T](a: Int, b: Class[T]): F[T] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getObject($a, $b)")) *>
    F.delay(value.getObject(a, b))

  def getObject(a: Int, b: Map[String, Class[_]]): F[AnyRef] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getObject($a, $b)")) *>
    F.delay(value.getObject(a, b))

  def getObject(a: String): F[AnyRef] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getObject($a)")) *>
    F.delay(value.getObject(a))

  def getObject[T](a: String, b: Class[T]): F[T] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getObject($a, $b)")) *>
    F.delay(value.getObject(a, b))

  def getObject(a: String, b: Map[String, Class[_]]): F[AnyRef] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getObject($a, $b)")) *>
    F.delay(value.getObject(a, b))

  def getRef(a: Int): F[Ref] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getRef($a)")) *>
    F.delay(value.getRef(a))

  def getRef(a: String): F[Ref] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getRef($a)")) *>
    F.delay(value.getRef(a))

  val getRow: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getRow()")) *>
    F.delay(value.getRow())

  def getRowId(a: Int): F[RowId] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getRowId($a)")) *>
    F.delay(value.getRowId(a))

  def getRowId(a: String): F[RowId] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getRowId($a)")) *>
    F.delay(value.getRowId(a))

  def getSQLXML(a: Int): F[SQLXML] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getSQLXML($a)")) *>
    F.delay(value.getSQLXML(a))

  def getSQLXML(a: String): F[SQLXML] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getSQLXML($a)")) *>
    F.delay(value.getSQLXML(a))

  def getShort(a: Int): F[Short] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getShort($a)")) *>
    F.delay(value.getShort(a))

  def getShort(a: String): F[Short] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getShort($a)")) *>
    F.delay(value.getShort(a))

  val getStatement: F[Statement] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getStatement()")) *>
    F.delay(value.getStatement())

  def getString(a: Int): F[String] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getString($a)")) *>
    F.delay(value.getString(a))

  def getString(a: String): F[String] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getString($a)")) *>
    F.delay(value.getString(a))

  def getTime(a: Int): F[Time] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getTime($a)")) *>
    F.delay(value.getTime(a))

  def getTime(a: Int, b: Calendar): F[Time] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getTime($a, $b)")) *>
    F.delay(value.getTime(a, b))

  def getTime(a: String): F[Time] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getTime($a)")) *>
    F.delay(value.getTime(a))

  def getTime(a: String, b: Calendar): F[Time] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getTime($a, $b)")) *>
    F.delay(value.getTime(a, b))

  def getTimestamp(a: Int): F[Timestamp] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getTimestamp($a)")) *>
    F.delay(value.getTimestamp(a))

  def getTimestamp(a: Int, b: Calendar): F[Timestamp] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getTimestamp($a, $b)")) *>
    F.delay(value.getTimestamp(a, b))

  def getTimestamp(a: String): F[Timestamp] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getTimestamp($a)")) *>
    F.delay(value.getTimestamp(a))

  def getTimestamp(a: String, b: Calendar): F[Timestamp] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getTimestamp($a, $b)")) *>
    F.delay(value.getTimestamp(a, b))

  val getType: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getType()")) *>
    F.delay(value.getType())

  def getURL(a: Int): F[URL] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getURL($a)")) *>
    F.delay(value.getURL(a))

  def getURL(a: String): F[URL] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getURL($a)")) *>
    F.delay(value.getURL(a))

  def getUnicodeStream(a: Int): F[InputStream] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getUnicodeStream($a)")) *>
    F.delay(value.getUnicodeStream(a))

  def getUnicodeStream(a: String): F[InputStream] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getUnicodeStream($a)")) *>
    F.delay(value.getUnicodeStream(a))

  val getWarnings: F[SQLWarning] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.getWarnings()")) *>
    F.delay(value.getWarnings())

  val insertRow: F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.insertRow()")) *>
    F.delay(value.insertRow())

  val isAfterLast: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.isAfterLast()")) *>
    F.delay(value.isAfterLast())

  val isBeforeFirst: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.isBeforeFirst()")) *>
    F.delay(value.isBeforeFirst())

  val isClosed: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.isClosed()")) *>
    F.delay(value.isClosed())

  val isFirst: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.isFirst()")) *>
    F.delay(value.isFirst())

  val isLast: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.isLast()")) *>
    F.delay(value.isLast())

  def isWrapperFor(a: Class[_]): F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.isWrapperFor($a)")) *>
    F.delay(value.isWrapperFor(a))

  val last: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.last()")) *>
    F.delay(value.last())

  val moveToCurrentRow: F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.moveToCurrentRow()")) *>
    F.delay(value.moveToCurrentRow())

  val moveToInsertRow: F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.moveToInsertRow()")) *>
    F.delay(value.moveToInsertRow())

  val next: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.next()")) *>
    F.delay(value.next())

  val previous: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.previous()")) *>
    F.delay(value.previous())

  val refreshRow: F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.refreshRow()")) *>
    F.delay(value.refreshRow())

  def relative(a: Int): F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.relative($a)")) *>
    F.delay(value.relative(a))

  val rowDeleted: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.rowDeleted()")) *>
    F.delay(value.rowDeleted())

  val rowInserted: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.rowInserted()")) *>
    F.delay(value.rowInserted())

  val rowUpdated: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.rowUpdated()")) *>
    F.delay(value.rowUpdated())

  def setFetchDirection(a: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.setFetchDirection($a)")) *>
    F.delay(value.setFetchDirection(a))

  def setFetchSize(a: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.setFetchSize($a)")) *>
    F.delay(value.setFetchSize(a))

  def unwrap[T](a: Class[T]): F[T] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.unwrap($a)")) *>
    F.delay(value.unwrap(a))

  def updateArray(a: Int, b: SqlArray): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateArray($a, $b)")) *>
    F.delay(value.updateArray(a, b))

  def updateArray(a: String, b: SqlArray): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateArray($a, $b)")) *>
    F.delay(value.updateArray(a, b))

  def updateAsciiStream(a: Int, b: InputStream): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateAsciiStream($a, $b)")) *>
    F.delay(value.updateAsciiStream(a, b))

  def updateAsciiStream(a: Int, b: InputStream, c: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateAsciiStream($a, $b, $c)")) *>
    F.delay(value.updateAsciiStream(a, b, c))

  def updateAsciiStream(a: Int, b: InputStream, c: Long): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateAsciiStream($a, $b, $c)")) *>
    F.delay(value.updateAsciiStream(a, b, c))

  def updateAsciiStream(a: String, b: InputStream): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateAsciiStream($a, $b)")) *>
    F.delay(value.updateAsciiStream(a, b))

  def updateAsciiStream(a: String, b: InputStream, c: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateAsciiStream($a, $b, $c)")) *>
    F.delay(value.updateAsciiStream(a, b, c))

  def updateAsciiStream(a: String, b: InputStream, c: Long): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateAsciiStream($a, $b, $c)")) *>
    F.delay(value.updateAsciiStream(a, b, c))

  def updateBigDecimal(a: Int, b: BigDecimal): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateBigDecimal($a, $b)")) *>
    F.delay(value.updateBigDecimal(a, b))

  def updateBigDecimal(a: String, b: BigDecimal): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateBigDecimal($a, $b)")) *>
    F.delay(value.updateBigDecimal(a, b))

  def updateBinaryStream(a: Int, b: InputStream): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateBinaryStream($a, $b)")) *>
    F.delay(value.updateBinaryStream(a, b))

  def updateBinaryStream(a: Int, b: InputStream, c: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateBinaryStream($a, $b, $c)")) *>
    F.delay(value.updateBinaryStream(a, b, c))

  def updateBinaryStream(a: Int, b: InputStream, c: Long): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateBinaryStream($a, $b, $c)")) *>
    F.delay(value.updateBinaryStream(a, b, c))

  def updateBinaryStream(a: String, b: InputStream): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateBinaryStream($a, $b)")) *>
    F.delay(value.updateBinaryStream(a, b))

  def updateBinaryStream(a: String, b: InputStream, c: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateBinaryStream($a, $b, $c)")) *>
    F.delay(value.updateBinaryStream(a, b, c))

  def updateBinaryStream(a: String, b: InputStream, c: Long): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateBinaryStream($a, $b, $c)")) *>
    F.delay(value.updateBinaryStream(a, b, c))

  def updateBlob(a: Int, b: Blob): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateBlob($a, $b)")) *>
    F.delay(value.updateBlob(a, b))

  def updateBlob(a: Int, b: InputStream): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateBlob($a, $b)")) *>
    F.delay(value.updateBlob(a, b))

  def updateBlob(a: Int, b: InputStream, c: Long): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateBlob($a, $b, $c)")) *>
    F.delay(value.updateBlob(a, b, c))

  def updateBlob(a: String, b: Blob): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateBlob($a, $b)")) *>
    F.delay(value.updateBlob(a, b))

  def updateBlob(a: String, b: InputStream): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateBlob($a, $b)")) *>
    F.delay(value.updateBlob(a, b))

  def updateBlob(a: String, b: InputStream, c: Long): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateBlob($a, $b, $c)")) *>
    F.delay(value.updateBlob(a, b, c))

  def updateBoolean(a: Int, b: Boolean): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateBoolean($a, $b)")) *>
    F.delay(value.updateBoolean(a, b))

  def updateBoolean(a: String, b: Boolean): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateBoolean($a, $b)")) *>
    F.delay(value.updateBoolean(a, b))

  def updateByte(a: Int, b: Byte): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateByte($a, $b)")) *>
    F.delay(value.updateByte(a, b))

  def updateByte(a: String, b: Byte): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateByte($a, $b)")) *>
    F.delay(value.updateByte(a, b))

  def updateBytes(a: Int, b: Array[Byte]): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateBytes($a, $b)")) *>
    F.delay(value.updateBytes(a, b))

  def updateBytes(a: String, b: Array[Byte]): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateBytes($a, $b)")) *>
    F.delay(value.updateBytes(a, b))

  def updateCharacterStream(a: Int, b: Reader): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateCharacterStream($a, $b)")) *>
    F.delay(value.updateCharacterStream(a, b))

  def updateCharacterStream(a: Int, b: Reader, c: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateCharacterStream($a, $b, $c)")) *>
    F.delay(value.updateCharacterStream(a, b, c))

  def updateCharacterStream(a: Int, b: Reader, c: Long): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateCharacterStream($a, $b, $c)")) *>
    F.delay(value.updateCharacterStream(a, b, c))

  def updateCharacterStream(a: String, b: Reader): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateCharacterStream($a, $b)")) *>
    F.delay(value.updateCharacterStream(a, b))

  def updateCharacterStream(a: String, b: Reader, c: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateCharacterStream($a, $b, $c)")) *>
    F.delay(value.updateCharacterStream(a, b, c))

  def updateCharacterStream(a: String, b: Reader, c: Long): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateCharacterStream($a, $b, $c)")) *>
    F.delay(value.updateCharacterStream(a, b, c))

  def updateClob(a: Int, b: Clob): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateClob($a, $b)")) *>
    F.delay(value.updateClob(a, b))

  def updateClob(a: Int, b: Reader): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateClob($a, $b)")) *>
    F.delay(value.updateClob(a, b))

  def updateClob(a: Int, b: Reader, c: Long): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateClob($a, $b, $c)")) *>
    F.delay(value.updateClob(a, b, c))

  def updateClob(a: String, b: Clob): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateClob($a, $b)")) *>
    F.delay(value.updateClob(a, b))

  def updateClob(a: String, b: Reader): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateClob($a, $b)")) *>
    F.delay(value.updateClob(a, b))

  def updateClob(a: String, b: Reader, c: Long): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateClob($a, $b, $c)")) *>
    F.delay(value.updateClob(a, b, c))

  def updateDate(a: Int, b: Date): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateDate($a, $b)")) *>
    F.delay(value.updateDate(a, b))

  def updateDate(a: String, b: Date): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateDate($a, $b)")) *>
    F.delay(value.updateDate(a, b))

  def updateDouble(a: Int, b: Double): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateDouble($a, $b)")) *>
    F.delay(value.updateDouble(a, b))

  def updateDouble(a: String, b: Double): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateDouble($a, $b)")) *>
    F.delay(value.updateDouble(a, b))

  def updateFloat(a: Int, b: Float): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateFloat($a, $b)")) *>
    F.delay(value.updateFloat(a, b))

  def updateFloat(a: String, b: Float): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateFloat($a, $b)")) *>
    F.delay(value.updateFloat(a, b))

  def updateInt(a: Int, b: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateInt($a, $b)")) *>
    F.delay(value.updateInt(a, b))

  def updateInt(a: String, b: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateInt($a, $b)")) *>
    F.delay(value.updateInt(a, b))

  def updateLong(a: Int, b: Long): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateLong($a, $b)")) *>
    F.delay(value.updateLong(a, b))

  def updateLong(a: String, b: Long): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateLong($a, $b)")) *>
    F.delay(value.updateLong(a, b))

  def updateNCharacterStream(a: Int, b: Reader): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateNCharacterStream($a, $b)")) *>
    F.delay(value.updateNCharacterStream(a, b))

  def updateNCharacterStream(a: Int, b: Reader, c: Long): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateNCharacterStream($a, $b, $c)")) *>
    F.delay(value.updateNCharacterStream(a, b, c))

  def updateNCharacterStream(a: String, b: Reader): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateNCharacterStream($a, $b)")) *>
    F.delay(value.updateNCharacterStream(a, b))

  def updateNCharacterStream(a: String, b: Reader, c: Long): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateNCharacterStream($a, $b, $c)")) *>
    F.delay(value.updateNCharacterStream(a, b, c))

  def updateNClob(a: Int, b: NClob): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateNClob($a, $b)")) *>
    F.delay(value.updateNClob(a, b))

  def updateNClob(a: Int, b: Reader): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateNClob($a, $b)")) *>
    F.delay(value.updateNClob(a, b))

  def updateNClob(a: Int, b: Reader, c: Long): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateNClob($a, $b, $c)")) *>
    F.delay(value.updateNClob(a, b, c))

  def updateNClob(a: String, b: NClob): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateNClob($a, $b)")) *>
    F.delay(value.updateNClob(a, b))

  def updateNClob(a: String, b: Reader): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateNClob($a, $b)")) *>
    F.delay(value.updateNClob(a, b))

  def updateNClob(a: String, b: Reader, c: Long): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateNClob($a, $b, $c)")) *>
    F.delay(value.updateNClob(a, b, c))

  def updateNString(a: Int, b: String): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateNString($a, $b)")) *>
    F.delay(value.updateNString(a, b))

  def updateNString(a: String, b: String): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateNString($a, $b)")) *>
    F.delay(value.updateNString(a, b))

  def updateNull(a: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateNull($a)")) *>
    F.delay(value.updateNull(a))

  def updateNull(a: String): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateNull($a)")) *>
    F.delay(value.updateNull(a))

  def updateObject(a: Int, b: AnyRef): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateObject($a, $b)")) *>
    F.delay(value.updateObject(a, b))

  def updateObject(a: Int, b: AnyRef, c: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateObject($a, $b, $c)")) *>
    F.delay(value.updateObject(a, b, c))

  def updateObject(a: Int, b: AnyRef, c: SQLType): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateObject($a, $b, $c)")) *>
    F.delay(value.updateObject(a, b, c))

  def updateObject(a: Int, b: AnyRef, c: SQLType, d: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateObject($a, $b, $c, $d)")) *>
    F.delay(value.updateObject(a, b, c, d))

  def updateObject(a: String, b: AnyRef): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateObject($a, $b)")) *>
    F.delay(value.updateObject(a, b))

  def updateObject(a: String, b: AnyRef, c: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateObject($a, $b, $c)")) *>
    F.delay(value.updateObject(a, b, c))

  def updateObject(a: String, b: AnyRef, c: SQLType): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateObject($a, $b, $c)")) *>
    F.delay(value.updateObject(a, b, c))

  def updateObject(a: String, b: AnyRef, c: SQLType, d: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateObject($a, $b, $c, $d)")) *>
    F.delay(value.updateObject(a, b, c, d))

  def updateRef(a: Int, b: Ref): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateRef($a, $b)")) *>
    F.delay(value.updateRef(a, b))

  def updateRef(a: String, b: Ref): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateRef($a, $b)")) *>
    F.delay(value.updateRef(a, b))

  val updateRow: F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateRow()")) *>
    F.delay(value.updateRow())

  def updateRowId(a: Int, b: RowId): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateRowId($a, $b)")) *>
    F.delay(value.updateRowId(a, b))

  def updateRowId(a: String, b: RowId): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateRowId($a, $b)")) *>
    F.delay(value.updateRowId(a, b))

  def updateSQLXML(a: Int, b: SQLXML): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateSQLXML($a, $b)")) *>
    F.delay(value.updateSQLXML(a, b))

  def updateSQLXML(a: String, b: SQLXML): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateSQLXML($a, $b)")) *>
    F.delay(value.updateSQLXML(a, b))

  def updateShort(a: Int, b: Short): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateShort($a, $b)")) *>
    F.delay(value.updateShort(a, b))

  def updateShort(a: String, b: Short): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateShort($a, $b)")) *>
    F.delay(value.updateShort(a, b))

  def updateString(a: Int, b: String): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateString($a, $b)")) *>
    F.delay(value.updateString(a, b))

  def updateString(a: String, b: String): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateString($a, $b)")) *>
    F.delay(value.updateString(a, b))

  def updateTime(a: Int, b: Time): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateTime($a, $b)")) *>
    F.delay(value.updateTime(a, b))

  def updateTime(a: String, b: Time): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateTime($a, $b)")) *>
    F.delay(value.updateTime(a, b))

  def updateTimestamp(a: Int, b: Timestamp): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateTimestamp($a, $b)")) *>
    F.delay(value.updateTimestamp(a, b))

  def updateTimestamp(a: String, b: Timestamp): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.updateTimestamp($a, $b)")) *>
    F.delay(value.updateTimestamp(a, b))

  val wasNull: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: ResultSet.wasNull()")) *>
    F.delay(value.wasNull())

}

