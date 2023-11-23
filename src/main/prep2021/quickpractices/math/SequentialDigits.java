package main.prep2021.quickpractices.math;

import java.util.*;

public class SequentialDigits {
    private int determineDigits(int number) {
        int digits = 0;
        int base = 1;
        while (number / base > 0) {
            base *= 10;
            digits++;
        }
        return digits;
    }

    public int convertArrayToInt(int[] array) {
        int result = 0;
        int base = 1;
        for (int i = array.length - 1; i >= 0; i --) {
            result += array[i] * base;
            base *= 10;
        }
        return result;
    }

    public List<Integer> sequentialDigits(int low, int high) {
        int lowerboundDigits = determineDigits(low);
        int upperboundDigits = determineDigits(high);
        List<Integer> answer = new ArrayList<>();
        for (int digits = lowerboundDigits; digits <= upperboundDigits; digits++) {
            for (int start = 1; start <= 10 - digits; start++) {
                int[] temporary = new int[digits];
                for (int k = 0; k < digits; k++) {
                    temporary[k] = start + k;
                }
                int converted = convertArrayToInt(temporary);
                if (converted < low) {
                    continue;
                }
                if (converted > high) {
                    return answer;
                }
                answer.add(converted);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        var solution = new SequentialDigits();
        System.out.println(solution.sequentialDigits(1000, 13000));
    }
}
