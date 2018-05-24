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
import java.sql.Blob

/**
 * Implementation of JdbcBlob that wraps a Blob and lifts its primitive operations into any F
 * given a Sync instance.
 */
@SuppressWarnings(Array("org.wartremover.warts.Overloading"))
class SyncBlob[F[_]](value: Blob)(implicit F: Sync[F]) extends JdbcBlob[F] {

  def free =
    F.delay(Console.err.println("Blob.free()")) *>
    F.delay(value.free())

  def getBinaryStream =
    F.delay(Console.err.println("Blob.getBinaryStream()")) *>
    F.delay(value.getBinaryStream())

  def getBinaryStream(a: Long, b: Long) =
    F.delay(Console.err.println(s"Blob.getBinaryStream($a, $b)")) *>
    F.delay(value.getBinaryStream(a, b))

  def getBytes(a: Long, b: Int) =
    F.delay(Console.err.println(s"Blob.getBytes($a, $b)")) *>
    F.delay(value.getBytes(a, b))

  def length =
    F.delay(Console.err.println("Blob.length()")) *>
    F.delay(value.length())

  def position(a: Array[Byte], b: Long) =
    F.delay(Console.err.println(s"Blob.position($a, $b)")) *>
    F.delay(value.position(a, b))

  def position(a: Blob, b: Long) =
    F.delay(Console.err.println(s"Blob.position($a, $b)")) *>
    F.delay(value.position(a, b))

  def setBinaryStream(a: Long) =
    F.delay(Console.err.println(s"Blob.setBinaryStream($a)")) *>
    F.delay(value.setBinaryStream(a))

  def setBytes(a: Long, b: Array[Byte]) =
    F.delay(Console.err.println(s"Blob.setBytes($a, $b)")) *>
    F.delay(value.setBytes(a, b))

  def setBytes(a: Long, b: Array[Byte], c: Int, d: Int) =
    F.delay(Console.err.println(s"Blob.setBytes($a, $b, $c, $d)")) *>
    F.delay(value.setBytes(a, b, c, d))

  def truncate(a: Long) =
    F.delay(Console.err.println(s"Blob.truncate($a)")) *>
    F.delay(value.truncate(a))

}

