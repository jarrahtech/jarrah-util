package com.jarrahtechnology.util

import scala.math.*
import scala.scalajs.js.annotation.*

@JSExportAll
object Math {
  def clamp(x: Double, lower: Double, upper: Double): Double = math.min(math.max(lower, x), upper)
  def clamp01(x: Double): Double = clamp(x, 0d, 1d)
  def truncate(dp: Int)(num: Double): Double = BigDecimal(num).setScale(dp, BigDecimal.RoundingMode.HALF_UP).toDouble
  def isEven(x: Long) = x % 2 == 0
  def isFloorEven(x: Double) = math.floor(math.abs(x) % 2) == 0

  import scala.concurrent.duration._
  def mod(x: Duration, divisor: Duration) = Duration(x.toNanos%divisor.toNanos, NANOSECONDS) 

}
