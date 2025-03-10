package com.tdd;

public class StringCalculator {

    public int add(String numbers) {
        int sum = 0;
        if (numbers.isEmpty()) {
            return 0;
        }
        else if (numbers.length() == 2) {
            sum = Integer.parseInt(numbers);
        }

        return sum;
    }

    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();

        String result = (stringCalculator.add("") == 0) ? "success.." : "failure..";
        System.out.println(result);

        result = (stringCalculator.add("1") == 1) ? "success.." : "failure..";
        System.out.println(result);

        result = (stringCalculator.add("3") == 3) ? "success.." : "failure..";
        System.out.println(result);

        result = (stringCalculator.add("9") == 3) ? "success.." : "failure..";
        System.out.println(result);

        stringCalculator = null;
    }


}
