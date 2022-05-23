package main.quickpractices.dynamicprogramming;

public class UniquePathII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        final int M = obstacleGrid.length;
        final int N = obstacleGrid[0].length;

        int[][] memo = new int[M][N];
        for (int column = 0; column < N; column++) {
            if (obstacleGrid[0][column] == 1) {
                break;
            }
            memo[0][column] = 1;
        }
        for (int row = 0; row < M; row++) {
            if (obstacleGrid[row][0] == 1) {
                break;
            }
            memo[row][0] = 1;
        }
        for (int row = 1; row < M; row++) {
            for (int column = 1; column < N; column++) {
                if (obstacleGrid[row][column] == 1) {
                    continue;
                }
                memo[row][column] = memo[row-1][column] + memo[row][column-1];
            }
        }
        return memo[M-1][N-1];
    }

    public static void main(String[] args) {
        var solution = new UniquePathII();
        System.out.println(solution.uniquePathsWithObstacles(new int[][] {
                {1}
        }));
    }
}
