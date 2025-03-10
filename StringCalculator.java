package com.tdd;

public class StringCalculator_1 {

    public int add(String numbers) {
        int total = 0;
        if (numbers.isEmpty()) {
            return 0;
        }
        else if (numbers.length() == 1) {
            total = Integer.parseInt(numbers);
        }
        else {
            for(String num: numbers.split(",")){
                total += Integer.parseInt(num);
            }
        }

        return total;
    }

    public static void main(String[] args) {
        StringCalculator_1 stringCalculator = new StringCalculator_1();

        String result = (stringCalculator.add("") == 0) ? "success.." : "failure..";
        System.out.println(result);

        result = (stringCalculator.add("1") == 1) ? "success.." : "failure..";
        System.out.println(result);

        result = (stringCalculator.add("3,5") == 8) ? "success.." : "failure..";
        System.out.println(result);

        result = (stringCalculator.add("9,1") == 10) ? "success.." : "failure..";
        System.out.println(result);

        stringCalculator = null;
    }


}
