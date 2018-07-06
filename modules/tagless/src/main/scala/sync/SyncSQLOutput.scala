// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless.sync

import cats.effect.Sync
import cats.implicits._
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

  def writeArray(a: SqlArray): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLOutput.writeArray($a)")) *>
    F.delay(value.writeArray(a))

  def writeAsciiStream(a: InputStream): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLOutput.writeAsciiStream($a)")) *>
    F.delay(value.writeAsciiStream(a))

  def writeBigDecimal(a: BigDecimal): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLOutput.writeBigDecimal($a)")) *>
    F.delay(value.writeBigDecimal(a))

  def writeBinaryStream(a: InputStream): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLOutput.writeBinaryStream($a)")) *>
    F.delay(value.writeBinaryStream(a))

  def writeBlob(a: Blob): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLOutput.writeBlob($a)")) *>
    F.delay(value.writeBlob(a))

  def writeBoolean(a: Boolean): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLOutput.writeBoolean($a)")) *>
    F.delay(value.writeBoolean(a))

  def writeByte(a: Byte): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLOutput.writeByte($a)")) *>
    F.delay(value.writeByte(a))

  def writeBytes(a: Array[Byte]): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLOutput.writeBytes($a)")) *>
    F.delay(value.writeBytes(a))

  def writeCharacterStream(a: Reader): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLOutput.writeCharacterStream($a)")) *>
    F.delay(value.writeCharacterStream(a))

  def writeClob(a: Clob): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLOutput.writeClob($a)")) *>
    F.delay(value.writeClob(a))

  def writeDate(a: Date): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLOutput.writeDate($a)")) *>
    F.delay(value.writeDate(a))

  def writeDouble(a: Double): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLOutput.writeDouble($a)")) *>
    F.delay(value.writeDouble(a))

  def writeFloat(a: Float): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLOutput.writeFloat($a)")) *>
    F.delay(value.writeFloat(a))

  def writeInt(a: Int): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLOutput.writeInt($a)")) *>
    F.delay(value.writeInt(a))

  def writeLong(a: Long): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLOutput.writeLong($a)")) *>
    F.delay(value.writeLong(a))

  def writeNClob(a: NClob): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLOutput.writeNClob($a)")) *>
    F.delay(value.writeNClob(a))

  def writeNString(a: String): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLOutput.writeNString($a)")) *>
    F.delay(value.writeNString(a))

  def writeObject(a: AnyRef, b: SQLType): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLOutput.writeObject($a, $b)")) *>
    F.delay(value.writeObject(a, b))

  def writeObject(a: SQLData): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLOutput.writeObject($a)")) *>
    F.delay(value.writeObject(a))

  def writeRef(a: Ref): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLOutput.writeRef($a)")) *>
    F.delay(value.writeRef(a))

  def writeRowId(a: RowId): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLOutput.writeRowId($a)")) *>
    F.delay(value.writeRowId(a))

  def writeSQLXML(a: SQLXML): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLOutput.writeSQLXML($a)")) *>
    F.delay(value.writeSQLXML(a))

  def writeShort(a: Short): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLOutput.writeShort($a)")) *>
    F.delay(value.writeShort(a))

  def writeString(a: String): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLOutput.writeString($a)")) *>
    F.delay(value.writeString(a))

  def writeStruct(a: Struct): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLOutput.writeStruct($a)")) *>
    F.delay(value.writeStruct(a))

  def writeTime(a: Time): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLOutput.writeTime($a)")) *>
    F.delay(value.writeTime(a))

  def writeTimestamp(a: Timestamp): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLOutput.writeTimestamp($a)")) *>
    F.delay(value.writeTimestamp(a))

  def writeURL(a: URL): F[Unit] =
    F.delay(Console.err.println(s"${Thread.currentThread}: SQLOutput.writeURL($a)")) *>
    F.delay(value.writeURL(a))

}

