// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless.sync

import cats.effect.Sync
import cats.implicits._
import doobie.tagless.jdbc._
import java.lang.String
import java.sql.Ref
import java.util.Map

/**
 * Implementation of JdbcRef that wraps a Ref and lifts its primitive operations into any F
 * given a Sync instance.
 */
@SuppressWarnings(Array("org.wartremover.warts.Overloading"))
class SyncRef[F[_]](value: Ref)(implicit F: Sync[F]) extends JdbcRef[F] {

  val getBaseTypeName: F[String] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Ref.getBaseTypeName()")) *>
    F.delay(value.getBaseTypeName())

  val getObject: F[AnyRef] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Ref.getObject()")) *>
    F.delay(value.getObject())

  def getObject(a: Map[String, Class[_]]): F[AnyRef] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Ref.getObject($a)")) *>
    F.delay(value.getObject(a))

  def setObject(a: AnyRef): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Ref.setObject($a)")) *>
    F.delay(value.setObject(a))

}

