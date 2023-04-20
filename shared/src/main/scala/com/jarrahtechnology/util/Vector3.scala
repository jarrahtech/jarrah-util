package com.jarrahtechnology.util

import scala.scalajs.js.annotation._

@JSExportAll
final case class Vector3(x: Double, y: Double, z: Double) {
  def magnitude: Double = x * x + y * y + z * z
  def sqrDistance(other: Vector3): Double = subtract(other).magnitude
  def distance(other: Vector3): Double = math.sqrt(sqrDistance(other))
  def multiply(that: Double): Vector3 = Vector3(x * that, y * that, z * that)
  def op(fn: Double => Double): Vector3 = Vector3(fn(x), fn(y), fn(z))
  def map[T](fn: Double => T): List[T] = toList map fn
  def divide(that: Double): Vector3 = Vector3(x / that, y / that, z / that)
  def dot(that: Vector3): Double = x * that.x + y * that.y + z * that.z
  def cross(that: Vector3): Vector3 = Vector3(y * that.z - z * that.y, z * that.x - x * that.z, x * that.y - y * that.x)
  def add(that: Vector3): Vector3 = Vector3(x + that.x, y + that.y, z + that.z)
  def subtract(that: Vector3): Vector3 = Vector3(x - that.x, y - that.y, z - that.z)
  def negate: Vector3 = Vector3(-x, -y, -z)
  def originDistance: Double = math.sqrt(magnitude)
  def normalized: Vector3 = divide(originDistance)
  def lerp(end: Vector3, fraction: Double): Vector3 = Vector3(x + (end.x - x) * fraction, y + (end.y - y) * fraction, z + (end.z - z) * fraction)
  def toList: List[Double] = List(x, y, z)
  def toTuple: (Double, Double, Double) = (x, y, z)
  def toFloor = Vector3(math.floor(x), math.floor(y), math.floor(z))
}

@JSExportAll
object Vector3 {
  val zero = Vector3(0, 0, 0)
  val origin = Vector3.zero
  val one = Vector3(1, 1, 1)

  def sqrDistance(a: Vector3, b: Vector3): Double = a.sqrDistance(b)
  def distance(a: Vector3, b: Vector3): Double = a.distance(b)

  def fromList(l: List[Double]): Vector3 = {
    require(l.size>=3, "size>=3")
    Vector3(l(0), l(1), l(2))
  }
  def fromTuple(t: (Double, Double, Double)): Vector3 = Vector3(t._1, t._2, t._3)
}
