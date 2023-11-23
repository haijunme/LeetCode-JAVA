package main.prep2021.quickpractices.recursion;

import java.util.*;

public class DifferentWaysToAddParentheses {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i ++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (Integer l:left) {
                    for (Integer r:right) {
                        result.add(cal(l, r, c));
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.parseInt(input));
        }
        return result;
    }

    private int cal(int num1, int num2, char c) {
        if (c == '+') {
            return num1 + num2;
        }
        if (c == '-') {
            return num1 - num2;
        }
        if (c == '*') {
            return num1 * num2;
        }
        return 0;
    }

    public static void main(String[] args) {
        var solution = new DifferentWaysToAddParentheses();
        System.out.println(solution.diffWaysToCompute("2*3-4*5"));
    }
}
