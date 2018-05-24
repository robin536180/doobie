// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless.sync

import cats.effect.Sync
import cats.implicits._
import cats.syntax._
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

  def readArray =
    F.delay(Console.err.println("SQLInput.readArray()")) *>
    F.delay(value.readArray())

  def readAsciiStream =
    F.delay(Console.err.println("SQLInput.readAsciiStream()")) *>
    F.delay(value.readAsciiStream())

  def readBigDecimal =
    F.delay(Console.err.println("SQLInput.readBigDecimal()")) *>
    F.delay(value.readBigDecimal())

  def readBinaryStream =
    F.delay(Console.err.println("SQLInput.readBinaryStream()")) *>
    F.delay(value.readBinaryStream())

  def readBlob =
    F.delay(Console.err.println("SQLInput.readBlob()")) *>
    F.delay(value.readBlob())

  def readBoolean =
    F.delay(Console.err.println("SQLInput.readBoolean()")) *>
    F.delay(value.readBoolean())

  def readByte =
    F.delay(Console.err.println("SQLInput.readByte()")) *>
    F.delay(value.readByte())

  def readBytes =
    F.delay(Console.err.println("SQLInput.readBytes()")) *>
    F.delay(value.readBytes())

  def readCharacterStream =
    F.delay(Console.err.println("SQLInput.readCharacterStream()")) *>
    F.delay(value.readCharacterStream())

  def readClob =
    F.delay(Console.err.println("SQLInput.readClob()")) *>
    F.delay(value.readClob())

  def readDate =
    F.delay(Console.err.println("SQLInput.readDate()")) *>
    F.delay(value.readDate())

  def readDouble =
    F.delay(Console.err.println("SQLInput.readDouble()")) *>
    F.delay(value.readDouble())

  def readFloat =
    F.delay(Console.err.println("SQLInput.readFloat()")) *>
    F.delay(value.readFloat())

  def readInt =
    F.delay(Console.err.println("SQLInput.readInt()")) *>
    F.delay(value.readInt())

  def readLong =
    F.delay(Console.err.println("SQLInput.readLong()")) *>
    F.delay(value.readLong())

  def readNClob =
    F.delay(Console.err.println("SQLInput.readNClob()")) *>
    F.delay(value.readNClob())

  def readNString =
    F.delay(Console.err.println("SQLInput.readNString()")) *>
    F.delay(value.readNString())

  def readObject =
    F.delay(Console.err.println("SQLInput.readObject()")) *>
    F.delay(value.readObject())

  def readObject[T](a: Class[T]) =
    F.delay(Console.err.println(s"SQLInput.readObject($a)")) *>
    F.delay(value.readObject(a))

  def readRef =
    F.delay(Console.err.println("SQLInput.readRef()")) *>
    F.delay(value.readRef())

  def readRowId =
    F.delay(Console.err.println("SQLInput.readRowId()")) *>
    F.delay(value.readRowId())

  def readSQLXML =
    F.delay(Console.err.println("SQLInput.readSQLXML()")) *>
    F.delay(value.readSQLXML())

  def readShort =
    F.delay(Console.err.println("SQLInput.readShort()")) *>
    F.delay(value.readShort())

  def readString =
    F.delay(Console.err.println("SQLInput.readString()")) *>
    F.delay(value.readString())

  def readTime =
    F.delay(Console.err.println("SQLInput.readTime()")) *>
    F.delay(value.readTime())

  def readTimestamp =
    F.delay(Console.err.println("SQLInput.readTimestamp()")) *>
    F.delay(value.readTimestamp())

  def readURL =
    F.delay(Console.err.println("SQLInput.readURL()")) *>
    F.delay(value.readURL())

  def wasNull =
    F.delay(Console.err.println("SQLInput.wasNull()")) *>
    F.delay(value.wasNull())

}

