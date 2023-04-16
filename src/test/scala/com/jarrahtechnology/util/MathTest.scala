package com.jarrahtechnology.util

import org.junit.Test
import junit.framework.TestCase
import org.junit.Assert.*

import com.jarrahtechnology.util.Math.*

class MathTest extends TestCase {
  
  @Test def testClamp: Unit =  {
    assertEquals(2d, 2d.clamp(1, 10), 0.000000001d)
    assertEquals(1d, -2d.clamp(1, 10), 0.000000001d)
    assertEquals(1d, -0d.clamp(1, 10), 0.000000001d)
    assertEquals(10d, 22d.clamp(1, 10), 0.000000001d)
    assertEquals(10d, 10d.clamp(1, 10), 0.000000001d)

    assertEquals(10d, 10d.clamp(0.25, 11.6), 0.000000001d)
    assertEquals(0.25d, 0.23d.clamp(0.25, 11.6), 0.000000001d)
    assertEquals(11.6, 365767.764567d.clamp(0.25, 11.6), 0.000000001d)
  }

  @Test def testClamp01: Unit =  {
    assertEquals(0.2d, 0.2d.clamp01, 0.000000001d)
    assertEquals(0d, 0d.clamp01, 0.000000001d)
    assertEquals(0d, -0.67d.clamp01, 0.000000001d)
    assertEquals(1d, 22d.clamp01, 0.000000001d)
    assertEquals(1d, 1d.clamp01, 0.000000001d)
    assertEquals(1d, 1.000003.clamp01, 0.000000001d)
  }

  @Test def testLog2: Unit =  {
    assertEquals(0.3010299956639812d, log2base10, 0.000000001d)
    assertEquals(1d, log2(2), 0.000000001d)
    assertTrue(log2(-2).isNaN)
    assertTrue(log2(0).isInfinity)
    assertEquals(0d, log2(1), 0.000000001d)
    assertEquals(-2d, log2(0.25d), 0.000000001d)
    assertEquals(8d, log2(256), 0.000000001d)
    assertEquals(3.321928094887362d, log2(10), 0.000000001d)
    assertEquals(6.996275748989886d, log2(127.67), 0.000000001d)
  }

  @Test def testLerp: Unit =  {
    assertEquals(0.5d, 0.5.lerp(0, 1), 0.000000001d)
    assertEquals(0d, 0.lerp(0, 1), 0.000000001d)
    assertEquals(1d, 1.lerp(0, 1), 0.000000001d)
    assertEquals(-1d, -1.lerp(0, 1), 0.000000001d)
    assertEquals(2.5d, 2.5.lerp(0, 1), 0.000000001d)
    assertEquals(3d, 0.2.lerp(2, 7), 0.000000001d)
    assertEquals(0.52d, 0.2.lerp(-2.2, 11.4), 0.000000001d)
  }

  @Test def testTruncate: Unit =  {
    assertEquals(0.3333, truncate(4)(1/3d), 0.0000000000000001)
    assertEquals(2.3333, truncate(4)(2.3333), 0.0000000000000001)
    assertEquals(3, truncate(4)(2.999999), 0.0000000000000001)
  }
}
