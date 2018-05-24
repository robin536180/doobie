// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless.jdbc

import java.sql.NClob
import java.sql.Blob
import java.sql.Clob
import java.sql.DatabaseMetaData
import java.sql.Driver
import java.sql.Ref
import java.sql.SQLData
import java.sql.SQLInput
import java.sql.SQLOutput
import java.sql.Connection
import java.sql.Statement
import java.sql.PreparedStatement
import java.sql.CallableStatement
import java.sql.ResultSet

trait JdbcInterpreter[F[_]] {
  def forNClob(a: NClob): JdbcNClob[F]
  def forBlob(a: Blob): JdbcBlob[F]
  def forClob(a: Clob): JdbcClob[F]
  def forDatabaseMetaData(a: DatabaseMetaData): JdbcDatabaseMetaData[F]
  def forDriver(a: Driver): JdbcDriver[F]
  def forRef(a: Ref): JdbcRef[F]
  def forSQLData(a: SQLData): JdbcSQLData[F]
  def forSQLInput(a: SQLInput): JdbcSQLInput[F]
  def forSQLOutput(a: SQLOutput): JdbcSQLOutput[F]
  def forConnection(a: Connection): JdbcConnection[F]
  def forStatement(a: Statement): JdbcStatement[F]
  def forPreparedStatement(a: PreparedStatement): JdbcPreparedStatement[F]
  def forCallableStatement(a: CallableStatement): JdbcCallableStatement[F]
  def forResultSet(a: ResultSet): JdbcResultSet[F]
}

