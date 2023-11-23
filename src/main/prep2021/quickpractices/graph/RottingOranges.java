package main.prep2021.quickpractices.graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class RottingOranges {
    private int M;
    private int N;

    private void addCoordinateIfValid(Deque<int[]> bfs, int[][] grid,
                                      boolean[][] rotten, int x, int y) {
        if (x >= 0 && x < M && y >= 0 && y < N && grid[x][y] == 1 && !rotten[x][y]) {
            bfs.addLast(new int[]{x, y});
            rotten[x][y] = true;
        }
    }

    public int orangesRotting(int[][] grid) {
        this.M = grid.length;
        this.N = grid[0].length;
        Deque<int[]> bfs = new ArrayDeque<>();
        boolean[][] rotten = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] != 2) {
                    continue;
                }
                rotten[i][j] = true;
                bfs.add(new int[]{i, j});
            }
        }
        int answer = 0;
        while (!bfs.isEmpty()) {
            int breadth = bfs.size();
            for (int i = 0; i < breadth; i++) {
                int[] current = bfs.removeFirst();
                int x = current[0], y = current[1];
                addCoordinateIfValid(bfs, grid, rotten, x + 1, y);
                addCoordinateIfValid(bfs, grid, rotten, x - 1, y);
                addCoordinateIfValid(bfs, grid, rotten, x, y  + 1);
                addCoordinateIfValid(bfs, grid, rotten, x, y - 1);

            }
            if (bfs.size() > 0) answer += 1;
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1 && !rotten[i][j]) {
                    return -1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        var solution = new RottingOranges();
        System.out.println(solution.orangesRotting(new int[][]{
                {2,1,1}, {0,1,1}, {1,0,1}
        }));
    }
}
