// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless

import cats.effect._
import java.util.concurrent.{ Executors, ThreadFactory }
import scala.concurrent.ExecutionContext

final case class RTS[F[_]: Async](
  io:  ExecutionContext,
  cpu: ExecutionContext
) {

  val block: Resource[F, Unit] =
    Resource.make(Async.shift(io))(_ => Async.shift(cpu))

}

object RTS {

  /** The global CPU-bound execution context, an alias for `ExecutionContext.global`. */
  val globalCpu: ExecutionContext =
    ExecutionContext.global

  /** The global IO-bound execution context, an unbounded thread pool. */
  val globalIo: ExecutionContext =
    ExecutionContext.fromExecutor(Executors.newCachedThreadPool(
      new ThreadFactory {
        def newThread(r: Runnable): Thread = {
          val th = new Thread(r)
          th.setName("doobie-rts-global-io")
          th.setDaemon(true)
          th
        }
      }
    ))

  def global[F[_]: Async]: RTS[F] =
    RTS(globalIo, globalCpu)

}