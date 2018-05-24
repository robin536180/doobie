// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless.sync

import cats.effect.Sync
import cats.implicits._
import cats.syntax._
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

  def addBatch(a: String) =
    F.delay(Console.err.println(s"Statement.addBatch($a)")) *>
    F.delay(value.addBatch(a))

  def cancel =
    F.delay(Console.err.println("Statement.cancel()")) *>
    F.delay(value.cancel())

  def clearBatch =
    F.delay(Console.err.println("Statement.clearBatch()")) *>
    F.delay(value.clearBatch())

  def clearWarnings =
    F.delay(Console.err.println("Statement.clearWarnings()")) *>
    F.delay(value.clearWarnings())

  def close =
    F.delay(Console.err.println("Statement.close()")) *>
    F.delay(value.close())

  def closeOnCompletion =
    F.delay(Console.err.println("Statement.closeOnCompletion()")) *>
    F.delay(value.closeOnCompletion())

  def execute(a: String) =
    F.delay(Console.err.println(s"Statement.execute($a)")) *>
    F.delay(value.execute(a))

  def execute(a: String, b: Array[Int]) =
    F.delay(Console.err.println(s"Statement.execute($a, $b)")) *>
    F.delay(value.execute(a, b))

  def execute(a: String, b: Array[String]) =
    F.delay(Console.err.println(s"Statement.execute($a, $b)")) *>
    F.delay(value.execute(a, b))

  def execute(a: String, b: Int) =
    F.delay(Console.err.println(s"Statement.execute($a, $b)")) *>
    F.delay(value.execute(a, b))

  def executeBatch =
    F.delay(Console.err.println("Statement.executeBatch()")) *>
    F.delay(value.executeBatch())

  def executeLargeBatch =
    F.delay(Console.err.println("Statement.executeLargeBatch()")) *>
    F.delay(value.executeLargeBatch())

  def executeLargeUpdate(a: String) =
    F.delay(Console.err.println(s"Statement.executeLargeUpdate($a)")) *>
    F.delay(value.executeLargeUpdate(a))

  def executeLargeUpdate(a: String, b: Array[Int]) =
    F.delay(Console.err.println(s"Statement.executeLargeUpdate($a, $b)")) *>
    F.delay(value.executeLargeUpdate(a, b))

  def executeLargeUpdate(a: String, b: Array[String]) =
    F.delay(Console.err.println(s"Statement.executeLargeUpdate($a, $b)")) *>
    F.delay(value.executeLargeUpdate(a, b))

  def executeLargeUpdate(a: String, b: Int) =
    F.delay(Console.err.println(s"Statement.executeLargeUpdate($a, $b)")) *>
    F.delay(value.executeLargeUpdate(a, b))

  def executeQuery(a: String) =
    F.delay(Console.err.println(s"Statement.executeQuery($a)")) *>
    F.delay(value.executeQuery(a))

  def executeUpdate(a: String) =
    F.delay(Console.err.println(s"Statement.executeUpdate($a)")) *>
    F.delay(value.executeUpdate(a))

  def executeUpdate(a: String, b: Array[Int]) =
    F.delay(Console.err.println(s"Statement.executeUpdate($a, $b)")) *>
    F.delay(value.executeUpdate(a, b))

  def executeUpdate(a: String, b: Array[String]) =
    F.delay(Console.err.println(s"Statement.executeUpdate($a, $b)")) *>
    F.delay(value.executeUpdate(a, b))

  def executeUpdate(a: String, b: Int) =
    F.delay(Console.err.println(s"Statement.executeUpdate($a, $b)")) *>
    F.delay(value.executeUpdate(a, b))

  def getConnection =
    F.delay(Console.err.println("Statement.getConnection()")) *>
    F.delay(value.getConnection())

  def getFetchDirection =
    F.delay(Console.err.println("Statement.getFetchDirection()")) *>
    F.delay(value.getFetchDirection())

  def getFetchSize =
    F.delay(Console.err.println("Statement.getFetchSize()")) *>
    F.delay(value.getFetchSize())

  def getGeneratedKeys =
    F.delay(Console.err.println("Statement.getGeneratedKeys()")) *>
    F.delay(value.getGeneratedKeys())

  def getLargeMaxRows =
    F.delay(Console.err.println("Statement.getLargeMaxRows()")) *>
    F.delay(value.getLargeMaxRows())

  def getLargeUpdateCount =
    F.delay(Console.err.println("Statement.getLargeUpdateCount()")) *>
    F.delay(value.getLargeUpdateCount())

  def getMaxFieldSize =
    F.delay(Console.err.println("Statement.getMaxFieldSize()")) *>
    F.delay(value.getMaxFieldSize())

  def getMaxRows =
    F.delay(Console.err.println("Statement.getMaxRows()")) *>
    F.delay(value.getMaxRows())

  def getMoreResults =
    F.delay(Console.err.println("Statement.getMoreResults()")) *>
    F.delay(value.getMoreResults())

  def getMoreResults(a: Int) =
    F.delay(Console.err.println(s"Statement.getMoreResults($a)")) *>
    F.delay(value.getMoreResults(a))

  def getQueryTimeout =
    F.delay(Console.err.println("Statement.getQueryTimeout()")) *>
    F.delay(value.getQueryTimeout())

  def getResultSet =
    F.delay(Console.err.println("Statement.getResultSet()")) *>
    F.delay(value.getResultSet())

  def getResultSetConcurrency =
    F.delay(Console.err.println("Statement.getResultSetConcurrency()")) *>
    F.delay(value.getResultSetConcurrency())

  def getResultSetHoldability =
    F.delay(Console.err.println("Statement.getResultSetHoldability()")) *>
    F.delay(value.getResultSetHoldability())

  def getResultSetType =
    F.delay(Console.err.println("Statement.getResultSetType()")) *>
    F.delay(value.getResultSetType())

  def getUpdateCount =
    F.delay(Console.err.println("Statement.getUpdateCount()")) *>
    F.delay(value.getUpdateCount())

  def getWarnings =
    F.delay(Console.err.println("Statement.getWarnings()")) *>
    F.delay(value.getWarnings())

  def isCloseOnCompletion =
    F.delay(Console.err.println("Statement.isCloseOnCompletion()")) *>
    F.delay(value.isCloseOnCompletion())

  def isClosed =
    F.delay(Console.err.println("Statement.isClosed()")) *>
    F.delay(value.isClosed())

  def isPoolable =
    F.delay(Console.err.println("Statement.isPoolable()")) *>
    F.delay(value.isPoolable())

  def isWrapperFor(a: Class[_]) =
    F.delay(Console.err.println(s"Statement.isWrapperFor($a)")) *>
    F.delay(value.isWrapperFor(a))

  def setCursorName(a: String) =
    F.delay(Console.err.println(s"Statement.setCursorName($a)")) *>
    F.delay(value.setCursorName(a))

  def setEscapeProcessing(a: Boolean) =
    F.delay(Console.err.println(s"Statement.setEscapeProcessing($a)")) *>
    F.delay(value.setEscapeProcessing(a))

  def setFetchDirection(a: Int) =
    F.delay(Console.err.println(s"Statement.setFetchDirection($a)")) *>
    F.delay(value.setFetchDirection(a))

  def setFetchSize(a: Int) =
    F.delay(Console.err.println(s"Statement.setFetchSize($a)")) *>
    F.delay(value.setFetchSize(a))

  def setLargeMaxRows(a: Long) =
    F.delay(Console.err.println(s"Statement.setLargeMaxRows($a)")) *>
    F.delay(value.setLargeMaxRows(a))

  def setMaxFieldSize(a: Int) =
    F.delay(Console.err.println(s"Statement.setMaxFieldSize($a)")) *>
    F.delay(value.setMaxFieldSize(a))

  def setMaxRows(a: Int) =
    F.delay(Console.err.println(s"Statement.setMaxRows($a)")) *>
    F.delay(value.setMaxRows(a))

  def setPoolable(a: Boolean) =
    F.delay(Console.err.println(s"Statement.setPoolable($a)")) *>
    F.delay(value.setPoolable(a))

  def setQueryTimeout(a: Int) =
    F.delay(Console.err.println(s"Statement.setQueryTimeout($a)")) *>
    F.delay(value.setQueryTimeout(a))

  def unwrap[T](a: Class[T]) =
    F.delay(Console.err.println(s"Statement.unwrap($a)")) *>
    F.delay(value.unwrap(a))

}

