/*
 * Copyright 2017 47 Degrees, LLC. <http://www.47deg.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sbtorgpolicies

import org.joda.time.{DateTime, DateTimeZone}

trait utils {

  def guard[T](flag: Boolean)(res: T*): List[T] = if (flag) res.toList else Nil

  def getEnvVar(name: String): Option[String] = Option(System.getenv().get(name))

  def getEnvVarOrElse(name: String, value: String = ""): String = getEnvVar(name).getOrElse(value)

  val currentYear: Int = DateTime.now(DateTimeZone.UTC).getYear

  def replaceableYear(startYear: Option[Int]): String = {
    startYear.getOrElse(currentYear) match {
      case start if start == currentYear => currentYear.toString
      case start                         => s"$start-$currentYear"
    }
  }
}

object utils extends utils
