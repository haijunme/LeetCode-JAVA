package main.quickpractices.dynamicprogramming.kadane;

public class MaximumArray {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = currentSum;

        for (int i = 1; i < nums.length; i++) {
            // gives us the locally optimized solution for nums[i]
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // make sure that we can get the globally optimized solution
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumArray solution =  new MaximumArray();
        System.out.println(solution.maxSubArray(new int[] {-1, 0, -2, -9}));
    }
}
