package com.jarrahtechnology.util

import scala.math.*
import scala.scalajs.js.annotation._

@JSExportTopLevel("Mathjt")
object Math {
  @JSExport def clamp(x: Double, lower: Double, upper: Double): Double = math.min(math.max(lower, x), upper)
  @JSExport def clamp01(x: Double): Double = clamp(x, 0d, 1d)
  @JSExport def lerp(x: Double, lower: Double, upper: Double): Double = lower + x * (upper - lower)
  @JSExport def truncate(dp: Int)(num: Double): Double = BigDecimal(num).setScale(dp, BigDecimal.RoundingMode.HALF_UP).toDouble
}
