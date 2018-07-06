// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless.async

import cats.effect.Sync
import doobie.tagless.RTS
import doobie.tagless.jdbc._
import org.slf4j.Logger
import java.lang.Class
import java.lang.String
import java.sql.Blob
import java.sql.CallableStatement
import java.sql.Clob
import java.sql.Connection
import java.sql.DatabaseMetaData
import java.sql.NClob
import java.sql.PreparedStatement
import java.sql.SQLWarning
import java.sql.SQLXML
import java.sql.Savepoint
import java.sql.Statement
import java.sql.Struct
import java.sql.{ Array => SqlArray }
import java.util.Map
import java.util.Properties
import java.util.concurrent.Executor

/**
 * Implementation of JdbcConnection that wraps a Connection and lifts its primitive operations into any F
 * given a Sync instance.
 */
@SuppressWarnings(Array("org.wartremover.warts.Overloading"))
class AsyncConnection[F[_]: Sync](value: Connection, rts: RTS[F], log: Logger) extends JdbcConnection[F] {

  val id: String =
    s"${System.identityHashCode(value).toHexString.padTo(8, ' ')} Connection".padTo(28, ' ')

  def abort(a: Executor): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id abort($a)")
        value.abort(a)
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

  val commit: F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id commit()")
        value.commit()
      }
    }

  def createArrayOf(a: String, b: Array[AnyRef]): F[SqlArray] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id createArrayOf($a, $b)")
        value.createArrayOf(a, b)
      }
    }

  val createBlob: F[Blob] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id createBlob()")
        value.createBlob()
      }
    }

  val createClob: F[Clob] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id createClob()")
        value.createClob()
      }
    }

  val createNClob: F[NClob] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id createNClob()")
        value.createNClob()
      }
    }

  val createSQLXML: F[SQLXML] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id createSQLXML()")
        value.createSQLXML()
      }
    }

  val createStatement: F[Statement] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id createStatement()")
        value.createStatement()
      }
    }

  def createStatement(a: Int, b: Int): F[Statement] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id createStatement($a, $b)")
        value.createStatement(a, b)
      }
    }

  def createStatement(a: Int, b: Int, c: Int): F[Statement] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id createStatement($a, $b, $c)")
        value.createStatement(a, b, c)
      }
    }

  def createStruct(a: String, b: Array[AnyRef]): F[Struct] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id createStruct($a, $b)")
        value.createStruct(a, b)
      }
    }

  val getAutoCommit: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getAutoCommit()")
        value.getAutoCommit()
      }
    }

  val getCatalog: F[String] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getCatalog()")
        value.getCatalog()
      }
    }

  val getClientInfo: F[Properties] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getClientInfo()")
        value.getClientInfo()
      }
    }

  def getClientInfo(a: String): F[String] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getClientInfo($a)")
        value.getClientInfo(a)
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

  val getMetaData: F[DatabaseMetaData] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getMetaData()")
        value.getMetaData()
      }
    }

  val getNetworkTimeout: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getNetworkTimeout()")
        value.getNetworkTimeout()
      }
    }

  val getSchema: F[String] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getSchema()")
        value.getSchema()
      }
    }

  val getTransactionIsolation: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getTransactionIsolation()")
        value.getTransactionIsolation()
      }
    }

  val getTypeMap: F[Map[String, Class[_]]] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getTypeMap()")
        value.getTypeMap()
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

  val isClosed: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id isClosed()")
        value.isClosed()
      }
    }

  val isReadOnly: F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id isReadOnly()")
        value.isReadOnly()
      }
    }

  def isValid(a: Int): F[Boolean] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id isValid($a)")
        value.isValid(a)
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

  def nativeSQL(a: String): F[String] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id nativeSQL($a)")
        value.nativeSQL(a)
      }
    }

  def prepareCall(a: String): F[CallableStatement] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id prepareCall($a)")
        value.prepareCall(a)
      }
    }

  def prepareCall(a: String, b: Int, c: Int): F[CallableStatement] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id prepareCall($a, $b, $c)")
        value.prepareCall(a, b, c)
      }
    }

  def prepareCall(a: String, b: Int, c: Int, d: Int): F[CallableStatement] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id prepareCall($a, $b, $c, $d)")
        value.prepareCall(a, b, c, d)
      }
    }

  def prepareStatement(a: String): F[PreparedStatement] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id prepareStatement($a)")
        value.prepareStatement(a)
      }
    }

  def prepareStatement(a: String, b: Array[Int]): F[PreparedStatement] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id prepareStatement($a, $b)")
        value.prepareStatement(a, b)
      }
    }

  def prepareStatement(a: String, b: Array[String]): F[PreparedStatement] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id prepareStatement($a, $b)")
        value.prepareStatement(a, b)
      }
    }

  def prepareStatement(a: String, b: Int): F[PreparedStatement] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id prepareStatement($a, $b)")
        value.prepareStatement(a, b)
      }
    }

  def prepareStatement(a: String, b: Int, c: Int): F[PreparedStatement] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id prepareStatement($a, $b, $c)")
        value.prepareStatement(a, b, c)
      }
    }

  def prepareStatement(a: String, b: Int, c: Int, d: Int): F[PreparedStatement] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id prepareStatement($a, $b, $c, $d)")
        value.prepareStatement(a, b, c, d)
      }
    }

  def releaseSavepoint(a: Savepoint): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id releaseSavepoint($a)")
        value.releaseSavepoint(a)
      }
    }

  val rollback: F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id rollback()")
        value.rollback()
      }
    }

  def rollback(a: Savepoint): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id rollback($a)")
        value.rollback(a)
      }
    }

  def setAutoCommit(a: Boolean): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setAutoCommit($a)")
        value.setAutoCommit(a)
      }
    }

  def setCatalog(a: String): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setCatalog($a)")
        value.setCatalog(a)
      }
    }

  def setClientInfo(a: Properties): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setClientInfo($a)")
        value.setClientInfo(a)
      }
    }

  def setClientInfo(a: String, b: String): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setClientInfo($a, $b)")
        value.setClientInfo(a, b)
      }
    }

  def setHoldability(a: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setHoldability($a)")
        value.setHoldability(a)
      }
    }

  def setNetworkTimeout(a: Executor, b: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setNetworkTimeout($a, $b)")
        value.setNetworkTimeout(a, b)
      }
    }

  def setReadOnly(a: Boolean): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setReadOnly($a)")
        value.setReadOnly(a)
      }
    }

  val setSavepoint: F[Savepoint] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setSavepoint()")
        value.setSavepoint()
      }
    }

  def setSavepoint(a: String): F[Savepoint] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setSavepoint($a)")
        value.setSavepoint(a)
      }
    }

  def setSchema(a: String): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setSchema($a)")
        value.setSchema(a)
      }
    }

  def setTransactionIsolation(a: Int): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setTransactionIsolation($a)")
        value.setTransactionIsolation(a)
      }
    }

  def setTypeMap(a: Map[String, Class[_]]): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setTypeMap($a)")
        value.setTypeMap(a)
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

}

