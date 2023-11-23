package main.prep2021.quickpractices.recursion;

public class NQueensII {
    private boolean[][] board;
    private int result;
    private int N;

    private boolean isCurrentBoardValid(int x, int y) {
        for (int i = 0; i < N; i++) {
            if (i != x && board[i][y]) {
                return false;
            }
        }
        int i = x-1, j = y-1;
        while (i >= 0 && j >= 0) {
            if (board[i][j]) return false;
            i--;j--;
        }
        i = x + 1; j = y + 1;
        while (i < N && j < N) {
            if (board[i][j]) return false;
            i++; j++;
        }
        i = x + 1; j = y - 1;
        while (i < N && j >= 0) {
            if (board[i][j]) return false;
            i++; j--;
        }
        i = x - 1; j = y + 1;
        while (i >= 0 && j < N) {
            if (board[i][j]) return false;
            i--;j++;
        }
        return true;
    }

    private void recur(int recurLevel) {
        if (recurLevel == N) {
            result++;
            return;
        }
        for (int i = 0; i < N; i++) {
            board[recurLevel][i] = true;
            if (recurLevel == 0 || isCurrentBoardValid(recurLevel, i)) {
                recur(recurLevel + 1);
            }
            board[recurLevel][i] = false;
        }
    }

    public int totalNQueens(int n) {
        this.board = new boolean[n][n];
        this.result = 0;
        this.N = n;
        recur(0);
        return result;
    }

    public static void main(String[] args) {
        var solution = new NQueensII();
        for (int i = 1; i <= 9; i++) {
            System.out.println(solution.totalNQueens(i));
        }
    }
}
