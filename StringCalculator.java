package com.tdd;

public class StringCalculator {

    public int add(String numbers) {
        int total = 0;
        if (numbers.isEmpty()) {
            return 0;
        }
        else if (numbers.length() == 1) {
            total = Integer.parseInt(numbers);
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

        for(String num: numList){
            total += Integer.parseInt(num);
        }

        return total;
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

        stringCalculator = null;
    }
}
