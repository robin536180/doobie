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
import java.sql.CallableStatement
import java.sql.Clob
import java.sql.Connection
import java.sql.Date
import java.sql.NClob
import java.sql.ParameterMetaData
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
import java.util.Map

/**
 * Implementation of JdbcCallableStatement that wraps a CallableStatement and lifts its primitive operations into any F
 * given a Sync instance.
 */
@SuppressWarnings(Array("org.wartremover.warts.Overloading"))
class SyncCallableStatement[F[_]](value: CallableStatement)(implicit F: Sync[F]) extends JdbcCallableStatement[F] {

  def addBatch =
    F.delay(Console.err.println("CallableStatement.addBatch()")) *>
    F.delay(value.addBatch())

  def addBatch(a: String) =
    F.delay(Console.err.println(s"CallableStatement.addBatch($a)")) *>
    F.delay(value.addBatch(a))

  def cancel =
    F.delay(Console.err.println("CallableStatement.cancel()")) *>
    F.delay(value.cancel())

  def clearBatch =
    F.delay(Console.err.println("CallableStatement.clearBatch()")) *>
    F.delay(value.clearBatch())

  def clearParameters =
    F.delay(Console.err.println("CallableStatement.clearParameters()")) *>
    F.delay(value.clearParameters())

  def clearWarnings =
    F.delay(Console.err.println("CallableStatement.clearWarnings()")) *>
    F.delay(value.clearWarnings())

  def close =
    F.delay(Console.err.println("CallableStatement.close()")) *>
    F.delay(value.close())

  def closeOnCompletion =
    F.delay(Console.err.println("CallableStatement.closeOnCompletion()")) *>
    F.delay(value.closeOnCompletion())

  def execute =
    F.delay(Console.err.println("CallableStatement.execute()")) *>
    F.delay(value.execute())

  def execute(a: String) =
    F.delay(Console.err.println(s"CallableStatement.execute($a)")) *>
    F.delay(value.execute(a))

  def execute(a: String, b: Array[Int]) =
    F.delay(Console.err.println(s"CallableStatement.execute($a, $b)")) *>
    F.delay(value.execute(a, b))

  def execute(a: String, b: Array[String]) =
    F.delay(Console.err.println(s"CallableStatement.execute($a, $b)")) *>
    F.delay(value.execute(a, b))

  def execute(a: String, b: Int) =
    F.delay(Console.err.println(s"CallableStatement.execute($a, $b)")) *>
    F.delay(value.execute(a, b))

  def executeBatch =
    F.delay(Console.err.println("CallableStatement.executeBatch()")) *>
    F.delay(value.executeBatch())

  def executeLargeBatch =
    F.delay(Console.err.println("CallableStatement.executeLargeBatch()")) *>
    F.delay(value.executeLargeBatch())

  def executeLargeUpdate =
    F.delay(Console.err.println("CallableStatement.executeLargeUpdate()")) *>
    F.delay(value.executeLargeUpdate())

  def executeLargeUpdate(a: String) =
    F.delay(Console.err.println(s"CallableStatement.executeLargeUpdate($a)")) *>
    F.delay(value.executeLargeUpdate(a))

  def executeLargeUpdate(a: String, b: Array[Int]) =
    F.delay(Console.err.println(s"CallableStatement.executeLargeUpdate($a, $b)")) *>
    F.delay(value.executeLargeUpdate(a, b))

  def executeLargeUpdate(a: String, b: Array[String]) =
    F.delay(Console.err.println(s"CallableStatement.executeLargeUpdate($a, $b)")) *>
    F.delay(value.executeLargeUpdate(a, b))

  def executeLargeUpdate(a: String, b: Int) =
    F.delay(Console.err.println(s"CallableStatement.executeLargeUpdate($a, $b)")) *>
    F.delay(value.executeLargeUpdate(a, b))

  def executeQuery =
    F.delay(Console.err.println("CallableStatement.executeQuery()")) *>
    F.delay(value.executeQuery())

  def executeQuery(a: String) =
    F.delay(Console.err.println(s"CallableStatement.executeQuery($a)")) *>
    F.delay(value.executeQuery(a))

  def executeUpdate =
    F.delay(Console.err.println("CallableStatement.executeUpdate()")) *>
    F.delay(value.executeUpdate())

  def executeUpdate(a: String) =
    F.delay(Console.err.println(s"CallableStatement.executeUpdate($a)")) *>
    F.delay(value.executeUpdate(a))

  def executeUpdate(a: String, b: Array[Int]) =
    F.delay(Console.err.println(s"CallableStatement.executeUpdate($a, $b)")) *>
    F.delay(value.executeUpdate(a, b))

  def executeUpdate(a: String, b: Array[String]) =
    F.delay(Console.err.println(s"CallableStatement.executeUpdate($a, $b)")) *>
    F.delay(value.executeUpdate(a, b))

  def executeUpdate(a: String, b: Int) =
    F.delay(Console.err.println(s"CallableStatement.executeUpdate($a, $b)")) *>
    F.delay(value.executeUpdate(a, b))

  def getArray(a: Int) =
    F.delay(Console.err.println(s"CallableStatement.getArray($a)")) *>
    F.delay(value.getArray(a))

  def getArray(a: String) =
    F.delay(Console.err.println(s"CallableStatement.getArray($a)")) *>
    F.delay(value.getArray(a))

  def getBigDecimal(a: Int) =
    F.delay(Console.err.println(s"CallableStatement.getBigDecimal($a)")) *>
    F.delay(value.getBigDecimal(a))

  def getBigDecimal(a: Int, b: Int) =
    F.delay(Console.err.println(s"CallableStatement.getBigDecimal($a, $b)")) *>
    F.delay(value.getBigDecimal(a, b))

  def getBigDecimal(a: String) =
    F.delay(Console.err.println(s"CallableStatement.getBigDecimal($a)")) *>
    F.delay(value.getBigDecimal(a))

  def getBlob(a: Int) =
    F.delay(Console.err.println(s"CallableStatement.getBlob($a)")) *>
    F.delay(value.getBlob(a))

  def getBlob(a: String) =
    F.delay(Console.err.println(s"CallableStatement.getBlob($a)")) *>
    F.delay(value.getBlob(a))

  def getBoolean(a: Int) =
    F.delay(Console.err.println(s"CallableStatement.getBoolean($a)")) *>
    F.delay(value.getBoolean(a))

  def getBoolean(a: String) =
    F.delay(Console.err.println(s"CallableStatement.getBoolean($a)")) *>
    F.delay(value.getBoolean(a))

  def getByte(a: Int) =
    F.delay(Console.err.println(s"CallableStatement.getByte($a)")) *>
    F.delay(value.getByte(a))

  def getByte(a: String) =
    F.delay(Console.err.println(s"CallableStatement.getByte($a)")) *>
    F.delay(value.getByte(a))

  def getBytes(a: Int) =
    F.delay(Console.err.println(s"CallableStatement.getBytes($a)")) *>
    F.delay(value.getBytes(a))

  def getBytes(a: String) =
    F.delay(Console.err.println(s"CallableStatement.getBytes($a)")) *>
    F.delay(value.getBytes(a))

  def getCharacterStream(a: Int) =
    F.delay(Console.err.println(s"CallableStatement.getCharacterStream($a)")) *>
    F.delay(value.getCharacterStream(a))

  def getCharacterStream(a: String) =
    F.delay(Console.err.println(s"CallableStatement.getCharacterStream($a)")) *>
    F.delay(value.getCharacterStream(a))

  def getClob(a: Int) =
    F.delay(Console.err.println(s"CallableStatement.getClob($a)")) *>
    F.delay(value.getClob(a))

  def getClob(a: String) =
    F.delay(Console.err.println(s"CallableStatement.getClob($a)")) *>
    F.delay(value.getClob(a))

  def getConnection =
    F.delay(Console.err.println("CallableStatement.getConnection()")) *>
    F.delay(value.getConnection())

  def getDate(a: Int) =
    F.delay(Console.err.println(s"CallableStatement.getDate($a)")) *>
    F.delay(value.getDate(a))

  def getDate(a: Int, b: Calendar) =
    F.delay(Console.err.println(s"CallableStatement.getDate($a, $b)")) *>
    F.delay(value.getDate(a, b))

  def getDate(a: String) =
    F.delay(Console.err.println(s"CallableStatement.getDate($a)")) *>
    F.delay(value.getDate(a))

  def getDate(a: String, b: Calendar) =
    F.delay(Console.err.println(s"CallableStatement.getDate($a, $b)")) *>
    F.delay(value.getDate(a, b))

  def getDouble(a: Int) =
    F.delay(Console.err.println(s"CallableStatement.getDouble($a)")) *>
    F.delay(value.getDouble(a))

  def getDouble(a: String) =
    F.delay(Console.err.println(s"CallableStatement.getDouble($a)")) *>
    F.delay(value.getDouble(a))

  def getFetchDirection =
    F.delay(Console.err.println("CallableStatement.getFetchDirection()")) *>
    F.delay(value.getFetchDirection())

  def getFetchSize =
    F.delay(Console.err.println("CallableStatement.getFetchSize()")) *>
    F.delay(value.getFetchSize())

  def getFloat(a: Int) =
    F.delay(Console.err.println(s"CallableStatement.getFloat($a)")) *>
    F.delay(value.getFloat(a))

  def getFloat(a: String) =
    F.delay(Console.err.println(s"CallableStatement.getFloat($a)")) *>
    F.delay(value.getFloat(a))

  def getGeneratedKeys =
    F.delay(Console.err.println("CallableStatement.getGeneratedKeys()")) *>
    F.delay(value.getGeneratedKeys())

  def getInt(a: Int) =
    F.delay(Console.err.println(s"CallableStatement.getInt($a)")) *>
    F.delay(value.getInt(a))

  def getInt(a: String) =
    F.delay(Console.err.println(s"CallableStatement.getInt($a)")) *>
    F.delay(value.getInt(a))

  def getLargeMaxRows =
    F.delay(Console.err.println("CallableStatement.getLargeMaxRows()")) *>
    F.delay(value.getLargeMaxRows())

  def getLargeUpdateCount =
    F.delay(Console.err.println("CallableStatement.getLargeUpdateCount()")) *>
    F.delay(value.getLargeUpdateCount())

  def getLong(a: Int) =
    F.delay(Console.err.println(s"CallableStatement.getLong($a)")) *>
    F.delay(value.getLong(a))

  def getLong(a: String) =
    F.delay(Console.err.println(s"CallableStatement.getLong($a)")) *>
    F.delay(value.getLong(a))

  def getMaxFieldSize =
    F.delay(Console.err.println("CallableStatement.getMaxFieldSize()")) *>
    F.delay(value.getMaxFieldSize())

  def getMaxRows =
    F.delay(Console.err.println("CallableStatement.getMaxRows()")) *>
    F.delay(value.getMaxRows())

  def getMetaData =
    F.delay(Console.err.println("CallableStatement.getMetaData()")) *>
    F.delay(value.getMetaData())

  def getMoreResults =
    F.delay(Console.err.println("CallableStatement.getMoreResults()")) *>
    F.delay(value.getMoreResults())

  def getMoreResults(a: Int) =
    F.delay(Console.err.println(s"CallableStatement.getMoreResults($a)")) *>
    F.delay(value.getMoreResults(a))

  def getNCharacterStream(a: Int) =
    F.delay(Console.err.println(s"CallableStatement.getNCharacterStream($a)")) *>
    F.delay(value.getNCharacterStream(a))

  def getNCharacterStream(a: String) =
    F.delay(Console.err.println(s"CallableStatement.getNCharacterStream($a)")) *>
    F.delay(value.getNCharacterStream(a))

  def getNClob(a: Int) =
    F.delay(Console.err.println(s"CallableStatement.getNClob($a)")) *>
    F.delay(value.getNClob(a))

  def getNClob(a: String) =
    F.delay(Console.err.println(s"CallableStatement.getNClob($a)")) *>
    F.delay(value.getNClob(a))

  def getNString(a: Int) =
    F.delay(Console.err.println(s"CallableStatement.getNString($a)")) *>
    F.delay(value.getNString(a))

  def getNString(a: String) =
    F.delay(Console.err.println(s"CallableStatement.getNString($a)")) *>
    F.delay(value.getNString(a))

  def getObject(a: Int) =
    F.delay(Console.err.println(s"CallableStatement.getObject($a)")) *>
    F.delay(value.getObject(a))

  def getObject[T](a: Int, b: Class[T]) =
    F.delay(Console.err.println(s"CallableStatement.getObject($a, $b)")) *>
    F.delay(value.getObject(a, b))

  def getObject(a: Int, b: Map[String, Class[_]]) =
    F.delay(Console.err.println(s"CallableStatement.getObject($a, $b)")) *>
    F.delay(value.getObject(a, b))

  def getObject(a: String) =
    F.delay(Console.err.println(s"CallableStatement.getObject($a)")) *>
    F.delay(value.getObject(a))

  def getObject[T](a: String, b: Class[T]) =
    F.delay(Console.err.println(s"CallableStatement.getObject($a, $b)")) *>
    F.delay(value.getObject(a, b))

  def getObject(a: String, b: Map[String, Class[_]]) =
    F.delay(Console.err.println(s"CallableStatement.getObject($a, $b)")) *>
    F.delay(value.getObject(a, b))

  def getParameterMetaData =
    F.delay(Console.err.println("CallableStatement.getParameterMetaData()")) *>
    F.delay(value.getParameterMetaData())

  def getQueryTimeout =
    F.delay(Console.err.println("CallableStatement.getQueryTimeout()")) *>
    F.delay(value.getQueryTimeout())

  def getRef(a: Int) =
    F.delay(Console.err.println(s"CallableStatement.getRef($a)")) *>
    F.delay(value.getRef(a))

  def getRef(a: String) =
    F.delay(Console.err.println(s"CallableStatement.getRef($a)")) *>
    F.delay(value.getRef(a))

  def getResultSet =
    F.delay(Console.err.println("CallableStatement.getResultSet()")) *>
    F.delay(value.getResultSet())

  def getResultSetConcurrency =
    F.delay(Console.err.println("CallableStatement.getResultSetConcurrency()")) *>
    F.delay(value.getResultSetConcurrency())

  def getResultSetHoldability =
    F.delay(Console.err.println("CallableStatement.getResultSetHoldability()")) *>
    F.delay(value.getResultSetHoldability())

  def getResultSetType =
    F.delay(Console.err.println("CallableStatement.getResultSetType()")) *>
    F.delay(value.getResultSetType())

  def getRowId(a: Int) =
    F.delay(Console.err.println(s"CallableStatement.getRowId($a)")) *>
    F.delay(value.getRowId(a))

  def getRowId(a: String) =
    F.delay(Console.err.println(s"CallableStatement.getRowId($a)")) *>
    F.delay(value.getRowId(a))

  def getSQLXML(a: Int) =
    F.delay(Console.err.println(s"CallableStatement.getSQLXML($a)")) *>
    F.delay(value.getSQLXML(a))

  def getSQLXML(a: String) =
    F.delay(Console.err.println(s"CallableStatement.getSQLXML($a)")) *>
    F.delay(value.getSQLXML(a))

  def getShort(a: Int) =
    F.delay(Console.err.println(s"CallableStatement.getShort($a)")) *>
    F.delay(value.getShort(a))

  def getShort(a: String) =
    F.delay(Console.err.println(s"CallableStatement.getShort($a)")) *>
    F.delay(value.getShort(a))

  def getString(a: Int) =
    F.delay(Console.err.println(s"CallableStatement.getString($a)")) *>
    F.delay(value.getString(a))

  def getString(a: String) =
    F.delay(Console.err.println(s"CallableStatement.getString($a)")) *>
    F.delay(value.getString(a))

  def getTime(a: Int) =
    F.delay(Console.err.println(s"CallableStatement.getTime($a)")) *>
    F.delay(value.getTime(a))

  def getTime(a: Int, b: Calendar) =
    F.delay(Console.err.println(s"CallableStatement.getTime($a, $b)")) *>
    F.delay(value.getTime(a, b))

  def getTime(a: String) =
    F.delay(Console.err.println(s"CallableStatement.getTime($a)")) *>
    F.delay(value.getTime(a))

  def getTime(a: String, b: Calendar) =
    F.delay(Console.err.println(s"CallableStatement.getTime($a, $b)")) *>
    F.delay(value.getTime(a, b))

  def getTimestamp(a: Int) =
    F.delay(Console.err.println(s"CallableStatement.getTimestamp($a)")) *>
    F.delay(value.getTimestamp(a))

  def getTimestamp(a: Int, b: Calendar) =
    F.delay(Console.err.println(s"CallableStatement.getTimestamp($a, $b)")) *>
    F.delay(value.getTimestamp(a, b))

  def getTimestamp(a: String) =
    F.delay(Console.err.println(s"CallableStatement.getTimestamp($a)")) *>
    F.delay(value.getTimestamp(a))

  def getTimestamp(a: String, b: Calendar) =
    F.delay(Console.err.println(s"CallableStatement.getTimestamp($a, $b)")) *>
    F.delay(value.getTimestamp(a, b))

  def getURL(a: Int) =
    F.delay(Console.err.println(s"CallableStatement.getURL($a)")) *>
    F.delay(value.getURL(a))

  def getURL(a: String) =
    F.delay(Console.err.println(s"CallableStatement.getURL($a)")) *>
    F.delay(value.getURL(a))

  def getUpdateCount =
    F.delay(Console.err.println("CallableStatement.getUpdateCount()")) *>
    F.delay(value.getUpdateCount())

  def getWarnings =
    F.delay(Console.err.println("CallableStatement.getWarnings()")) *>
    F.delay(value.getWarnings())

  def isCloseOnCompletion =
    F.delay(Console.err.println("CallableStatement.isCloseOnCompletion()")) *>
    F.delay(value.isCloseOnCompletion())

  def isClosed =
    F.delay(Console.err.println("CallableStatement.isClosed()")) *>
    F.delay(value.isClosed())

  def isPoolable =
    F.delay(Console.err.println("CallableStatement.isPoolable()")) *>
    F.delay(value.isPoolable())

  def isWrapperFor(a: Class[_]) =
    F.delay(Console.err.println(s"CallableStatement.isWrapperFor($a)")) *>
    F.delay(value.isWrapperFor(a))

  def registerOutParameter(a: Int, b: Int) =
    F.delay(Console.err.println(s"CallableStatement.registerOutParameter($a, $b)")) *>
    F.delay(value.registerOutParameter(a, b))

  def registerOutParameter(a: Int, b: Int, c: Int) =
    F.delay(Console.err.println(s"CallableStatement.registerOutParameter($a, $b, $c)")) *>
    F.delay(value.registerOutParameter(a, b, c))

  def registerOutParameter(a: Int, b: Int, c: String) =
    F.delay(Console.err.println(s"CallableStatement.registerOutParameter($a, $b, $c)")) *>
    F.delay(value.registerOutParameter(a, b, c))

  def registerOutParameter(a: Int, b: SQLType) =
    F.delay(Console.err.println(s"CallableStatement.registerOutParameter($a, $b)")) *>
    F.delay(value.registerOutParameter(a, b))

  def registerOutParameter(a: Int, b: SQLType, c: Int) =
    F.delay(Console.err.println(s"CallableStatement.registerOutParameter($a, $b, $c)")) *>
    F.delay(value.registerOutParameter(a, b, c))

  def registerOutParameter(a: Int, b: SQLType, c: String) =
    F.delay(Console.err.println(s"CallableStatement.registerOutParameter($a, $b, $c)")) *>
    F.delay(value.registerOutParameter(a, b, c))

  def registerOutParameter(a: String, b: Int) =
    F.delay(Console.err.println(s"CallableStatement.registerOutParameter($a, $b)")) *>
    F.delay(value.registerOutParameter(a, b))

  def registerOutParameter(a: String, b: Int, c: Int) =
    F.delay(Console.err.println(s"CallableStatement.registerOutParameter($a, $b, $c)")) *>
    F.delay(value.registerOutParameter(a, b, c))

  def registerOutParameter(a: String, b: Int, c: String) =
    F.delay(Console.err.println(s"CallableStatement.registerOutParameter($a, $b, $c)")) *>
    F.delay(value.registerOutParameter(a, b, c))

  def registerOutParameter(a: String, b: SQLType) =
    F.delay(Console.err.println(s"CallableStatement.registerOutParameter($a, $b)")) *>
    F.delay(value.registerOutParameter(a, b))

  def registerOutParameter(a: String, b: SQLType, c: Int) =
    F.delay(Console.err.println(s"CallableStatement.registerOutParameter($a, $b, $c)")) *>
    F.delay(value.registerOutParameter(a, b, c))

  def registerOutParameter(a: String, b: SQLType, c: String) =
    F.delay(Console.err.println(s"CallableStatement.registerOutParameter($a, $b, $c)")) *>
    F.delay(value.registerOutParameter(a, b, c))

  def setArray(a: Int, b: SqlArray) =
    F.delay(Console.err.println(s"CallableStatement.setArray($a, $b)")) *>
    F.delay(value.setArray(a, b))

  def setAsciiStream(a: Int, b: InputStream) =
    F.delay(Console.err.println(s"CallableStatement.setAsciiStream($a, $b)")) *>
    F.delay(value.setAsciiStream(a, b))

  def setAsciiStream(a: Int, b: InputStream, c: Int) =
    F.delay(Console.err.println(s"CallableStatement.setAsciiStream($a, $b, $c)")) *>
    F.delay(value.setAsciiStream(a, b, c))

  def setAsciiStream(a: Int, b: InputStream, c: Long) =
    F.delay(Console.err.println(s"CallableStatement.setAsciiStream($a, $b, $c)")) *>
    F.delay(value.setAsciiStream(a, b, c))

  def setAsciiStream(a: String, b: InputStream) =
    F.delay(Console.err.println(s"CallableStatement.setAsciiStream($a, $b)")) *>
    F.delay(value.setAsciiStream(a, b))

  def setAsciiStream(a: String, b: InputStream, c: Int) =
    F.delay(Console.err.println(s"CallableStatement.setAsciiStream($a, $b, $c)")) *>
    F.delay(value.setAsciiStream(a, b, c))

  def setAsciiStream(a: String, b: InputStream, c: Long) =
    F.delay(Console.err.println(s"CallableStatement.setAsciiStream($a, $b, $c)")) *>
    F.delay(value.setAsciiStream(a, b, c))

  def setBigDecimal(a: Int, b: BigDecimal) =
    F.delay(Console.err.println(s"CallableStatement.setBigDecimal($a, $b)")) *>
    F.delay(value.setBigDecimal(a, b))

  def setBigDecimal(a: String, b: BigDecimal) =
    F.delay(Console.err.println(s"CallableStatement.setBigDecimal($a, $b)")) *>
    F.delay(value.setBigDecimal(a, b))

  def setBinaryStream(a: Int, b: InputStream) =
    F.delay(Console.err.println(s"CallableStatement.setBinaryStream($a, $b)")) *>
    F.delay(value.setBinaryStream(a, b))

  def setBinaryStream(a: Int, b: InputStream, c: Int) =
    F.delay(Console.err.println(s"CallableStatement.setBinaryStream($a, $b, $c)")) *>
    F.delay(value.setBinaryStream(a, b, c))

  def setBinaryStream(a: Int, b: InputStream, c: Long) =
    F.delay(Console.err.println(s"CallableStatement.setBinaryStream($a, $b, $c)")) *>
    F.delay(value.setBinaryStream(a, b, c))

  def setBinaryStream(a: String, b: InputStream) =
    F.delay(Console.err.println(s"CallableStatement.setBinaryStream($a, $b)")) *>
    F.delay(value.setBinaryStream(a, b))

  def setBinaryStream(a: String, b: InputStream, c: Int) =
    F.delay(Console.err.println(s"CallableStatement.setBinaryStream($a, $b, $c)")) *>
    F.delay(value.setBinaryStream(a, b, c))

  def setBinaryStream(a: String, b: InputStream, c: Long) =
    F.delay(Console.err.println(s"CallableStatement.setBinaryStream($a, $b, $c)")) *>
    F.delay(value.setBinaryStream(a, b, c))

  def setBlob(a: Int, b: Blob) =
    F.delay(Console.err.println(s"CallableStatement.setBlob($a, $b)")) *>
    F.delay(value.setBlob(a, b))

  def setBlob(a: Int, b: InputStream) =
    F.delay(Console.err.println(s"CallableStatement.setBlob($a, $b)")) *>
    F.delay(value.setBlob(a, b))

  def setBlob(a: Int, b: InputStream, c: Long) =
    F.delay(Console.err.println(s"CallableStatement.setBlob($a, $b, $c)")) *>
    F.delay(value.setBlob(a, b, c))

  def setBlob(a: String, b: Blob) =
    F.delay(Console.err.println(s"CallableStatement.setBlob($a, $b)")) *>
    F.delay(value.setBlob(a, b))

  def setBlob(a: String, b: InputStream) =
    F.delay(Console.err.println(s"CallableStatement.setBlob($a, $b)")) *>
    F.delay(value.setBlob(a, b))

  def setBlob(a: String, b: InputStream, c: Long) =
    F.delay(Console.err.println(s"CallableStatement.setBlob($a, $b, $c)")) *>
    F.delay(value.setBlob(a, b, c))

  def setBoolean(a: Int, b: Boolean) =
    F.delay(Console.err.println(s"CallableStatement.setBoolean($a, $b)")) *>
    F.delay(value.setBoolean(a, b))

  def setBoolean(a: String, b: Boolean) =
    F.delay(Console.err.println(s"CallableStatement.setBoolean($a, $b)")) *>
    F.delay(value.setBoolean(a, b))

  def setByte(a: Int, b: Byte) =
    F.delay(Console.err.println(s"CallableStatement.setByte($a, $b)")) *>
    F.delay(value.setByte(a, b))

  def setByte(a: String, b: Byte) =
    F.delay(Console.err.println(s"CallableStatement.setByte($a, $b)")) *>
    F.delay(value.setByte(a, b))

  def setBytes(a: Int, b: Array[Byte]) =
    F.delay(Console.err.println(s"CallableStatement.setBytes($a, $b)")) *>
    F.delay(value.setBytes(a, b))

  def setBytes(a: String, b: Array[Byte]) =
    F.delay(Console.err.println(s"CallableStatement.setBytes($a, $b)")) *>
    F.delay(value.setBytes(a, b))

  def setCharacterStream(a: Int, b: Reader) =
    F.delay(Console.err.println(s"CallableStatement.setCharacterStream($a, $b)")) *>
    F.delay(value.setCharacterStream(a, b))

  def setCharacterStream(a: Int, b: Reader, c: Int) =
    F.delay(Console.err.println(s"CallableStatement.setCharacterStream($a, $b, $c)")) *>
    F.delay(value.setCharacterStream(a, b, c))

  def setCharacterStream(a: Int, b: Reader, c: Long) =
    F.delay(Console.err.println(s"CallableStatement.setCharacterStream($a, $b, $c)")) *>
    F.delay(value.setCharacterStream(a, b, c))

  def setCharacterStream(a: String, b: Reader) =
    F.delay(Console.err.println(s"CallableStatement.setCharacterStream($a, $b)")) *>
    F.delay(value.setCharacterStream(a, b))

  def setCharacterStream(a: String, b: Reader, c: Int) =
    F.delay(Console.err.println(s"CallableStatement.setCharacterStream($a, $b, $c)")) *>
    F.delay(value.setCharacterStream(a, b, c))

  def setCharacterStream(a: String, b: Reader, c: Long) =
    F.delay(Console.err.println(s"CallableStatement.setCharacterStream($a, $b, $c)")) *>
    F.delay(value.setCharacterStream(a, b, c))

  def setClob(a: Int, b: Clob) =
    F.delay(Console.err.println(s"CallableStatement.setClob($a, $b)")) *>
    F.delay(value.setClob(a, b))

  def setClob(a: Int, b: Reader) =
    F.delay(Console.err.println(s"CallableStatement.setClob($a, $b)")) *>
    F.delay(value.setClob(a, b))

  def setClob(a: Int, b: Reader, c: Long) =
    F.delay(Console.err.println(s"CallableStatement.setClob($a, $b, $c)")) *>
    F.delay(value.setClob(a, b, c))

  def setClob(a: String, b: Clob) =
    F.delay(Console.err.println(s"CallableStatement.setClob($a, $b)")) *>
    F.delay(value.setClob(a, b))

  def setClob(a: String, b: Reader) =
    F.delay(Console.err.println(s"CallableStatement.setClob($a, $b)")) *>
    F.delay(value.setClob(a, b))

  def setClob(a: String, b: Reader, c: Long) =
    F.delay(Console.err.println(s"CallableStatement.setClob($a, $b, $c)")) *>
    F.delay(value.setClob(a, b, c))

  def setCursorName(a: String) =
    F.delay(Console.err.println(s"CallableStatement.setCursorName($a)")) *>
    F.delay(value.setCursorName(a))

  def setDate(a: Int, b: Date) =
    F.delay(Console.err.println(s"CallableStatement.setDate($a, $b)")) *>
    F.delay(value.setDate(a, b))

  def setDate(a: Int, b: Date, c: Calendar) =
    F.delay(Console.err.println(s"CallableStatement.setDate($a, $b, $c)")) *>
    F.delay(value.setDate(a, b, c))

  def setDate(a: String, b: Date) =
    F.delay(Console.err.println(s"CallableStatement.setDate($a, $b)")) *>
    F.delay(value.setDate(a, b))

  def setDate(a: String, b: Date, c: Calendar) =
    F.delay(Console.err.println(s"CallableStatement.setDate($a, $b, $c)")) *>
    F.delay(value.setDate(a, b, c))

  def setDouble(a: Int, b: Double) =
    F.delay(Console.err.println(s"CallableStatement.setDouble($a, $b)")) *>
    F.delay(value.setDouble(a, b))

  def setDouble(a: String, b: Double) =
    F.delay(Console.err.println(s"CallableStatement.setDouble($a, $b)")) *>
    F.delay(value.setDouble(a, b))

  def setEscapeProcessing(a: Boolean) =
    F.delay(Console.err.println(s"CallableStatement.setEscapeProcessing($a)")) *>
    F.delay(value.setEscapeProcessing(a))

  def setFetchDirection(a: Int) =
    F.delay(Console.err.println(s"CallableStatement.setFetchDirection($a)")) *>
    F.delay(value.setFetchDirection(a))

  def setFetchSize(a: Int) =
    F.delay(Console.err.println(s"CallableStatement.setFetchSize($a)")) *>
    F.delay(value.setFetchSize(a))

  def setFloat(a: Int, b: Float) =
    F.delay(Console.err.println(s"CallableStatement.setFloat($a, $b)")) *>
    F.delay(value.setFloat(a, b))

  def setFloat(a: String, b: Float) =
    F.delay(Console.err.println(s"CallableStatement.setFloat($a, $b)")) *>
    F.delay(value.setFloat(a, b))

  def setInt(a: Int, b: Int) =
    F.delay(Console.err.println(s"CallableStatement.setInt($a, $b)")) *>
    F.delay(value.setInt(a, b))

  def setInt(a: String, b: Int) =
    F.delay(Console.err.println(s"CallableStatement.setInt($a, $b)")) *>
    F.delay(value.setInt(a, b))

  def setLargeMaxRows(a: Long) =
    F.delay(Console.err.println(s"CallableStatement.setLargeMaxRows($a)")) *>
    F.delay(value.setLargeMaxRows(a))

  def setLong(a: Int, b: Long) =
    F.delay(Console.err.println(s"CallableStatement.setLong($a, $b)")) *>
    F.delay(value.setLong(a, b))

  def setLong(a: String, b: Long) =
    F.delay(Console.err.println(s"CallableStatement.setLong($a, $b)")) *>
    F.delay(value.setLong(a, b))

  def setMaxFieldSize(a: Int) =
    F.delay(Console.err.println(s"CallableStatement.setMaxFieldSize($a)")) *>
    F.delay(value.setMaxFieldSize(a))

  def setMaxRows(a: Int) =
    F.delay(Console.err.println(s"CallableStatement.setMaxRows($a)")) *>
    F.delay(value.setMaxRows(a))

  def setNCharacterStream(a: Int, b: Reader) =
    F.delay(Console.err.println(s"CallableStatement.setNCharacterStream($a, $b)")) *>
    F.delay(value.setNCharacterStream(a, b))

  def setNCharacterStream(a: Int, b: Reader, c: Long) =
    F.delay(Console.err.println(s"CallableStatement.setNCharacterStream($a, $b, $c)")) *>
    F.delay(value.setNCharacterStream(a, b, c))

  def setNCharacterStream(a: String, b: Reader) =
    F.delay(Console.err.println(s"CallableStatement.setNCharacterStream($a, $b)")) *>
    F.delay(value.setNCharacterStream(a, b))

  def setNCharacterStream(a: String, b: Reader, c: Long) =
    F.delay(Console.err.println(s"CallableStatement.setNCharacterStream($a, $b, $c)")) *>
    F.delay(value.setNCharacterStream(a, b, c))

  def setNClob(a: Int, b: NClob) =
    F.delay(Console.err.println(s"CallableStatement.setNClob($a, $b)")) *>
    F.delay(value.setNClob(a, b))

  def setNClob(a: Int, b: Reader) =
    F.delay(Console.err.println(s"CallableStatement.setNClob($a, $b)")) *>
    F.delay(value.setNClob(a, b))

  def setNClob(a: Int, b: Reader, c: Long) =
    F.delay(Console.err.println(s"CallableStatement.setNClob($a, $b, $c)")) *>
    F.delay(value.setNClob(a, b, c))

  def setNClob(a: String, b: NClob) =
    F.delay(Console.err.println(s"CallableStatement.setNClob($a, $b)")) *>
    F.delay(value.setNClob(a, b))

  def setNClob(a: String, b: Reader) =
    F.delay(Console.err.println(s"CallableStatement.setNClob($a, $b)")) *>
    F.delay(value.setNClob(a, b))

  def setNClob(a: String, b: Reader, c: Long) =
    F.delay(Console.err.println(s"CallableStatement.setNClob($a, $b, $c)")) *>
    F.delay(value.setNClob(a, b, c))

  def setNString(a: Int, b: String) =
    F.delay(Console.err.println(s"CallableStatement.setNString($a, $b)")) *>
    F.delay(value.setNString(a, b))

  def setNString(a: String, b: String) =
    F.delay(Console.err.println(s"CallableStatement.setNString($a, $b)")) *>
    F.delay(value.setNString(a, b))

  def setNull(a: Int, b: Int) =
    F.delay(Console.err.println(s"CallableStatement.setNull($a, $b)")) *>
    F.delay(value.setNull(a, b))

  def setNull(a: Int, b: Int, c: String) =
    F.delay(Console.err.println(s"CallableStatement.setNull($a, $b, $c)")) *>
    F.delay(value.setNull(a, b, c))

  def setNull(a: String, b: Int) =
    F.delay(Console.err.println(s"CallableStatement.setNull($a, $b)")) *>
    F.delay(value.setNull(a, b))

  def setNull(a: String, b: Int, c: String) =
    F.delay(Console.err.println(s"CallableStatement.setNull($a, $b, $c)")) *>
    F.delay(value.setNull(a, b, c))

  def setObject(a: Int, b: AnyRef) =
    F.delay(Console.err.println(s"CallableStatement.setObject($a, $b)")) *>
    F.delay(value.setObject(a, b))

  def setObject(a: Int, b: AnyRef, c: Int) =
    F.delay(Console.err.println(s"CallableStatement.setObject($a, $b, $c)")) *>
    F.delay(value.setObject(a, b, c))

  def setObject(a: Int, b: AnyRef, c: Int, d: Int) =
    F.delay(Console.err.println(s"CallableStatement.setObject($a, $b, $c, $d)")) *>
    F.delay(value.setObject(a, b, c, d))

  def setObject(a: Int, b: AnyRef, c: SQLType) =
    F.delay(Console.err.println(s"CallableStatement.setObject($a, $b, $c)")) *>
    F.delay(value.setObject(a, b, c))

  def setObject(a: Int, b: AnyRef, c: SQLType, d: Int) =
    F.delay(Console.err.println(s"CallableStatement.setObject($a, $b, $c, $d)")) *>
    F.delay(value.setObject(a, b, c, d))

  def setObject(a: String, b: AnyRef) =
    F.delay(Console.err.println(s"CallableStatement.setObject($a, $b)")) *>
    F.delay(value.setObject(a, b))

  def setObject(a: String, b: AnyRef, c: Int) =
    F.delay(Console.err.println(s"CallableStatement.setObject($a, $b, $c)")) *>
    F.delay(value.setObject(a, b, c))

  def setObject(a: String, b: AnyRef, c: Int, d: Int) =
    F.delay(Console.err.println(s"CallableStatement.setObject($a, $b, $c, $d)")) *>
    F.delay(value.setObject(a, b, c, d))

  def setObject(a: String, b: AnyRef, c: SQLType) =
    F.delay(Console.err.println(s"CallableStatement.setObject($a, $b, $c)")) *>
    F.delay(value.setObject(a, b, c))

  def setObject(a: String, b: AnyRef, c: SQLType, d: Int) =
    F.delay(Console.err.println(s"CallableStatement.setObject($a, $b, $c, $d)")) *>
    F.delay(value.setObject(a, b, c, d))

  def setPoolable(a: Boolean) =
    F.delay(Console.err.println(s"CallableStatement.setPoolable($a)")) *>
    F.delay(value.setPoolable(a))

  def setQueryTimeout(a: Int) =
    F.delay(Console.err.println(s"CallableStatement.setQueryTimeout($a)")) *>
    F.delay(value.setQueryTimeout(a))

  def setRef(a: Int, b: Ref) =
    F.delay(Console.err.println(s"CallableStatement.setRef($a, $b)")) *>
    F.delay(value.setRef(a, b))

  def setRowId(a: Int, b: RowId) =
    F.delay(Console.err.println(s"CallableStatement.setRowId($a, $b)")) *>
    F.delay(value.setRowId(a, b))

  def setRowId(a: String, b: RowId) =
    F.delay(Console.err.println(s"CallableStatement.setRowId($a, $b)")) *>
    F.delay(value.setRowId(a, b))

  def setSQLXML(a: Int, b: SQLXML) =
    F.delay(Console.err.println(s"CallableStatement.setSQLXML($a, $b)")) *>
    F.delay(value.setSQLXML(a, b))

  def setSQLXML(a: String, b: SQLXML) =
    F.delay(Console.err.println(s"CallableStatement.setSQLXML($a, $b)")) *>
    F.delay(value.setSQLXML(a, b))

  def setShort(a: Int, b: Short) =
    F.delay(Console.err.println(s"CallableStatement.setShort($a, $b)")) *>
    F.delay(value.setShort(a, b))

  def setShort(a: String, b: Short) =
    F.delay(Console.err.println(s"CallableStatement.setShort($a, $b)")) *>
    F.delay(value.setShort(a, b))

  def setString(a: Int, b: String) =
    F.delay(Console.err.println(s"CallableStatement.setString($a, $b)")) *>
    F.delay(value.setString(a, b))

  def setString(a: String, b: String) =
    F.delay(Console.err.println(s"CallableStatement.setString($a, $b)")) *>
    F.delay(value.setString(a, b))

  def setTime(a: Int, b: Time) =
    F.delay(Console.err.println(s"CallableStatement.setTime($a, $b)")) *>
    F.delay(value.setTime(a, b))

  def setTime(a: Int, b: Time, c: Calendar) =
    F.delay(Console.err.println(s"CallableStatement.setTime($a, $b, $c)")) *>
    F.delay(value.setTime(a, b, c))

  def setTime(a: String, b: Time) =
    F.delay(Console.err.println(s"CallableStatement.setTime($a, $b)")) *>
    F.delay(value.setTime(a, b))

  def setTime(a: String, b: Time, c: Calendar) =
    F.delay(Console.err.println(s"CallableStatement.setTime($a, $b, $c)")) *>
    F.delay(value.setTime(a, b, c))

  def setTimestamp(a: Int, b: Timestamp) =
    F.delay(Console.err.println(s"CallableStatement.setTimestamp($a, $b)")) *>
    F.delay(value.setTimestamp(a, b))

  def setTimestamp(a: Int, b: Timestamp, c: Calendar) =
    F.delay(Console.err.println(s"CallableStatement.setTimestamp($a, $b, $c)")) *>
    F.delay(value.setTimestamp(a, b, c))

  def setTimestamp(a: String, b: Timestamp) =
    F.delay(Console.err.println(s"CallableStatement.setTimestamp($a, $b)")) *>
    F.delay(value.setTimestamp(a, b))

  def setTimestamp(a: String, b: Timestamp, c: Calendar) =
    F.delay(Console.err.println(s"CallableStatement.setTimestamp($a, $b, $c)")) *>
    F.delay(value.setTimestamp(a, b, c))

  def setURL(a: Int, b: URL) =
    F.delay(Console.err.println(s"CallableStatement.setURL($a, $b)")) *>
    F.delay(value.setURL(a, b))

  def setURL(a: String, b: URL) =
    F.delay(Console.err.println(s"CallableStatement.setURL($a, $b)")) *>
    F.delay(value.setURL(a, b))

  def setUnicodeStream(a: Int, b: InputStream, c: Int) =
    F.delay(Console.err.println(s"CallableStatement.setUnicodeStream($a, $b, $c)")) *>
    F.delay(value.setUnicodeStream(a, b, c))

  def unwrap[T](a: Class[T]) =
    F.delay(Console.err.println(s"CallableStatement.unwrap($a)")) *>
    F.delay(value.unwrap(a))

  def wasNull =
    F.delay(Console.err.println("CallableStatement.wasNull()")) *>
    F.delay(value.wasNull())

}

