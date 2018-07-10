// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless

import cats.effect.Async
import doobie.tagless.async._
import org.slf4j.{ Logger, LoggerFactory }

final case class Interpreter[F[_]](jdbc: AsyncInterpreter[F]) {

  def rts: RTS[F] = jdbc.rts
  def log: Logger = jdbc.log

  def forNClob(a: java.sql.NClob): NClob[F] = NClob(jdbc.forNClob(a), this)
  def forBlob(a: java.sql.Blob): Blob[F] = Blob(jdbc.forBlob(a), this)
  def forClob(a: java.sql.Clob): Clob[F] = Clob(jdbc.forClob(a), this)
  def forDatabaseMetaData(a: java.sql.DatabaseMetaData): DatabaseMetaData[F] = DatabaseMetaData(jdbc.forDatabaseMetaData(a), this)
  def forDriver(a: java.sql.Driver): Driver[F] = Driver(jdbc.forDriver(a), this)
  def forRef(a: java.sql.Ref): Ref[F] = Ref(jdbc.forRef(a), this)
  def forSQLData(a: java.sql.SQLData): SQLData[F] = SQLData(jdbc.forSQLData(a), this)
  def forSQLInput(a: java.sql.SQLInput): SQLInput[F] = SQLInput(jdbc.forSQLInput(a), this)
  def forSQLOutput(a: java.sql.SQLOutput): SQLOutput[F] = SQLOutput(jdbc.forSQLOutput(a), this)
  def forConnection(a: java.sql.Connection): Connection[F] = Connection(jdbc.forConnection(a), this)
  def forStatement(a: java.sql.Statement): Statement[F] = Statement(jdbc.forStatement(a), this)
  def forPreparedStatement(a: java.sql.PreparedStatement): PreparedStatement[F] = PreparedStatement(jdbc.forPreparedStatement(a), this)
  def forCallableStatement(a: java.sql.CallableStatement): CallableStatement[F] = CallableStatement(jdbc.forCallableStatement(a), this)
  def forResultSet(a: java.sql.ResultSet): ResultSet[F] = ResultSet(jdbc.forResultSet(a), this)
}

object Interpreter {

  def default[M[_]: Async]: Interpreter[M] = {
    val rts  = RTS.global[M]
    val log  = LoggerFactory.getLogger("doobie")
    val jdbc = new AsyncInterpreter[M](rts, log)
    Interpreter(jdbc)
  }

}

// Unimplemented
final case class NClob[F[_]](jdbc: AsyncNClob[F], interp: Interpreter[F])
final case class Blob[F[_]](jdbc: AsyncBlob[F], interp: Interpreter[F])
final case class Clob[F[_]](jdbc: AsyncClob[F], interp: Interpreter[F])
final case class DatabaseMetaData[F[_]](jdbc: AsyncDatabaseMetaData[F], interp: Interpreter[F])
final case class Driver[F[_]](jdbc: AsyncDriver[F], interp: Interpreter[F])
final case class Ref[F[_]](jdbc: AsyncRef[F], interp: Interpreter[F])
final case class SQLData[F[_]](jdbc: AsyncSQLData[F], interp: Interpreter[F])
final case class SQLInput[F[_]](jdbc: AsyncSQLInput[F], interp: Interpreter[F])
final case class SQLOutput[F[_]](jdbc: AsyncSQLOutput[F], interp: Interpreter[F])
final case class Statement[F[_]](jdbc: AsyncStatement[F], interp: Interpreter[F])
final case class CallableStatement[F[_]](jdbc: AsyncCallableStatement[F], interp: Interpreter[F])
