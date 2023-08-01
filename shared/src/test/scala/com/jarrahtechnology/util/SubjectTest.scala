package com.jarrahtechnology.util

import org.scalatest.funsuite.AnyFunSuite

class SubjectTest extends AnyFunSuite {
  
  test("testToRoman") { 
    val testSub = Subject[Int]()  
    @SuppressWarnings(Array("org.wartremover.warts.Var")) 
    var notify = 0
    assert(0 == testSub.size()) 
    val id = testSub.add(notify = _)
    assert(1 == testSub.size()) 
    assert(0 == notify) 
    testSub.notify(3)
    assert(3 == notify) 
    testSub.notify(5)
    assert(5 == notify) 
    testSub.remove(id)
    assert(0 == testSub.size()) 
    notify = 0
    assert(0 == notify) 
    testSub.notify(3)
    assert(0 == notify)
    testSub.remove(id)
  }

}