// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless.sync

import cats.effect.Sync
import cats.implicits._
import doobie.tagless.jdbc._
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
class SyncStatement[F[_]](value: Statement)(implicit F: Sync[F]) extends JdbcStatement[F] {

  def addBatch(a: String): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.addBatch($a)")) *>
    F.delay(value.addBatch(a))

  val cancel: F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.cancel()")) *>
    F.delay(value.cancel())

  val clearBatch: F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.clearBatch()")) *>
    F.delay(value.clearBatch())

  val clearWarnings: F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.clearWarnings()")) *>
    F.delay(value.clearWarnings())

  val close: F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.close()")) *>
    F.delay(value.close())

  val closeOnCompletion: F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.closeOnCompletion()")) *>
    F.delay(value.closeOnCompletion())

  def execute(a: String): F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.execute($a)")) *>
    F.delay(value.execute(a))

  def execute(a: String, b: Array[Int]): F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.execute($a, $b)")) *>
    F.delay(value.execute(a, b))

  def execute(a: String, b: Array[String]): F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.execute($a, $b)")) *>
    F.delay(value.execute(a, b))

  def execute(a: String, b: Int): F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.execute($a, $b)")) *>
    F.delay(value.execute(a, b))

  val executeBatch: F[Array[Int]] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.executeBatch()")) *>
    F.delay(value.executeBatch())

  val executeLargeBatch: F[Array[Long]] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.executeLargeBatch()")) *>
    F.delay(value.executeLargeBatch())

  def executeLargeUpdate(a: String): F[Long] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.executeLargeUpdate($a)")) *>
    F.delay(value.executeLargeUpdate(a))

  def executeLargeUpdate(a: String, b: Array[Int]): F[Long] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.executeLargeUpdate($a, $b)")) *>
    F.delay(value.executeLargeUpdate(a, b))

  def executeLargeUpdate(a: String, b: Array[String]): F[Long] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.executeLargeUpdate($a, $b)")) *>
    F.delay(value.executeLargeUpdate(a, b))

  def executeLargeUpdate(a: String, b: Int): F[Long] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.executeLargeUpdate($a, $b)")) *>
    F.delay(value.executeLargeUpdate(a, b))

  def executeQuery(a: String): F[ResultSet] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.executeQuery($a)")) *>
    F.delay(value.executeQuery(a))

  def executeUpdate(a: String): F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.executeUpdate($a)")) *>
    F.delay(value.executeUpdate(a))

  def executeUpdate(a: String, b: Array[Int]): F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.executeUpdate($a, $b)")) *>
    F.delay(value.executeUpdate(a, b))

  def executeUpdate(a: String, b: Array[String]): F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.executeUpdate($a, $b)")) *>
    F.delay(value.executeUpdate(a, b))

  def executeUpdate(a: String, b: Int): F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.executeUpdate($a, $b)")) *>
    F.delay(value.executeUpdate(a, b))

  val getConnection: F[Connection] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.getConnection()")) *>
    F.delay(value.getConnection())

  val getFetchDirection: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.getFetchDirection()")) *>
    F.delay(value.getFetchDirection())

  val getFetchSize: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.getFetchSize()")) *>
    F.delay(value.getFetchSize())

  val getGeneratedKeys: F[ResultSet] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.getGeneratedKeys()")) *>
    F.delay(value.getGeneratedKeys())

  val getLargeMaxRows: F[Long] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.getLargeMaxRows()")) *>
    F.delay(value.getLargeMaxRows())

  val getLargeUpdateCount: F[Long] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.getLargeUpdateCount()")) *>
    F.delay(value.getLargeUpdateCount())

  val getMaxFieldSize: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.getMaxFieldSize()")) *>
    F.delay(value.getMaxFieldSize())

  val getMaxRows: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.getMaxRows()")) *>
    F.delay(value.getMaxRows())

  val getMoreResults: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.getMoreResults()")) *>
    F.delay(value.getMoreResults())

  def getMoreResults(a: Int): F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.getMoreResults($a)")) *>
    F.delay(value.getMoreResults(a))

  val getQueryTimeout: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.getQueryTimeout()")) *>
    F.delay(value.getQueryTimeout())

  val getResultSet: F[ResultSet] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.getResultSet()")) *>
    F.delay(value.getResultSet())

  val getResultSetConcurrency: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.getResultSetConcurrency()")) *>
    F.delay(value.getResultSetConcurrency())

  val getResultSetHoldability: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.getResultSetHoldability()")) *>
    F.delay(value.getResultSetHoldability())

  val getResultSetType: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.getResultSetType()")) *>
    F.delay(value.getResultSetType())

  val getUpdateCount: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.getUpdateCount()")) *>
    F.delay(value.getUpdateCount())

  val getWarnings: F[SQLWarning] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.getWarnings()")) *>
    F.delay(value.getWarnings())

  val isCloseOnCompletion: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.isCloseOnCompletion()")) *>
    F.delay(value.isCloseOnCompletion())

  val isClosed: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.isClosed()")) *>
    F.delay(value.isClosed())

  val isPoolable: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.isPoolable()")) *>
    F.delay(value.isPoolable())

  def isWrapperFor(a: Class[_]): F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.isWrapperFor($a)")) *>
    F.delay(value.isWrapperFor(a))

  def setCursorName(a: String): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.setCursorName($a)")) *>
    F.delay(value.setCursorName(a))

  def setEscapeProcessing(a: Boolean): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.setEscapeProcessing($a)")) *>
    F.delay(value.setEscapeProcessing(a))

  def setFetchDirection(a: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.setFetchDirection($a)")) *>
    F.delay(value.setFetchDirection(a))

  def setFetchSize(a: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.setFetchSize($a)")) *>
    F.delay(value.setFetchSize(a))

  def setLargeMaxRows(a: Long): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.setLargeMaxRows($a)")) *>
    F.delay(value.setLargeMaxRows(a))

  def setMaxFieldSize(a: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.setMaxFieldSize($a)")) *>
    F.delay(value.setMaxFieldSize(a))

  def setMaxRows(a: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.setMaxRows($a)")) *>
    F.delay(value.setMaxRows(a))

  def setPoolable(a: Boolean): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.setPoolable($a)")) *>
    F.delay(value.setPoolable(a))

  def setQueryTimeout(a: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.setQueryTimeout($a)")) *>
    F.delay(value.setQueryTimeout(a))

  def unwrap[T](a: Class[T]): F[T] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Statement.unwrap($a)")) *>
    F.delay(value.unwrap(a))

}

