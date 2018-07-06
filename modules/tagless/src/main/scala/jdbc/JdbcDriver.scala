// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless.jdbc

import java.lang.String
import java.sql.Connection
import java.sql.Driver
import java.sql.DriverPropertyInfo
import java.util.Properties
import java.util.logging.{ Logger => JdkLogger }

/** Algebra of operations for `java.sql.Driver`. */
@SuppressWarnings(Array("org.wartremover.warts.Overloading"))
trait JdbcDriver[F[_]] {
  def acceptsURL(a: String): F[Boolean]
  def connect(a: String, b: Properties): F[Connection]
  def getMajorVersion: F[Int]
  def getMinorVersion: F[Int]
  def getParentLogger: F[JdkLogger]
  def getPropertyInfo(a: String, b: Properties): F[Array[DriverPropertyInfo]]
  def jdbcCompliant: F[Boolean]
}

