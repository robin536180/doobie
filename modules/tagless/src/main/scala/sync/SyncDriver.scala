// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless.sync

import cats.effect.Sync
import cats.implicits._
import doobie.tagless.jdbc._
import java.lang.String
import java.sql.Connection
import java.sql.Driver
import java.sql.DriverPropertyInfo
import java.util.Properties
import java.util.logging.{ Logger => JdkLogger }

/**
 * Implementation of JdbcDriver that wraps a Driver and lifts its primitive operations into any F
 * given a Sync instance.
 */
@SuppressWarnings(Array("org.wartremover.warts.Overloading"))
class SyncDriver[F[_]](value: Driver)(implicit F: Sync[F]) extends JdbcDriver[F] {

  def acceptsURL(a: String): F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Driver.acceptsURL($a)")) *>
    F.delay(value.acceptsURL(a))

  def connect(a: String, b: Properties): F[Connection] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Driver.connect($a, $b)")) *>
    F.delay(value.connect(a, b))

  val getMajorVersion: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Driver.getMajorVersion()")) *>
    F.delay(value.getMajorVersion())

  val getMinorVersion: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Driver.getMinorVersion()")) *>
    F.delay(value.getMinorVersion())

  val getParentLogger: F[JdkLogger] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Driver.getParentLogger()")) *>
    F.delay(value.getParentLogger())

  def getPropertyInfo(a: String, b: Properties): F[Array[DriverPropertyInfo]] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Driver.getPropertyInfo($a, $b)")) *>
    F.delay(value.getPropertyInfo(a, b))

  val jdbcCompliant: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Driver.jdbcCompliant()")) *>
    F.delay(value.jdbcCompliant())

}

