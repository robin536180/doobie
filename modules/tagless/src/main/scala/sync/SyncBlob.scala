// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless.sync

import cats.effect.Sync
import cats.implicits._
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

  val free: F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Blob.free()")) *>
    F.delay(value.free())

  val getBinaryStream: F[InputStream] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Blob.getBinaryStream()")) *>
    F.delay(value.getBinaryStream())

  def getBinaryStream(a: Long, b: Long): F[InputStream] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Blob.getBinaryStream($a, $b)")) *>
    F.delay(value.getBinaryStream(a, b))

  def getBytes(a: Long, b: Int): F[Array[Byte]] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Blob.getBytes($a, $b)")) *>
    F.delay(value.getBytes(a, b))

  val length: F[Long] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Blob.length()")) *>
    F.delay(value.length())

  def position(a: Array[Byte], b: Long): F[Long] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Blob.position($a, $b)")) *>
    F.delay(value.position(a, b))

  def position(a: Blob, b: Long): F[Long] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Blob.position($a, $b)")) *>
    F.delay(value.position(a, b))

  def setBinaryStream(a: Long): F[OutputStream] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Blob.setBinaryStream($a)")) *>
    F.delay(value.setBinaryStream(a))

  def setBytes(a: Long, b: Array[Byte]): F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Blob.setBytes($a, $b)")) *>
    F.delay(value.setBytes(a, b))

  def setBytes(a: Long, b: Array[Byte], c: Int, d: Int): F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Blob.setBytes($a, $b, $c, $d)")) *>
    F.delay(value.setBytes(a, b, c, d))

  def truncate(a: Long): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: Blob.truncate($a)")) *>
    F.delay(value.truncate(a))

}

