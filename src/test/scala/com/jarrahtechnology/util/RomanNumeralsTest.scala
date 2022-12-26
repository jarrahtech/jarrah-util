package com.jarrahtechnology.util

import org.junit.Test
import junit.framework.TestCase
import org.junit.Assert.*

class RomanNumeralsTest extends TestCase {
  
  @Test def testToRoman: Unit =  {   
    assertEquals("MMXIX", RomanNumerals.toRoman(2019)) 
    assertEquals("III", RomanNumerals.toRoman(3)) 
    assertEquals("MMCMIV", RomanNumerals.toRoman(2904))    
  }

  @Test def testFromRoman: Unit =  { 
    assertEquals(2904, RomanNumerals.fromRoman("MMCMIV"))
    assertEquals(43, RomanNumerals.fromRoman("XLIII"))
    assertEquals(2019, RomanNumerals.fromRoman(RomanNumerals.toRoman(2019)))
  } 
}