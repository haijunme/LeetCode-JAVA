package main.prep2021.quickpractices.prefixsum;

public class RangeSumQuery2DImmutable {

    private static class NumMatrix {
        private final int[][] prefixSumCache;

        public NumMatrix(int[][] matrix) {
            this.prefixSumCache = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (i == 0) {
                        prefixSumCache[i][j] = matrix[i][j];
                    } else {
                        prefixSumCache[i][j] = matrix[i][j] + prefixSumCache[i-1][j];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int prefixSums = 0;
            if (row1 != 0) {
                for (int i = col1; i <= col2; i++) {
                    prefixSums += prefixSumCache[row1-1][i];
                }
            }
            int totalSums = 0;
            for (int i = col1; i <= col2; i++) {
                totalSums += prefixSumCache[row2][i];
            }
            return totalSums - prefixSums;
        }
    }

    public static void main(String[] args) {
        var solution = new NumMatrix(new int[][] {
                {3,0,1,4,2},
                {5,6,3,2,1},
                {1,2,0,1,5},
                {4,1,0,1,7},
                {1,0,3,0,5}

        });
        System.out.println(solution.sumRegion(0,0,1,1));
        System.out.println(solution.sumRegion(1,1,2,2));
        System.out.println(solution.sumRegion(1,2,2,4));
    }
}
