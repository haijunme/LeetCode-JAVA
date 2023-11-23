package main.prep2021.quickpractices.array.twodimensional.matrix;

import java.util.Arrays;

public class TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        final int M = matrix.length;
        final int N = matrix[0].length;
        int[][] answer = new int[N][M];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                answer[j][i] = matrix[i][j];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        var solution = new TransposeMatrix();
        System.out.println(Arrays.deepToString(solution.transpose(new int[][] {{1,2,3},{4,5,6},{7,8,9}})));
    }
}
