package com.jarrahtechnology.util

import scala.scalajs.js.annotation.*

@JSExportAll
final case class Vector2(x: Double, y: Double) {
  def magnitude: Double = x * x + y * y
  def sqrDistance(other: Vector2): Double = subtractPiecewise(other).magnitude
  def distance(other: Vector2): Double = math.sqrt(sqrDistance(other))
  def multiply(that: Double): Vector2 = Vector2(x * that, y * that)
  def op(fn: Double => Double): Vector2 = Vector2(fn(x), fn(y))
  def map[T](fn: Double => T): List[T] = toList map fn
  def divide(that: Double): Vector2 = Vector2(x / that, y / that)
  def dot(that: Vector2): Double = x * that.x + y * that.y
  def cross(that: Vector2): Vector2 = Vector2(y, -x)
  def addToAll(that: Double): Vector2 = Vector2(x + that, y + that)
  def addPiecewise(that: Vector2): Vector2 = Vector2(x + that.x, y + that.y)
  def subtractPiecewise(that: Vector2): Vector2 = Vector2(x - that.x, y - that.y)
  def negate: Vector2 = Vector2(-x, -y)
  def normalized: Vector2 = divide(math.sqrt(magnitude))
  def lerp(end: Vector2, fraction: Double): Vector2 = Vector2(x + (end.x - x) * fraction, y + (end.y - y) * fraction)
  def toList: List[Double] = List(x, y)
  def toTuple: (Double, Double) = (x, y)
  def toFloor = Vector2(math.floor(x), math.floor(y))
  def toInt(fn: Double => Int): IntVector2 = IntVector2(fn(x), fn(y))
}

// convenience class so you can still use x & y accessors after mapping to Ints (rather than using a List) 
final case class IntVector2(x: Int, y: Int) { }

@JSExportAll
object Vector2 {
  val zero = Vector2(0, 0)
  val origin = Vector2.zero
  val one = Vector2(1, 1)
  val up = Vector2(0, 1)
  val down = Vector2(0, -1)
  val right = Vector2(1, 0)
  val left = Vector2(-1, 0)

  def sqrDistance(a: Vector2, b: Vector2): Double = a.sqrDistance(b)
  def distance(a: Vector2, b: Vector2): Double = a.distance(b)

  def fromList(l: List[Double]): Vector2 = {
    require(l.size>=2, "size>=2")
    Vector2(l(0), l(1))
  }
  def fromTuple(t: (Double, Double)): Vector2 = Vector2(t._1, t._2)
}
