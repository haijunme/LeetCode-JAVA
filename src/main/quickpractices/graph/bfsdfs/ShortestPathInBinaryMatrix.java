package main.quickpractices.graph.bfsdfs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    private int n;
    private int[][] grid;

    private int[] createRecord(int x, int y) {
        return new int[]{x, y};
    }

    private void updateQueueIfValid(Queue<int[]> queue, int[] position) {
        int x = position[0];
        int y = position[1];
        if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0) {
            queue.add(position);
            grid[x][y] = 1;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        this.n = grid.length;
        this.grid = grid;

        // Top-left and bottom-right must be 0
        if (grid[0][0] != 0 || grid[n-1][n-1] != 0) {
            return -1;
        }

        // do a BFS search
        Queue<int[]> positionQueue = new LinkedList<>();
        positionQueue.add(createRecord(0, 0));
        grid[0][0] = 1;
        int pathLength = 1;

        while (!positionQueue.isEmpty()) {
            int initialSize = positionQueue.size();
            for (int i = 0; i < initialSize; i ++) {
                int[] currentPosition = positionQueue.remove();
                int x = currentPosition[0];
                int y = currentPosition[1];
                if (x == n-1 && y == n-1) {
                    return pathLength;
                }
                for (int newX = x-1; newX <= x+1; newX++) {
                    for (int newY = y-1; newY <= y+1; newY++) {
                        if (newX == x && newY == y) continue;
                        updateQueueIfValid(positionQueue, createRecord(newX, newY));
                    }
                }
            }
            pathLength++;
        }

        return -1;
    }

    public static void main(String[] args) {
        var solution = new ShortestPathInBinaryMatrix();
        System.out.println(solution.shortestPathBinaryMatrix(new int[][]{
                {0,0,1},
                {0,1,1},
                {1,1,0}
        }));
    }
}
