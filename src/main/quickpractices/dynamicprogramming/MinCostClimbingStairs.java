package main.quickpractices.dynamicprogramming;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        final int N = cost.length;
        int[] memo = new int[N];
        memo[0] = 0;
        memo[1] = 0;
        for (int i = 2; i < N; i ++) {
            memo[i] = Math.min(memo[i-1] + cost[i-1], memo[i-2] + cost[i-2]);
        }
        return memo[N-1];
    }

    public static void main(String[] args) {

    }
}
