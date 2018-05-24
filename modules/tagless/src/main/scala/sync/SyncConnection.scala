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
class SyncConnection[F[_]](value: Connection)(implicit F: Sync[F]) extends JdbcConnection[F] {

  def abort(a: Executor) =
    F.delay(Console.err.println(s"Connection.abort($a)")) *>
    F.delay(value.abort(a))

  def clearWarnings =
    F.delay(Console.err.println("Connection.clearWarnings()")) *>
    F.delay(value.clearWarnings())

  def close =
    F.delay(Console.err.println("Connection.close()")) *>
    F.delay(value.close())

  def commit =
    F.delay(Console.err.println("Connection.commit()")) *>
    F.delay(value.commit())

  def createArrayOf(a: String, b: Array[AnyRef]) =
    F.delay(Console.err.println(s"Connection.createArrayOf($a, $b)")) *>
    F.delay(value.createArrayOf(a, b))

  def createBlob =
    F.delay(Console.err.println("Connection.createBlob()")) *>
    F.delay(value.createBlob())

  def createClob =
    F.delay(Console.err.println("Connection.createClob()")) *>
    F.delay(value.createClob())

  def createNClob =
    F.delay(Console.err.println("Connection.createNClob()")) *>
    F.delay(value.createNClob())

  def createSQLXML =
    F.delay(Console.err.println("Connection.createSQLXML()")) *>
    F.delay(value.createSQLXML())

  def createStatement =
    F.delay(Console.err.println("Connection.createStatement()")) *>
    F.delay(value.createStatement())

  def createStatement(a: Int, b: Int) =
    F.delay(Console.err.println(s"Connection.createStatement($a, $b)")) *>
    F.delay(value.createStatement(a, b))

  def createStatement(a: Int, b: Int, c: Int) =
    F.delay(Console.err.println(s"Connection.createStatement($a, $b, $c)")) *>
    F.delay(value.createStatement(a, b, c))

  def createStruct(a: String, b: Array[AnyRef]) =
    F.delay(Console.err.println(s"Connection.createStruct($a, $b)")) *>
    F.delay(value.createStruct(a, b))

  def getAutoCommit =
    F.delay(Console.err.println("Connection.getAutoCommit()")) *>
    F.delay(value.getAutoCommit())

  def getCatalog =
    F.delay(Console.err.println("Connection.getCatalog()")) *>
    F.delay(value.getCatalog())

  def getClientInfo =
    F.delay(Console.err.println("Connection.getClientInfo()")) *>
    F.delay(value.getClientInfo())

  def getClientInfo(a: String) =
    F.delay(Console.err.println(s"Connection.getClientInfo($a)")) *>
    F.delay(value.getClientInfo(a))

  def getHoldability =
    F.delay(Console.err.println("Connection.getHoldability()")) *>
    F.delay(value.getHoldability())

  def getMetaData =
    F.delay(Console.err.println("Connection.getMetaData()")) *>
    F.delay(value.getMetaData())

  def getNetworkTimeout =
    F.delay(Console.err.println("Connection.getNetworkTimeout()")) *>
    F.delay(value.getNetworkTimeout())

  def getSchema =
    F.delay(Console.err.println("Connection.getSchema()")) *>
    F.delay(value.getSchema())

  def getTransactionIsolation =
    F.delay(Console.err.println("Connection.getTransactionIsolation()")) *>
    F.delay(value.getTransactionIsolation())

  def getTypeMap =
    F.delay(Console.err.println("Connection.getTypeMap()")) *>
    F.delay(value.getTypeMap())

  def getWarnings =
    F.delay(Console.err.println("Connection.getWarnings()")) *>
    F.delay(value.getWarnings())

  def isClosed =
    F.delay(Console.err.println("Connection.isClosed()")) *>
    F.delay(value.isClosed())

  def isReadOnly =
    F.delay(Console.err.println("Connection.isReadOnly()")) *>
    F.delay(value.isReadOnly())

  def isValid(a: Int) =
    F.delay(Console.err.println(s"Connection.isValid($a)")) *>
    F.delay(value.isValid(a))

  def isWrapperFor(a: Class[_]) =
    F.delay(Console.err.println(s"Connection.isWrapperFor($a)")) *>
    F.delay(value.isWrapperFor(a))

  def nativeSQL(a: String) =
    F.delay(Console.err.println(s"Connection.nativeSQL($a)")) *>
    F.delay(value.nativeSQL(a))

  def prepareCall(a: String) =
    F.delay(Console.err.println(s"Connection.prepareCall($a)")) *>
    F.delay(value.prepareCall(a))

  def prepareCall(a: String, b: Int, c: Int) =
    F.delay(Console.err.println(s"Connection.prepareCall($a, $b, $c)")) *>
    F.delay(value.prepareCall(a, b, c))

  def prepareCall(a: String, b: Int, c: Int, d: Int) =
    F.delay(Console.err.println(s"Connection.prepareCall($a, $b, $c, $d)")) *>
    F.delay(value.prepareCall(a, b, c, d))

  def prepareStatement(a: String) =
    F.delay(Console.err.println(s"Connection.prepareStatement($a)")) *>
    F.delay(value.prepareStatement(a))

  def prepareStatement(a: String, b: Array[Int]) =
    F.delay(Console.err.println(s"Connection.prepareStatement($a, $b)")) *>
    F.delay(value.prepareStatement(a, b))

  def prepareStatement(a: String, b: Array[String]) =
    F.delay(Console.err.println(s"Connection.prepareStatement($a, $b)")) *>
    F.delay(value.prepareStatement(a, b))

  def prepareStatement(a: String, b: Int) =
    F.delay(Console.err.println(s"Connection.prepareStatement($a, $b)")) *>
    F.delay(value.prepareStatement(a, b))

  def prepareStatement(a: String, b: Int, c: Int) =
    F.delay(Console.err.println(s"Connection.prepareStatement($a, $b, $c)")) *>
    F.delay(value.prepareStatement(a, b, c))

  def prepareStatement(a: String, b: Int, c: Int, d: Int) =
    F.delay(Console.err.println(s"Connection.prepareStatement($a, $b, $c, $d)")) *>
    F.delay(value.prepareStatement(a, b, c, d))

  def releaseSavepoint(a: Savepoint) =
    F.delay(Console.err.println(s"Connection.releaseSavepoint($a)")) *>
    F.delay(value.releaseSavepoint(a))

  def rollback =
    F.delay(Console.err.println("Connection.rollback()")) *>
    F.delay(value.rollback())

  def rollback(a: Savepoint) =
    F.delay(Console.err.println(s"Connection.rollback($a)")) *>
    F.delay(value.rollback(a))

  def setAutoCommit(a: Boolean) =
    F.delay(Console.err.println(s"Connection.setAutoCommit($a)")) *>
    F.delay(value.setAutoCommit(a))

  def setCatalog(a: String) =
    F.delay(Console.err.println(s"Connection.setCatalog($a)")) *>
    F.delay(value.setCatalog(a))

  def setClientInfo(a: Properties) =
    F.delay(Console.err.println(s"Connection.setClientInfo($a)")) *>
    F.delay(value.setClientInfo(a))

  def setClientInfo(a: String, b: String) =
    F.delay(Console.err.println(s"Connection.setClientInfo($a, $b)")) *>
    F.delay(value.setClientInfo(a, b))

  def setHoldability(a: Int) =
    F.delay(Console.err.println(s"Connection.setHoldability($a)")) *>
    F.delay(value.setHoldability(a))

  def setNetworkTimeout(a: Executor, b: Int) =
    F.delay(Console.err.println(s"Connection.setNetworkTimeout($a, $b)")) *>
    F.delay(value.setNetworkTimeout(a, b))

  def setReadOnly(a: Boolean) =
    F.delay(Console.err.println(s"Connection.setReadOnly($a)")) *>
    F.delay(value.setReadOnly(a))

  def setSavepoint =
    F.delay(Console.err.println("Connection.setSavepoint()")) *>
    F.delay(value.setSavepoint())

  def setSavepoint(a: String) =
    F.delay(Console.err.println(s"Connection.setSavepoint($a)")) *>
    F.delay(value.setSavepoint(a))

  def setSchema(a: String) =
    F.delay(Console.err.println(s"Connection.setSchema($a)")) *>
    F.delay(value.setSchema(a))

  def setTransactionIsolation(a: Int) =
    F.delay(Console.err.println(s"Connection.setTransactionIsolation($a)")) *>
    F.delay(value.setTransactionIsolation(a))

  def setTypeMap(a: Map[String, Class[_]]) =
    F.delay(Console.err.println(s"Connection.setTypeMap($a)")) *>
    F.delay(value.setTypeMap(a))

  def unwrap[T](a: Class[T]) =
    F.delay(Console.err.println(s"Connection.unwrap($a)")) *>
    F.delay(value.unwrap(a))

}

