// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless.jdbc

import java.lang.Class
import java.lang.String
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLWarning
import java.sql.Statement

/** Algebra of operations for `java.sql.Statement`. */
@SuppressWarnings(Array("org.wartremover.warts.Overloading"))
trait JdbcStatement[F[_]] {
  def addBatch(a: String): F[Unit]
  def cancel: F[Unit]
  def clearBatch: F[Unit]
  def clearWarnings: F[Unit]
  def close: F[Unit]
  def closeOnCompletion: F[Unit]
  def execute(a: String): F[Boolean]
  def execute(a: String, b: Array[Int]): F[Boolean]
  def execute(a: String, b: Array[String]): F[Boolean]
  def execute(a: String, b: Int): F[Boolean]
  def executeBatch: F[Array[Int]]
  def executeLargeBatch: F[Array[Long]]
  def executeLargeUpdate(a: String): F[Long]
  def executeLargeUpdate(a: String, b: Array[Int]): F[Long]
  def executeLargeUpdate(a: String, b: Array[String]): F[Long]
  def executeLargeUpdate(a: String, b: Int): F[Long]
  def executeQuery(a: String): F[ResultSet]
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
  def getMoreResults: F[Boolean]
  def getMoreResults(a: Int): F[Boolean]
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
  def setCursorName(a: String): F[Unit]
  def setEscapeProcessing(a: Boolean): F[Unit]
  def setFetchDirection(a: Int): F[Unit]
  def setFetchSize(a: Int): F[Unit]
  def setLargeMaxRows(a: Long): F[Unit]
  def setMaxFieldSize(a: Int): F[Unit]
  def setMaxRows(a: Int): F[Unit]
  def setPoolable(a: Boolean): F[Unit]
  def setQueryTimeout(a: Int): F[Unit]
  def unwrap[T](a: Class[T]): F[T]
}

