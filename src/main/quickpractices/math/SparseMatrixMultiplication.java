package main.quickpractices.math;

import java.util.*;

public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        final int M = mat1.length;
        final int K = mat1[0].length;
        final int N = mat2[0].length;

        List<List<int[]>> transformed1 = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            transformed1.add(new ArrayList<>());
            for (int j = 0; j < K; j++) {
                if (mat1[i][j] != 0) {
                    transformed1.get(i).add(new int[]{j, mat1[i][j]});
                }
            }
        }
        List<List<int[]>> transformed2 = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            transformed2.add(new ArrayList<>());
            for (int j = 0; j < K; j++) {
                if (mat2[j][i] != 0) {
                    transformed2.get(i).add(new int[]{j, mat2[j][i]});
                }
            }
        }
        int[][] result = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int[] element1 : transformed1.get(i)) {
                    int column = element1[0];
                    int value1 = element1[1];
                    for (int[] element2 : transformed2.get(j)) {
                        int row = element2[0];
                        int value2 = element2[1];
                        if (row == column) result[i][j] += value1 * value2;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var solution = new SparseMatrixMultiplication();
        System.out.println(Arrays.deepToString(
                solution.multiply(
                        new int[][]{{1,0,0},{-1,0,3}},
                        new int[][]{{7,0,0}, {0,0,0}, {0,0,1}}
                )
        ));
    }
}
