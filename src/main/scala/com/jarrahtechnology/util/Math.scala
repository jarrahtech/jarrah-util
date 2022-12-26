package com.jarrahtechnology.util

import scala.math.*

object Math {
  extension (x: Double) def clamp(lower: Double, upper: Double): Double = math.min(math.max(lower, x), upper)
  extension (t: Double) def clamp01: Double = t.clamp(0d, 1d)
  extension (t: Double) def lerp(lower: Double, upper: Double): Double = lower + t * (upper - lower)
  val log2base10: Double = log10(2d)
  def log2(x: Double): Double = log10(x) / log2base10
}
