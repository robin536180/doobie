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
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLWarning
import java.sql.Statement

/**
 * Implementation of JdbcStatement that wraps a Statement and lifts its primitive operations into any F
 * given a Sync instance.
 */
@SuppressWarnings(Array("org.wartremover.warts.Overloading"))
class AsyncStatement[F[_]: Sync](value: Statement, rts: RTS[F], log: Logger) extends JdbcStatement[F] {

  val id: String =
    s"${System.identityHashCode(value).toHexString.padTo(8, ' ')} Statement".padTo(28, ' ')

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

  def executeQuery(a: String): F[ResultSet] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id executeQuery($a)")
        value.executeQuery(a)
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

  val getConnection: F[Connection] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getConnection()")
        value.getConnection()
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

  val getGeneratedKeys: F[ResultSet] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getGeneratedKeys()")
        value.getGeneratedKeys()
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

  val getQueryTimeout: F[Int] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getQueryTimeout()")
        value.getQueryTimeout()
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

  def setCursorName(a: String): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setCursorName($a)")
        value.setCursorName(a)
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

  def setLargeMaxRows(a: Long): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id setLargeMaxRows($a)")
        value.setLargeMaxRows(a)
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

  def unwrap[T](a: Class[T]): F[T] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id unwrap($a)")
        value.unwrap(a)
      }
    }

}

