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
class AsyncCallableStatement[F[_]: Sync](value: CallableStatement, rts: RTS[F], log: Logger) extends JdbcCallableStatement[F] {

  val id: String =
    s"${System.identityHashCode(value).toHexString.padTo(8, ' ')} CallableStatement".padTo(28, ' ')

  val addBatch: F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id addBatch()")
        value.addBatch()
      }
    }

  def addBatch(a: String): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id addBatch($a)")
        value.addBatch(a)
      }
    }

  val cancel: F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id cancel()")
        value.cancel()
      }
    }

  val clearBatch: F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id clearBatch()")
        value.clearBatch()
      }
    }

  val clearParameters: F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id clearParameters()")
        value.clearParameters()
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

  val closeOnCompletion: F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id closeOnCompletion()")
        value.closeOnCompletion()
      }
    }

  val execute: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id execute()")
        value.execute()
      }
    }

  def execute(a: String): F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id execute($a)")
        value.execute(a)
      }
    }

  def execute(a: String, b: Array[Int]): F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id execute($a, $b)")
        value.execute(a, b)
      }
    }

  def execute(a: String, b: Array[String]): F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id execute($a, $b)")
        value.execute(a, b)
      }
    }

  def execute(a: String, b: Int): F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id execute($a, $b)")
        value.execute(a, b)
      }
    }

  val executeBatch: F[Array[Int]] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id executeBatch()")
        value.executeBatch()
      }
    }

  val executeLargeBatch: F[Array[Long]] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id executeLargeBatch()")
        value.executeLargeBatch()
      }
    }

  val executeLargeUpdate: F[Long] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id executeLargeUpdate()")
        value.executeLargeUpdate()
      }
    }

  def executeLargeUpdate(a: String): F[Long] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id executeLargeUpdate($a)")
        value.executeLargeUpdate(a)
      }
    }

  def executeLargeUpdate(a: String, b: Array[Int]): F[Long] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id executeLargeUpdate($a, $b)")
        value.executeLargeUpdate(a, b)
      }
    }

  def executeLargeUpdate(a: String, b: Array[String]): F[Long] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id executeLargeUpdate($a, $b)")
        value.executeLargeUpdate(a, b)
      }
    }

  def executeLargeUpdate(a: String, b: Int): F[Long] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id executeLargeUpdate($a, $b)")
        value.executeLargeUpdate(a, b)
      }
    }

  val executeQuery: F[ResultSet] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id executeQuery()")
        value.executeQuery()
      }
    }

  def executeQuery(a: String): F[ResultSet] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id executeQuery($a)")
        value.executeQuery(a)
      }
    }

  val executeUpdate: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id executeUpdate()")
        value.executeUpdate()
      }
    }

  def executeUpdate(a: String): F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id executeUpdate($a)")
        value.executeUpdate(a)
      }
    }

  def executeUpdate(a: String, b: Array[Int]): F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id executeUpdate($a, $b)")
        value.executeUpdate(a, b)
      }
    }

  def executeUpdate(a: String, b: Array[String]): F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id executeUpdate($a, $b)")
        value.executeUpdate(a, b)
      }
    }

  def executeUpdate(a: String, b: Int): F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id executeUpdate($a, $b)")
        value.executeUpdate(a, b)
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

  val getConnection: F[Connection] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getConnection()")
        value.getConnection()
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

  val getGeneratedKeys: F[ResultSet] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getGeneratedKeys()")
        value.getGeneratedKeys()
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

  val getLargeMaxRows: F[Long] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getLargeMaxRows()")
        value.getLargeMaxRows()
      }
    }

  val getLargeUpdateCount: F[Long] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getLargeUpdateCount()")
        value.getLargeUpdateCount()
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

  val getMaxFieldSize: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getMaxFieldSize()")
        value.getMaxFieldSize()
      }
    }

  val getMaxRows: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getMaxRows()")
        value.getMaxRows()
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

  val getMoreResults: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getMoreResults()")
        value.getMoreResults()
      }
    }

  def getMoreResults(a: Int): F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getMoreResults($a)")
        value.getMoreResults(a)
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

  val getParameterMetaData: F[ParameterMetaData] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getParameterMetaData()")
        value.getParameterMetaData()
      }
    }

  val getQueryTimeout: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getQueryTimeout()")
        value.getQueryTimeout()
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

  val getResultSet: F[ResultSet] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getResultSet()")
        value.getResultSet()
      }
    }

  val getResultSetConcurrency: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getResultSetConcurrency()")
        value.getResultSetConcurrency()
      }
    }

  val getResultSetHoldability: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getResultSetHoldability()")
        value.getResultSetHoldability()
      }
    }

  val getResultSetType: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getResultSetType()")
        value.getResultSetType()
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

  val getUpdateCount: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getUpdateCount()")
        value.getUpdateCount()
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

  val isCloseOnCompletion: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id isCloseOnCompletion()")
        value.isCloseOnCompletion()
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

  val isPoolable: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id isPoolable()")
        value.isPoolable()
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

  def registerOutParameter(a: Int, b: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id registerOutParameter($a, $b)")
        value.registerOutParameter(a, b)
      }
    }

  def registerOutParameter(a: Int, b: Int, c: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id registerOutParameter($a, $b, $c)")
        value.registerOutParameter(a, b, c)
      }
    }

  def registerOutParameter(a: Int, b: Int, c: String): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id registerOutParameter($a, $b, $c)")
        value.registerOutParameter(a, b, c)
      }
    }

  def registerOutParameter(a: Int, b: SQLType): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id registerOutParameter($a, $b)")
        value.registerOutParameter(a, b)
      }
    }

  def registerOutParameter(a: Int, b: SQLType, c: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id registerOutParameter($a, $b, $c)")
        value.registerOutParameter(a, b, c)
      }
    }

  def registerOutParameter(a: Int, b: SQLType, c: String): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id registerOutParameter($a, $b, $c)")
        value.registerOutParameter(a, b, c)
      }
    }

  def registerOutParameter(a: String, b: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id registerOutParameter($a, $b)")
        value.registerOutParameter(a, b)
      }
    }

  def registerOutParameter(a: String, b: Int, c: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id registerOutParameter($a, $b, $c)")
        value.registerOutParameter(a, b, c)
      }
    }

  def registerOutParameter(a: String, b: Int, c: String): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id registerOutParameter($a, $b, $c)")
        value.registerOutParameter(a, b, c)
      }
    }

  def registerOutParameter(a: String, b: SQLType): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id registerOutParameter($a, $b)")
        value.registerOutParameter(a, b)
      }
    }

  def registerOutParameter(a: String, b: SQLType, c: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id registerOutParameter($a, $b, $c)")
        value.registerOutParameter(a, b, c)
      }
    }

  def registerOutParameter(a: String, b: SQLType, c: String): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id registerOutParameter($a, $b, $c)")
        value.registerOutParameter(a, b, c)
      }
    }

  def setArray(a: Int, b: SqlArray): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setArray($a, $b)")
        value.setArray(a, b)
      }
    }

  def setAsciiStream(a: Int, b: InputStream): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setAsciiStream($a, $b)")
        value.setAsciiStream(a, b)
      }
    }

  def setAsciiStream(a: Int, b: InputStream, c: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setAsciiStream($a, $b, $c)")
        value.setAsciiStream(a, b, c)
      }
    }

  def setAsciiStream(a: Int, b: InputStream, c: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setAsciiStream($a, $b, $c)")
        value.setAsciiStream(a, b, c)
      }
    }

  def setAsciiStream(a: String, b: InputStream): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setAsciiStream($a, $b)")
        value.setAsciiStream(a, b)
      }
    }

  def setAsciiStream(a: String, b: InputStream, c: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setAsciiStream($a, $b, $c)")
        value.setAsciiStream(a, b, c)
      }
    }

  def setAsciiStream(a: String, b: InputStream, c: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setAsciiStream($a, $b, $c)")
        value.setAsciiStream(a, b, c)
      }
    }

  def setBigDecimal(a: Int, b: BigDecimal): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setBigDecimal($a, $b)")
        value.setBigDecimal(a, b)
      }
    }

  def setBigDecimal(a: String, b: BigDecimal): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setBigDecimal($a, $b)")
        value.setBigDecimal(a, b)
      }
    }

  def setBinaryStream(a: Int, b: InputStream): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setBinaryStream($a, $b)")
        value.setBinaryStream(a, b)
      }
    }

  def setBinaryStream(a: Int, b: InputStream, c: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setBinaryStream($a, $b, $c)")
        value.setBinaryStream(a, b, c)
      }
    }

  def setBinaryStream(a: Int, b: InputStream, c: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setBinaryStream($a, $b, $c)")
        value.setBinaryStream(a, b, c)
      }
    }

  def setBinaryStream(a: String, b: InputStream): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setBinaryStream($a, $b)")
        value.setBinaryStream(a, b)
      }
    }

  def setBinaryStream(a: String, b: InputStream, c: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setBinaryStream($a, $b, $c)")
        value.setBinaryStream(a, b, c)
      }
    }

  def setBinaryStream(a: String, b: InputStream, c: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setBinaryStream($a, $b, $c)")
        value.setBinaryStream(a, b, c)
      }
    }

  def setBlob(a: Int, b: Blob): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setBlob($a, $b)")
        value.setBlob(a, b)
      }
    }

  def setBlob(a: Int, b: InputStream): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setBlob($a, $b)")
        value.setBlob(a, b)
      }
    }

  def setBlob(a: Int, b: InputStream, c: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setBlob($a, $b, $c)")
        value.setBlob(a, b, c)
      }
    }

  def setBlob(a: String, b: Blob): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setBlob($a, $b)")
        value.setBlob(a, b)
      }
    }

  def setBlob(a: String, b: InputStream): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setBlob($a, $b)")
        value.setBlob(a, b)
      }
    }

  def setBlob(a: String, b: InputStream, c: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setBlob($a, $b, $c)")
        value.setBlob(a, b, c)
      }
    }

  def setBoolean(a: Int, b: Boolean): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setBoolean($a, $b)")
        value.setBoolean(a, b)
      }
    }

  def setBoolean(a: String, b: Boolean): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setBoolean($a, $b)")
        value.setBoolean(a, b)
      }
    }

  def setByte(a: Int, b: Byte): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setByte($a, $b)")
        value.setByte(a, b)
      }
    }

  def setByte(a: String, b: Byte): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setByte($a, $b)")
        value.setByte(a, b)
      }
    }

  def setBytes(a: Int, b: Array[Byte]): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setBytes($a, $b)")
        value.setBytes(a, b)
      }
    }

  def setBytes(a: String, b: Array[Byte]): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setBytes($a, $b)")
        value.setBytes(a, b)
      }
    }

  def setCharacterStream(a: Int, b: Reader): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setCharacterStream($a, $b)")
        value.setCharacterStream(a, b)
      }
    }

  def setCharacterStream(a: Int, b: Reader, c: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setCharacterStream($a, $b, $c)")
        value.setCharacterStream(a, b, c)
      }
    }

  def setCharacterStream(a: Int, b: Reader, c: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setCharacterStream($a, $b, $c)")
        value.setCharacterStream(a, b, c)
      }
    }

  def setCharacterStream(a: String, b: Reader): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setCharacterStream($a, $b)")
        value.setCharacterStream(a, b)
      }
    }

  def setCharacterStream(a: String, b: Reader, c: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setCharacterStream($a, $b, $c)")
        value.setCharacterStream(a, b, c)
      }
    }

  def setCharacterStream(a: String, b: Reader, c: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setCharacterStream($a, $b, $c)")
        value.setCharacterStream(a, b, c)
      }
    }

  def setClob(a: Int, b: Clob): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setClob($a, $b)")
        value.setClob(a, b)
      }
    }

  def setClob(a: Int, b: Reader): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setClob($a, $b)")
        value.setClob(a, b)
      }
    }

  def setClob(a: Int, b: Reader, c: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setClob($a, $b, $c)")
        value.setClob(a, b, c)
      }
    }

  def setClob(a: String, b: Clob): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setClob($a, $b)")
        value.setClob(a, b)
      }
    }

  def setClob(a: String, b: Reader): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setClob($a, $b)")
        value.setClob(a, b)
      }
    }

  def setClob(a: String, b: Reader, c: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setClob($a, $b, $c)")
        value.setClob(a, b, c)
      }
    }

  def setCursorName(a: String): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setCursorName($a)")
        value.setCursorName(a)
      }
    }

  def setDate(a: Int, b: Date): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setDate($a, $b)")
        value.setDate(a, b)
      }
    }

  def setDate(a: Int, b: Date, c: Calendar): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setDate($a, $b, $c)")
        value.setDate(a, b, c)
      }
    }

  def setDate(a: String, b: Date): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setDate($a, $b)")
        value.setDate(a, b)
      }
    }

  def setDate(a: String, b: Date, c: Calendar): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setDate($a, $b, $c)")
        value.setDate(a, b, c)
      }
    }

  def setDouble(a: Int, b: Double): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setDouble($a, $b)")
        value.setDouble(a, b)
      }
    }

  def setDouble(a: String, b: Double): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setDouble($a, $b)")
        value.setDouble(a, b)
      }
    }

  def setEscapeProcessing(a: Boolean): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setEscapeProcessing($a)")
        value.setEscapeProcessing(a)
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

  def setFloat(a: Int, b: Float): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setFloat($a, $b)")
        value.setFloat(a, b)
      }
    }

  def setFloat(a: String, b: Float): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setFloat($a, $b)")
        value.setFloat(a, b)
      }
    }

  def setInt(a: Int, b: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setInt($a, $b)")
        value.setInt(a, b)
      }
    }

  def setInt(a: String, b: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setInt($a, $b)")
        value.setInt(a, b)
      }
    }

  def setLargeMaxRows(a: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setLargeMaxRows($a)")
        value.setLargeMaxRows(a)
      }
    }

  def setLong(a: Int, b: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setLong($a, $b)")
        value.setLong(a, b)
      }
    }

  def setLong(a: String, b: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setLong($a, $b)")
        value.setLong(a, b)
      }
    }

  def setMaxFieldSize(a: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setMaxFieldSize($a)")
        value.setMaxFieldSize(a)
      }
    }

  def setMaxRows(a: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setMaxRows($a)")
        value.setMaxRows(a)
      }
    }

  def setNCharacterStream(a: Int, b: Reader): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setNCharacterStream($a, $b)")
        value.setNCharacterStream(a, b)
      }
    }

  def setNCharacterStream(a: Int, b: Reader, c: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setNCharacterStream($a, $b, $c)")
        value.setNCharacterStream(a, b, c)
      }
    }

  def setNCharacterStream(a: String, b: Reader): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setNCharacterStream($a, $b)")
        value.setNCharacterStream(a, b)
      }
    }

  def setNCharacterStream(a: String, b: Reader, c: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setNCharacterStream($a, $b, $c)")
        value.setNCharacterStream(a, b, c)
      }
    }

  def setNClob(a: Int, b: NClob): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setNClob($a, $b)")
        value.setNClob(a, b)
      }
    }

  def setNClob(a: Int, b: Reader): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setNClob($a, $b)")
        value.setNClob(a, b)
      }
    }

  def setNClob(a: Int, b: Reader, c: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setNClob($a, $b, $c)")
        value.setNClob(a, b, c)
      }
    }

  def setNClob(a: String, b: NClob): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setNClob($a, $b)")
        value.setNClob(a, b)
      }
    }

  def setNClob(a: String, b: Reader): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setNClob($a, $b)")
        value.setNClob(a, b)
      }
    }

  def setNClob(a: String, b: Reader, c: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setNClob($a, $b, $c)")
        value.setNClob(a, b, c)
      }
    }

  def setNString(a: Int, b: String): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setNString($a, $b)")
        value.setNString(a, b)
      }
    }

  def setNString(a: String, b: String): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setNString($a, $b)")
        value.setNString(a, b)
      }
    }

  def setNull(a: Int, b: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setNull($a, $b)")
        value.setNull(a, b)
      }
    }

  def setNull(a: Int, b: Int, c: String): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setNull($a, $b, $c)")
        value.setNull(a, b, c)
      }
    }

  def setNull(a: String, b: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setNull($a, $b)")
        value.setNull(a, b)
      }
    }

  def setNull(a: String, b: Int, c: String): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setNull($a, $b, $c)")
        value.setNull(a, b, c)
      }
    }

  def setObject(a: Int, b: AnyRef): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setObject($a, $b)")
        value.setObject(a, b)
      }
    }

  def setObject(a: Int, b: AnyRef, c: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setObject($a, $b, $c)")
        value.setObject(a, b, c)
      }
    }

  def setObject(a: Int, b: AnyRef, c: Int, d: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setObject($a, $b, $c, $d)")
        value.setObject(a, b, c, d)
      }
    }

  def setObject(a: Int, b: AnyRef, c: SQLType): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setObject($a, $b, $c)")
        value.setObject(a, b, c)
      }
    }

  def setObject(a: Int, b: AnyRef, c: SQLType, d: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setObject($a, $b, $c, $d)")
        value.setObject(a, b, c, d)
      }
    }

  def setObject(a: String, b: AnyRef): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setObject($a, $b)")
        value.setObject(a, b)
      }
    }

  def setObject(a: String, b: AnyRef, c: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setObject($a, $b, $c)")
        value.setObject(a, b, c)
      }
    }

  def setObject(a: String, b: AnyRef, c: Int, d: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setObject($a, $b, $c, $d)")
        value.setObject(a, b, c, d)
      }
    }

  def setObject(a: String, b: AnyRef, c: SQLType): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setObject($a, $b, $c)")
        value.setObject(a, b, c)
      }
    }

  def setObject(a: String, b: AnyRef, c: SQLType, d: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setObject($a, $b, $c, $d)")
        value.setObject(a, b, c, d)
      }
    }

  def setPoolable(a: Boolean): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setPoolable($a)")
        value.setPoolable(a)
      }
    }

  def setQueryTimeout(a: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setQueryTimeout($a)")
        value.setQueryTimeout(a)
      }
    }

  def setRef(a: Int, b: Ref): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setRef($a, $b)")
        value.setRef(a, b)
      }
    }

  def setRowId(a: Int, b: RowId): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setRowId($a, $b)")
        value.setRowId(a, b)
      }
    }

  def setRowId(a: String, b: RowId): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setRowId($a, $b)")
        value.setRowId(a, b)
      }
    }

  def setSQLXML(a: Int, b: SQLXML): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setSQLXML($a, $b)")
        value.setSQLXML(a, b)
      }
    }

  def setSQLXML(a: String, b: SQLXML): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setSQLXML($a, $b)")
        value.setSQLXML(a, b)
      }
    }

  def setShort(a: Int, b: Short): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setShort($a, $b)")
        value.setShort(a, b)
      }
    }

  def setShort(a: String, b: Short): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setShort($a, $b)")
        value.setShort(a, b)
      }
    }

  def setString(a: Int, b: String): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setString($a, $b)")
        value.setString(a, b)
      }
    }

  def setString(a: String, b: String): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setString($a, $b)")
        value.setString(a, b)
      }
    }

  def setTime(a: Int, b: Time): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setTime($a, $b)")
        value.setTime(a, b)
      }
    }

  def setTime(a: Int, b: Time, c: Calendar): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setTime($a, $b, $c)")
        value.setTime(a, b, c)
      }
    }

  def setTime(a: String, b: Time): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setTime($a, $b)")
        value.setTime(a, b)
      }
    }

  def setTime(a: String, b: Time, c: Calendar): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setTime($a, $b, $c)")
        value.setTime(a, b, c)
      }
    }

  def setTimestamp(a: Int, b: Timestamp): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setTimestamp($a, $b)")
        value.setTimestamp(a, b)
      }
    }

  def setTimestamp(a: Int, b: Timestamp, c: Calendar): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setTimestamp($a, $b, $c)")
        value.setTimestamp(a, b, c)
      }
    }

  def setTimestamp(a: String, b: Timestamp): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setTimestamp($a, $b)")
        value.setTimestamp(a, b)
      }
    }

  def setTimestamp(a: String, b: Timestamp, c: Calendar): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setTimestamp($a, $b, $c)")
        value.setTimestamp(a, b, c)
      }
    }

  def setURL(a: Int, b: URL): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setURL($a, $b)")
        value.setURL(a, b)
      }
    }

  def setURL(a: String, b: URL): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setURL($a, $b)")
        value.setURL(a, b)
      }
    }

  def setUnicodeStream(a: Int, b: InputStream, c: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setUnicodeStream($a, $b, $c)")
        value.setUnicodeStream(a, b, c)
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

  val wasNull: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id wasNull()")
        value.wasNull()
      }
    }

}

