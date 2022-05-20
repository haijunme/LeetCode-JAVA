package main.quickpractices.graph.bfsdfs;

import java.util.*;

public class ZeroOneMatrix {
    private int M;
    private int N;
    private int[][] mat;
    private Deque<int[]> bfs;
    private int[][] answer;

    private void updateDequeAndCellIfValid(int depth, int x, int y) {
        if (x >= 0 && x < M && y >= 0 && y < N && mat[x][y] == 1 && answer[x][y] == Integer.MAX_VALUE) {
            bfs.add(new int[]{x, y});
            answer[x][y] = depth;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        M = mat.length;
        N = mat[0].length;
        this.mat = mat;
        bfs = new ArrayDeque<>();
        answer = new int[M][N];

        for (int[] row : answer) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (mat[i][j] == 0) {
                    bfs.add(new int[]{i, j});
                    answer[i][j] = 0;
                }
            }
        }
        int depth = 0;
        while (!bfs.isEmpty()) {
            depth ++;
            int breadth = bfs.size();
            for (int i = 0; i < breadth; i++) {
                int[] current = bfs.removeFirst();
                int x = current[0];
                int y = current[1];
                updateDequeAndCellIfValid(depth, x+1, y);
                updateDequeAndCellIfValid(depth, x-1, y);
                updateDequeAndCellIfValid(depth, x, y+1);
                updateDequeAndCellIfValid(depth, x, y-1);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        var solution = new ZeroOneMatrix();
        int[][] output = solution.updateMatrix(new int[][]{
                {0,0,0},
                {0,1,0},
                {1,1,1}
        });
        for (int[] row : output) {
            System.out.println(Arrays.toString(row));
        }
    }
}
