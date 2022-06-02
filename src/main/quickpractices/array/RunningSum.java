package main.quickpractices.array;

import java.util.Arrays;

public class RunningSum {
    public int[] runningSum(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        return nums;
    }

    public static void main(String[] args) {
        var solution = new RunningSum();
        System.out.println(Arrays.toString(solution.runningSum(new int[]{1,2,3,4})));
    }
}
