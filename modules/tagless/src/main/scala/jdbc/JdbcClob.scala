// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless.jdbc

import java.io.InputStream
import java.io.OutputStream
import java.io.Reader
import java.io.Writer
import java.lang.String
import java.sql.Clob

/** Algebra of operations for `java.sql.Clob`. */
@SuppressWarnings(Array("org.wartremover.warts.Overloading"))
trait JdbcClob[F[_]] {
  def free: F[Unit]
  def getAsciiStream: F[InputStream]
  def getCharacterStream: F[Reader]
  def getCharacterStream(a: Long, b: Long): F[Reader]
  def getSubString(a: Long, b: Int): F[String]
  def length: F[Long]
  def position(a: Clob, b: Long): F[Long]
  def position(a: String, b: Long): F[Long]
  def setAsciiStream(a: Long): F[OutputStream]
  def setCharacterStream(a: Long): F[Writer]
  def setString(a: Long, b: String): F[Int]
  def setString(a: Long, b: String, c: Int, d: Int): F[Int]
  def truncate(a: Long): F[Unit]
}

