// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless

import cats.effect._
import doobie.{ Query0, Update }
import doobie.syntax.string._

@SuppressWarnings(Array("org.wartremover.warts.ToString"))
object Test {

  final case class Country(code: String, name: String)

  val xa = Transactor.fromDriverManager[IO](
    "org.postgresql.Driver", "jdbc:postgresql:world", "postgres", ""
  )

  object Statements {

    val countries: Query0[Country] =
      sql"select * from country".query[Country]

    def up: Update[Country] =
      Update("insert into country2 (code, name) values (?, ?)")

  }

  val prog: IO[Unit] =
    xa.transact { c =>

      // I want to say
      // countries.stream(128).to(up.sink).compile.drain
      c.stream(Statements.countries, 64).to(c.sink(Statements.up)).compile.drain
    }


  def main(args: Array[String]): Unit =
    prog.unsafeRunSync

}
