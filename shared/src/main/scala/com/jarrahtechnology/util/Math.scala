package com.jarrahtechnology.util

import scala.math.*
import scala.scalajs.js.annotation._

@JSExportAll
object Math {
  def clamp(x: Double, lower: Double, upper: Double): Double = math.min(math.max(lower, x), upper)
  def clamp01(x: Double): Double = clamp(x, 0d, 1d)
  def lerp(x: Double, lower: Double, upper: Double): Double = lower + x * (upper - lower)
  def truncate(dp: Int)(num: Double): Double = BigDecimal(num).setScale(dp, BigDecimal.RoundingMode.HALF_UP).toDouble
}
