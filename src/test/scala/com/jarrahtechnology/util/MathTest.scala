package com.jarrahtechnology.util

import org.scalatest.funsuite.AnyFunSuite

import com.jarrahtechnology.util.Math.*

class MathTest extends AnyFunSuite {
 
  test("testClamp") {
    assert(math.abs(2d - 2d.clamp(1, 10))< 0.000000001d)
    assert(math.abs(1d- -2d.clamp(1, 10))< 0.000000001d)
    assert(math.abs(1d- -0d.clamp(1, 10))< 0.000000001d)
    assert(math.abs(10d- 22d.clamp(1, 10))< 0.000000001d)
    assert(math.abs(10d- 10d.clamp(1, 10))< 0.000000001d)

    assert(math.abs(10d- 10d.clamp(0.25, 11.6))< 0.000000001d)
    assert(math.abs(0.25d- 0.23d.clamp(0.25, 11.6))< 0.000000001d)
    assert(math.abs(11.6- 365767.764567d.clamp(0.25, 11.6))< 0.000000001d)
  }

  test("testClamp01") {
    assert(math.abs(0.2d- 0.2d.clamp01)< 0.000000001d)
    assert(math.abs(0d- 0d.clamp01)< 0.000000001d)
    assert(math.abs(0d- -0.67d.clamp01)< 0.000000001d)
    assert(math.abs(1d- 22d.clamp01)< 0.000000001d)
    assert(math.abs(1d- 1d.clamp01)< 0.000000001d)
    assert(math.abs(1d- 1.000003.clamp01)< 0.000000001d)
  }

  test("testLog2") {
    assert(math.abs(0.3010299956639812d - log2base10)< 0.000000001d)
    assert(math.abs(1d- log2(2))< 0.000000001d)
    assert(log2(-2).isNaN)
    assert(log2(0).isInfinity)
    assert(math.abs(0d- log2(1))< 0.000000001d)
    assert(math.abs(-2d- log2(0.25d))< 0.000000001d)
    assert(math.abs(8d- log2(256))< 0.000000001d)
    assert(math.abs(3.321928094887362d- log2(10))< 0.000000001d)
    assert(math.abs(6.996275748989886d- log2(127.67))< 0.000000001d)
  }

  test("testLerp") {
    assert(math.abs(0.5d- 0.5.lerp(0, 1))< 0.000000001d)
    assert(math.abs(0d- 0.lerp(0, 1))< 0.000000001d)
    assert(math.abs(1d- 1.lerp(0, 1))< 0.000000001d)
    assert(math.abs(-1d- -1.lerp(0, 1))< 0.000000001d)
    assert(math.abs(2.5d- 2.5.lerp(0, 1))< 0.000000001d)
    assert(math.abs(3d- 0.2.lerp(2, 7))< 0.000000001d)
    assert(math.abs(0.52d- 0.2.lerp(-2.2, 11.4))< 0.000000001d)
  }

  test("testTruncate") {
    assert(math.abs(0.3333- truncate(4)(1/3d))< 0.0000000000000001)
    assert(math.abs(2.3333- truncate(4)(2.3333))< 0.0000000000000001)
    assert(math.abs(3- truncate(4)(2.999999))< 0.0000000000000001)
  }
  
}
