// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless.jdbc

import java.lang.String
import java.sql.SQLData
import java.sql.SQLInput
import java.sql.SQLOutput

/** Algebra of operations for `java.sql.SQLData`. */
@SuppressWarnings(Array("org.wartremover.warts.Overloading"))
trait JdbcSQLData[F[_]] {
  def getSQLTypeName: F[String]
  def readSQL(a: SQLInput, b: String): F[Unit]
  def writeSQL(a: SQLOutput): F[Unit]
}

