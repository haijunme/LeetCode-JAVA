package main.quickpractices.dynamicprogramming;

public class HouseRobberII {
    private int[] nums;
    private int N;

    private int solve(int start, int end) {
        int[] memo = new int[N];
        if (start == 0) {
            memo[0] = nums[0];
            memo[1] = Math.max(nums[0], nums[1]);
        } else {
            memo[1] = nums[1];
            memo[2] = Math.max(nums[1], nums[2]);
        }
        for (int i = start+2; i <= end; i++) {
            memo[i] = Math.max(memo[i-2] + nums[i], memo[i-1]);
        }
        return memo[end];
    }

    public int rob(int[] nums) {
       N = nums.length;
        if (N == 1) {
            return nums[0];
        }
        if (N == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (N == 3) {
            return Math.max(Math.max(nums[0], nums[2]), nums[1]);
        }
        this.nums = nums;
        return Math.max(solve(0, N-2), solve(1, N-1));
    }

    public static void main(String[] args) {
        var solution = new HouseRobberII();
        System.out.println(solution.rob(new int[]{1,3,1,3,100}));
    }
}
