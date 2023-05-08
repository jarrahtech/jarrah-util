package com.jarrahtechnology.util
 
import org.scalatest.funsuite.AnyFunSuite

import com.jarrahtechnology.util.Interpolation.*

class InterpolationTest extends AnyFunSuite {

  test("testLerp") {
    assert(math.abs(0.5d- lerp(0.5, 0, 1))< 0.000000001d, "a")
    assert(math.abs(0d- lerp(0, 0, 1))< 0.000000001d, "b")
    assert(math.abs(1d- lerp(1, 0, 1))< 0.000000001d, "c")
    assert(math.abs(0d- lerp(-1, 0, 1))< 0.000000001d, "d")
    assert(math.abs(1d- lerp(2.5, 0, 1))< 0.000000001d, "e")
    assert(math.abs(3d- lerp(0.2, 2, 7))< 0.000000001d, "f")
    assert(math.abs(0.52d- lerp(0.2, -2.2, 11.4))< 0.000000001d, "g")
  }
  
}
