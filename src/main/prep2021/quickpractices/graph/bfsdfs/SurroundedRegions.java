package main.prep2021.quickpractices.graph.bfsdfs;

import java.util.Arrays;
import java.util.*;

public class SurroundedRegions {
    private int m;
    private int n;
    private char[][] board;
    private boolean[][] visited;

    private int[] createPosition(int x, int y) {
        return new int[]{x, y};
    }

    private void updateQueueIfValid(Queue<int[]> queue, int x, int y) {
        if (0 <= x && x < m && 0 <= y && y < n) {
            if (board[x][y] != 'X' && !visited[x][y]) queue.add(createPosition(x, y));
            visited[x][y] = true;
        }
    }

    public void solve(char[][] board) {
        this.m = board.length;
        this.n = board[0].length;
        this.board = board;
        this.visited = new boolean[m][n];
        Queue<int[]> positionQueue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // first row
            updateQueueIfValid(positionQueue, 0, i);
            // last row
            if (m >= 2) {
                updateQueueIfValid(positionQueue, m-1, i);
            }
        }

        // the left and right sides
        if (m >= 3) {
            for (int i = 1; i < m - 1; i++) {
                updateQueueIfValid(positionQueue, i, 0);
                if (n >= 1) {
                    updateQueueIfValid(positionQueue, i, n - 1);
                }
            }
        }

        // bfs to update visited
        while (!positionQueue.isEmpty()) {
            int initialSize = positionQueue.size();
            for (int i = 0; i < initialSize; i++) {
                int[] currentPosition = positionQueue.remove();
                int x = currentPosition[0];
                int y = currentPosition[1];

                updateQueueIfValid(positionQueue, x-1, y);
                updateQueueIfValid(positionQueue, x+1, y);
                updateQueueIfValid(positionQueue, x, y-1);
                updateQueueIfValid(positionQueue, x, y+1);
            }
        }

        for (int row = 0; row < m; row ++) {
            for (int column = 0; column < n; column++) {
                if (board[row][column] == 'O' && !visited[row][column]) {
                    board[row][column] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
        var solution = new SurroundedRegions();
        char[][] testInput = new char[][]{
                {'X', 'O', 'X', 'X'}
        };
        solution.solve(testInput);
        for (char[] row : testInput) {
            System.out.println(Arrays.toString(row));
        }
    }
}
