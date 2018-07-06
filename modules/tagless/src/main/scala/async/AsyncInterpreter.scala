// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless.async

import cats.effect.Sync
import doobie.tagless.RTS
import doobie.tagless.jdbc._
import org.slf4j.Logger
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

object AsyncInterpreter {
  def apply[F[_]: Sync](rts: RTS[F], log: Logger): JdbcInterpreter[F] =
    new JdbcInterpreter[F] {
      def forNClob(a: NClob) = new AsyncNClob[F](a, rts, log)
      def forBlob(a: Blob) = new AsyncBlob[F](a, rts, log)
      def forClob(a: Clob) = new AsyncClob[F](a, rts, log)
      def forDatabaseMetaData(a: DatabaseMetaData) = new AsyncDatabaseMetaData[F](a, rts, log)
      def forDriver(a: Driver) = new AsyncDriver[F](a, rts, log)
      def forRef(a: Ref) = new AsyncRef[F](a, rts, log)
      def forSQLData(a: SQLData) = new AsyncSQLData[F](a, rts, log)
      def forSQLInput(a: SQLInput) = new AsyncSQLInput[F](a, rts, log)
      def forSQLOutput(a: SQLOutput) = new AsyncSQLOutput[F](a, rts, log)
      def forConnection(a: Connection) = new AsyncConnection[F](a, rts, log)
      def forStatement(a: Statement) = new AsyncStatement[F](a, rts, log)
      def forPreparedStatement(a: PreparedStatement) = new AsyncPreparedStatement[F](a, rts, log)
      def forCallableStatement(a: CallableStatement) = new AsyncCallableStatement[F](a, rts, log)
      def forResultSet(a: ResultSet) = new AsyncResultSet[F](a, rts, log)
    }
}

