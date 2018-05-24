// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless.jdbc

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

/** Algebra of operations for `java.sql.SQLInput`. */
@SuppressWarnings(Array("org.wartremover.warts.Overloading"))
trait JdbcSQLInput[F[_]] {
  def readArray: F[SqlArray]
  def readAsciiStream: F[InputStream]
  def readBigDecimal: F[BigDecimal]
  def readBinaryStream: F[InputStream]
  def readBlob: F[Blob]
  def readBoolean: F[Boolean]
  def readByte: F[Byte]
  def readBytes: F[Array[Byte]]
  def readCharacterStream: F[Reader]
  def readClob: F[Clob]
  def readDate: F[Date]
  def readDouble: F[Double]
  def readFloat: F[Float]
  def readInt: F[Int]
  def readLong: F[Long]
  def readNClob: F[NClob]
  def readNString: F[String]
  def readObject: F[AnyRef]
  def readObject[T](a: Class[T]): F[T]
  def readRef: F[Ref]
  def readRowId: F[RowId]
  def readSQLXML: F[SQLXML]
  def readShort: F[Short]
  def readString: F[String]
  def readTime: F[Time]
  def readTimestamp: F[Timestamp]
  def readURL: F[URL]
  def wasNull: F[Boolean]
}

