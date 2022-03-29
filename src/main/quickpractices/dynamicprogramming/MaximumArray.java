package main.quickpractices.dynamicprogramming;

public class MaximumArray {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = currentSum;

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumArray solution =  new MaximumArray();
        System.out.println(solution.maxSubArray(new int[] {1}));
    }
}
