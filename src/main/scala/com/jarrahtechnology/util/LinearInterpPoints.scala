package com.jarrahtechnology.util

case class LinearInterpPoints(points: Seq[Vector2]) {

  val sortedPoints = points.sortWith { (a, b) => a._1 < b._1 }
  val reverseSorted = sortedPoints.reverse

  val max: Vector2 = sortedPoints.lastOption.getOrElse(Vector2.zero)
  val min: Vector2 = sortedPoints.headOption.getOrElse(Vector2.zero)
  val hasPoints = !points.isEmpty

  private def lerp(x: Double, start: Vector2, end: Vector2): Double =
    start.y + (end.y - start.y) * (x - start.x) / (end.x - start.x)

  def interp(x: Double): Double =
    if (x>=max.x) max.y else if (x<=min.x) min.y else {
      val endIdx = sortedPoints.indexWhere(x <= _.x)
      lerp(x, sortedPoints(endIdx-1), sortedPoints(endIdx))
    }

}
