package com.tdd

class StringCalculator {

  def add(numbers: String): Int = {
    var total = 0

    if (numbers.isEmpty) {
      0
    }
    else if (numbers.length == 1) {
      total = numbers.toInt
    }

    total
  }

}

