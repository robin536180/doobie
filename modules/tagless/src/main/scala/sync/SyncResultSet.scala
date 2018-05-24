// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless.sync

import cats.effect.Sync
import cats.implicits._
import cats.syntax._
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

  def absolute(a: Int) =
    F.delay(Console.err.println(s"ResultSet.absolute($a)")) *>
    F.delay(value.absolute(a))

  def afterLast =
    F.delay(Console.err.println("ResultSet.afterLast()")) *>
    F.delay(value.afterLast())

  def beforeFirst =
    F.delay(Console.err.println("ResultSet.beforeFirst()")) *>
    F.delay(value.beforeFirst())

  def cancelRowUpdates =
    F.delay(Console.err.println("ResultSet.cancelRowUpdates()")) *>
    F.delay(value.cancelRowUpdates())

  def clearWarnings =
    F.delay(Console.err.println("ResultSet.clearWarnings()")) *>
    F.delay(value.clearWarnings())

  def close =
    F.delay(Console.err.println("ResultSet.close()")) *>
    F.delay(value.close())

  def deleteRow =
    F.delay(Console.err.println("ResultSet.deleteRow()")) *>
    F.delay(value.deleteRow())

  def findColumn(a: String) =
    F.delay(Console.err.println(s"ResultSet.findColumn($a)")) *>
    F.delay(value.findColumn(a))

  def first =
    F.delay(Console.err.println("ResultSet.first()")) *>
    F.delay(value.first())

  def getArray(a: Int) =
    F.delay(Console.err.println(s"ResultSet.getArray($a)")) *>
    F.delay(value.getArray(a))

  def getArray(a: String) =
    F.delay(Console.err.println(s"ResultSet.getArray($a)")) *>
    F.delay(value.getArray(a))

  def getAsciiStream(a: Int) =
    F.delay(Console.err.println(s"ResultSet.getAsciiStream($a)")) *>
    F.delay(value.getAsciiStream(a))

  def getAsciiStream(a: String) =
    F.delay(Console.err.println(s"ResultSet.getAsciiStream($a)")) *>
    F.delay(value.getAsciiStream(a))

  def getBigDecimal(a: Int) =
    F.delay(Console.err.println(s"ResultSet.getBigDecimal($a)")) *>
    F.delay(value.getBigDecimal(a))

  def getBigDecimal(a: Int, b: Int) =
    F.delay(Console.err.println(s"ResultSet.getBigDecimal($a, $b)")) *>
    F.delay(value.getBigDecimal(a, b))

  def getBigDecimal(a: String) =
    F.delay(Console.err.println(s"ResultSet.getBigDecimal($a)")) *>
    F.delay(value.getBigDecimal(a))

  def getBigDecimal(a: String, b: Int) =
    F.delay(Console.err.println(s"ResultSet.getBigDecimal($a, $b)")) *>
    F.delay(value.getBigDecimal(a, b))

  def getBinaryStream(a: Int) =
    F.delay(Console.err.println(s"ResultSet.getBinaryStream($a)")) *>
    F.delay(value.getBinaryStream(a))

  def getBinaryStream(a: String) =
    F.delay(Console.err.println(s"ResultSet.getBinaryStream($a)")) *>
    F.delay(value.getBinaryStream(a))

  def getBlob(a: Int) =
    F.delay(Console.err.println(s"ResultSet.getBlob($a)")) *>
    F.delay(value.getBlob(a))

  def getBlob(a: String) =
    F.delay(Console.err.println(s"ResultSet.getBlob($a)")) *>
    F.delay(value.getBlob(a))

  def getBoolean(a: Int) =
    F.delay(Console.err.println(s"ResultSet.getBoolean($a)")) *>
    F.delay(value.getBoolean(a))

  def getBoolean(a: String) =
    F.delay(Console.err.println(s"ResultSet.getBoolean($a)")) *>
    F.delay(value.getBoolean(a))

  def getByte(a: Int) =
    F.delay(Console.err.println(s"ResultSet.getByte($a)")) *>
    F.delay(value.getByte(a))

  def getByte(a: String) =
    F.delay(Console.err.println(s"ResultSet.getByte($a)")) *>
    F.delay(value.getByte(a))

  def getBytes(a: Int) =
    F.delay(Console.err.println(s"ResultSet.getBytes($a)")) *>
    F.delay(value.getBytes(a))

  def getBytes(a: String) =
    F.delay(Console.err.println(s"ResultSet.getBytes($a)")) *>
    F.delay(value.getBytes(a))

  def getCharacterStream(a: Int) =
    F.delay(Console.err.println(s"ResultSet.getCharacterStream($a)")) *>
    F.delay(value.getCharacterStream(a))

  def getCharacterStream(a: String) =
    F.delay(Console.err.println(s"ResultSet.getCharacterStream($a)")) *>
    F.delay(value.getCharacterStream(a))

  def getClob(a: Int) =
    F.delay(Console.err.println(s"ResultSet.getClob($a)")) *>
    F.delay(value.getClob(a))

  def getClob(a: String) =
    F.delay(Console.err.println(s"ResultSet.getClob($a)")) *>
    F.delay(value.getClob(a))

  def getConcurrency =
    F.delay(Console.err.println("ResultSet.getConcurrency()")) *>
    F.delay(value.getConcurrency())

  def getCursorName =
    F.delay(Console.err.println("ResultSet.getCursorName()")) *>
    F.delay(value.getCursorName())

  def getDate(a: Int) =
    F.delay(Console.err.println(s"ResultSet.getDate($a)")) *>
    F.delay(value.getDate(a))

  def getDate(a: Int, b: Calendar) =
    F.delay(Console.err.println(s"ResultSet.getDate($a, $b)")) *>
    F.delay(value.getDate(a, b))

  def getDate(a: String) =
    F.delay(Console.err.println(s"ResultSet.getDate($a)")) *>
    F.delay(value.getDate(a))

  def getDate(a: String, b: Calendar) =
    F.delay(Console.err.println(s"ResultSet.getDate($a, $b)")) *>
    F.delay(value.getDate(a, b))

  def getDouble(a: Int) =
    F.delay(Console.err.println(s"ResultSet.getDouble($a)")) *>
    F.delay(value.getDouble(a))

  def getDouble(a: String) =
    F.delay(Console.err.println(s"ResultSet.getDouble($a)")) *>
    F.delay(value.getDouble(a))

  def getFetchDirection =
    F.delay(Console.err.println("ResultSet.getFetchDirection()")) *>
    F.delay(value.getFetchDirection())

  def getFetchSize =
    F.delay(Console.err.println("ResultSet.getFetchSize()")) *>
    F.delay(value.getFetchSize())

  def getFloat(a: Int) =
    F.delay(Console.err.println(s"ResultSet.getFloat($a)")) *>
    F.delay(value.getFloat(a))

  def getFloat(a: String) =
    F.delay(Console.err.println(s"ResultSet.getFloat($a)")) *>
    F.delay(value.getFloat(a))

  def getHoldability =
    F.delay(Console.err.println("ResultSet.getHoldability()")) *>
    F.delay(value.getHoldability())

  def getInt(a: Int) =
    F.delay(Console.err.println(s"ResultSet.getInt($a)")) *>
    F.delay(value.getInt(a))

  def getInt(a: String) =
    F.delay(Console.err.println(s"ResultSet.getInt($a)")) *>
    F.delay(value.getInt(a))

  def getLong(a: Int) =
    F.delay(Console.err.println(s"ResultSet.getLong($a)")) *>
    F.delay(value.getLong(a))

  def getLong(a: String) =
    F.delay(Console.err.println(s"ResultSet.getLong($a)")) *>
    F.delay(value.getLong(a))

  def getMetaData =
    F.delay(Console.err.println("ResultSet.getMetaData()")) *>
    F.delay(value.getMetaData())

  def getNCharacterStream(a: Int) =
    F.delay(Console.err.println(s"ResultSet.getNCharacterStream($a)")) *>
    F.delay(value.getNCharacterStream(a))

  def getNCharacterStream(a: String) =
    F.delay(Console.err.println(s"ResultSet.getNCharacterStream($a)")) *>
    F.delay(value.getNCharacterStream(a))

  def getNClob(a: Int) =
    F.delay(Console.err.println(s"ResultSet.getNClob($a)")) *>
    F.delay(value.getNClob(a))

  def getNClob(a: String) =
    F.delay(Console.err.println(s"ResultSet.getNClob($a)")) *>
    F.delay(value.getNClob(a))

  def getNString(a: Int) =
    F.delay(Console.err.println(s"ResultSet.getNString($a)")) *>
    F.delay(value.getNString(a))

  def getNString(a: String) =
    F.delay(Console.err.println(s"ResultSet.getNString($a)")) *>
    F.delay(value.getNString(a))

  def getObject(a: Int) =
    F.delay(Console.err.println(s"ResultSet.getObject($a)")) *>
    F.delay(value.getObject(a))

  def getObject[T](a: Int, b: Class[T]) =
    F.delay(Console.err.println(s"ResultSet.getObject($a, $b)")) *>
    F.delay(value.getObject(a, b))

  def getObject(a: Int, b: Map[String, Class[_]]) =
    F.delay(Console.err.println(s"ResultSet.getObject($a, $b)")) *>
    F.delay(value.getObject(a, b))

  def getObject(a: String) =
    F.delay(Console.err.println(s"ResultSet.getObject($a)")) *>
    F.delay(value.getObject(a))

  def getObject[T](a: String, b: Class[T]) =
    F.delay(Console.err.println(s"ResultSet.getObject($a, $b)")) *>
    F.delay(value.getObject(a, b))

  def getObject(a: String, b: Map[String, Class[_]]) =
    F.delay(Console.err.println(s"ResultSet.getObject($a, $b)")) *>
    F.delay(value.getObject(a, b))

  def getRef(a: Int) =
    F.delay(Console.err.println(s"ResultSet.getRef($a)")) *>
    F.delay(value.getRef(a))

  def getRef(a: String) =
    F.delay(Console.err.println(s"ResultSet.getRef($a)")) *>
    F.delay(value.getRef(a))

  def getRow =
    F.delay(Console.err.println("ResultSet.getRow()")) *>
    F.delay(value.getRow())

  def getRowId(a: Int) =
    F.delay(Console.err.println(s"ResultSet.getRowId($a)")) *>
    F.delay(value.getRowId(a))

  def getRowId(a: String) =
    F.delay(Console.err.println(s"ResultSet.getRowId($a)")) *>
    F.delay(value.getRowId(a))

  def getSQLXML(a: Int) =
    F.delay(Console.err.println(s"ResultSet.getSQLXML($a)")) *>
    F.delay(value.getSQLXML(a))

  def getSQLXML(a: String) =
    F.delay(Console.err.println(s"ResultSet.getSQLXML($a)")) *>
    F.delay(value.getSQLXML(a))

  def getShort(a: Int) =
    F.delay(Console.err.println(s"ResultSet.getShort($a)")) *>
    F.delay(value.getShort(a))

  def getShort(a: String) =
    F.delay(Console.err.println(s"ResultSet.getShort($a)")) *>
    F.delay(value.getShort(a))

  def getStatement =
    F.delay(Console.err.println("ResultSet.getStatement()")) *>
    F.delay(value.getStatement())

  def getString(a: Int) =
    F.delay(Console.err.println(s"ResultSet.getString($a)")) *>
    F.delay(value.getString(a))

  def getString(a: String) =
    F.delay(Console.err.println(s"ResultSet.getString($a)")) *>
    F.delay(value.getString(a))

  def getTime(a: Int) =
    F.delay(Console.err.println(s"ResultSet.getTime($a)")) *>
    F.delay(value.getTime(a))

  def getTime(a: Int, b: Calendar) =
    F.delay(Console.err.println(s"ResultSet.getTime($a, $b)")) *>
    F.delay(value.getTime(a, b))

  def getTime(a: String) =
    F.delay(Console.err.println(s"ResultSet.getTime($a)")) *>
    F.delay(value.getTime(a))

  def getTime(a: String, b: Calendar) =
    F.delay(Console.err.println(s"ResultSet.getTime($a, $b)")) *>
    F.delay(value.getTime(a, b))

  def getTimestamp(a: Int) =
    F.delay(Console.err.println(s"ResultSet.getTimestamp($a)")) *>
    F.delay(value.getTimestamp(a))

  def getTimestamp(a: Int, b: Calendar) =
    F.delay(Console.err.println(s"ResultSet.getTimestamp($a, $b)")) *>
    F.delay(value.getTimestamp(a, b))

  def getTimestamp(a: String) =
    F.delay(Console.err.println(s"ResultSet.getTimestamp($a)")) *>
    F.delay(value.getTimestamp(a))

  def getTimestamp(a: String, b: Calendar) =
    F.delay(Console.err.println(s"ResultSet.getTimestamp($a, $b)")) *>
    F.delay(value.getTimestamp(a, b))

  def getType =
    F.delay(Console.err.println("ResultSet.getType()")) *>
    F.delay(value.getType())

  def getURL(a: Int) =
    F.delay(Console.err.println(s"ResultSet.getURL($a)")) *>
    F.delay(value.getURL(a))

  def getURL(a: String) =
    F.delay(Console.err.println(s"ResultSet.getURL($a)")) *>
    F.delay(value.getURL(a))

  def getUnicodeStream(a: Int) =
    F.delay(Console.err.println(s"ResultSet.getUnicodeStream($a)")) *>
    F.delay(value.getUnicodeStream(a))

  def getUnicodeStream(a: String) =
    F.delay(Console.err.println(s"ResultSet.getUnicodeStream($a)")) *>
    F.delay(value.getUnicodeStream(a))

  def getWarnings =
    F.delay(Console.err.println("ResultSet.getWarnings()")) *>
    F.delay(value.getWarnings())

  def insertRow =
    F.delay(Console.err.println("ResultSet.insertRow()")) *>
    F.delay(value.insertRow())

  def isAfterLast =
    F.delay(Console.err.println("ResultSet.isAfterLast()")) *>
    F.delay(value.isAfterLast())

  def isBeforeFirst =
    F.delay(Console.err.println("ResultSet.isBeforeFirst()")) *>
    F.delay(value.isBeforeFirst())

  def isClosed =
    F.delay(Console.err.println("ResultSet.isClosed()")) *>
    F.delay(value.isClosed())

  def isFirst =
    F.delay(Console.err.println("ResultSet.isFirst()")) *>
    F.delay(value.isFirst())

  def isLast =
    F.delay(Console.err.println("ResultSet.isLast()")) *>
    F.delay(value.isLast())

  def isWrapperFor(a: Class[_]) =
    F.delay(Console.err.println(s"ResultSet.isWrapperFor($a)")) *>
    F.delay(value.isWrapperFor(a))

  def last =
    F.delay(Console.err.println("ResultSet.last()")) *>
    F.delay(value.last())

  def moveToCurrentRow =
    F.delay(Console.err.println("ResultSet.moveToCurrentRow()")) *>
    F.delay(value.moveToCurrentRow())

  def moveToInsertRow =
    F.delay(Console.err.println("ResultSet.moveToInsertRow()")) *>
    F.delay(value.moveToInsertRow())

  def next =
    F.delay(Console.err.println("ResultSet.next()")) *>
    F.delay(value.next())

  def previous =
    F.delay(Console.err.println("ResultSet.previous()")) *>
    F.delay(value.previous())

  def refreshRow =
    F.delay(Console.err.println("ResultSet.refreshRow()")) *>
    F.delay(value.refreshRow())

  def relative(a: Int) =
    F.delay(Console.err.println(s"ResultSet.relative($a)")) *>
    F.delay(value.relative(a))

  def rowDeleted =
    F.delay(Console.err.println("ResultSet.rowDeleted()")) *>
    F.delay(value.rowDeleted())

  def rowInserted =
    F.delay(Console.err.println("ResultSet.rowInserted()")) *>
    F.delay(value.rowInserted())

  def rowUpdated =
    F.delay(Console.err.println("ResultSet.rowUpdated()")) *>
    F.delay(value.rowUpdated())

  def setFetchDirection(a: Int) =
    F.delay(Console.err.println(s"ResultSet.setFetchDirection($a)")) *>
    F.delay(value.setFetchDirection(a))

  def setFetchSize(a: Int) =
    F.delay(Console.err.println(s"ResultSet.setFetchSize($a)")) *>
    F.delay(value.setFetchSize(a))

  def unwrap[T](a: Class[T]) =
    F.delay(Console.err.println(s"ResultSet.unwrap($a)")) *>
    F.delay(value.unwrap(a))

  def updateArray(a: Int, b: SqlArray) =
    F.delay(Console.err.println(s"ResultSet.updateArray($a, $b)")) *>
    F.delay(value.updateArray(a, b))

  def updateArray(a: String, b: SqlArray) =
    F.delay(Console.err.println(s"ResultSet.updateArray($a, $b)")) *>
    F.delay(value.updateArray(a, b))

  def updateAsciiStream(a: Int, b: InputStream) =
    F.delay(Console.err.println(s"ResultSet.updateAsciiStream($a, $b)")) *>
    F.delay(value.updateAsciiStream(a, b))

  def updateAsciiStream(a: Int, b: InputStream, c: Int) =
    F.delay(Console.err.println(s"ResultSet.updateAsciiStream($a, $b, $c)")) *>
    F.delay(value.updateAsciiStream(a, b, c))

  def updateAsciiStream(a: Int, b: InputStream, c: Long) =
    F.delay(Console.err.println(s"ResultSet.updateAsciiStream($a, $b, $c)")) *>
    F.delay(value.updateAsciiStream(a, b, c))

  def updateAsciiStream(a: String, b: InputStream) =
    F.delay(Console.err.println(s"ResultSet.updateAsciiStream($a, $b)")) *>
    F.delay(value.updateAsciiStream(a, b))

  def updateAsciiStream(a: String, b: InputStream, c: Int) =
    F.delay(Console.err.println(s"ResultSet.updateAsciiStream($a, $b, $c)")) *>
    F.delay(value.updateAsciiStream(a, b, c))

  def updateAsciiStream(a: String, b: InputStream, c: Long) =
    F.delay(Console.err.println(s"ResultSet.updateAsciiStream($a, $b, $c)")) *>
    F.delay(value.updateAsciiStream(a, b, c))

  def updateBigDecimal(a: Int, b: BigDecimal) =
    F.delay(Console.err.println(s"ResultSet.updateBigDecimal($a, $b)")) *>
    F.delay(value.updateBigDecimal(a, b))

  def updateBigDecimal(a: String, b: BigDecimal) =
    F.delay(Console.err.println(s"ResultSet.updateBigDecimal($a, $b)")) *>
    F.delay(value.updateBigDecimal(a, b))

  def updateBinaryStream(a: Int, b: InputStream) =
    F.delay(Console.err.println(s"ResultSet.updateBinaryStream($a, $b)")) *>
    F.delay(value.updateBinaryStream(a, b))

  def updateBinaryStream(a: Int, b: InputStream, c: Int) =
    F.delay(Console.err.println(s"ResultSet.updateBinaryStream($a, $b, $c)")) *>
    F.delay(value.updateBinaryStream(a, b, c))

  def updateBinaryStream(a: Int, b: InputStream, c: Long) =
    F.delay(Console.err.println(s"ResultSet.updateBinaryStream($a, $b, $c)")) *>
    F.delay(value.updateBinaryStream(a, b, c))

  def updateBinaryStream(a: String, b: InputStream) =
    F.delay(Console.err.println(s"ResultSet.updateBinaryStream($a, $b)")) *>
    F.delay(value.updateBinaryStream(a, b))

  def updateBinaryStream(a: String, b: InputStream, c: Int) =
    F.delay(Console.err.println(s"ResultSet.updateBinaryStream($a, $b, $c)")) *>
    F.delay(value.updateBinaryStream(a, b, c))

  def updateBinaryStream(a: String, b: InputStream, c: Long) =
    F.delay(Console.err.println(s"ResultSet.updateBinaryStream($a, $b, $c)")) *>
    F.delay(value.updateBinaryStream(a, b, c))

  def updateBlob(a: Int, b: Blob) =
    F.delay(Console.err.println(s"ResultSet.updateBlob($a, $b)")) *>
    F.delay(value.updateBlob(a, b))

  def updateBlob(a: Int, b: InputStream) =
    F.delay(Console.err.println(s"ResultSet.updateBlob($a, $b)")) *>
    F.delay(value.updateBlob(a, b))

  def updateBlob(a: Int, b: InputStream, c: Long) =
    F.delay(Console.err.println(s"ResultSet.updateBlob($a, $b, $c)")) *>
    F.delay(value.updateBlob(a, b, c))

  def updateBlob(a: String, b: Blob) =
    F.delay(Console.err.println(s"ResultSet.updateBlob($a, $b)")) *>
    F.delay(value.updateBlob(a, b))

  def updateBlob(a: String, b: InputStream) =
    F.delay(Console.err.println(s"ResultSet.updateBlob($a, $b)")) *>
    F.delay(value.updateBlob(a, b))

  def updateBlob(a: String, b: InputStream, c: Long) =
    F.delay(Console.err.println(s"ResultSet.updateBlob($a, $b, $c)")) *>
    F.delay(value.updateBlob(a, b, c))

  def updateBoolean(a: Int, b: Boolean) =
    F.delay(Console.err.println(s"ResultSet.updateBoolean($a, $b)")) *>
    F.delay(value.updateBoolean(a, b))

  def updateBoolean(a: String, b: Boolean) =
    F.delay(Console.err.println(s"ResultSet.updateBoolean($a, $b)")) *>
    F.delay(value.updateBoolean(a, b))

  def updateByte(a: Int, b: Byte) =
    F.delay(Console.err.println(s"ResultSet.updateByte($a, $b)")) *>
    F.delay(value.updateByte(a, b))

  def updateByte(a: String, b: Byte) =
    F.delay(Console.err.println(s"ResultSet.updateByte($a, $b)")) *>
    F.delay(value.updateByte(a, b))

  def updateBytes(a: Int, b: Array[Byte]) =
    F.delay(Console.err.println(s"ResultSet.updateBytes($a, $b)")) *>
    F.delay(value.updateBytes(a, b))

  def updateBytes(a: String, b: Array[Byte]) =
    F.delay(Console.err.println(s"ResultSet.updateBytes($a, $b)")) *>
    F.delay(value.updateBytes(a, b))

  def updateCharacterStream(a: Int, b: Reader) =
    F.delay(Console.err.println(s"ResultSet.updateCharacterStream($a, $b)")) *>
    F.delay(value.updateCharacterStream(a, b))

  def updateCharacterStream(a: Int, b: Reader, c: Int) =
    F.delay(Console.err.println(s"ResultSet.updateCharacterStream($a, $b, $c)")) *>
    F.delay(value.updateCharacterStream(a, b, c))

  def updateCharacterStream(a: Int, b: Reader, c: Long) =
    F.delay(Console.err.println(s"ResultSet.updateCharacterStream($a, $b, $c)")) *>
    F.delay(value.updateCharacterStream(a, b, c))

  def updateCharacterStream(a: String, b: Reader) =
    F.delay(Console.err.println(s"ResultSet.updateCharacterStream($a, $b)")) *>
    F.delay(value.updateCharacterStream(a, b))

  def updateCharacterStream(a: String, b: Reader, c: Int) =
    F.delay(Console.err.println(s"ResultSet.updateCharacterStream($a, $b, $c)")) *>
    F.delay(value.updateCharacterStream(a, b, c))

  def updateCharacterStream(a: String, b: Reader, c: Long) =
    F.delay(Console.err.println(s"ResultSet.updateCharacterStream($a, $b, $c)")) *>
    F.delay(value.updateCharacterStream(a, b, c))

  def updateClob(a: Int, b: Clob) =
    F.delay(Console.err.println(s"ResultSet.updateClob($a, $b)")) *>
    F.delay(value.updateClob(a, b))

  def updateClob(a: Int, b: Reader) =
    F.delay(Console.err.println(s"ResultSet.updateClob($a, $b)")) *>
    F.delay(value.updateClob(a, b))

  def updateClob(a: Int, b: Reader, c: Long) =
    F.delay(Console.err.println(s"ResultSet.updateClob($a, $b, $c)")) *>
    F.delay(value.updateClob(a, b, c))

  def updateClob(a: String, b: Clob) =
    F.delay(Console.err.println(s"ResultSet.updateClob($a, $b)")) *>
    F.delay(value.updateClob(a, b))

  def updateClob(a: String, b: Reader) =
    F.delay(Console.err.println(s"ResultSet.updateClob($a, $b)")) *>
    F.delay(value.updateClob(a, b))

  def updateClob(a: String, b: Reader, c: Long) =
    F.delay(Console.err.println(s"ResultSet.updateClob($a, $b, $c)")) *>
    F.delay(value.updateClob(a, b, c))

  def updateDate(a: Int, b: Date) =
    F.delay(Console.err.println(s"ResultSet.updateDate($a, $b)")) *>
    F.delay(value.updateDate(a, b))

  def updateDate(a: String, b: Date) =
    F.delay(Console.err.println(s"ResultSet.updateDate($a, $b)")) *>
    F.delay(value.updateDate(a, b))

  def updateDouble(a: Int, b: Double) =
    F.delay(Console.err.println(s"ResultSet.updateDouble($a, $b)")) *>
    F.delay(value.updateDouble(a, b))

  def updateDouble(a: String, b: Double) =
    F.delay(Console.err.println(s"ResultSet.updateDouble($a, $b)")) *>
    F.delay(value.updateDouble(a, b))

  def updateFloat(a: Int, b: Float) =
    F.delay(Console.err.println(s"ResultSet.updateFloat($a, $b)")) *>
    F.delay(value.updateFloat(a, b))

  def updateFloat(a: String, b: Float) =
    F.delay(Console.err.println(s"ResultSet.updateFloat($a, $b)")) *>
    F.delay(value.updateFloat(a, b))

  def updateInt(a: Int, b: Int) =
    F.delay(Console.err.println(s"ResultSet.updateInt($a, $b)")) *>
    F.delay(value.updateInt(a, b))

  def updateInt(a: String, b: Int) =
    F.delay(Console.err.println(s"ResultSet.updateInt($a, $b)")) *>
    F.delay(value.updateInt(a, b))

  def updateLong(a: Int, b: Long) =
    F.delay(Console.err.println(s"ResultSet.updateLong($a, $b)")) *>
    F.delay(value.updateLong(a, b))

  def updateLong(a: String, b: Long) =
    F.delay(Console.err.println(s"ResultSet.updateLong($a, $b)")) *>
    F.delay(value.updateLong(a, b))

  def updateNCharacterStream(a: Int, b: Reader) =
    F.delay(Console.err.println(s"ResultSet.updateNCharacterStream($a, $b)")) *>
    F.delay(value.updateNCharacterStream(a, b))

  def updateNCharacterStream(a: Int, b: Reader, c: Long) =
    F.delay(Console.err.println(s"ResultSet.updateNCharacterStream($a, $b, $c)")) *>
    F.delay(value.updateNCharacterStream(a, b, c))

  def updateNCharacterStream(a: String, b: Reader) =
    F.delay(Console.err.println(s"ResultSet.updateNCharacterStream($a, $b)")) *>
    F.delay(value.updateNCharacterStream(a, b))

  def updateNCharacterStream(a: String, b: Reader, c: Long) =
    F.delay(Console.err.println(s"ResultSet.updateNCharacterStream($a, $b, $c)")) *>
    F.delay(value.updateNCharacterStream(a, b, c))

  def updateNClob(a: Int, b: NClob) =
    F.delay(Console.err.println(s"ResultSet.updateNClob($a, $b)")) *>
    F.delay(value.updateNClob(a, b))

  def updateNClob(a: Int, b: Reader) =
    F.delay(Console.err.println(s"ResultSet.updateNClob($a, $b)")) *>
    F.delay(value.updateNClob(a, b))

  def updateNClob(a: Int, b: Reader, c: Long) =
    F.delay(Console.err.println(s"ResultSet.updateNClob($a, $b, $c)")) *>
    F.delay(value.updateNClob(a, b, c))

  def updateNClob(a: String, b: NClob) =
    F.delay(Console.err.println(s"ResultSet.updateNClob($a, $b)")) *>
    F.delay(value.updateNClob(a, b))

  def updateNClob(a: String, b: Reader) =
    F.delay(Console.err.println(s"ResultSet.updateNClob($a, $b)")) *>
    F.delay(value.updateNClob(a, b))

  def updateNClob(a: String, b: Reader, c: Long) =
    F.delay(Console.err.println(s"ResultSet.updateNClob($a, $b, $c)")) *>
    F.delay(value.updateNClob(a, b, c))

  def updateNString(a: Int, b: String) =
    F.delay(Console.err.println(s"ResultSet.updateNString($a, $b)")) *>
    F.delay(value.updateNString(a, b))

  def updateNString(a: String, b: String) =
    F.delay(Console.err.println(s"ResultSet.updateNString($a, $b)")) *>
    F.delay(value.updateNString(a, b))

  def updateNull(a: Int) =
    F.delay(Console.err.println(s"ResultSet.updateNull($a)")) *>
    F.delay(value.updateNull(a))

  def updateNull(a: String) =
    F.delay(Console.err.println(s"ResultSet.updateNull($a)")) *>
    F.delay(value.updateNull(a))

  def updateObject(a: Int, b: AnyRef) =
    F.delay(Console.err.println(s"ResultSet.updateObject($a, $b)")) *>
    F.delay(value.updateObject(a, b))

  def updateObject(a: Int, b: AnyRef, c: Int) =
    F.delay(Console.err.println(s"ResultSet.updateObject($a, $b, $c)")) *>
    F.delay(value.updateObject(a, b, c))

  def updateObject(a: Int, b: AnyRef, c: SQLType) =
    F.delay(Console.err.println(s"ResultSet.updateObject($a, $b, $c)")) *>
    F.delay(value.updateObject(a, b, c))

  def updateObject(a: Int, b: AnyRef, c: SQLType, d: Int) =
    F.delay(Console.err.println(s"ResultSet.updateObject($a, $b, $c, $d)")) *>
    F.delay(value.updateObject(a, b, c, d))

  def updateObject(a: String, b: AnyRef) =
    F.delay(Console.err.println(s"ResultSet.updateObject($a, $b)")) *>
    F.delay(value.updateObject(a, b))

  def updateObject(a: String, b: AnyRef, c: Int) =
    F.delay(Console.err.println(s"ResultSet.updateObject($a, $b, $c)")) *>
    F.delay(value.updateObject(a, b, c))

  def updateObject(a: String, b: AnyRef, c: SQLType) =
    F.delay(Console.err.println(s"ResultSet.updateObject($a, $b, $c)")) *>
    F.delay(value.updateObject(a, b, c))

  def updateObject(a: String, b: AnyRef, c: SQLType, d: Int) =
    F.delay(Console.err.println(s"ResultSet.updateObject($a, $b, $c, $d)")) *>
    F.delay(value.updateObject(a, b, c, d))

  def updateRef(a: Int, b: Ref) =
    F.delay(Console.err.println(s"ResultSet.updateRef($a, $b)")) *>
    F.delay(value.updateRef(a, b))

  def updateRef(a: String, b: Ref) =
    F.delay(Console.err.println(s"ResultSet.updateRef($a, $b)")) *>
    F.delay(value.updateRef(a, b))

  def updateRow =
    F.delay(Console.err.println("ResultSet.updateRow()")) *>
    F.delay(value.updateRow())

  def updateRowId(a: Int, b: RowId) =
    F.delay(Console.err.println(s"ResultSet.updateRowId($a, $b)")) *>
    F.delay(value.updateRowId(a, b))

  def updateRowId(a: String, b: RowId) =
    F.delay(Console.err.println(s"ResultSet.updateRowId($a, $b)")) *>
    F.delay(value.updateRowId(a, b))

  def updateSQLXML(a: Int, b: SQLXML) =
    F.delay(Console.err.println(s"ResultSet.updateSQLXML($a, $b)")) *>
    F.delay(value.updateSQLXML(a, b))

  def updateSQLXML(a: String, b: SQLXML) =
    F.delay(Console.err.println(s"ResultSet.updateSQLXML($a, $b)")) *>
    F.delay(value.updateSQLXML(a, b))

  def updateShort(a: Int, b: Short) =
    F.delay(Console.err.println(s"ResultSet.updateShort($a, $b)")) *>
    F.delay(value.updateShort(a, b))

  def updateShort(a: String, b: Short) =
    F.delay(Console.err.println(s"ResultSet.updateShort($a, $b)")) *>
    F.delay(value.updateShort(a, b))

  def updateString(a: Int, b: String) =
    F.delay(Console.err.println(s"ResultSet.updateString($a, $b)")) *>
    F.delay(value.updateString(a, b))

  def updateString(a: String, b: String) =
    F.delay(Console.err.println(s"ResultSet.updateString($a, $b)")) *>
    F.delay(value.updateString(a, b))

  def updateTime(a: Int, b: Time) =
    F.delay(Console.err.println(s"ResultSet.updateTime($a, $b)")) *>
    F.delay(value.updateTime(a, b))

  def updateTime(a: String, b: Time) =
    F.delay(Console.err.println(s"ResultSet.updateTime($a, $b)")) *>
    F.delay(value.updateTime(a, b))

  def updateTimestamp(a: Int, b: Timestamp) =
    F.delay(Console.err.println(s"ResultSet.updateTimestamp($a, $b)")) *>
    F.delay(value.updateTimestamp(a, b))

  def updateTimestamp(a: String, b: Timestamp) =
    F.delay(Console.err.println(s"ResultSet.updateTimestamp($a, $b)")) *>
    F.delay(value.updateTimestamp(a, b))

  def wasNull =
    F.delay(Console.err.println("ResultSet.wasNull()")) *>
    F.delay(value.wasNull())

}

