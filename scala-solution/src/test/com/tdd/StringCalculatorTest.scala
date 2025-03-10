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
}

