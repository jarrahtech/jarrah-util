package com.jarrahtechnology.util

import scala.scalajs.js.annotation.*
import Interpolation.*

@JSExportAll
final case class InterpCurve(interpolator: Interpolator, points: Seq[Vector2]) {

  val sortedPoints = points.sortWith { (a, b) => a._1 < b._1 }
  val reverseSorted = sortedPoints.reverse

  val max: Vector2 = sortedPoints.lastOption.getOrElse(Vector2.zero)
  val min: Vector2 = sortedPoints.headOption.getOrElse(Vector2.zero)
  val hasPoints = !points.isEmpty
  private val stepInterp = Interpolation.interp(interpolator)
  lazy val isUnit = max == Vector2.one && min == Vector2.zero && !points.exists(p => p._2<0 || p._2>1)

  def interp(x: Double): Double =
    if (x>=max.x) max.y else if (x<=min.x) min.y else {
      val endIdx = sortedPoints.indexWhere(x <= _.x)
      val start = sortedPoints(endIdx-1)
      val end = sortedPoints(endIdx)
      val progress = (x - start.x) / (end.x - start.x)
      stepInterp(progress, start.y, end.y)
    }
}

@JSExportAll
object InterpCurve {
  def linear(points: Seq[Vector2]) = InterpCurve(identity, points)
  def linearUnit = InterpCurve(identity, List(Vector2.zero, Vector2.one))
}