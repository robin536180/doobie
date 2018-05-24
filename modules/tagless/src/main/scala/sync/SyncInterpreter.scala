// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless.sync

import cats.effect.Sync
import doobie.tagless.jdbc._
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

object SyncInterpreter {
  def apply[F[_]: Sync]: JdbcInterpreter[F] =
    new JdbcInterpreter[F] {
      def forNClob(a: NClob) = new SyncNClob[F](a)
      def forBlob(a: Blob) = new SyncBlob[F](a)
      def forClob(a: Clob) = new SyncClob[F](a)
      def forDatabaseMetaData(a: DatabaseMetaData) = new SyncDatabaseMetaData[F](a)
      def forDriver(a: Driver) = new SyncDriver[F](a)
      def forRef(a: Ref) = new SyncRef[F](a)
      def forSQLData(a: SQLData) = new SyncSQLData[F](a)
      def forSQLInput(a: SQLInput) = new SyncSQLInput[F](a)
      def forSQLOutput(a: SQLOutput) = new SyncSQLOutput[F](a)
      def forConnection(a: Connection) = new SyncConnection[F](a)
      def forStatement(a: Statement) = new SyncStatement[F](a)
      def forPreparedStatement(a: PreparedStatement) = new SyncPreparedStatement[F](a)
      def forCallableStatement(a: CallableStatement) = new SyncCallableStatement[F](a)
      def forResultSet(a: ResultSet) = new SyncResultSet[F](a)
    }
}

