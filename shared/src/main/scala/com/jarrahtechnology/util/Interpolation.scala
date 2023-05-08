package com.jarrahtechnology.util

import scala.scalajs.js.annotation.*

@JSExportAll
object Interpolation {
  type Interpolator = Double => Double

  def interp(interpFn: Interpolator)(value: Double, lower: Double, upper: Double) = (upper - lower) * interpFn(Math.clamp01(value)) + lower
  def lerp = interp(identity)
  def powerInterp(power: Int): Interpolator = { require(power>0, s"power=${power} !>0"); math.pow(_, power) }
  def eInterp(k: Double): Interpolator = v => { require(k>0, s"k=${k} !>0"); 1-1/(1+math.pow(math.E, (v*2-1)/k)) }
  def circInterp: Interpolator = v => math.sqrt(1 - v * v) - 1
  def expoInterp: Interpolator = v => math.pow(2, 10 * (v - 1))
  def bounceInterp: Interpolator = _ match {
    case v if v < (1 / 2.75d) => 7.5625d * v * v
    case v if v < (2 / 2.75d) => { val av = v - (1.5d / 2.75d); 7.5625d * av * av + 0.75d }
    case v if v < (2.5 / 2.75d) => { val av = v - (2.25d / 2.75d); 7.5625d * av * av + 0.9375d }
    case v => { val av = v - (2.625d / 2.75d); 7.5625d * av * av + 0.984375d }
  }
  def sinInterp: Interpolator = v => 1d - math.sin(0.5d * math.Pi * (1d - v))
  def springInterp: Interpolator = c => (math.sin(c * math.Pi * (0.2f + 2.5f * c * c * c)) * math.pow(1f - c, 2.2f) + c) * (1f + (1.2f * (1f - c)))
}
