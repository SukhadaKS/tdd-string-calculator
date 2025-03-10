package com.tdd;

public class StringCalculator {

    public int add(String numbers) {
        int total = 0;
        if (numbers.isEmpty()) {
            return 0;
        }
        else if (numbers.length() == 1) {
            total = convertToInt(numbers);
        }
        else {
            String delimiter = ",";
            if (numbers.matches("//(.)\n(.)")) {
                delimiter = Character.toString(numbers.charAt(2));
                numbers = numbers.substring(4);
            }

            String[] numList = numbers.split("[" + delimiter + ",\n]");
            total = sum(numList);
        }

        return total;
    }

    private int sum(String[] numList) {
        int total = 0;

        StringBuilder negativeString = new StringBuilder();

        for (String num : numList) {
            if (convertToInt(num) < 0) {
                if (negativeString.toString().equals(""))
                    negativeString = new StringBuilder(num);
                else
                    negativeString.append(",").append(num);
            }
            if (convertToInt(num) < 1000)
                total += convertToInt(num);
        }

        if (negativeString.length() != 0) {
            throw new IllegalArgumentException("negative numbers not allowed " + negativeString);
        }

        return total;
    }

    private int convertToInt(String num) {
        return Integer.parseInt(num);
    }

    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();

        String result = (stringCalculator.add("") == 0) ? "success.." : "failure..";
        System.out.println(result);

        result = (stringCalculator.add("1") == 1) ? "success.." : "failure..";
        System.out.println(result);

        result = (stringCalculator.add("3,5\n1") == 9) ? "success.." : "failure..";
        System.out.println(result);

        result = (stringCalculator.add("9\n1,5") == 15) ? "success.." : "failure..";
        System.out.println(result);

        result = (stringCalculator.add("//;\n3;5") == 8) ? "success.." : "failure..";
        System.out.println(result);

        result = (stringCalculator.add("//:\n1:5:3") == 9) ? "success.." : "failure..";
        System.out.println(result);

        try {
            stringCalculator.add("-1,2");
        } catch (IllegalArgumentException e) {
            result = (e.getMessage().equals("negative numbers not allowed -1")) ? "success.." : "failure..";
            System.out.println(result);
        }
        try {
            stringCalculator.add("1,-2,3,-5");
        } catch (IllegalArgumentException e) {
            result = (e.getMessage().equals("negative numbers not allowed -2,-5")) ? "success.." : "failure..";
            System.out.println(result);
        }

        stringCalculator = null;
    }
}
