package com.jarrahtechnology.util

import org.scalatest.funsuite.AnyFunSuite

class Vector2Test extends AnyFunSuite {
  
  test("testOrigin") {
    assert(Vector2(0,0) == Vector2.zero)
    assert(Vector2(0,0) == Vector2.origin)
    assert(Vector2(1,1) == Vector2.one)
  }
  
  test("testMagnitude") {
    assert(Vector2(0,0).magnitude == 0, 0)
    assert(Vector2(1,1).magnitude == 2, 0)
    assert(Vector2(1,2).magnitude == 5, 0)
    assert(Vector2(1,-2).magnitude == 5, 0)
  }
  
  test("testDistance") {
    assert(Vector2.zero.distance(Vector2.zero) == 0, 0)
    assert(Vector2.zero.distance(Vector2.one) == math.sqrt(2), 0)
    assert(Vector2.one.distance(Vector2.one) == 0, 0)
    
    assert(Vector2(3, 4).distance(Vector2(4,9)) == math.sqrt(26), 0)
    assert(Vector2(4,9).distance(Vector2(3, 4)) == math.sqrt(26), 0)
  }

  test("testObjectDistance") {
    assert(Vector2.distance(Vector2.zero, Vector2.zero) == 0, 0)
    assert(Vector2.distance(Vector2.zero, Vector2.one) == math.sqrt(2), 0)
    assert(Vector2.distance(Vector2.one, Vector2.one) == 0, 0)   
    assert(Vector2.distance(Vector2(3, 4), Vector2(4,9)) == math.sqrt(26), 0)
    assert(Vector2.distance(Vector2(4,9), Vector2(3, 4)) == math.sqrt(26), 0)

    assert(Vector2.sqrDistance(Vector2.zero, Vector2.one) == 2, 0)
  }

  test("testToFloor") {
    assert(Vector2.zero.toFloor == Vector2.zero)
    assert(Vector2(2, 2).toFloor == Vector2(2, 2))
    assert(Vector2(23.8, 67.98765).toFloor == Vector2(23, 67))
    assert(Vector2(-2.76, 0.786).toFloor == Vector2(-3, 0))
  }

  test("testToInt") {
    assert(Vector2.zero.toInt(_.toInt) == IntVector2(0, 0))
    assert(Vector2(23.8, 67.98765).toInt(math.floor(_).toInt) == IntVector2(23, 67))
    assert(Vector2(23.8, 67.98765).toInt(math.ceil(_).toInt) == IntVector2(24, 68))
  }
  
  test("testMult") {
    assert(Vector2.zero.multiply(2) == Vector2.zero)
    assert(Vector2.one.multiply(0) == Vector2.zero)
    assert(Vector2.one.multiply(1) == Vector2.one)
    assert(Vector2.one.multiply(2) == Vector2(2, 2))
    assert((Vector2(2, -5) multiply 3) == Vector2(6, -15))
  }
  
  test("testMultFn") {
    assert(Vector2.zero.op(_ * 2) == Vector2.zero)
    assert(Vector2.one.op(_ * 2) == Vector2(2, 2))
    assert(Vector2.one.op(_ - 1) == Vector2.zero)
    assert(Vector2(3, 3).op(_ + 2) == Vector2(5, 5))
    assert((Vector2(-5, 5) op (d => math.abs(d))) == Vector2(5, 5))
  }
  
  test("testMap") {
    assert(Vector2.zero.map(_ * 2) == List(0, 0))
    assert(Vector2.one.map(_ * 2) == List(2, 2))
    assert(Vector2.one.map(_ - 1) == List(0, 0))
    assert(Vector2(3, 3).map(_ + 2) == List(5, 5))
    assert(Vector2(-5, 5).map(d => math.abs(d)) == List(5, 5))
  }
  
  test("testDivide") {
    assert(Vector2.zero.divide(2) == Vector2.zero)
    assert(Vector2.one.divide(0) == Vector2(Double.PositiveInfinity, Double.PositiveInfinity))
    assert(Vector2.one.divide(1) == Vector2.one)
    assert(Vector2.one.divide(2) == Vector2(0.5, 0.5))
    assert((Vector2(4, -8) divide 2) == Vector2(2, -4))
  }
  
  test("testPlus") {
    assert((Vector2.zero addPiecewise Vector2.zero) == Vector2.zero)
    assert((Vector2.zero addPiecewise Vector2.one) == Vector2.one)
    assert((Vector2.one addPiecewise Vector2.one) == Vector2(2, 2))
    assert((Vector2.one addPiecewise Vector2(3, -7)) == Vector2(4, -6))
  }

  test("addToAll") {
    assert((Vector2.zero addToAll 0) == Vector2.zero)
    assert((Vector2.zero addToAll 1) == Vector2.one)
    assert((Vector2.one addToAll -1) == Vector2.zero)
    assert((Vector2.one addToAll 24) == Vector2(25, 25))
    assert((Vector2(3,5) addToAll 4) == Vector2(7, 9))
  }
  
  test("testNegative") {
    assert(Vector2.zero.negate == Vector2.zero)
    assert(Vector2.one.negate == Vector2(-1, -1))
    assert(Vector2(-1, -1).negate == Vector2.one)
    assert(Vector2(3, 5).negate == Vector2(-3, -5))
  }
  
  test("testMinus") {
    assert((Vector2.zero subtractPiecewise Vector2.zero) == Vector2.zero)
    assert((Vector2.zero subtractPiecewise Vector2.one) == Vector2.one.negate)
    assert((Vector2.one subtractPiecewise Vector2.one) == Vector2.zero)
    assert((Vector2.one subtractPiecewise Vector2(3, -7)) == Vector2(-2, 8))
  }
  
  test("testDot") {
    assert(Vector2.zero.dot(Vector2.zero) == 0, 0)
    assert(Vector2.zero.dot(Vector2.one) == 0, 0)
    assert(Vector2.one.dot(Vector2.zero) == 0, 0)
    assert(Vector2.one.dot(Vector2.one) ==  2, 0)
    assert(Vector2(1, -5).dot(Vector2(4, -1)) == 9, 0)
  }
  
  test("testCross") {
    assert(Vector2.zero.cross(Vector2.zero) == Vector2.zero)
    assert(Vector2.zero.cross(Vector2.one) == Vector2.zero)
    assert(Vector2.one.cross(Vector2.one) == Vector2(1, -1))
    assert(Vector2(1, 0).cross(Vector2(0, 1)) == Vector2(0, -1))
    assert(Vector2(3, -3).cross(Vector2(4, 9)) == Vector2(-3, -3))
  }
  
  test("testNormalise") {
    assert(Vector2.zero.normalized.x.isNaN)
    assert(Vector2.one.normalized == Vector2(1/math.sqrt(2), 1/math.sqrt(2)))
    assert(Vector2(1, 0).normalized == Vector2(1, 0))
    assert(Vector2(0, 1).normalized == Vector2(0, 1))
    assert(Vector2(0, -1).normalized == Vector2(0, -1))
    assert(Vector2(3, -2).normalized == Vector2(3/math.sqrt(13), -2/math.sqrt(13)))
  }
  
  test("testLerp") {
    assert(Vector2.zero.lerp(Vector2.zero, 0) == Vector2.zero)
    assert(Vector2.zero.lerp(Vector2.zero, 0.5) == Vector2.zero)
    assert(Vector2.zero.lerp(Vector2.zero, 1) == Vector2.zero)
    
    assert(Vector2.zero.lerp(Vector2.one, 0) == Vector2.zero)
    assert(Vector2.zero.lerp(Vector2.one, 0.5) == Vector2(0.5, 0.5))
    assert(Vector2.zero.lerp(Vector2.one, 1) == Vector2.one)
    
    assert(Vector2(2, -4).lerp(Vector2(3, 6), 0.25) == Vector2(2.25, -1.5))
  }
  
  test("testConversions") {
    assert(Vector2.fromTuple((0d, 0d)) == Vector2.zero)
    assert(Vector2.fromList(List(0d, 0d)) == Vector2.zero)
    assert(Vector2.zero.toTuple == (0d, 0d))
    assert(List(0d, 0d) == Vector2.zero.toList)
  }
  
}