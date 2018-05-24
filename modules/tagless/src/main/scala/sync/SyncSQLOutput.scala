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
import java.lang.String
import java.math.BigDecimal
import java.net.URL
import java.sql.Blob
import java.sql.Clob
import java.sql.Date
import java.sql.NClob
import java.sql.Ref
import java.sql.RowId
import java.sql.SQLData
import java.sql.SQLOutput
import java.sql.SQLType
import java.sql.SQLXML
import java.sql.Struct
import java.sql.Time
import java.sql.Timestamp
import java.sql.{ Array => SqlArray }

/**
 * Implementation of JdbcSQLOutput that wraps a SQLOutput and lifts its primitive operations into any F
 * given a Sync instance.
 */
@SuppressWarnings(Array("org.wartremover.warts.Overloading"))
class SyncSQLOutput[F[_]](value: SQLOutput)(implicit F: Sync[F]) extends JdbcSQLOutput[F] {

  def writeArray(a: SqlArray) =
    F.delay(Console.err.println(s"SQLOutput.writeArray($a)")) *>
    F.delay(value.writeArray(a))

  def writeAsciiStream(a: InputStream) =
    F.delay(Console.err.println(s"SQLOutput.writeAsciiStream($a)")) *>
    F.delay(value.writeAsciiStream(a))

  def writeBigDecimal(a: BigDecimal) =
    F.delay(Console.err.println(s"SQLOutput.writeBigDecimal($a)")) *>
    F.delay(value.writeBigDecimal(a))

  def writeBinaryStream(a: InputStream) =
    F.delay(Console.err.println(s"SQLOutput.writeBinaryStream($a)")) *>
    F.delay(value.writeBinaryStream(a))

  def writeBlob(a: Blob) =
    F.delay(Console.err.println(s"SQLOutput.writeBlob($a)")) *>
    F.delay(value.writeBlob(a))

  def writeBoolean(a: Boolean) =
    F.delay(Console.err.println(s"SQLOutput.writeBoolean($a)")) *>
    F.delay(value.writeBoolean(a))

  def writeByte(a: Byte) =
    F.delay(Console.err.println(s"SQLOutput.writeByte($a)")) *>
    F.delay(value.writeByte(a))

  def writeBytes(a: Array[Byte]) =
    F.delay(Console.err.println(s"SQLOutput.writeBytes($a)")) *>
    F.delay(value.writeBytes(a))

  def writeCharacterStream(a: Reader) =
    F.delay(Console.err.println(s"SQLOutput.writeCharacterStream($a)")) *>
    F.delay(value.writeCharacterStream(a))

  def writeClob(a: Clob) =
    F.delay(Console.err.println(s"SQLOutput.writeClob($a)")) *>
    F.delay(value.writeClob(a))

  def writeDate(a: Date) =
    F.delay(Console.err.println(s"SQLOutput.writeDate($a)")) *>
    F.delay(value.writeDate(a))

  def writeDouble(a: Double) =
    F.delay(Console.err.println(s"SQLOutput.writeDouble($a)")) *>
    F.delay(value.writeDouble(a))

  def writeFloat(a: Float) =
    F.delay(Console.err.println(s"SQLOutput.writeFloat($a)")) *>
    F.delay(value.writeFloat(a))

  def writeInt(a: Int) =
    F.delay(Console.err.println(s"SQLOutput.writeInt($a)")) *>
    F.delay(value.writeInt(a))

  def writeLong(a: Long) =
    F.delay(Console.err.println(s"SQLOutput.writeLong($a)")) *>
    F.delay(value.writeLong(a))

  def writeNClob(a: NClob) =
    F.delay(Console.err.println(s"SQLOutput.writeNClob($a)")) *>
    F.delay(value.writeNClob(a))

  def writeNString(a: String) =
    F.delay(Console.err.println(s"SQLOutput.writeNString($a)")) *>
    F.delay(value.writeNString(a))

  def writeObject(a: AnyRef, b: SQLType) =
    F.delay(Console.err.println(s"SQLOutput.writeObject($a, $b)")) *>
    F.delay(value.writeObject(a, b))

  def writeObject(a: SQLData) =
    F.delay(Console.err.println(s"SQLOutput.writeObject($a)")) *>
    F.delay(value.writeObject(a))

  def writeRef(a: Ref) =
    F.delay(Console.err.println(s"SQLOutput.writeRef($a)")) *>
    F.delay(value.writeRef(a))

  def writeRowId(a: RowId) =
    F.delay(Console.err.println(s"SQLOutput.writeRowId($a)")) *>
    F.delay(value.writeRowId(a))

  def writeSQLXML(a: SQLXML) =
    F.delay(Console.err.println(s"SQLOutput.writeSQLXML($a)")) *>
    F.delay(value.writeSQLXML(a))

  def writeShort(a: Short) =
    F.delay(Console.err.println(s"SQLOutput.writeShort($a)")) *>
    F.delay(value.writeShort(a))

  def writeString(a: String) =
    F.delay(Console.err.println(s"SQLOutput.writeString($a)")) *>
    F.delay(value.writeString(a))

  def writeStruct(a: Struct) =
    F.delay(Console.err.println(s"SQLOutput.writeStruct($a)")) *>
    F.delay(value.writeStruct(a))

  def writeTime(a: Time) =
    F.delay(Console.err.println(s"SQLOutput.writeTime($a)")) *>
    F.delay(value.writeTime(a))

  def writeTimestamp(a: Timestamp) =
    F.delay(Console.err.println(s"SQLOutput.writeTimestamp($a)")) *>
    F.delay(value.writeTimestamp(a))

  def writeURL(a: URL) =
    F.delay(Console.err.println(s"SQLOutput.writeURL($a)")) *>
    F.delay(value.writeURL(a))

}

