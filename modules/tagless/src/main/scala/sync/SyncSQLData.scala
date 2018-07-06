// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless.sync

import cats.effect.Sync
import cats.implicits._
import doobie.tagless.jdbc._
import java.lang.String
import java.sql.SQLData
import java.sql.SQLInput
import java.sql.SQLOutput

/**
 * Implementation of JdbcSQLData that wraps a SQLData and lifts its primitive operations into any F
 * given a Sync instance.
 */
@SuppressWarnings(Array("org.wartremover.warts.Overloading"))
class SyncSQLData[F[_]](value: SQLData)(implicit F: Sync[F]) extends JdbcSQLData[F] {

  val getSQLTypeName: F[String] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLData.getSQLTypeName()")) *>
    F.delay(value.getSQLTypeName())

  def readSQL(a: SQLInput, b: String): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLData.readSQL($a, $b)")) *>
    F.delay(value.readSQL(a, b))

  def writeSQL(a: SQLOutput): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLData.writeSQL($a)")) *>
    F.delay(value.writeSQL(a))

}

