package com.jarrahtechnology.util

import org.junit.Test
import junit.framework.TestCase
import org.junit.Assert.*


class LinearInterpPointsTest extends TestCase {

  val ig = LinearInterpPoints(List(Vector2(0, 4),Vector2(0.1, 0.5),Vector2(1, 0.1),Vector2(5, 0.05)))
  
  @Test def testPoints: Unit =  {    
    assertEquals(4, ig.interp(0), 0.0000001)
    assertEquals(0.5, ig.interp(0.1), 0.0000001)  
    assertEquals(0.1, ig.interp(1), 0.0000001)  
    assertEquals(0.05, ig.interp(5), 0.0000001)
  }
    
  @Test def testExtrap: Unit =  { 
    assertEquals(0.05, ig.interp(6), 0)
    assertEquals(4, ig.interp(-1), 0)
  }
    
  @Test def testInterp: Unit =  { 
    assertEquals(0.0765, ig.interp(2.88), 0.001)
    assertEquals(2.25, ig.interp(0.05), 0.001)
    assertEquals(0.1888, ig.interp(0.8), 0.001)
  }
  
  @Test def testHasPoints: Unit =  { 
    assertTrue(ig.hasPoints)
    assertFalse(LinearInterpPoints(List.empty).hasPoints)
  }
  
  @Test def testMin: Unit =  { 
    assertEquals(Vector2(0, 4), ig.min)
    assertEquals(Vector2(0, 0), LinearInterpPoints(List.empty).min)
  }
  
  @Test def testMax: Unit =  { 
    assertEquals(Vector2(5, 0.05), ig.max)
    assertEquals(Vector2(0, 0), LinearInterpPoints(List.empty).max)
  }
}