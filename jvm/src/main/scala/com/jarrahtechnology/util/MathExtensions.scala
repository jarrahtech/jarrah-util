package com.jarrahtechnology.util

import scala.math.*

object MathExtensions {
  extension (x: Double) def clamp(lower: Double, upper: Double): Double = Math.clamp(x, lower, upper)
  extension (x: Double) def clamp01: Double = Math.clamp01(x)
  extension (x: Double) def lerp(lower: Double, upper: Double): Double = Math.lerp(x, lower, upper)
  //extension (x: Double) def trunc(dp: Int): Double = Math.truncate(dp)(x)

  // these can't be js exported as log10 is an unsupported Java method
  val log2base10: Double = log10(2d) 
  extension (x: Double) def log2: Double = log10(x) / log2base10
}
