package com.jarrahtechnology.util

import scala.scalajs.js.annotation._

@JSExportTopLevel("Vector3")
final case class Vector3(x: Double, y: Double, z: Double) {

  @JSExport def magnitude: Double = x * x + y * y + z * z
  @JSExport def sqrDistance(other: Vector3): Double = subtract(other).magnitude
  @JSExport def distance(other: Vector3): Double = math.sqrt(sqrDistance(other))
  @JSExport def multiply(that: Double): Vector3 = Vector3(x * that, y * that, z * that)
  @JSExport def op(fn: Double => Double): Vector3 = Vector3(fn(x), fn(y), fn(z))
  @JSExport def map[T](fn: Double => T): List[T] = toList map fn
  @JSExport def divide(that: Double): Vector3 = Vector3(x / that, y / that, z / that)
  @JSExport def dot(that: Vector3): Double = x * that.x + y * that.y + z * that.z
  @JSExport def cross(that: Vector3): Vector3 = Vector3(y * that.z - z * that.y, z * that.x - x * that.z, x * that.y - y * that.x)
  @JSExport def add(that: Vector3): Vector3 = Vector3(x + that.x, y + that.y, z + that.z)
  @JSExport def subtract(that: Vector3): Vector3 = Vector3(x - that.x, y - that.y, z - that.z)
  @JSExport def negate: Vector3 = Vector3(-x, -y, -z)
  @JSExport def originDistance: Double = math.sqrt(magnitude)
  @JSExport def normalized: Vector3 = divide(originDistance)
  @JSExport def lerp(end: Vector3, fraction: Double): Vector3 = Vector3(x + (end.x - x) * fraction, y + (end.y - y) * fraction, z + (end.z - z) * fraction)
  @JSExport def toList: List[Double] = List(x, y, z)
  @JSExport def toTuple: (Double, Double, Double) = (x, y, z)
  @JSExport def toFloor = Vector3(math.floor(x), math.floor(y), math.floor(z))
}

@JSExportTopLevel("V3")
object Vector3 {
  @JSExport val zero = Vector3(0, 0, 0)
  @JSExport val origin = Vector3.zero
  @JSExport val one = Vector3(1, 1, 1)

  @JSExport def sqrDistance(a: Vector3, b: Vector3): Double = a.sqrDistance(b)
  @JSExport def distance(a: Vector3, b: Vector3): Double = a.distance(b)

  def apply(l: List[Double]): Vector3 = {
    require(l.size>=3, "size>=3")
    Vector3(l(0), l(1), l(2))
  }
  def apply(t: (Double, Double, Double)): Vector3 = Vector3(t._1, t._2, t._3)
}
