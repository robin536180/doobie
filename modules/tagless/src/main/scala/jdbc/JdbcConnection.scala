// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless.jdbc

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

/** Algebra of operations for `java.sql.Connection`. */
@SuppressWarnings(Array("org.wartremover.warts.Overloading"))
trait JdbcConnection[F[_]] {
  def abort(a: Executor): F[Unit]
  def clearWarnings: F[Unit]
  def close: F[Unit]
  def commit: F[Unit]
  def createArrayOf(a: String, b: Array[AnyRef]): F[SqlArray]
  def createBlob: F[Blob]
  def createClob: F[Clob]
  def createNClob: F[NClob]
  def createSQLXML: F[SQLXML]
  def createStatement: F[Statement]
  def createStatement(a: Int, b: Int): F[Statement]
  def createStatement(a: Int, b: Int, c: Int): F[Statement]
  def createStruct(a: String, b: Array[AnyRef]): F[Struct]
  def getAutoCommit: F[Boolean]
  def getCatalog: F[String]
  def getClientInfo: F[Properties]
  def getClientInfo(a: String): F[String]
  def getHoldability: F[Int]
  def getMetaData: F[DatabaseMetaData]
  def getNetworkTimeout: F[Int]
  def getSchema: F[String]
  def getTransactionIsolation: F[Int]
  def getTypeMap: F[Map[String, Class[_]]]
  def getWarnings: F[SQLWarning]
  def isClosed: F[Boolean]
  def isReadOnly: F[Boolean]
  def isValid(a: Int): F[Boolean]
  def isWrapperFor(a: Class[_]): F[Boolean]
  def nativeSQL(a: String): F[String]
  def prepareCall(a: String): F[CallableStatement]
  def prepareCall(a: String, b: Int, c: Int): F[CallableStatement]
  def prepareCall(a: String, b: Int, c: Int, d: Int): F[CallableStatement]
  def prepareStatement(a: String): F[PreparedStatement]
  def prepareStatement(a: String, b: Array[Int]): F[PreparedStatement]
  def prepareStatement(a: String, b: Array[String]): F[PreparedStatement]
  def prepareStatement(a: String, b: Int): F[PreparedStatement]
  def prepareStatement(a: String, b: Int, c: Int): F[PreparedStatement]
  def prepareStatement(a: String, b: Int, c: Int, d: Int): F[PreparedStatement]
  def releaseSavepoint(a: Savepoint): F[Unit]
  def rollback: F[Unit]
  def rollback(a: Savepoint): F[Unit]
  def setAutoCommit(a: Boolean): F[Unit]
  def setCatalog(a: String): F[Unit]
  def setClientInfo(a: Properties): F[Unit]
  def setClientInfo(a: String, b: String): F[Unit]
  def setHoldability(a: Int): F[Unit]
  def setNetworkTimeout(a: Executor, b: Int): F[Unit]
  def setReadOnly(a: Boolean): F[Unit]
  def setSavepoint: F[Savepoint]
  def setSavepoint(a: String): F[Savepoint]
  def setSchema(a: String): F[Unit]
  def setTransactionIsolation(a: Int): F[Unit]
  def setTypeMap(a: Map[String, Class[_]]): F[Unit]
  def unwrap[T](a: Class[T]): F[T]
}

