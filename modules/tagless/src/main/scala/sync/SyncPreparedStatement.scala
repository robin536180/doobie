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
import java.sql.Connection
import java.sql.Date
import java.sql.NClob
import java.sql.ParameterMetaData
import java.sql.PreparedStatement
import java.sql.Ref
import java.sql.ResultSet
import java.sql.ResultSetMetaData
import java.sql.RowId
import java.sql.SQLType
import java.sql.SQLWarning
import java.sql.SQLXML
import java.sql.Time
import java.sql.Timestamp
import java.sql.{ Array => SqlArray }
import java.util.Calendar

/**
 * Implementation of JdbcPreparedStatement that wraps a PreparedStatement and lifts its primitive operations into any F
 * given a Sync instance.
 */
@SuppressWarnings(Array("org.wartremover.warts.Overloading"))
class SyncPreparedStatement[F[_]](value: PreparedStatement)(implicit F: Sync[F]) extends JdbcPreparedStatement[F] {

  def addBatch =
    F.delay(Console.err.println("PreparedStatement.addBatch()")) *>
    F.delay(value.addBatch())

  def addBatch(a: String) =
    F.delay(Console.err.println(s"PreparedStatement.addBatch($a)")) *>
    F.delay(value.addBatch(a))

  def cancel =
    F.delay(Console.err.println("PreparedStatement.cancel()")) *>
    F.delay(value.cancel())

  def clearBatch =
    F.delay(Console.err.println("PreparedStatement.clearBatch()")) *>
    F.delay(value.clearBatch())

  def clearParameters =
    F.delay(Console.err.println("PreparedStatement.clearParameters()")) *>
    F.delay(value.clearParameters())

  def clearWarnings =
    F.delay(Console.err.println("PreparedStatement.clearWarnings()")) *>
    F.delay(value.clearWarnings())

  def close =
    F.delay(Console.err.println("PreparedStatement.close()")) *>
    F.delay(value.close())

  def closeOnCompletion =
    F.delay(Console.err.println("PreparedStatement.closeOnCompletion()")) *>
    F.delay(value.closeOnCompletion())

  def execute =
    F.delay(Console.err.println("PreparedStatement.execute()")) *>
    F.delay(value.execute())

  def execute(a: String) =
    F.delay(Console.err.println(s"PreparedStatement.execute($a)")) *>
    F.delay(value.execute(a))

  def execute(a: String, b: Array[Int]) =
    F.delay(Console.err.println(s"PreparedStatement.execute($a, $b)")) *>
    F.delay(value.execute(a, b))

  def execute(a: String, b: Array[String]) =
    F.delay(Console.err.println(s"PreparedStatement.execute($a, $b)")) *>
    F.delay(value.execute(a, b))

  def execute(a: String, b: Int) =
    F.delay(Console.err.println(s"PreparedStatement.execute($a, $b)")) *>
    F.delay(value.execute(a, b))

  def executeBatch =
    F.delay(Console.err.println("PreparedStatement.executeBatch()")) *>
    F.delay(value.executeBatch())

  def executeLargeBatch =
    F.delay(Console.err.println("PreparedStatement.executeLargeBatch()")) *>
    F.delay(value.executeLargeBatch())

  def executeLargeUpdate =
    F.delay(Console.err.println("PreparedStatement.executeLargeUpdate()")) *>
    F.delay(value.executeLargeUpdate())

  def executeLargeUpdate(a: String) =
    F.delay(Console.err.println(s"PreparedStatement.executeLargeUpdate($a)")) *>
    F.delay(value.executeLargeUpdate(a))

  def executeLargeUpdate(a: String, b: Array[Int]) =
    F.delay(Console.err.println(s"PreparedStatement.executeLargeUpdate($a, $b)")) *>
    F.delay(value.executeLargeUpdate(a, b))

  def executeLargeUpdate(a: String, b: Array[String]) =
    F.delay(Console.err.println(s"PreparedStatement.executeLargeUpdate($a, $b)")) *>
    F.delay(value.executeLargeUpdate(a, b))

  def executeLargeUpdate(a: String, b: Int) =
    F.delay(Console.err.println(s"PreparedStatement.executeLargeUpdate($a, $b)")) *>
    F.delay(value.executeLargeUpdate(a, b))

  def executeQuery =
    F.delay(Console.err.println("PreparedStatement.executeQuery()")) *>
    F.delay(value.executeQuery())

  def executeQuery(a: String) =
    F.delay(Console.err.println(s"PreparedStatement.executeQuery($a)")) *>
    F.delay(value.executeQuery(a))

  def executeUpdate =
    F.delay(Console.err.println("PreparedStatement.executeUpdate()")) *>
    F.delay(value.executeUpdate())

  def executeUpdate(a: String) =
    F.delay(Console.err.println(s"PreparedStatement.executeUpdate($a)")) *>
    F.delay(value.executeUpdate(a))

  def executeUpdate(a: String, b: Array[Int]) =
    F.delay(Console.err.println(s"PreparedStatement.executeUpdate($a, $b)")) *>
    F.delay(value.executeUpdate(a, b))

  def executeUpdate(a: String, b: Array[String]) =
    F.delay(Console.err.println(s"PreparedStatement.executeUpdate($a, $b)")) *>
    F.delay(value.executeUpdate(a, b))

  def executeUpdate(a: String, b: Int) =
    F.delay(Console.err.println(s"PreparedStatement.executeUpdate($a, $b)")) *>
    F.delay(value.executeUpdate(a, b))

  def getConnection =
    F.delay(Console.err.println("PreparedStatement.getConnection()")) *>
    F.delay(value.getConnection())

  def getFetchDirection =
    F.delay(Console.err.println("PreparedStatement.getFetchDirection()")) *>
    F.delay(value.getFetchDirection())

  def getFetchSize =
    F.delay(Console.err.println("PreparedStatement.getFetchSize()")) *>
    F.delay(value.getFetchSize())

  def getGeneratedKeys =
    F.delay(Console.err.println("PreparedStatement.getGeneratedKeys()")) *>
    F.delay(value.getGeneratedKeys())

  def getLargeMaxRows =
    F.delay(Console.err.println("PreparedStatement.getLargeMaxRows()")) *>
    F.delay(value.getLargeMaxRows())

  def getLargeUpdateCount =
    F.delay(Console.err.println("PreparedStatement.getLargeUpdateCount()")) *>
    F.delay(value.getLargeUpdateCount())

  def getMaxFieldSize =
    F.delay(Console.err.println("PreparedStatement.getMaxFieldSize()")) *>
    F.delay(value.getMaxFieldSize())

  def getMaxRows =
    F.delay(Console.err.println("PreparedStatement.getMaxRows()")) *>
    F.delay(value.getMaxRows())

  def getMetaData =
    F.delay(Console.err.println("PreparedStatement.getMetaData()")) *>
    F.delay(value.getMetaData())

  def getMoreResults =
    F.delay(Console.err.println("PreparedStatement.getMoreResults()")) *>
    F.delay(value.getMoreResults())

  def getMoreResults(a: Int) =
    F.delay(Console.err.println(s"PreparedStatement.getMoreResults($a)")) *>
    F.delay(value.getMoreResults(a))

  def getParameterMetaData =
    F.delay(Console.err.println("PreparedStatement.getParameterMetaData()")) *>
    F.delay(value.getParameterMetaData())

  def getQueryTimeout =
    F.delay(Console.err.println("PreparedStatement.getQueryTimeout()")) *>
    F.delay(value.getQueryTimeout())

  def getResultSet =
    F.delay(Console.err.println("PreparedStatement.getResultSet()")) *>
    F.delay(value.getResultSet())

  def getResultSetConcurrency =
    F.delay(Console.err.println("PreparedStatement.getResultSetConcurrency()")) *>
    F.delay(value.getResultSetConcurrency())

  def getResultSetHoldability =
    F.delay(Console.err.println("PreparedStatement.getResultSetHoldability()")) *>
    F.delay(value.getResultSetHoldability())

  def getResultSetType =
    F.delay(Console.err.println("PreparedStatement.getResultSetType()")) *>
    F.delay(value.getResultSetType())

  def getUpdateCount =
    F.delay(Console.err.println("PreparedStatement.getUpdateCount()")) *>
    F.delay(value.getUpdateCount())

  def getWarnings =
    F.delay(Console.err.println("PreparedStatement.getWarnings()")) *>
    F.delay(value.getWarnings())

  def isCloseOnCompletion =
    F.delay(Console.err.println("PreparedStatement.isCloseOnCompletion()")) *>
    F.delay(value.isCloseOnCompletion())

  def isClosed =
    F.delay(Console.err.println("PreparedStatement.isClosed()")) *>
    F.delay(value.isClosed())

  def isPoolable =
    F.delay(Console.err.println("PreparedStatement.isPoolable()")) *>
    F.delay(value.isPoolable())

  def isWrapperFor(a: Class[_]) =
    F.delay(Console.err.println(s"PreparedStatement.isWrapperFor($a)")) *>
    F.delay(value.isWrapperFor(a))

  def setArray(a: Int, b: SqlArray) =
    F.delay(Console.err.println(s"PreparedStatement.setArray($a, $b)")) *>
    F.delay(value.setArray(a, b))

  def setAsciiStream(a: Int, b: InputStream) =
    F.delay(Console.err.println(s"PreparedStatement.setAsciiStream($a, $b)")) *>
    F.delay(value.setAsciiStream(a, b))

  def setAsciiStream(a: Int, b: InputStream, c: Int) =
    F.delay(Console.err.println(s"PreparedStatement.setAsciiStream($a, $b, $c)")) *>
    F.delay(value.setAsciiStream(a, b, c))

  def setAsciiStream(a: Int, b: InputStream, c: Long) =
    F.delay(Console.err.println(s"PreparedStatement.setAsciiStream($a, $b, $c)")) *>
    F.delay(value.setAsciiStream(a, b, c))

  def setBigDecimal(a: Int, b: BigDecimal) =
    F.delay(Console.err.println(s"PreparedStatement.setBigDecimal($a, $b)")) *>
    F.delay(value.setBigDecimal(a, b))

  def setBinaryStream(a: Int, b: InputStream) =
    F.delay(Console.err.println(s"PreparedStatement.setBinaryStream($a, $b)")) *>
    F.delay(value.setBinaryStream(a, b))

  def setBinaryStream(a: Int, b: InputStream, c: Int) =
    F.delay(Console.err.println(s"PreparedStatement.setBinaryStream($a, $b, $c)")) *>
    F.delay(value.setBinaryStream(a, b, c))

  def setBinaryStream(a: Int, b: InputStream, c: Long) =
    F.delay(Console.err.println(s"PreparedStatement.setBinaryStream($a, $b, $c)")) *>
    F.delay(value.setBinaryStream(a, b, c))

  def setBlob(a: Int, b: Blob) =
    F.delay(Console.err.println(s"PreparedStatement.setBlob($a, $b)")) *>
    F.delay(value.setBlob(a, b))

  def setBlob(a: Int, b: InputStream) =
    F.delay(Console.err.println(s"PreparedStatement.setBlob($a, $b)")) *>
    F.delay(value.setBlob(a, b))

  def setBlob(a: Int, b: InputStream, c: Long) =
    F.delay(Console.err.println(s"PreparedStatement.setBlob($a, $b, $c)")) *>
    F.delay(value.setBlob(a, b, c))

  def setBoolean(a: Int, b: Boolean) =
    F.delay(Console.err.println(s"PreparedStatement.setBoolean($a, $b)")) *>
    F.delay(value.setBoolean(a, b))

  def setByte(a: Int, b: Byte) =
    F.delay(Console.err.println(s"PreparedStatement.setByte($a, $b)")) *>
    F.delay(value.setByte(a, b))

  def setBytes(a: Int, b: Array[Byte]) =
    F.delay(Console.err.println(s"PreparedStatement.setBytes($a, $b)")) *>
    F.delay(value.setBytes(a, b))

  def setCharacterStream(a: Int, b: Reader) =
    F.delay(Console.err.println(s"PreparedStatement.setCharacterStream($a, $b)")) *>
    F.delay(value.setCharacterStream(a, b))

  def setCharacterStream(a: Int, b: Reader, c: Int) =
    F.delay(Console.err.println(s"PreparedStatement.setCharacterStream($a, $b, $c)")) *>
    F.delay(value.setCharacterStream(a, b, c))

  def setCharacterStream(a: Int, b: Reader, c: Long) =
    F.delay(Console.err.println(s"PreparedStatement.setCharacterStream($a, $b, $c)")) *>
    F.delay(value.setCharacterStream(a, b, c))

  def setClob(a: Int, b: Clob) =
    F.delay(Console.err.println(s"PreparedStatement.setClob($a, $b)")) *>
    F.delay(value.setClob(a, b))

  def setClob(a: Int, b: Reader) =
    F.delay(Console.err.println(s"PreparedStatement.setClob($a, $b)")) *>
    F.delay(value.setClob(a, b))

  def setClob(a: Int, b: Reader, c: Long) =
    F.delay(Console.err.println(s"PreparedStatement.setClob($a, $b, $c)")) *>
    F.delay(value.setClob(a, b, c))

  def setCursorName(a: String) =
    F.delay(Console.err.println(s"PreparedStatement.setCursorName($a)")) *>
    F.delay(value.setCursorName(a))

  def setDate(a: Int, b: Date) =
    F.delay(Console.err.println(s"PreparedStatement.setDate($a, $b)")) *>
    F.delay(value.setDate(a, b))

  def setDate(a: Int, b: Date, c: Calendar) =
    F.delay(Console.err.println(s"PreparedStatement.setDate($a, $b, $c)")) *>
    F.delay(value.setDate(a, b, c))

  def setDouble(a: Int, b: Double) =
    F.delay(Console.err.println(s"PreparedStatement.setDouble($a, $b)")) *>
    F.delay(value.setDouble(a, b))

  def setEscapeProcessing(a: Boolean) =
    F.delay(Console.err.println(s"PreparedStatement.setEscapeProcessing($a)")) *>
    F.delay(value.setEscapeProcessing(a))

  def setFetchDirection(a: Int) =
    F.delay(Console.err.println(s"PreparedStatement.setFetchDirection($a)")) *>
    F.delay(value.setFetchDirection(a))

  def setFetchSize(a: Int) =
    F.delay(Console.err.println(s"PreparedStatement.setFetchSize($a)")) *>
    F.delay(value.setFetchSize(a))

  def setFloat(a: Int, b: Float) =
    F.delay(Console.err.println(s"PreparedStatement.setFloat($a, $b)")) *>
    F.delay(value.setFloat(a, b))

  def setInt(a: Int, b: Int) =
    F.delay(Console.err.println(s"PreparedStatement.setInt($a, $b)")) *>
    F.delay(value.setInt(a, b))

  def setLargeMaxRows(a: Long) =
    F.delay(Console.err.println(s"PreparedStatement.setLargeMaxRows($a)")) *>
    F.delay(value.setLargeMaxRows(a))

  def setLong(a: Int, b: Long) =
    F.delay(Console.err.println(s"PreparedStatement.setLong($a, $b)")) *>
    F.delay(value.setLong(a, b))

  def setMaxFieldSize(a: Int) =
    F.delay(Console.err.println(s"PreparedStatement.setMaxFieldSize($a)")) *>
    F.delay(value.setMaxFieldSize(a))

  def setMaxRows(a: Int) =
    F.delay(Console.err.println(s"PreparedStatement.setMaxRows($a)")) *>
    F.delay(value.setMaxRows(a))

  def setNCharacterStream(a: Int, b: Reader) =
    F.delay(Console.err.println(s"PreparedStatement.setNCharacterStream($a, $b)")) *>
    F.delay(value.setNCharacterStream(a, b))

  def setNCharacterStream(a: Int, b: Reader, c: Long) =
    F.delay(Console.err.println(s"PreparedStatement.setNCharacterStream($a, $b, $c)")) *>
    F.delay(value.setNCharacterStream(a, b, c))

  def setNClob(a: Int, b: NClob) =
    F.delay(Console.err.println(s"PreparedStatement.setNClob($a, $b)")) *>
    F.delay(value.setNClob(a, b))

  def setNClob(a: Int, b: Reader) =
    F.delay(Console.err.println(s"PreparedStatement.setNClob($a, $b)")) *>
    F.delay(value.setNClob(a, b))

  def setNClob(a: Int, b: Reader, c: Long) =
    F.delay(Console.err.println(s"PreparedStatement.setNClob($a, $b, $c)")) *>
    F.delay(value.setNClob(a, b, c))

  def setNString(a: Int, b: String) =
    F.delay(Console.err.println(s"PreparedStatement.setNString($a, $b)")) *>
    F.delay(value.setNString(a, b))

  def setNull(a: Int, b: Int) =
    F.delay(Console.err.println(s"PreparedStatement.setNull($a, $b)")) *>
    F.delay(value.setNull(a, b))

  def setNull(a: Int, b: Int, c: String) =
    F.delay(Console.err.println(s"PreparedStatement.setNull($a, $b, $c)")) *>
    F.delay(value.setNull(a, b, c))

  def setObject(a: Int, b: AnyRef) =
    F.delay(Console.err.println(s"PreparedStatement.setObject($a, $b)")) *>
    F.delay(value.setObject(a, b))

  def setObject(a: Int, b: AnyRef, c: Int) =
    F.delay(Console.err.println(s"PreparedStatement.setObject($a, $b, $c)")) *>
    F.delay(value.setObject(a, b, c))

  def setObject(a: Int, b: AnyRef, c: Int, d: Int) =
    F.delay(Console.err.println(s"PreparedStatement.setObject($a, $b, $c, $d)")) *>
    F.delay(value.setObject(a, b, c, d))

  def setObject(a: Int, b: AnyRef, c: SQLType) =
    F.delay(Console.err.println(s"PreparedStatement.setObject($a, $b, $c)")) *>
    F.delay(value.setObject(a, b, c))

  def setObject(a: Int, b: AnyRef, c: SQLType, d: Int) =
    F.delay(Console.err.println(s"PreparedStatement.setObject($a, $b, $c, $d)")) *>
    F.delay(value.setObject(a, b, c, d))

  def setPoolable(a: Boolean) =
    F.delay(Console.err.println(s"PreparedStatement.setPoolable($a)")) *>
    F.delay(value.setPoolable(a))

  def setQueryTimeout(a: Int) =
    F.delay(Console.err.println(s"PreparedStatement.setQueryTimeout($a)")) *>
    F.delay(value.setQueryTimeout(a))

  def setRef(a: Int, b: Ref) =
    F.delay(Console.err.println(s"PreparedStatement.setRef($a, $b)")) *>
    F.delay(value.setRef(a, b))

  def setRowId(a: Int, b: RowId) =
    F.delay(Console.err.println(s"PreparedStatement.setRowId($a, $b)")) *>
    F.delay(value.setRowId(a, b))

  def setSQLXML(a: Int, b: SQLXML) =
    F.delay(Console.err.println(s"PreparedStatement.setSQLXML($a, $b)")) *>
    F.delay(value.setSQLXML(a, b))

  def setShort(a: Int, b: Short) =
    F.delay(Console.err.println(s"PreparedStatement.setShort($a, $b)")) *>
    F.delay(value.setShort(a, b))

  def setString(a: Int, b: String) =
    F.delay(Console.err.println(s"PreparedStatement.setString($a, $b)")) *>
    F.delay(value.setString(a, b))

  def setTime(a: Int, b: Time) =
    F.delay(Console.err.println(s"PreparedStatement.setTime($a, $b)")) *>
    F.delay(value.setTime(a, b))

  def setTime(a: Int, b: Time, c: Calendar) =
    F.delay(Console.err.println(s"PreparedStatement.setTime($a, $b, $c)")) *>
    F.delay(value.setTime(a, b, c))

  def setTimestamp(a: Int, b: Timestamp) =
    F.delay(Console.err.println(s"PreparedStatement.setTimestamp($a, $b)")) *>
    F.delay(value.setTimestamp(a, b))

  def setTimestamp(a: Int, b: Timestamp, c: Calendar) =
    F.delay(Console.err.println(s"PreparedStatement.setTimestamp($a, $b, $c)")) *>
    F.delay(value.setTimestamp(a, b, c))

  def setURL(a: Int, b: URL) =
    F.delay(Console.err.println(s"PreparedStatement.setURL($a, $b)")) *>
    F.delay(value.setURL(a, b))

  def setUnicodeStream(a: Int, b: InputStream, c: Int) =
    F.delay(Console.err.println(s"PreparedStatement.setUnicodeStream($a, $b, $c)")) *>
    F.delay(value.setUnicodeStream(a, b, c))

  def unwrap[T](a: Class[T]) =
    F.delay(Console.err.println(s"PreparedStatement.unwrap($a)")) *>
    F.delay(value.unwrap(a))

}

