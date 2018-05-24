// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless.jdbc

import java.io.InputStream
import java.io.OutputStream
import java.sql.Blob

/** Algebra of operations for `java.sql.Blob`. */
@SuppressWarnings(Array("org.wartremover.warts.Overloading"))
trait JdbcBlob[F[_]] {
  def free: F[Unit]
  def getBinaryStream: F[InputStream]
  def getBinaryStream(a: Long, b: Long): F[InputStream]
  def getBytes(a: Long, b: Int): F[Array[Byte]]
  def length: F[Long]
  def position(a: Array[Byte], b: Long): F[Long]
  def position(a: Blob, b: Long): F[Long]
  def setBinaryStream(a: Long): F[OutputStream]
  def setBytes(a: Long, b: Array[Byte]): F[Int]
  def setBytes(a: Long, b: Array[Byte], c: Int, d: Int): F[Int]
  def truncate(a: Long): F[Unit]
}

