// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless.async

import cats.effect.Sync
import doobie.tagless.RTS
import doobie.tagless.jdbc._
import org.slf4j.Logger
import java.lang.String
import java.sql.SQLData
import java.sql.SQLInput
import java.sql.SQLOutput

/**
 * Implementation of JdbcSQLData that wraps a SQLData and lifts its primitive operations into any F
 * given a Sync instance.
 */
@SuppressWarnings(Array("org.wartremover.warts.Overloading"))
class AsyncSQLData[F[_]: Sync](value: SQLData, rts: RTS[F], log: Logger) extends JdbcSQLData[F] {

  val id: String =
    s"${System.identityHashCode(value).toHexString.padTo(8, ' ')} SQLData".padTo(28, ' ')

  val getSQLTypeName: F[String] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id getSQLTypeName()")
        value.getSQLTypeName()
      }
    }

  def readSQL(a: SQLInput, b: String): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id readSQL($a, $b)")
        value.readSQL(a, b)
      }
    }

  def writeSQL(a: SQLOutput): F[Unit] =
    rts.block.use { _ =>
      Sync[F].delay {
        if (log.isTraceEnabled)
          log.trace(s"$id writeSQL($a)")
        value.writeSQL(a)
      }
    }

}

