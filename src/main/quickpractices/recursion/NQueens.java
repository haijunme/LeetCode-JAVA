package main.quickpractices.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    private char[][] board;
    private List<List<String>> answers;
    private int N;

    private boolean isBoardValid(int row, int column) {
        // check the current column
        for (int i = 0; i < N; i++) {
            if (i != row && board[i][column] == 'Q') {
                return false;
            }
        }
        // diagonally check top-left to current
        int i = row - 1;
        int j = column - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }
        // diagonally check current to bottom-right
        i = row + 1;
        j = column + 1;
        while (i < N && j < N) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i++;
            j++;
        }
        // diagonally check bottom-left to current
        i = row + 1;
        j = column - 1;
        while (i < N && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i++;
            j--;
        }
        // diagonally check current to top-right
        i = row - 1;
        j = column + 1;
        while (i >= 0  && j < N) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }

    private void recur(int row) {
        if (row == N) {
            List<String> acceptable = new ArrayList<>();
            for (char[] charRow : board) {
                acceptable.add(String.valueOf(charRow));
            }
            answers.add(acceptable);
        } else {
            for (int i = 0; i < N; i++) {
                board[row][i] = 'Q';
                if (row == 0 || isBoardValid(row, i)) {
                    recur(row + 1);
                }
                board[row][i] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        // board initialization
        this.board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        // initialize other class members
        this.answers = new ArrayList<>();
        this.N = n;

        recur(0);
        return answers;
    }

    public static void main(String[] args) {
        var solution = new NQueens();
        List<List<String>> result = solution.solveNQueens(9);
        for (List<String> possibility : result) {
            System.out.println(possibility);
        }
    }

}
