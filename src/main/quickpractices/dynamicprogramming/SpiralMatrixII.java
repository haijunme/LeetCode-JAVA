package main.quickpractices.dynamicprogramming;

import java.util.Arrays;

public class SpiralMatrixII {
    private int[][] board;
    private int N;

    public int[][] generateMatrix(int n) {
        this.N = n;
        this.board = new int[n][n];
        for (int[] row : board) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        int num = 1;
        int loopCount = N % 2 == 0 ? N/2-1 : N/2;
        for (int i = 0; i <= loopCount; i++) {
            for (int j = i; j < N-i; j++) {
                board[i][j] = num;
                num++;
            }
            for (int j = i+1; j < N-i; j++) {
                board[j][N-1-i] = num;
                num++;
            }
            for (int j = N-2-i; j >= i; j--) {
                board[N-1-i][j] = num;
                num++;
            }
            for (int j = N-2-i; j >= i+1; j--) {
                board[j][i] = num;
                num++;
            }
        }
        return this.board;
    }

    public static void main(String[] args) {
        var solution = new SpiralMatrixII();
        for (int[] row : solution.generateMatrix(10)) {
            System.out.println(Arrays.toString(row));
        }
    }
}
