package main.quickpractices.dynamicprogramming;

import java.util.Arrays;

public class CoinChangeV2 {

    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int denomination : coins) {
                if (i - denomination >= 0 && memo[i - denomination] != -1) {
                    if (memo[i] == -1) memo[i] = memo[i - denomination] + 1;
                    else memo[i] = Math.min(memo[i], memo[i - denomination] + 1);
                }
            }
        }
        return memo[amount];
    }

    public static void main(String[] args) {
        var solution = new CoinChangeV2();
        System.out.println(solution.coinChange(new int[]{2,3,4}, 11));
    }
}
