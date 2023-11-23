package main.prep2021.quickpractices.dynamicprogramming;

import java.util.Arrays;

public class PaintHouseII {
    public int minCostII(int[][] costs) {
        final int N = costs.length;
        final int K = costs[0].length;
        int[][] memo = new int[N][K];
        System.arraycopy(costs[0], 0, memo[0], 0, K);
        for (int i = 1; i < N; i++) {
            int[] optimized = memo[i-1];
            int[] newCosts = costs[i];
            for (int j = 0; j < K; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < K; k++) {
                    if (k == j) continue;
                    min = Math.min(min, optimized[k]);
                }
                memo[i][j] = min + newCosts[j];
            }
        }
        return Arrays.stream(memo[N-1]).min().getAsInt();
    }

    public static void main(String[] args) {
        var solution = new PaintHouseII();
        int[][] sampleInput = new int[][]{
                {1,3},
                {2,4}
        };
        System.out.println(solution.minCostII(sampleInput));
    }
}
