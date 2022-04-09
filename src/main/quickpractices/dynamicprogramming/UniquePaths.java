package main.quickpractices.dynamicprogramming;

import java.util.Arrays;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] pathsCache = new int[m][n];
        for (int i = 0; i < pathsCache.length; i++) {
            if (i == 0) {
                Arrays.fill(pathsCache[0], 1);
            } else {
                pathsCache[i][0] = 1;
                if (n > 1) Arrays.fill(pathsCache[i], 1, n, 0);
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                pathsCache[i][j] = pathsCache[i][j-1] + pathsCache[i-1][j];
            }
        }
        return pathsCache[m-1][n-1];
    }

    public static void main(String[] args) {
        var solution = new UniquePaths();
        System.out.println(solution.uniquePaths(1, 1));
    }
}
