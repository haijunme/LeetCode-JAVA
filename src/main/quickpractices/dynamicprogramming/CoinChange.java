package main.quickpractices.dynamicprogramming;

import java.util.Arrays;

public class CoinChange {
    private int[] memo;
    private int[] coins;

    private int calculateChanges(int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (memo[amount] != 0) {
            return memo[amount];
        }
        int minCount = Integer.MAX_VALUE;
        for (int i = coins.length - 1; i >= 0; i --) {
            int denomination = coins[i];
            int additional = calculateChanges(amount - denomination);
            if (additional >= 0) minCount = Math.min(minCount, 1 + additional);
        }
        if (minCount != Integer.MAX_VALUE) {
            memo[amount] = minCount;
        } else {
            memo[amount] = -1;
        }
        return memo[amount];
    }

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        memo = new int[amount + 1];
        this.coins = coins;
        Arrays.sort(this.coins);
        calculateChanges(amount);
        return memo[amount];
    }

    public static void main(String[] args) {
        var solution = new CoinChange();
        System.out.println(solution.coinChange(new int[]{1}, 0));
    }
}
