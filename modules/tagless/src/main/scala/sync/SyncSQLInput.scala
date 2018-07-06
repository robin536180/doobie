// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless.sync

import cats.effect.Sync
import cats.implicits._
import doobie.tagless.jdbc._
import java.io.InputStream
import java.io.Reader
import java.lang.Class
import java.lang.String
import java.math.BigDecimal
import java.net.URL
import java.sql.Blob
import java.sql.Clob
import java.sql.Date
import java.sql.NClob
import java.sql.Ref
import java.sql.RowId
import java.sql.SQLInput
import java.sql.SQLXML
import java.sql.Time
import java.sql.Timestamp
import java.sql.{ Array => SqlArray }

/**
 * Implementation of JdbcSQLInput that wraps a SQLInput and lifts its primitive operations into any F
 * given a Sync instance.
 */
@SuppressWarnings(Array("org.wartremover.warts.Overloading"))
class SyncSQLInput[F[_]](value: SQLInput)(implicit F: Sync[F]) extends JdbcSQLInput[F] {

  val readArray: F[SqlArray] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLInput.readArray()")) *>
    F.delay(value.readArray())

  val readAsciiStream: F[InputStream] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLInput.readAsciiStream()")) *>
    F.delay(value.readAsciiStream())

  val readBigDecimal: F[BigDecimal] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLInput.readBigDecimal()")) *>
    F.delay(value.readBigDecimal())

  val readBinaryStream: F[InputStream] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLInput.readBinaryStream()")) *>
    F.delay(value.readBinaryStream())

  val readBlob: F[Blob] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLInput.readBlob()")) *>
    F.delay(value.readBlob())

  val readBoolean: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLInput.readBoolean()")) *>
    F.delay(value.readBoolean())

  val readByte: F[Byte] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLInput.readByte()")) *>
    F.delay(value.readByte())

  val readBytes: F[Array[Byte]] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLInput.readBytes()")) *>
    F.delay(value.readBytes())

  val readCharacterStream: F[Reader] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLInput.readCharacterStream()")) *>
    F.delay(value.readCharacterStream())

  val readClob: F[Clob] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLInput.readClob()")) *>
    F.delay(value.readClob())

  val readDate: F[Date] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLInput.readDate()")) *>
    F.delay(value.readDate())

  val readDouble: F[Double] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLInput.readDouble()")) *>
    F.delay(value.readDouble())

  val readFloat: F[Float] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLInput.readFloat()")) *>
    F.delay(value.readFloat())

  val readInt: F[Int] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLInput.readInt()")) *>
    F.delay(value.readInt())

  val readLong: F[Long] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLInput.readLong()")) *>
    F.delay(value.readLong())

  val readNClob: F[NClob] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLInput.readNClob()")) *>
    F.delay(value.readNClob())

  val readNString: F[String] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLInput.readNString()")) *>
    F.delay(value.readNString())

  val readObject: F[AnyRef] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLInput.readObject()")) *>
    F.delay(value.readObject())

  def readObject[T](a: Class[T]): F[T] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLInput.readObject($a)")) *>
    F.delay(value.readObject(a))

  val readRef: F[Ref] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLInput.readRef()")) *>
    F.delay(value.readRef())

  val readRowId: F[RowId] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLInput.readRowId()")) *>
    F.delay(value.readRowId())

  val readSQLXML: F[SQLXML] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLInput.readSQLXML()")) *>
    F.delay(value.readSQLXML())

  val readShort: F[Short] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLInput.readShort()")) *>
    F.delay(value.readShort())

  val readString: F[String] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLInput.readString()")) *>
    F.delay(value.readString())

  val readTime: F[Time] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLInput.readTime()")) *>
    F.delay(value.readTime())

  val readTimestamp: F[Timestamp] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLInput.readTimestamp()")) *>
    F.delay(value.readTimestamp())

  val readURL: F[URL] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLInput.readURL()")) *>
    F.delay(value.readURL())

  val wasNull: F[Boolean] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLInput.wasNull()")) *>
    F.delay(value.wasNull())

}

