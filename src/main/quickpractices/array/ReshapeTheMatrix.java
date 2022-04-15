package main.quickpractices.array;

import java.util.Arrays;

public class ReshapeTheMatrix {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        final int M = mat.length;
        final int N = mat[0].length;
        if (M * N != r * c) {
            return mat;
        }
        int row = 0;
        int column = 0;
        int[][] answer = new int[r][c];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                answer[row][column] = mat[i][j];
                if (column == c - 1) {
                    row++;
                    column = 0;
                } else {
                    column++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        var solution = new ReshapeTheMatrix();
        for (int[] row : solution.matrixReshape(new int[][]{{1,2},{3,4},{5,6}}, 2, 3)) {
            System.out.println(Arrays.toString(row));
        }
    }
}
