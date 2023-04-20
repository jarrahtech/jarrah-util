package com.jarrahtechnology.util
 
import org.scalatest.funsuite.AnyFunSuite

import com.jarrahtechnology.util.Math.*

class MathTest extends AnyFunSuite {

  test("testClamp") {
    assert(math.abs(2d - clamp(2d, 1, 10))< 0.000000001d)
    assert(math.abs(1d- clamp(-2d, 1, 10))< 0.000000001d)
    assert(math.abs(1d- clamp(0, 1, 10))< 0.000000001d)
    assert(math.abs(10d- clamp(22, 1, 10))< 0.000000001d)
    assert(clamp(-10, 1, 10)==1)

    assert(math.abs(10d- clamp(10d, 0.25, 11.6))< 0.000000001d)
    assert(math.abs(0.25d- clamp(0.23, 0.25, 11.6))< 0.000000001d)
    assert(math.abs(11.6- clamp(365767.764567d, 0.25, 11.6))< 0.000000001d)
  }

  test("testClamp01") {
    assert(math.abs(0.2d- clamp01(0.2d))< 0.000000001d)
    assert(math.abs(0d- clamp01(0))< 0.000000001d)
    assert(math.abs(0d- clamp01(-0.67d))< 0.000000001d)
    assert(math.abs(1d- clamp01(22))< 0.000000001d)
    assert(math.abs(1d- clamp01(1))< 0.000000001d)
    assert(math.abs(1d- clamp01(1.000003))< 0.000000001d)
  }

  test("testLerp") {
    assert(math.abs(0.5d- lerp(0.5, 0, 1))< 0.000000001d)
    assert(math.abs(0d- lerp(0, 0, 1))< 0.000000001d)
    assert(math.abs(1d- lerp(1, 0, 1))< 0.000000001d)
    assert(math.abs(-1d- lerp(-1, 0, 1))< 0.000000001d)
    assert(math.abs(2.5d- lerp(2.5, 0, 1))< 0.000000001d)
    assert(math.abs(3d- lerp(0.2, 2, 7))< 0.000000001d)
    assert(math.abs(0.52d- lerp(0.2, -2.2, 11.4))< 0.000000001d)
  }

  test("testTruncate") {
    assert(math.abs(0.3333- truncate(4)(1/3d))< 0.0000000000000001)
    assert(math.abs(2.3333- truncate(4)(2.3333))< 0.0000000000000001)
    assert(math.abs(3- truncate(4)(2.999999))< 0.0000000000000001)
  }
 
}
