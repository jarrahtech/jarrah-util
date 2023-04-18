package com.jarrahtechnology.util

import org.scalatest.funsuite.AnyFunSuite

class LinearInterpPointsTest extends AnyFunSuite {

  val ig = LinearInterpPoints(List(Vector2(0, 4),Vector2(0.1, 0.5),Vector2(1, 0.1),Vector2(5, 0.05)))
  
  test("testPoints") {    
    assert(4 == ig.interp(0))
    assert(0.5 == ig.interp(0.1))  
    assert(math.abs(0.1 - ig.interp(1))<0.0000001)  
    assert(math.abs(0.05 - ig.interp(5))<0.0000001)
  }
    
  test("testExtrap") { 
    assert(0.05 == ig.interp(6))
    assert(4 == ig.interp(-1))
  }
    
  test("testInterp") { 
    assert(math.abs(0.0765 - ig.interp(2.88))< 0.001)
    assert(math.abs(2.25 - ig.interp(0.05))< 0.001)
    assert(math.abs(0.1888 - ig.interp(0.8))< 0.001)
  }
  
  test("testHasPoints") { 
    assert(ig.hasPoints)
    assert(!LinearInterpPoints(List.empty).hasPoints)
  }
  
  test("testMin") { 
    assert(Vector2(0, 4) == ig.min)
    assert(Vector2(0, 0) == LinearInterpPoints(List.empty).min)
  }
  
  test("testMax") { 
    assert(Vector2(5, 0.05) == ig.max)
    assert(Vector2(0, 0) == LinearInterpPoints(List.empty).max)
  }
  
}