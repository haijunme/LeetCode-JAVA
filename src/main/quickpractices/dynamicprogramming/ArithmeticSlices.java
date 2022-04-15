package main.quickpractices.dynamicprogramming;

import java.util.Arrays;

public class ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] nums) {
        final int N = nums.length;
        int answer = 0;

        for (int i = 0; i < nums.length-2; i ++) {
            int difference = nums[i+1] - nums[i];
            for (int j = i + 2; j < nums.length; j ++) {
                 if (nums[j] - nums[j - 1] != difference) {
                     break;
                 } else {
                     answer++;
                 }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        var solution = new ArithmeticSlices();
        System.out.println(solution.numberOfArithmeticSlices(new int[]{1,2,1}));
    }
}
