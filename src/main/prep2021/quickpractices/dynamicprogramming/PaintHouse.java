package main.prep2021.quickpractices.dynamicprogramming;

public class PaintHouse {
    private static final int RED = 0;
    private static final int BLUE = 1;
    public static final int GREEN = 2;

    public int minCost(int[][] costs) {
        final int N = costs.length;
        int[][] memo = new int[N][3];
        memo[0][RED] = costs[0][RED];
        memo[0][BLUE] = costs[0][BLUE];
        memo[0][GREEN] = costs[0][GREEN];
        for (int i = 1; i < N; i++) {
            int[] optimized = memo[i-1];
            int[] newCosts = costs[i];
            memo[i][RED] = Math.min(optimized[GREEN], optimized[BLUE]) + newCosts[RED];
            memo[i][BLUE] = Math.min(optimized[RED], optimized[GREEN]) + newCosts[BLUE];
            memo[i][GREEN] = Math.min(optimized[RED], optimized[BLUE]) + newCosts[GREEN];
        }
        int[] candidates = memo[N-1];
        return Math.min(Math.min(candidates[RED], candidates[BLUE]), candidates[GREEN]);
    }

    public static void main(String[] args) {
        var solution = new PaintHouse();
        int[][] sampleInput = new int[][] {
                {7,6,2}
        };
        System.out.println(solution.minCost(sampleInput));
    }
}
