package main.prep2021.quickpractices.dynamicprogramming;

import java.util.Arrays;

public class PerfectSquares {
    public int numSquares(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;
        int squareNumsCount = (int) Math.sqrt(n);
        int[] squareNums = new int[squareNumsCount +1];
        for (int i = 0; i <= squareNumsCount; i++) {
            squareNums[i] = i * i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= squareNumsCount; j++) {
                if (i < squareNums[j]) break;
                memo[i] = Math.min(memo[i], memo[i-squareNums[j]] + 1);
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        PerfectSquares solution = new PerfectSquares();
        System.out.println(solution.numSquares(11));
    }
}
