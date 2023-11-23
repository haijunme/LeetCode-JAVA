package main.prep2021.quickpractices.graph.bfsdfs;

import java.util.*;

public class WallsAndGates {
    private static final int EMPTY_ROOM = Integer.MAX_VALUE;
    private static final int GATE = 0;

    int M;
    int N;
    int[][] rooms;
    Queue<int[]> coordinations;

    private boolean isEmptyRoom(int x, int y) {
        return rooms[x][y] == EMPTY_ROOM;
    }

    private boolean isGate(int x, int y) {
        return rooms[x][y] == GATE;
    }

    private void processRoom(int x, int y, int level) {
        if (x >= 0 && x < M && y >=0 && y < N && isEmptyRoom(x, y)) {
            coordinations.add(new int[]{x, y});
            rooms[x][y] = level;
        }
    }

    /**
     * Do a level-based BFS to update values of all empty spaces
     * @param rooms a 2-D array representing a grid that contains gates, walls and empty spaces
     */
    public void wallsAndGates(int[][] rooms) {
        M = rooms.length;
        N = rooms[0].length;
        this.rooms = rooms;

        coordinations = new LinkedList<>();
        for (int i = 0; i < M; i ++) {
            for (int j = 0; j < N; j++) {
                if (isGate(i, j)) {
                    coordinations.add(new int[]{i, j});
                }
            }
        }

        int graphLevel = 0;
        while (!coordinations.isEmpty()) {
            int currentLevelCount = coordinations.size();
            graphLevel ++;
            for (int i = 0; i < currentLevelCount; i ++) {
                int[] start = coordinations.remove();
                int x = start[0];
                int y = start[1];
                processRoom(x - 1, y, graphLevel);
                processRoom(x + 1, y, graphLevel);
                processRoom( x, y  - 1, graphLevel);
                processRoom(x, y + 1, graphLevel);
            }
        }
    }

    public static void main(String[] args) {
        var solution = new WallsAndGates();
        int MAX = Integer.MAX_VALUE;
        int[][] sampleInput = new int[][] {
                {MAX, -1, 0, MAX},
                {MAX, MAX, MAX, -1},
                {MAX, -1, MAX, -1},
                {0, -1, MAX, MAX}
        };
        solution.wallsAndGates(sampleInput);
        for (int[] row : sampleInput) {
            System.out.println(Arrays.toString(row));
        }
    }
}
