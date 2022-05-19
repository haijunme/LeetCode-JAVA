package main.quickpractices.array.stringcharacters;

import java.util.*;

public class AddStrings {

    public String addStrings(String num1, String num2) {
        final int firstEnd = num1.length() - 1;
        final int secondEnd = num2.length() - 1;

        StringBuilder answer = new StringBuilder();
        int carryOver = 0;
        for (int i = 0; i <= Math.max(firstEnd, secondEnd); i++) {
            int first = firstEnd - i >= 0 ? Character.getNumericValue(num1.charAt(firstEnd - i)) : 0;
            int second = secondEnd - i >= 0 ? Character.getNumericValue(num2.charAt(secondEnd - i)) : 0;
            int digit = first + second + carryOver;
            if (digit >= 10) {
                digit %= 10;
                carryOver = 1;
            } else {
                carryOver = 0;
            }
            answer.append(Character.forDigit(digit, 10));
        }
        if (carryOver != 0) {
            answer.append('1');
        }
        return answer.reverse().toString();
    }

    public static void main(String[] args) {
        var solution = new AddStrings();
        System.out.println(solution.addStrings("9999", "1"));
    }
}
