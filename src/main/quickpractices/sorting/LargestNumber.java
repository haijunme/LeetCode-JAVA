package main.quickpractices.sorting;

import java.util.Arrays;
import java.util.Objects;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] numbers = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(numbers, (a, b) -> {
            if (a.charAt(0) < b.charAt(0)) {
                return 1;
            } else if (a.charAt(0) > b.charAt(0)) {
                return -1;
            } else {
                return CharSequence.compare(b + a, a + b);
            }
        });
        if (numbers[0].equals("0")) {
            return "0";
        }
        StringBuilder answer = new StringBuilder();
        for (String number : numbers) {
            answer.append(number);
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        var solution = new LargestNumber();
        System.out.println(solution.largestNumber(new int[]{3,30,34,5,9}));
    }
}
