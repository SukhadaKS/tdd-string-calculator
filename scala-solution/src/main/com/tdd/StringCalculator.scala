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
      var delimiter = ","
      if (numbers.matches("//(.)\n(.)")) {
        delimiter = numbers.charAt(2).toString
        numbers = numbers.substring(4)
      }

      for (number <- numbers.split(s"[$delimiter,\n]")) {
        total += number.toInt
      }
    }

    total
  }

}
