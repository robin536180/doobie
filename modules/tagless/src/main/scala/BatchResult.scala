// Copyright (c) 2013-2018 Rob Norris and Contributors
// This software is licensed under the MIT License (MIT).
// For more information see LICENSE or https://opensource.org/licenses/MIT

package doobie.tagless
import java.sql.Statement.{ SUCCESS_NO_INFO, EXECUTE_FAILED }

sealed abstract class BatchResult extends Product with Serializable
object BatchResult {

  final case class  Success(toInt: Int) extends BatchResult
  final case object SuccessNoInfo       extends BatchResult
  final case object ExecuteFailed       extends BatchResult

  def fromJdbc(n: Int): BatchResult =
    n match {
      case SUCCESS_NO_INFO => SuccessNoInfo
      case EXECUTE_FAILED  => ExecuteFailed
      case n               => Success(n)
    }

}