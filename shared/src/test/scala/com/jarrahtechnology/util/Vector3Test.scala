package com.jarrahtechnology.util

import org.scalatest.funsuite.AnyFunSuite

class Vector3Test extends AnyFunSuite {
  
  test("testOrigin") {
    assert(Vector3(0,0,0) == Vector3.origin)
    assert(Vector3(0,0,0) == Vector3.zero)
    assert(Vector3(1,1,1) == Vector3.one)
  }
  
  test("testMagnitude") {
    assert(Vector3(0,0,0).magnitude == 0, 0)
    assert(Vector3(1,1,1).magnitude == 3, 0)
    assert(Vector3(1,2,3).magnitude == 14, 0)
    assert(Vector3(1,-2,-3).magnitude == 14, 0)
  }
  
  test("testDistance") {
    assert(Vector3.zero.distance(Vector3.zero) == 0, 0)
    assert(Vector3.zero.distance(Vector3.one) == math.sqrt(3), 0)
    assert(Vector3.one.distance(Vector3.one) == 0, 0)
    
    assert(Vector3(3, 4, 5).distance(Vector3(4,9,3)) == math.sqrt(30), 0)
    assert(Vector3(4,9,3).distance(Vector3(3, 4, 5)) == math.sqrt(30), 0)
  }

  test("testObjectDistance") {
    assert(Vector3.distance(Vector3.zero, Vector3.zero) == 0, 0)
    assert(Vector3.distance(Vector3.zero, Vector3.one) == math.sqrt(3), 0)
    assert(Vector3.distance(Vector3.one, Vector3.one) == 0, 0)   
    assert(Vector3.distance(Vector3(3, 4, 5), Vector3(4,9, 3)) == math.sqrt(30), 0)
    assert(Vector3.distance(Vector3(4,9,3), Vector3(3, 4,5)) == math.sqrt(30), 0)

    assert(Vector3.sqrDistance(Vector3.zero, Vector3.one) == 3, 0)
  }

  test("testToFloor") {
    assert(Vector3.zero.toFloor == Vector3.zero)
    assert(Vector3(2, 2, 2).toFloor == Vector3(2, 2, 2))
    assert(Vector3(23.8, 67.98765, 765.97).toFloor == Vector3(23, 67, 765))
    assert(Vector3(-2.76, 0.786, -7.87).toFloor == Vector3(-3, 0, -8))
  }
  
  test("testMult") {
    assert(Vector3.zero.multiply(2) == Vector3.zero)
    assert(Vector3.one.multiply(0) == Vector3.zero)
    assert(Vector3.one.multiply(1) == Vector3.one)
    assert(Vector3.one.multiply(2) == Vector3(2, 2, 2))
    assert((Vector3(2, -5, 5) multiply 3) == Vector3(6, -15, 15))
  }
  
  test("testMultFn") {
    assert(Vector3.zero.op(_ * 2) == Vector3.zero)
    assert(Vector3.one.op(_ * 2) == Vector3(2, 2, 2))
    assert(Vector3.one.op(_ - 1) == Vector3.zero)
    assert(Vector3(3, 3, 3).op(_ + 2) == Vector3(5, 5, 5))
    assert((Vector3(-2, -5, 5) op (d => math.abs(d))) == Vector3(2, 5, 5))
  }
  
  test("testMap") {
    assert(Vector3.zero.map(_ * 2) == List(0, 0, 0))
    assert(Vector3.one.map(_ * 2) == List(2, 2, 2))
    assert(Vector3.one.map(_ - 1) == List(0, 0, 0))
    assert(Vector3(2, 3, 3).map(_ + 2) == List(4, 5, 5))
    assert((Vector3(-2, -5, 5).map(d => math.abs(d))) == List(2, 5, 5))
  }
  
  test("testDivide") {
    assert(Vector3.zero.divide(2) == Vector3.zero)
    assert(Vector3.one.divide(0) == Vector3(Double.PositiveInfinity, Double.PositiveInfinity, Double.PositiveInfinity))
    assert(Vector3.one.divide(1) == Vector3.one)
    assert(Vector3.one.divide(2) == Vector3(0.5, 0.5, 0.5))
    assert((Vector3(4, -8, 2) divide 2) == Vector3(2, -4, 1))
  }
  
  test("testPlus") {
    assert((Vector3.zero addPiecewise Vector3.zero) == Vector3.zero)
    assert((Vector3.zero addPiecewise Vector3.one) == Vector3.one)
    assert((Vector3.one addPiecewise Vector3.one) == Vector3(2, 2, 2))
    assert((Vector3.one addPiecewise Vector3(3, 5, -7)) == Vector3(4, 6, -6))
  }

  test("addToAll") {
    assert((Vector3.zero addToAll 0) == Vector3.zero)
    assert((Vector3.zero addToAll 1) == Vector3.one)
    assert((Vector3.one addToAll -1) == Vector3.zero)
    assert((Vector3.one addToAll 24) == Vector3(25, 25, 25))
    assert((Vector3(3,5, -4) addToAll 4) == Vector3(7, 9, 0))
  }
  
  test("testNegative") {
    assert(Vector3.zero.negate == Vector3.zero)
    assert(Vector3.one.negate == Vector3(-1, -1, -1))
    assert(Vector3(-1, -1, -1).negate == Vector3.one)
    assert(Vector3(3, 5, -7).negate == Vector3(-3, -5, 7))
  }
  
  test("testMinus") {
    assert((Vector3.zero subtractPiecewise Vector3.zero) == Vector3.zero)
    assert((Vector3.zero subtractPiecewise Vector3.one) == Vector3.one.negate)
    assert((Vector3.one subtractPiecewise Vector3.one) == Vector3.zero)
    assert((Vector3.one subtractPiecewise Vector3(3, 5, -7)) == Vector3(-2, -4, 8))
  }
  
  test("testDot") {
    assert(Vector3.zero.dot(Vector3.zero) == 0, 0)
    assert(Vector3.zero.dot(Vector3.one) == 0, 0)
    assert(Vector3.one.dot(Vector3.zero) == 0, 0)
    assert(Vector3.one.dot(Vector3.one) == 3, 0)
    assert(Vector3(1, 3, -5).dot(Vector3(4, -2, -1)) == 3, 0)
  }
  
  test("testCross") {
    assert(Vector3.zero.cross(Vector3.zero) == Vector3.zero)
    assert(Vector3.zero.cross(Vector3.one) == Vector3.zero)
    assert(Vector3.one.cross(Vector3.one) == Vector3.zero)
    assert(Vector3(1, 0, 0).cross(Vector3(0, 1, 0)) == Vector3(0, 0, 1))
    assert(Vector3(3, -3, 1).cross(Vector3(4, 9, 2)) == Vector3(-15, -2, 39))
  }
  
  test("testNormalise") {
    assert(Vector3.zero.normalized.x.isNaN)
    assert(Vector3.one.normalized == Vector3(1/math.sqrt(3), 1/math.sqrt(3), 1/math.sqrt(3)))
    assert(Vector3(1, 0, 0).normalized == Vector3(1, 0, 0))
    assert(Vector3(0, 0, 1).normalized == Vector3(0, 0, 1))
    assert(Vector3(0, 0, -1).normalized == Vector3(0, 0, -1))
    assert(Vector3(3, 1, -2).normalized == Vector3(3/math.sqrt(14), 1/math.sqrt(14), -2/math.sqrt(14)))
  }
  
  test("testLerp") {
    assert(Vector3.zero.lerp(Vector3.zero, 0) == Vector3.zero)
    assert(Vector3.zero.lerp(Vector3.zero, 0.5) == Vector3.zero)
    assert(Vector3.zero.lerp(Vector3.zero, 1) == Vector3.zero)
    
    assert(Vector3.zero.lerp(Vector3.one, 0) == Vector3.zero)
    assert(Vector3.zero.lerp(Vector3.one, 0.5) == Vector3(0.5, 0.5, 0.5))
    assert(Vector3.zero.lerp(Vector3.one, 1) == Vector3.one)
    
    assert(Vector3(2, -4, 6).lerp(Vector3(3, 6, 10), 0.25) == Vector3(2.25, -1.5, 7))
  }
  
  test("testConversions") {
    assert(Vector3.fromTuple((0d, 0d, 0d)) == Vector3.zero)
    assert(Vector3.fromList(List(0d, 0d, 0d)) == Vector3.zero)
    assert(Vector3.fromList(List(1d, 0d, 0d, 2d)) == Vector3(1, 0, 0))
    assert(Vector3.zero.toTuple == (0d, 0d, 0d))
    assert(List(0d, 0d, 0d) == Vector3.zero.toList)
  }

  test("testConversion fail") {
    assertThrows[IllegalArgumentException] {
      Vector3.fromList(List(0d, 0d))
    }
  }
}