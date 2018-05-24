// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless

import cats._
import cats.implicits._

final case class Strategy[F[_]](
  before: Connection[F] => F[Unit],
  after:  Connection[F] => F[Unit],
  always: Connection[F] => F[Unit]
)

object Strategy {

  def default[F[_]]: Strategy[F] =
    Strategy[F](
      _.jdbc.setAutoCommit(false),
      _.jdbc.commit,
      _.jdbc.close
    )

  def void[F[_]: Applicative]: Strategy[F] =
    Strategy[F](
      _ => ().pure[F],
      _ => ().pure[F],
      _ => ().pure[F]
    )

}