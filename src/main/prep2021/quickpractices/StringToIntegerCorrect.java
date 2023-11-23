package main.prep2021.quickpractices;

public class StringToIntegerCorrect {

    public int myAtoi(String input) {
        int sign = 1;
        int result = 0;
        int index = 0;
        int n = input.length();

        while (index < n && input.charAt(index) == ' ') {
            index++;
        }
        if (index < n && input.charAt(index) == '+') {
            sign = 1;
            index++;
        } else if (index < n && input.charAt(index) == '-') {
            sign = -1;
            index++;
        }

        while (index < n && Character.isDigit(input.charAt(index))) {
            int digit = input.charAt(index) - '0';

            if ((result > Integer.MAX_VALUE / 10) ||
                    (result == Integer.MAX_VALUE / 10 && digit >= 8)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = 10 * result + digit;
            index++;
        }

        return sign * result;
    }

    public static void main(String[] args) {
        var solution = new StringToIntegerCorrect();
        System.out.println(solution.myAtoi("-2147483649"));
    }
}
