package com.jarrahtechnology.util

import org.scalatest.funsuite.AnyFunSuite

class RomanNumeralsTest extends AnyFunSuite {
  
  test("testToRoman") {   
    assert("MMXIX" == RomanNumerals.toRoman(2019)) 
    assert("III" == RomanNumerals.toRoman(3)) 
    assert("MMCMIV" == RomanNumerals.toRoman(2904))    
  }

  test("testFromRoman") { 
    assert(2904 == RomanNumerals.fromRoman("MMCMIV"))
    assert(43 == RomanNumerals.fromRoman("XLIII"))
    assert(2019 == RomanNumerals.fromRoman(RomanNumerals.toRoman(2019)))
  } 
}
