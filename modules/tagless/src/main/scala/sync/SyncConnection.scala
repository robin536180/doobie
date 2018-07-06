// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless.sync

import cats.effect.Sync
import cats.implicits._
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

  def abort(a: Executor): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.abort($a)")) *>
    F.delay(value.abort(a))

  val clearWarnings: F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.clearWarnings()")) *>
    F.delay(value.clearWarnings())

  val close: F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.close()")) *>
    F.delay(value.close())

  val commit: F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.commit()")) *>
    F.delay(value.commit())

  def createArrayOf(a: String, b: Array[AnyRef]): F[SqlArray] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.createArrayOf($a, $b)")) *>
    F.delay(value.createArrayOf(a, b))

  val createBlob: F[Blob] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.createBlob()")) *>
    F.delay(value.createBlob())

  val createClob: F[Clob] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.createClob()")) *>
    F.delay(value.createClob())

  val createNClob: F[NClob] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.createNClob()")) *>
    F.delay(value.createNClob())

  val createSQLXML: F[SQLXML] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.createSQLXML()")) *>
    F.delay(value.createSQLXML())

  val createStatement: F[Statement] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.createStatement()")) *>
    F.delay(value.createStatement())

  def createStatement(a: Int, b: Int): F[Statement] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.createStatement($a, $b)")) *>
    F.delay(value.createStatement(a, b))

  def createStatement(a: Int, b: Int, c: Int): F[Statement] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.createStatement($a, $b, $c)")) *>
    F.delay(value.createStatement(a, b, c))

  def createStruct(a: String, b: Array[AnyRef]): F[Struct] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.createStruct($a, $b)")) *>
    F.delay(value.createStruct(a, b))

  val getAutoCommit: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.getAutoCommit()")) *>
    F.delay(value.getAutoCommit())

  val getCatalog: F[String] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.getCatalog()")) *>
    F.delay(value.getCatalog())

  val getClientInfo: F[Properties] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.getClientInfo()")) *>
    F.delay(value.getClientInfo())

  def getClientInfo(a: String): F[String] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.getClientInfo($a)")) *>
    F.delay(value.getClientInfo(a))

  val getHoldability: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.getHoldability()")) *>
    F.delay(value.getHoldability())

  val getMetaData: F[DatabaseMetaData] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.getMetaData()")) *>
    F.delay(value.getMetaData())

  val getNetworkTimeout: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.getNetworkTimeout()")) *>
    F.delay(value.getNetworkTimeout())

  val getSchema: F[String] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.getSchema()")) *>
    F.delay(value.getSchema())

  val getTransactionIsolation: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.getTransactionIsolation()")) *>
    F.delay(value.getTransactionIsolation())

  val getTypeMap: F[Map[String, Class[_]]] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.getTypeMap()")) *>
    F.delay(value.getTypeMap())

  val getWarnings: F[SQLWarning] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.getWarnings()")) *>
    F.delay(value.getWarnings())

  val isClosed: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.isClosed()")) *>
    F.delay(value.isClosed())

  val isReadOnly: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.isReadOnly()")) *>
    F.delay(value.isReadOnly())

  def isValid(a: Int): F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.isValid($a)")) *>
    F.delay(value.isValid(a))

  def isWrapperFor(a: Class[_]): F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.isWrapperFor($a)")) *>
    F.delay(value.isWrapperFor(a))

  def nativeSQL(a: String): F[String] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.nativeSQL($a)")) *>
    F.delay(value.nativeSQL(a))

  def prepareCall(a: String): F[CallableStatement] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.prepareCall($a)")) *>
    F.delay(value.prepareCall(a))

  def prepareCall(a: String, b: Int, c: Int): F[CallableStatement] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.prepareCall($a, $b, $c)")) *>
    F.delay(value.prepareCall(a, b, c))

  def prepareCall(a: String, b: Int, c: Int, d: Int): F[CallableStatement] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.prepareCall($a, $b, $c, $d)")) *>
    F.delay(value.prepareCall(a, b, c, d))

  def prepareStatement(a: String): F[PreparedStatement] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.prepareStatement($a)")) *>
    F.delay(value.prepareStatement(a))

  def prepareStatement(a: String, b: Array[Int]): F[PreparedStatement] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.prepareStatement($a, $b)")) *>
    F.delay(value.prepareStatement(a, b))

  def prepareStatement(a: String, b: Array[String]): F[PreparedStatement] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.prepareStatement($a, $b)")) *>
    F.delay(value.prepareStatement(a, b))

  def prepareStatement(a: String, b: Int): F[PreparedStatement] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.prepareStatement($a, $b)")) *>
    F.delay(value.prepareStatement(a, b))

  def prepareStatement(a: String, b: Int, c: Int): F[PreparedStatement] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.prepareStatement($a, $b, $c)")) *>
    F.delay(value.prepareStatement(a, b, c))

  def prepareStatement(a: String, b: Int, c: Int, d: Int): F[PreparedStatement] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.prepareStatement($a, $b, $c, $d)")) *>
    F.delay(value.prepareStatement(a, b, c, d))

  def releaseSavepoint(a: Savepoint): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.releaseSavepoint($a)")) *>
    F.delay(value.releaseSavepoint(a))

  val rollback: F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.rollback()")) *>
    F.delay(value.rollback())

  def rollback(a: Savepoint): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.rollback($a)")) *>
    F.delay(value.rollback(a))

  def setAutoCommit(a: Boolean): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.setAutoCommit($a)")) *>
    F.delay(value.setAutoCommit(a))

  def setCatalog(a: String): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.setCatalog($a)")) *>
    F.delay(value.setCatalog(a))

  def setClientInfo(a: Properties): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.setClientInfo($a)")) *>
    F.delay(value.setClientInfo(a))

  def setClientInfo(a: String, b: String): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.setClientInfo($a, $b)")) *>
    F.delay(value.setClientInfo(a, b))

  def setHoldability(a: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.setHoldability($a)")) *>
    F.delay(value.setHoldability(a))

  def setNetworkTimeout(a: Executor, b: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.setNetworkTimeout($a, $b)")) *>
    F.delay(value.setNetworkTimeout(a, b))

  def setReadOnly(a: Boolean): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.setReadOnly($a)")) *>
    F.delay(value.setReadOnly(a))

  val setSavepoint: F[Savepoint] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.setSavepoint()")) *>
    F.delay(value.setSavepoint())

  def setSavepoint(a: String): F[Savepoint] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.setSavepoint($a)")) *>
    F.delay(value.setSavepoint(a))

  def setSchema(a: String): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.setSchema($a)")) *>
    F.delay(value.setSchema(a))

  def setTransactionIsolation(a: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.setTransactionIsolation($a)")) *>
    F.delay(value.setTransactionIsolation(a))

  def setTypeMap(a: Map[String, Class[_]]): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.setTypeMap($a)")) *>
    F.delay(value.setTypeMap(a))

  def unwrap[T](a: Class[T]): F[T] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Connection.unwrap($a)")) *>
    F.delay(value.unwrap(a))

}

