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

  test("testTruncate") {
    assert(math.abs(0.3333- truncate(4)(1/3d))< 0.0000000000000001)
    assert(math.abs(2.3333- truncate(4)(2.3333))< 0.0000000000000001)
    assert(math.abs(3- truncate(4)(2.999999))< 0.0000000000000001)
  }

  test("isEven") {
    assert(isEven(2))
    assert(isEven(29867534))
    assert(isEven(0))
    assert(isEven(-98738))
    assert(!isEven(-3))
    assert(!isEven(15))

    assert(isFloorEven(2d))
    assert(isFloorEven(29867534d))
    assert(isFloorEven(0d))
    assert(isFloorEven(-98738d))
    assert(!isFloorEven(-3d))
    
    assert(!isFloorEven(15d))
    assert(isFloorEven(2.1d))
    assert(isFloorEven(8.0d))
    assert(!isFloorEven(-7.3d))
    assert(isFloorEven(-2.3d))
  }
 
  test("duration mode") {
    import scala.concurrent.duration.*
    assert(mod(Duration(1, HOURS), Duration(24, MINUTES))==Duration(12, MINUTES))
  }
}
