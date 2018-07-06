// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless.sync

import cats.effect.Sync
import cats.implicits._
import doobie.tagless.jdbc._
import java.io.InputStream
import java.io.OutputStream
import java.io.Reader
import java.io.Writer
import java.lang.String
import java.sql.Clob

/**
 * Implementation of JdbcClob that wraps a Clob and lifts its primitive operations into any F
 * given a Sync instance.
 */
@SuppressWarnings(Array("org.wartremover.warts.Overloading"))
class SyncClob[F[_]](value: Clob)(implicit F: Sync[F]) extends JdbcClob[F] {

  val free: F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Clob.free()")) *>
    F.delay(value.free())

  val getAsciiStream: F[InputStream] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Clob.getAsciiStream()")) *>
    F.delay(value.getAsciiStream())

  val getCharacterStream: F[Reader] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Clob.getCharacterStream()")) *>
    F.delay(value.getCharacterStream())

  def getCharacterStream(a: Long, b: Long): F[Reader] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Clob.getCharacterStream($a, $b)")) *>
    F.delay(value.getCharacterStream(a, b))

  def getSubString(a: Long, b: Int): F[String] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Clob.getSubString($a, $b)")) *>
    F.delay(value.getSubString(a, b))

  val length: F[Long] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Clob.length()")) *>
    F.delay(value.length())

  def position(a: Clob, b: Long): F[Long] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Clob.position($a, $b)")) *>
    F.delay(value.position(a, b))

  def position(a: String, b: Long): F[Long] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Clob.position($a, $b)")) *>
    F.delay(value.position(a, b))

  def setAsciiStream(a: Long): F[OutputStream] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Clob.setAsciiStream($a)")) *>
    F.delay(value.setAsciiStream(a))

  def setCharacterStream(a: Long): F[Writer] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Clob.setCharacterStream($a)")) *>
    F.delay(value.setCharacterStream(a))

  def setString(a: Long, b: String): F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Clob.setString($a, $b)")) *>
    F.delay(value.setString(a, b))

  def setString(a: Long, b: String, c: Int, d: Int): F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Clob.setString($a, $b, $c, $d)")) *>
    F.delay(value.setString(a, b, c, d))

  def truncate(a: Long): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Clob.truncate($a)")) *>
    F.delay(value.truncate(a))

}

