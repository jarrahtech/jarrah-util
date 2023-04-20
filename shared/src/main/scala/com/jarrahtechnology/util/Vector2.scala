package com.jarrahtechnology.util

import scala.scalajs.js.annotation._

@JSExportTopLevel("Vector2")
final case class Vector2(x: Double, y: Double) {

  @JSExport def magnitude: Double = x * x + y * y
  @JSExport def sqrDistance(other: Vector2): Double = subtract(other).magnitude
  @JSExport def distance(other: Vector2): Double = math.sqrt(sqrDistance(other))
  @JSExport def multiply(that: Double): Vector2 = Vector2(x * that, y * that)
  @JSExport def op(fn: Double => Double): Vector2 = Vector2(fn(x), fn(y))
  @JSExport def map[T](fn: Double => T): List[T] = toList map fn
  @JSExport def divide(that: Double): Vector2 = Vector2(x / that, y / that)
  @JSExport def dot(that: Vector2): Double = x * that.x + y * that.y
  @JSExport def cross(that: Vector2): Vector2 = Vector2(y, -x)
  @JSExport def add(that: Vector2): Vector2 = Vector2(x + that.x, y + that.y)
  @JSExport def subtract(that: Vector2): Vector2 = Vector2(x - that.x, y - that.y)
  @JSExport def negate: Vector2 = Vector2(-x, -y)
  @JSExport def normalized: Vector2 = divide(math.sqrt(magnitude))
  @JSExport def lerp(end: Vector2, fraction: Double): Vector2 = Vector2(x + (end.x - x) * fraction, y + (end.y - y) * fraction)
  @JSExport def toList: List[Double] = List(x, y)
  @JSExport def toTuple: (Double, Double) = (x, y)
  @JSExport def toFloor = Vector2(math.floor(x), math.floor(y))
  @JSExport def toInt(fn: Double => Int): IntVector2 = IntVector2(fn(x), fn(y))
}

// convenience class so you can still use x & y accessors after mapping to Ints (rather than using a List) 
final case class IntVector2(x: Int, y: Int) { }

@JSExportTopLevel("V2")
object Vector2 {
  @JSExport val zero = Vector2(0, 0)
  @JSExport val origin = Vector2.zero
  @JSExport val one = Vector2(1, 1)
  @JSExport val up = Vector2(0, 1)
  @JSExport val down = Vector2(0, -1)
  @JSExport val right = Vector2(1, 0)
  @JSExport val left = Vector2(-1, 0)

  @JSExport def sqrDistance(a: Vector2, b: Vector2): Double = a.sqrDistance(b)
  @JSExport def distance(a: Vector2, b: Vector2): Double = a.distance(b)

  def apply(l: List[Double]): Vector2 = {
    require(l.size>=2, "size>=2")
    Vector2(l(0), l(1))
  }
  def apply(t: (Double, Double)): Vector2 = Vector2(t._1, t._2)
}
