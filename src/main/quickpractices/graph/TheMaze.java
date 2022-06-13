package main.quickpractices.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class TheMaze {
    private int M;
    private int N;
    private final List<int[]> FOUR_DIRECTIONS = Arrays.asList(
            new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, -1}, new int[]{0, 1}
    );

    private int[] getDestination(int[][] maze, int[] start, int[] direction) {
        int[] destination = new int[]{start[0], start[1]};
        while (true) {
            int nextX = destination[0] + direction[0];
            int nextY = destination[1] + direction[1];
            if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N || maze[nextX][nextY] == 1) {
                break;
            }
            destination[0] = nextX;
            destination[1] = nextY;
        }
        return destination;
    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        M = maze.length;
        N = maze[0].length;
        boolean[][] visited = new boolean[M][N];

        Deque<int[]> bfsQueue = new ArrayDeque<>();
        bfsQueue.addLast(start);
        visited[start[0]][start[1]] = true;
        while (!bfsQueue.isEmpty()) {
            int breadth = bfsQueue.size();
            for (int i = 0; i < breadth; i++) {
                int[] current = bfsQueue.removeFirst();
                for (int[] direction : FOUR_DIRECTIONS) {
                    int[] potentialDest = getDestination(maze, current, direction);
                    if (Arrays.equals(potentialDest, destination)) {
                        return true;
                    }
                    if (!visited[potentialDest[0]][potentialDest[1]]) {
                        visited[potentialDest[0]][potentialDest[1]] = true;
                        bfsQueue.add(potentialDest);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        var solution = new TheMaze();
        System.out.println(solution.hasPath(
                new int[][]{{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}},
                new int[]{0,4},
                new int[]{3,2}
        ));
    }
}
