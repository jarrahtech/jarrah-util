package com.jarrahtechnology.util

import scala.scalajs.js.annotation._

@JSExportAll
object RomanNumerals {

  enum Symbol(val value: Int) {
    case M extends Symbol(1000)
    case CM extends Symbol(900)
    case D extends Symbol(500)
    case CD extends Symbol(400)
    case C extends Symbol(100)
    case XC extends Symbol(90)
    case L extends Symbol(50)
    case XL extends Symbol(40)
    case X extends Symbol(10)
    case IX extends Symbol(9)
    case V extends Symbol(5)
    case IV extends Symbol(4)
    case I extends Symbol(1)
  }

  lazy val allNumerals = Symbol.values.sortWith(_.value > _.value).toList

  def toRoman(number: Int): String = {
    def toSymbols(number: Int, digits: List[Symbol]): String = digits match {
      case Nil    => ""
      case h :: t => h.toString * (number / h.value) + toSymbols(number % h.value, t)
    }

    toSymbols(number, allNumerals)
  }

  def fromRoman(numerals: String): Int = {
    def fromSymbols(numerals: List[Char], acc: Int): Int = acc + (numerals match {
      case Nil                                                                           => 0
      case a :: b :: t if allNumerals.exists(_.toString.equals(a.toString + b.toString)) => fromSymbols(t, Symbol.valueOf(a.toString + b.toString).value)
      case a :: t                                                                        => fromSymbols(t, Symbol.valueOf(a.toString).value)
    })

    fromSymbols(numerals.toList, 0)
  }
}
