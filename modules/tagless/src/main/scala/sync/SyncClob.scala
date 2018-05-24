// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless.sync

import cats.effect.Sync
import cats.implicits._
import cats.syntax._
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

  def free =
    F.delay(Console.err.println("Clob.free()")) *>
    F.delay(value.free())

  def getAsciiStream =
    F.delay(Console.err.println("Clob.getAsciiStream()")) *>
    F.delay(value.getAsciiStream())

  def getCharacterStream =
    F.delay(Console.err.println("Clob.getCharacterStream()")) *>
    F.delay(value.getCharacterStream())

  def getCharacterStream(a: Long, b: Long) =
    F.delay(Console.err.println(s"Clob.getCharacterStream($a, $b)")) *>
    F.delay(value.getCharacterStream(a, b))

  def getSubString(a: Long, b: Int) =
    F.delay(Console.err.println(s"Clob.getSubString($a, $b)")) *>
    F.delay(value.getSubString(a, b))

  def length =
    F.delay(Console.err.println("Clob.length()")) *>
    F.delay(value.length())

  def position(a: Clob, b: Long) =
    F.delay(Console.err.println(s"Clob.position($a, $b)")) *>
    F.delay(value.position(a, b))

  def position(a: String, b: Long) =
    F.delay(Console.err.println(s"Clob.position($a, $b)")) *>
    F.delay(value.position(a, b))

  def setAsciiStream(a: Long) =
    F.delay(Console.err.println(s"Clob.setAsciiStream($a)")) *>
    F.delay(value.setAsciiStream(a))

  def setCharacterStream(a: Long) =
    F.delay(Console.err.println(s"Clob.setCharacterStream($a)")) *>
    F.delay(value.setCharacterStream(a))

  def setString(a: Long, b: String) =
    F.delay(Console.err.println(s"Clob.setString($a, $b)")) *>
    F.delay(value.setString(a, b))

  def setString(a: Long, b: String, c: Int, d: Int) =
    F.delay(Console.err.println(s"Clob.setString($a, $b, $c, $d)")) *>
    F.delay(value.setString(a, b, c, d))

  def truncate(a: Long) =
    F.delay(Console.err.println(s"Clob.truncate($a)")) *>
    F.delay(value.truncate(a))

}

