// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless.jdbc

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

/** Algebra of operations for `java.sql.SQLOutput`. */
@SuppressWarnings(Array("org.wartremover.warts.Overloading"))
trait JdbcSQLOutput[F[_]] {
  def writeArray(a: SqlArray): F[Unit]
  def writeAsciiStream(a: InputStream): F[Unit]
  def writeBigDecimal(a: BigDecimal): F[Unit]
  def writeBinaryStream(a: InputStream): F[Unit]
  def writeBlob(a: Blob): F[Unit]
  def writeBoolean(a: Boolean): F[Unit]
  def writeByte(a: Byte): F[Unit]
  def writeBytes(a: Array[Byte]): F[Unit]
  def writeCharacterStream(a: Reader): F[Unit]
  def writeClob(a: Clob): F[Unit]
  def writeDate(a: Date): F[Unit]
  def writeDouble(a: Double): F[Unit]
  def writeFloat(a: Float): F[Unit]
  def writeInt(a: Int): F[Unit]
  def writeLong(a: Long): F[Unit]
  def writeNClob(a: NClob): F[Unit]
  def writeNString(a: String): F[Unit]
  def writeObject(a: AnyRef, b: SQLType): F[Unit]
  def writeObject(a: SQLData): F[Unit]
  def writeRef(a: Ref): F[Unit]
  def writeRowId(a: RowId): F[Unit]
  def writeSQLXML(a: SQLXML): F[Unit]
  def writeShort(a: Short): F[Unit]
  def writeString(a: String): F[Unit]
  def writeStruct(a: Struct): F[Unit]
  def writeTime(a: Time): F[Unit]
  def writeTimestamp(a: Timestamp): F[Unit]
  def writeURL(a: URL): F[Unit]
}

