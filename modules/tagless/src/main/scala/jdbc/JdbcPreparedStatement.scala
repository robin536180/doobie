// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless.jdbc

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

/** Algebra of operations for `java.sql.PreparedStatement`. */
@SuppressWarnings(Array("org.wartremover.warts.Overloading"))
trait JdbcPreparedStatement[F[_]] {
  def addBatch: F[Unit]
  def addBatch(a: String): F[Unit]
  def cancel: F[Unit]
  def clearBatch: F[Unit]
  def clearParameters: F[Unit]
  def clearWarnings: F[Unit]
  def close: F[Unit]
  def closeOnCompletion: F[Unit]
  def execute: F[Boolean]
  def execute(a: String): F[Boolean]
  def execute(a: String, b: Array[Int]): F[Boolean]
  def execute(a: String, b: Array[String]): F[Boolean]
  def execute(a: String, b: Int): F[Boolean]
  def executeBatch: F[Array[Int]]
  def executeLargeBatch: F[Array[Long]]
  def executeLargeUpdate: F[Long]
  def executeLargeUpdate(a: String): F[Long]
  def executeLargeUpdate(a: String, b: Array[Int]): F[Long]
  def executeLargeUpdate(a: String, b: Array[String]): F[Long]
  def executeLargeUpdate(a: String, b: Int): F[Long]
  def executeQuery: F[ResultSet]
  def executeQuery(a: String): F[ResultSet]
  def executeUpdate: F[Int]
  def executeUpdate(a: String): F[Int]
  def executeUpdate(a: String, b: Array[Int]): F[Int]
  def executeUpdate(a: String, b: Array[String]): F[Int]
  def executeUpdate(a: String, b: Int): F[Int]
  def getConnection: F[Connection]
  def getFetchDirection: F[Int]
  def getFetchSize: F[Int]
  def getGeneratedKeys: F[ResultSet]
  def getLargeMaxRows: F[Long]
  def getLargeUpdateCount: F[Long]
  def getMaxFieldSize: F[Int]
  def getMaxRows: F[Int]
  def getMetaData: F[ResultSetMetaData]
  def getMoreResults: F[Boolean]
  def getMoreResults(a: Int): F[Boolean]
  def getParameterMetaData: F[ParameterMetaData]
  def getQueryTimeout: F[Int]
  def getResultSet: F[ResultSet]
  def getResultSetConcurrency: F[Int]
  def getResultSetHoldability: F[Int]
  def getResultSetType: F[Int]
  def getUpdateCount: F[Int]
  def getWarnings: F[SQLWarning]
  def isCloseOnCompletion: F[Boolean]
  def isClosed: F[Boolean]
  def isPoolable: F[Boolean]
  def isWrapperFor(a: Class[_]): F[Boolean]
  def setArray(a: Int, b: SqlArray): F[Unit]
  def setAsciiStream(a: Int, b: InputStream): F[Unit]
  def setAsciiStream(a: Int, b: InputStream, c: Int): F[Unit]
  def setAsciiStream(a: Int, b: InputStream, c: Long): F[Unit]
  def setBigDecimal(a: Int, b: BigDecimal): F[Unit]
  def setBinaryStream(a: Int, b: InputStream): F[Unit]
  def setBinaryStream(a: Int, b: InputStream, c: Int): F[Unit]
  def setBinaryStream(a: Int, b: InputStream, c: Long): F[Unit]
  def setBlob(a: Int, b: Blob): F[Unit]
  def setBlob(a: Int, b: InputStream): F[Unit]
  def setBlob(a: Int, b: InputStream, c: Long): F[Unit]
  def setBoolean(a: Int, b: Boolean): F[Unit]
  def setByte(a: Int, b: Byte): F[Unit]
  def setBytes(a: Int, b: Array[Byte]): F[Unit]
  def setCharacterStream(a: Int, b: Reader): F[Unit]
  def setCharacterStream(a: Int, b: Reader, c: Int): F[Unit]
  def setCharacterStream(a: Int, b: Reader, c: Long): F[Unit]
  def setClob(a: Int, b: Clob): F[Unit]
  def setClob(a: Int, b: Reader): F[Unit]
  def setClob(a: Int, b: Reader, c: Long): F[Unit]
  def setCursorName(a: String): F[Unit]
  def setDate(a: Int, b: Date): F[Unit]
  def setDate(a: Int, b: Date, c: Calendar): F[Unit]
  def setDouble(a: Int, b: Double): F[Unit]
  def setEscapeProcessing(a: Boolean): F[Unit]
  def setFetchDirection(a: Int): F[Unit]
  def setFetchSize(a: Int): F[Unit]
  def setFloat(a: Int, b: Float): F[Unit]
  def setInt(a: Int, b: Int): F[Unit]
  def setLargeMaxRows(a: Long): F[Unit]
  def setLong(a: Int, b: Long): F[Unit]
  def setMaxFieldSize(a: Int): F[Unit]
  def setMaxRows(a: Int): F[Unit]
  def setNCharacterStream(a: Int, b: Reader): F[Unit]
  def setNCharacterStream(a: Int, b: Reader, c: Long): F[Unit]
  def setNClob(a: Int, b: NClob): F[Unit]
  def setNClob(a: Int, b: Reader): F[Unit]
  def setNClob(a: Int, b: Reader, c: Long): F[Unit]
  def setNString(a: Int, b: String): F[Unit]
  def setNull(a: Int, b: Int): F[Unit]
  def setNull(a: Int, b: Int, c: String): F[Unit]
  def setObject(a: Int, b: AnyRef): F[Unit]
  def setObject(a: Int, b: AnyRef, c: Int): F[Unit]
  def setObject(a: Int, b: AnyRef, c: Int, d: Int): F[Unit]
  def setObject(a: Int, b: AnyRef, c: SQLType): F[Unit]
  def setObject(a: Int, b: AnyRef, c: SQLType, d: Int): F[Unit]
  def setPoolable(a: Boolean): F[Unit]
  def setQueryTimeout(a: Int): F[Unit]
  def setRef(a: Int, b: Ref): F[Unit]
  def setRowId(a: Int, b: RowId): F[Unit]
  def setSQLXML(a: Int, b: SQLXML): F[Unit]
  def setShort(a: Int, b: Short): F[Unit]
  def setString(a: Int, b: String): F[Unit]
  def setTime(a: Int, b: Time): F[Unit]
  def setTime(a: Int, b: Time, c: Calendar): F[Unit]
  def setTimestamp(a: Int, b: Timestamp): F[Unit]
  def setTimestamp(a: Int, b: Timestamp, c: Calendar): F[Unit]
  def setURL(a: Int, b: URL): F[Unit]
  def setUnicodeStream(a: Int, b: InputStream, c: Int): F[Unit]
  def unwrap[T](a: Class[T]): F[T]
}

