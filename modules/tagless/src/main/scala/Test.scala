// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless

import cats.effect._
import cats.implicits._
import doobie.{ Query0, Update }
import doobie.syntax.string._
import org.slf4j._

@SuppressWarnings(Array("org.wartremover.warts.ToString"))
object Test {

  final case class Code(code: String)

  final case class Country(code: Code, name: String)

  val xa = Transactor.fromDriverManager[IO](
    "org.postgresql.Driver", "jdbc:postgresql:world", "postgres", ""
  )

  object Statements {

    val countries: Query0[Country] =
      sql"select * from country".query[Country]

    def up: Update[Country] =
      Update("insert into country2 (code, name) values (?, ?)")

  }

  def go[F[_]: Sync](c: Connection[F]): F[Unit] =
    c.stream(Statements.countries, 64).to(c.sink(Statements.up)).compile.drain

  lazy val log =
    LoggerFactory.getLogger("doobie")

  val prog: IO[Unit] =
    Async.shift[IO](RTS.global[IO].cpu) *>
    IO(log.info("Starting up.")) *>
    xa.transact(go(_)) *>
    IO(log.info(s"Done."))

  def main(args: Array[String]): Unit = {
    val a = System.setProperty("org.slf4j.simpleLogger.log.doobie", "trace")
    log.info(s"main <enter>")
    prog.unsafeRunSync
    log.info(s"main <exit>")
  }

}
