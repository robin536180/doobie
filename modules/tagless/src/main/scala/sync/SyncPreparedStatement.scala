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

  val addBatch: F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.addBatch()")) *>
    F.delay(value.addBatch())

  def addBatch(a: String): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.addBatch($a)")) *>
    F.delay(value.addBatch(a))

  val cancel: F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.cancel()")) *>
    F.delay(value.cancel())

  val clearBatch: F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.clearBatch()")) *>
    F.delay(value.clearBatch())

  val clearParameters: F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.clearParameters()")) *>
    F.delay(value.clearParameters())

  val clearWarnings: F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.clearWarnings()")) *>
    F.delay(value.clearWarnings())

  val close: F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.close()")) *>
    F.delay(value.close())

  val closeOnCompletion: F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.closeOnCompletion()")) *>
    F.delay(value.closeOnCompletion())

  val execute: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.execute()")) *>
    F.delay(value.execute())

  def execute(a: String): F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.execute($a)")) *>
    F.delay(value.execute(a))

  def execute(a: String, b: Array[Int]): F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.execute($a, $b)")) *>
    F.delay(value.execute(a, b))

  def execute(a: String, b: Array[String]): F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.execute($a, $b)")) *>
    F.delay(value.execute(a, b))

  def execute(a: String, b: Int): F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.execute($a, $b)")) *>
    F.delay(value.execute(a, b))

  val executeBatch: F[Array[Int]] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.executeBatch()")) *>
    F.delay(value.executeBatch())

  val executeLargeBatch: F[Array[Long]] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.executeLargeBatch()")) *>
    F.delay(value.executeLargeBatch())

  val executeLargeUpdate: F[Long] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.executeLargeUpdate()")) *>
    F.delay(value.executeLargeUpdate())

  def executeLargeUpdate(a: String): F[Long] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.executeLargeUpdate($a)")) *>
    F.delay(value.executeLargeUpdate(a))

  def executeLargeUpdate(a: String, b: Array[Int]): F[Long] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.executeLargeUpdate($a, $b)")) *>
    F.delay(value.executeLargeUpdate(a, b))

  def executeLargeUpdate(a: String, b: Array[String]): F[Long] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.executeLargeUpdate($a, $b)")) *>
    F.delay(value.executeLargeUpdate(a, b))

  def executeLargeUpdate(a: String, b: Int): F[Long] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.executeLargeUpdate($a, $b)")) *>
    F.delay(value.executeLargeUpdate(a, b))

  val executeQuery: F[ResultSet] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.executeQuery()")) *>
    F.delay(value.executeQuery())

  def executeQuery(a: String): F[ResultSet] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.executeQuery($a)")) *>
    F.delay(value.executeQuery(a))

  val executeUpdate: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.executeUpdate()")) *>
    F.delay(value.executeUpdate())

  def executeUpdate(a: String): F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.executeUpdate($a)")) *>
    F.delay(value.executeUpdate(a))

  def executeUpdate(a: String, b: Array[Int]): F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.executeUpdate($a, $b)")) *>
    F.delay(value.executeUpdate(a, b))

  def executeUpdate(a: String, b: Array[String]): F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.executeUpdate($a, $b)")) *>
    F.delay(value.executeUpdate(a, b))

  def executeUpdate(a: String, b: Int): F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.executeUpdate($a, $b)")) *>
    F.delay(value.executeUpdate(a, b))

  val getConnection: F[Connection] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.getConnection()")) *>
    F.delay(value.getConnection())

  val getFetchDirection: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.getFetchDirection()")) *>
    F.delay(value.getFetchDirection())

  val getFetchSize: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.getFetchSize()")) *>
    F.delay(value.getFetchSize())

  val getGeneratedKeys: F[ResultSet] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.getGeneratedKeys()")) *>
    F.delay(value.getGeneratedKeys())

  val getLargeMaxRows: F[Long] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.getLargeMaxRows()")) *>
    F.delay(value.getLargeMaxRows())

  val getLargeUpdateCount: F[Long] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.getLargeUpdateCount()")) *>
    F.delay(value.getLargeUpdateCount())

  val getMaxFieldSize: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.getMaxFieldSize()")) *>
    F.delay(value.getMaxFieldSize())

  val getMaxRows: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.getMaxRows()")) *>
    F.delay(value.getMaxRows())

  val getMetaData: F[ResultSetMetaData] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.getMetaData()")) *>
    F.delay(value.getMetaData())

  val getMoreResults: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.getMoreResults()")) *>
    F.delay(value.getMoreResults())

  def getMoreResults(a: Int): F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.getMoreResults($a)")) *>
    F.delay(value.getMoreResults(a))

  val getParameterMetaData: F[ParameterMetaData] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.getParameterMetaData()")) *>
    F.delay(value.getParameterMetaData())

  val getQueryTimeout: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.getQueryTimeout()")) *>
    F.delay(value.getQueryTimeout())

  val getResultSet: F[ResultSet] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.getResultSet()")) *>
    F.delay(value.getResultSet())

  val getResultSetConcurrency: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.getResultSetConcurrency()")) *>
    F.delay(value.getResultSetConcurrency())

  val getResultSetHoldability: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.getResultSetHoldability()")) *>
    F.delay(value.getResultSetHoldability())

  val getResultSetType: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.getResultSetType()")) *>
    F.delay(value.getResultSetType())

  val getUpdateCount: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.getUpdateCount()")) *>
    F.delay(value.getUpdateCount())

  val getWarnings: F[SQLWarning] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.getWarnings()")) *>
    F.delay(value.getWarnings())

  val isCloseOnCompletion: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.isCloseOnCompletion()")) *>
    F.delay(value.isCloseOnCompletion())

  val isClosed: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.isClosed()")) *>
    F.delay(value.isClosed())

  val isPoolable: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.isPoolable()")) *>
    F.delay(value.isPoolable())

  def isWrapperFor(a: Class[_]): F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.isWrapperFor($a)")) *>
    F.delay(value.isWrapperFor(a))

  def setArray(a: Int, b: SqlArray): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setArray($a, $b)")) *>
    F.delay(value.setArray(a, b))

  def setAsciiStream(a: Int, b: InputStream): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setAsciiStream($a, $b)")) *>
    F.delay(value.setAsciiStream(a, b))

  def setAsciiStream(a: Int, b: InputStream, c: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setAsciiStream($a, $b, $c)")) *>
    F.delay(value.setAsciiStream(a, b, c))

  def setAsciiStream(a: Int, b: InputStream, c: Long): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setAsciiStream($a, $b, $c)")) *>
    F.delay(value.setAsciiStream(a, b, c))

  def setBigDecimal(a: Int, b: BigDecimal): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setBigDecimal($a, $b)")) *>
    F.delay(value.setBigDecimal(a, b))

  def setBinaryStream(a: Int, b: InputStream): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setBinaryStream($a, $b)")) *>
    F.delay(value.setBinaryStream(a, b))

  def setBinaryStream(a: Int, b: InputStream, c: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setBinaryStream($a, $b, $c)")) *>
    F.delay(value.setBinaryStream(a, b, c))

  def setBinaryStream(a: Int, b: InputStream, c: Long): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setBinaryStream($a, $b, $c)")) *>
    F.delay(value.setBinaryStream(a, b, c))

  def setBlob(a: Int, b: Blob): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setBlob($a, $b)")) *>
    F.delay(value.setBlob(a, b))

  def setBlob(a: Int, b: InputStream): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setBlob($a, $b)")) *>
    F.delay(value.setBlob(a, b))

  def setBlob(a: Int, b: InputStream, c: Long): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setBlob($a, $b, $c)")) *>
    F.delay(value.setBlob(a, b, c))

  def setBoolean(a: Int, b: Boolean): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setBoolean($a, $b)")) *>
    F.delay(value.setBoolean(a, b))

  def setByte(a: Int, b: Byte): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setByte($a, $b)")) *>
    F.delay(value.setByte(a, b))

  def setBytes(a: Int, b: Array[Byte]): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setBytes($a, $b)")) *>
    F.delay(value.setBytes(a, b))

  def setCharacterStream(a: Int, b: Reader): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setCharacterStream($a, $b)")) *>
    F.delay(value.setCharacterStream(a, b))

  def setCharacterStream(a: Int, b: Reader, c: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setCharacterStream($a, $b, $c)")) *>
    F.delay(value.setCharacterStream(a, b, c))

  def setCharacterStream(a: Int, b: Reader, c: Long): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setCharacterStream($a, $b, $c)")) *>
    F.delay(value.setCharacterStream(a, b, c))

  def setClob(a: Int, b: Clob): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setClob($a, $b)")) *>
    F.delay(value.setClob(a, b))

  def setClob(a: Int, b: Reader): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setClob($a, $b)")) *>
    F.delay(value.setClob(a, b))

  def setClob(a: Int, b: Reader, c: Long): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setClob($a, $b, $c)")) *>
    F.delay(value.setClob(a, b, c))

  def setCursorName(a: String): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setCursorName($a)")) *>
    F.delay(value.setCursorName(a))

  def setDate(a: Int, b: Date): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setDate($a, $b)")) *>
    F.delay(value.setDate(a, b))

  def setDate(a: Int, b: Date, c: Calendar): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setDate($a, $b, $c)")) *>
    F.delay(value.setDate(a, b, c))

  def setDouble(a: Int, b: Double): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setDouble($a, $b)")) *>
    F.delay(value.setDouble(a, b))

  def setEscapeProcessing(a: Boolean): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setEscapeProcessing($a)")) *>
    F.delay(value.setEscapeProcessing(a))

  def setFetchDirection(a: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setFetchDirection($a)")) *>
    F.delay(value.setFetchDirection(a))

  def setFetchSize(a: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setFetchSize($a)")) *>
    F.delay(value.setFetchSize(a))

  def setFloat(a: Int, b: Float): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setFloat($a, $b)")) *>
    F.delay(value.setFloat(a, b))

  def setInt(a: Int, b: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setInt($a, $b)")) *>
    F.delay(value.setInt(a, b))

  def setLargeMaxRows(a: Long): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setLargeMaxRows($a)")) *>
    F.delay(value.setLargeMaxRows(a))

  def setLong(a: Int, b: Long): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setLong($a, $b)")) *>
    F.delay(value.setLong(a, b))

  def setMaxFieldSize(a: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setMaxFieldSize($a)")) *>
    F.delay(value.setMaxFieldSize(a))

  def setMaxRows(a: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setMaxRows($a)")) *>
    F.delay(value.setMaxRows(a))

  def setNCharacterStream(a: Int, b: Reader): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setNCharacterStream($a, $b)")) *>
    F.delay(value.setNCharacterStream(a, b))

  def setNCharacterStream(a: Int, b: Reader, c: Long): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setNCharacterStream($a, $b, $c)")) *>
    F.delay(value.setNCharacterStream(a, b, c))

  def setNClob(a: Int, b: NClob): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setNClob($a, $b)")) *>
    F.delay(value.setNClob(a, b))

  def setNClob(a: Int, b: Reader): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setNClob($a, $b)")) *>
    F.delay(value.setNClob(a, b))

  def setNClob(a: Int, b: Reader, c: Long): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setNClob($a, $b, $c)")) *>
    F.delay(value.setNClob(a, b, c))

  def setNString(a: Int, b: String): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setNString($a, $b)")) *>
    F.delay(value.setNString(a, b))

  def setNull(a: Int, b: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setNull($a, $b)")) *>
    F.delay(value.setNull(a, b))

  def setNull(a: Int, b: Int, c: String): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setNull($a, $b, $c)")) *>
    F.delay(value.setNull(a, b, c))

  def setObject(a: Int, b: AnyRef): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setObject($a, $b)")) *>
    F.delay(value.setObject(a, b))

  def setObject(a: Int, b: AnyRef, c: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setObject($a, $b, $c)")) *>
    F.delay(value.setObject(a, b, c))

  def setObject(a: Int, b: AnyRef, c: Int, d: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setObject($a, $b, $c, $d)")) *>
    F.delay(value.setObject(a, b, c, d))

  def setObject(a: Int, b: AnyRef, c: SQLType): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setObject($a, $b, $c)")) *>
    F.delay(value.setObject(a, b, c))

  def setObject(a: Int, b: AnyRef, c: SQLType, d: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setObject($a, $b, $c, $d)")) *>
    F.delay(value.setObject(a, b, c, d))

  def setPoolable(a: Boolean): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setPoolable($a)")) *>
    F.delay(value.setPoolable(a))

  def setQueryTimeout(a: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setQueryTimeout($a)")) *>
    F.delay(value.setQueryTimeout(a))

  def setRef(a: Int, b: Ref): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setRef($a, $b)")) *>
    F.delay(value.setRef(a, b))

  def setRowId(a: Int, b: RowId): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setRowId($a, $b)")) *>
    F.delay(value.setRowId(a, b))

  def setSQLXML(a: Int, b: SQLXML): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setSQLXML($a, $b)")) *>
    F.delay(value.setSQLXML(a, b))

  def setShort(a: Int, b: Short): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setShort($a, $b)")) *>
    F.delay(value.setShort(a, b))

  def setString(a: Int, b: String): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setString($a, $b)")) *>
    F.delay(value.setString(a, b))

  def setTime(a: Int, b: Time): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setTime($a, $b)")) *>
    F.delay(value.setTime(a, b))

  def setTime(a: Int, b: Time, c: Calendar): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setTime($a, $b, $c)")) *>
    F.delay(value.setTime(a, b, c))

  def setTimestamp(a: Int, b: Timestamp): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setTimestamp($a, $b)")) *>
    F.delay(value.setTimestamp(a, b))

  def setTimestamp(a: Int, b: Timestamp, c: Calendar): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setTimestamp($a, $b, $c)")) *>
    F.delay(value.setTimestamp(a, b, c))

  def setURL(a: Int, b: URL): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setURL($a, $b)")) *>
    F.delay(value.setURL(a, b))

  def setUnicodeStream(a: Int, b: InputStream, c: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.setUnicodeStream($a, $b, $c)")) *>
    F.delay(value.setUnicodeStream(a, b, c))

  def unwrap[T](a: Class[T]): F[T] =
    F.delay(Console.err.println(s"${Thread.currentThread}: PreparedStatement.unwrap($a)")) *>
    F.delay(value.unwrap(a))

}

