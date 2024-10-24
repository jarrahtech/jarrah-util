package com.jarrahtechnology.util

import org.scalatest.funsuite.AnyFunSuite

import com.jarrahtechnology.util.MathExtensions.*

class MathExtensionsTest extends AnyFunSuite {
 
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

  test("testTruncate") {
    assert(math.abs(0.3333- (1/3d).trunc(4))< 0.0000000000000001)
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

  test("isEven") {
    assert(2.isEven)
    assert(29867534.isEven)
    assert(0.isEven)
    assert(-98738.isEven)
    assert(!(-3.isEven))
    assert(!15.isEven)

    assert(2d.isFloorEven)
    assert(29867534d.isFloorEven)
    assert(0d.isFloorEven)
    assert(-98738d.isFloorEven)
    assert(!(-3d.isFloorEven))
    
    assert(!15d.isFloorEven)
    assert(2.1d.isFloorEven)
    assert(8.0d.isFloorEven)
    assert(!(-7.3d.isFloorEven))
    assert(-2.3d.isFloorEven)
  }
  
}
