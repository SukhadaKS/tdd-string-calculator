package com.tdd

import org.mockito.MockitoSugar
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers


class StringCalculatorTest extends AnyFunSuite with MockitoSugar with Matchers {

  var stringCalculator: StringCalculator = new StringCalculator()

  test("testEmptyString") {
    assert(stringCalculator.add("") === 0)
  }

  test("testAddOneNumber") {
    assert(stringCalculator.add("1") === 1)
  }

  test("testMultipleNumbers1") {
    assert(stringCalculator.add("1,2") === 3)
  }

  test("testMultipleNumbers2") {
    assert(stringCalculator.add("4,6") === 10)
  }

  test("testnewline") {
    assert(stringCalculator.add("1\n2,3\n4") === 10)
  }

  test("testOtherDelimiter") {
    assert(stringCalculator.add("//;\n1;2") === 3)
  }
}
