package main.quickpractices.graph.bfsdfs;

import java.util.*;

public class PacificAtlanticWaterFlow {
    private int M;
    private int N;
    int[][] heights;

    private void processCell(Queue<int[]> bfsQueue, boolean[][] visited, int x, int y, int previousHeight) {
        if (x >= 0 && x < M && y >= 0 && y < N
                && !visited[x][y]
                && heights[x][y] >= previousHeight) {
            visited[x][y] = true;
            bfsQueue.add(new int[]{x, y});
        }
    }
    private void bfs(Queue<int[]> bfsQueue, boolean[][] visited) {
        while (!bfsQueue.isEmpty()) {
            int iterationCount = bfsQueue.size();
            for (int i = 0; i < iterationCount; i++) {
                int[] coordination = bfsQueue.remove();
                int x = coordination[0];
                int y = coordination[1];
                int height = heights[x][y];

                processCell(bfsQueue, visited, x + 1, y, height);
                processCell(bfsQueue, visited, x - 1, y, height);
                processCell(bfsQueue, visited, x, y + 1, height);
                processCell(bfsQueue, visited, x, y - 1, height);
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        M = heights.length;
        N = heights[0].length;
        this.heights = heights;

        // two grids to track reachable cells separately.
        boolean[][] pacific = new boolean[M][N];
        boolean[][] atlantic = new boolean[M][N];

        // prepare queues for BFS
        Queue<int[]> pacificBfs = new LinkedList<>();
        Queue<int[]> atlanticBfs = new LinkedList<>();
        for (int j = 0; j < N; j++) {
            if (!pacific[0][j]) {
                pacificBfs.add(new int[]{0, j});
                pacific[0][j] = true;
            }
            if (!atlantic[M -1][j]) {
                atlanticBfs.add(new int[]{M - 1, j});
                atlantic[M - 1][j] = true;
            }
        }
        for (int i = 0; i < M; i++) {
            if (!pacific[i][0]) {
                pacificBfs.add(new int[]{i, 0});
                pacific[i][0] = true;
            }
            if (!atlantic[i][N-1]) {
                atlanticBfs.add(new int[]{i, N-1});
                atlantic[i][N-1] = true;
            }
        }

        // collect answers after bfs
        bfs(pacificBfs, pacific);
        bfs(atlanticBfs, atlantic);

        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < M; i ++) {
            for (int j = 0; j < N; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    answer.add(Arrays.asList(i, j));
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        var solution = new PacificAtlanticWaterFlow();
        int[][] sampleInput = new int[][]{
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        };
        solution.pacificAtlantic(sampleInput);
    }
}
