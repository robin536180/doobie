// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless.jdbc

import java.lang.String
import java.sql.Ref
import java.util.Map

/** Algebra of operations for `java.sql.Ref`. */
@SuppressWarnings(Array("org.wartremover.warts.Overloading"))
trait JdbcRef[F[_]] {
  def getBaseTypeName: F[String]
  def getObject: F[AnyRef]
  def getObject(a: Map[String, Class[_]]): F[AnyRef]
  def setObject(a: AnyRef): F[Unit]
}

