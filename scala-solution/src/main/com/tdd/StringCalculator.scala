package com.tdd

class StringCalculator {

  def add(strNumbers: String): Int = {
    var numbers = strNumbers
    var total = 0

    if (numbers.isEmpty) {
      0
    }
    else if (numbers.length == 1) {
      total = numbers.toInt
    }
    else {
      for (number <- numbers.split("[,\n]")) {
        total += number.toInt
      }
    }

    total
  }

}
