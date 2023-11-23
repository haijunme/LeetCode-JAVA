package main.prep2021.quickpractices.graph.bfsdfs;

import java.util.*;

public class NumberOfDistinctIslands {
    private static class DfsWithHashcode {
        int M;
        int N;
        int[][] grid;
        boolean[][] visited;

        private void updateDequeIfValid(Deque<int[]> dfs, int x, int y) {
            if (x >= 0 && x < M && y >= 0 && y < N && !visited[x][y] && grid[x][y] == 1) {
                dfs.addLast(new int[]{x, y});
                visited[x][y] = true;
            }
        }

        private int getDfsPathHashCode(int x, int y) {
            List<int[]> path = new ArrayList<>();
            // a stack for DFS
            Deque<int[]> dfs = new ArrayDeque<>();
            int[] start = new int[]{x, y};
            dfs.add(start);
            visited[x][y] = true;

            while (!dfs.isEmpty()) {
                int[] current = dfs.removeLast();
                path.add(current);
                int currentX = current[0];
                int currentY = current[1];
                updateDequeIfValid(dfs, currentX + 1, currentY);
                updateDequeIfValid(dfs, currentX - 1, currentY);
                updateDequeIfValid(dfs, currentX, currentY + 1);
                updateDequeIfValid(dfs, currentX, currentY - 1);
            }

            path.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
            int xNormalization = path.get(0)[0];
            int yNormalization = path.get(0)[1];
            int[] normalizedPath = new int[path.size() * 2];
            int i = 0;
            for (int[] coordination : path) {
                normalizedPath[i++] = coordination[0] - xNormalization;
                normalizedPath[i++] = coordination[1] - yNormalization;
            }
            return Arrays.hashCode(normalizedPath);
        }

        public int numDistinctIslands(int[][] grid) {
            this.grid = grid;
            M = grid.length;
            N = grid[0].length;
            this.visited = new boolean[M][N];
            Set<Integer> uniqueIslandHashes = new HashSet<>();

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && grid[i][j] == 1) {
                        uniqueIslandHashes.add(getDfsPathHashCode(i, j));
                    }
                }
            }
            return uniqueIslandHashes.size();
        }
    }

    public static void main(String[] args) {
        var solution = new DfsWithHashcode();
        System.out.println(solution.numDistinctIslands(new int[][]{
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1}
        }));
    }
}
