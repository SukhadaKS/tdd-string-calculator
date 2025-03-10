package com.tdd

class StringCalculator {

  def add(strNumbers: String): Int = {
    var numbers = strNumbers
    var total = 0

    if (numbers.isEmpty) {
      0
    }
    else if (numbers.length == 1) {
      total = convertToInt(numbers)
    }
    else {
      var delimiter = ","
      if (numbers.matches("//(.)\n(.)")) {
        delimiter = numbers.charAt(2).toString
        numbers = numbers.substring(4)
      }

      val numList = numbers.split(s"[$delimiter,\n]")
      total = sum(numList)
    }

    total
  }

  private def sum(numbers: Array[String]): Int = {
    var total = 0
    val negativeString = new StringBuilder()

    for (number <- numbers) {
      if (convertToInt(number) < 0) {
        if (negativeString.isEmpty)
          negativeString.append(number)
        else
          negativeString.append(",").append(number)
      }
    }

    if (negativeString.nonEmpty) {
      throw new IllegalArgumentException(s"negative numbers not allowed: $negativeString")
    }

    total
  }

  private def convertToInt(num: String): Int = {
    num.toInt
  }

}
