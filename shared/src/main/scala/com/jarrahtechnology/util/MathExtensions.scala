package com.jarrahtechnology.util

import scala.math.*
import scala.scalajs.js.annotation.*

@JSExportAll
object MathExtensions {
  extension (x: Double) def clamp(lower: Double, upper: Double): Double = Math.clamp(x, lower, upper)
  extension (x: Double) def clamp01: Double = Math.clamp01(x)
  extension (x: Double) def trunc(dp: Int): Double = Math.truncate(dp)(x)
  extension (x: Long) def isEven = Math.isEven(x)
  extension (x: Double) def isFloorEven = Math.isFloorEven(x)

  // these can't be js exported as log10 is an unsupported Java method
  val log2base10: Double = log10(2d) 
  extension (x: Double) def log2: Double = log10(x) / log2base10
}
