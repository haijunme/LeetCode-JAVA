package main.prep2021.quickpractices.dynamicprogramming;

public class HouseRobber {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            memo[i] = Math.max(memo[i-2] + nums[i], memo[i-1]);
        }
        return memo[nums.length-1];
    }

    public static void main(String[] args) {
        var solution = new HouseRobber();
        System.out.println(solution.rob(new int[]{2,7,8}));
    }
}
