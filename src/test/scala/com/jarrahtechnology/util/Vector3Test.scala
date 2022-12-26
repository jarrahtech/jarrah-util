package com.jarrahtechnology.util

import org.junit.Assert.assertEquals
import org.junit.Test

import junit.framework.TestCase

class Vector3Test extends TestCase {
  
  @Test def testOrigin: Unit =  {
    assertEquals(Vector3(0,0,0), Vector3.origin)
    assertEquals(Vector3(0,0,0), Vector3.zero)
    assertEquals(Vector3(1,1,1), Vector3.one)
  }
  
  @Test def testMagnitude: Unit =  {
    assertEquals(Vector3(0,0,0).magnitude, 0, 0)
    assertEquals(Vector3(1,1,1).magnitude, 3, 0)
    assertEquals(Vector3(1,2,3).magnitude, 14, 0)
    assertEquals(Vector3(1,-2,-3).magnitude, 14, 0)
  }
  
  @Test def testDistance: Unit =  {
    assertEquals(Vector3.zero.distance(Vector3.zero), 0, 0)
    assertEquals(Vector3.zero.distance(Vector3.one), math.sqrt(3), 0)
    assertEquals(Vector3.one.distance(Vector3.one), 0, 0)
    
    assertEquals(Vector3(3, 4, 5).distance(Vector3(4,9,3)), math.sqrt(30), 0)
    assertEquals(Vector3(4,9,3).distance(Vector3(3, 4, 5)), math.sqrt(30), 0)
  }

  @Test def testObjectDistance: Unit =  {
    assertEquals(Vector3.distance(Vector3.zero, Vector3.zero), 0, 0)
    assertEquals(Vector3.distance(Vector3.zero, Vector3.one), math.sqrt(3), 0)
    assertEquals(Vector3.distance(Vector3.one, Vector3.one), 0, 0)   
    assertEquals(Vector3.distance(Vector3(3, 4, 5), Vector3(4,9, 3)), math.sqrt(30), 0)
    assertEquals(Vector3.distance(Vector3(4,9,3), Vector3(3, 4,5)), math.sqrt(30), 0)

    assertEquals(Vector3.sqrDistance(Vector3.zero, Vector3.one), 3, 0)
  }

  @Test def testToFloor: Unit =  {
    assertEquals(Vector3.zero.toFloor, Vector3.zero)
    assertEquals(Vector3(2, 2, 2).toFloor, Vector3(2, 2, 2))
    assertEquals(Vector3(23.8, 67.98765, 765.97).toFloor, Vector3(23, 67, 765))
    assertEquals(Vector3(-2.76, 0.786, -7.87).toFloor, Vector3(-3, 0, -8))
  }
  
  @Test def testMult: Unit =  {
    assertEquals(Vector3.zero.multiply(2), Vector3.zero)
    assertEquals(Vector3.one.multiply(0), Vector3.zero)
    assertEquals(Vector3.one.multiply(1), Vector3.one)
    assertEquals(Vector3.one.multiply(2), Vector3(2, 2, 2))
    assertEquals(Vector3(2, -5, 5) multiply 3, Vector3(6, -15, 15))
  }
  
  @Test def testMultFn: Unit =  {
    assertEquals(Vector3.zero.op(_ * 2), Vector3.zero)
    assertEquals(Vector3.one.op(_ * 2), Vector3(2, 2, 2))
    assertEquals(Vector3.one.op(_ - 1), Vector3.zero)
    assertEquals(Vector3(3, 3, 3).op(_ + 2), Vector3(5, 5, 5))
    assertEquals(Vector3(-2, -5, 5) op (d => math.abs(d)), Vector3(2, 5, 5))
  }
  
  @Test def testMap: Unit =  {
    assertEquals(Vector3.zero.map(_ * 2), List(0, 0, 0))
    assertEquals(Vector3.one.map(_ * 2), List(2, 2, 2))
    assertEquals(Vector3.one.map(_ - 1), List(0, 0, 0))
    assertEquals(Vector3(2, 3, 3).map(_ + 2), List(4, 5, 5))
    assertEquals(Vector3(-2, -5, 5).map(d => math.abs(d)), List(2, 5, 5))
  }
  
  @Test def testDivide: Unit =  {
    assertEquals(Vector3.zero.divide(2), Vector3.zero)
    assertEquals(Vector3.one.divide(0), Vector3(Double.PositiveInfinity, Double.PositiveInfinity, Double.PositiveInfinity))
    assertEquals(Vector3.one.divide(1), Vector3.one)
    assertEquals(Vector3.one.divide(2), Vector3(0.5, 0.5, 0.5))
    assertEquals(Vector3(4, -8, 2) divide 2, Vector3(2, -4, 1))
  }
  
  @Test def testPlus: Unit =  {
    assertEquals(Vector3.zero add Vector3.zero, Vector3.zero)
    assertEquals(Vector3.zero add Vector3.one, Vector3.one)
    assertEquals(Vector3.one add Vector3.one, Vector3(2, 2, 2))
    assertEquals(Vector3.one add Vector3(3, 5, -7), Vector3(4, 6, -6))
  }
  
  @Test def testNegative: Unit =  {
    assertEquals(Vector3.zero.negate, Vector3.zero)
    assertEquals(Vector3.one.negate, Vector3(-1, -1, -1))
    assertEquals(Vector3(-1, -1, -1).negate, Vector3.one)
    assertEquals(Vector3(3, 5, -7).negate, Vector3(-3, -5, 7))
  }
  
  @Test def testMinus: Unit =  {
    assertEquals(Vector3.zero subtract Vector3.zero, Vector3.zero)
    assertEquals(Vector3.zero subtract Vector3.one, Vector3.one.negate)
    assertEquals(Vector3.one subtract Vector3.one, Vector3.zero)
    assertEquals(Vector3.one subtract Vector3(3, 5, -7), Vector3(-2, -4, 8))
  }
  
  @Test def testDot: Unit =  {
    assertEquals(Vector3.zero.dot(Vector3.zero), 0, 0)
    assertEquals(Vector3.zero.dot(Vector3.one), 0, 0)
    assertEquals(Vector3.one.dot(Vector3.zero), 0, 0)
    assertEquals(Vector3.one.dot(Vector3.one), 3, 0)
    assertEquals(Vector3(1, 3, -5).dot(Vector3(4, -2, -1)), 3, 0)
  }
  
  @Test def testCross: Unit =  {
    assertEquals(Vector3.zero.cross(Vector3.zero), Vector3.zero)
    assertEquals(Vector3.zero.cross(Vector3.one), Vector3.zero)
    assertEquals(Vector3.one.cross(Vector3.one), Vector3.zero)
    assertEquals(Vector3(1, 0, 0).cross(Vector3(0, 1, 0)), Vector3(0, 0, 1))
    assertEquals(Vector3(3, -3, 1).cross(Vector3(4, 9, 2)), Vector3(-15, -2, 39))
  }
  
  @Test def testNormalise: Unit =  {
    assertEquals(Vector3.zero.normalized.x, Double.NaN, 0)
    assertEquals(Vector3.one.normalized, Vector3(1/math.sqrt(3), 1/math.sqrt(3), 1/math.sqrt(3)))
    assertEquals(Vector3(1, 0, 0).normalized, Vector3(1, 0, 0))
    assertEquals(Vector3(0, 0, 1).normalized, Vector3(0, 0, 1))
    assertEquals(Vector3(0, 0, -1).normalized, Vector3(0, 0, -1))
    assertEquals(Vector3(3, 1, -2).normalized, Vector3(3/math.sqrt(14), 1/math.sqrt(14), -2/math.sqrt(14)))
  }
  
  @Test def testLerp: Unit =  {
    assertEquals(Vector3.zero.lerp(Vector3.zero, 0), Vector3.zero)
    assertEquals(Vector3.zero.lerp(Vector3.zero, 0.5), Vector3.zero)
    assertEquals(Vector3.zero.lerp(Vector3.zero, 1), Vector3.zero)
    
    assertEquals(Vector3.zero.lerp(Vector3.one, 0), Vector3.zero)
    assertEquals(Vector3.zero.lerp(Vector3.one, 0.5), Vector3(0.5, 0.5, 0.5))
    assertEquals(Vector3.zero.lerp(Vector3.one, 1), Vector3.one)
    
    assertEquals(Vector3(2, -4, 6).lerp(Vector3(3, 6, 10), 0.25), Vector3(2.25, -1.5, 7))
  }
  
  @Test def testConversions: Unit =  {
    assertEquals(Vector3((0d, 0d, 0d)), Vector3.zero)
    assertEquals(Vector3(List(0d, 0d, 0d)), Vector3.zero)
    assertEquals(Vector3.zero.toTuple, (0d, 0d, 0d))
    assertEquals(List(0d, 0d, 0d), Vector3.zero.toList)
  }
  
}