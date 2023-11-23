package main.prep2021.quickpractices.graph.bfsdfs;

import java.util.*;

public class MinimumKnightMoves {
    private static final int[][] EIGHT_DIRECTIONS = new int[][]{
            {1, 2}, {2, 1},
            {1, -2}, {2, -1},
            {-1, -2}, {-2, -1},
            {-1, 2}, {-2, 1}
    };

    public int minKnightMoves(int x, int y) {
        final int[] target = new int[]{x, y};
        Deque<int[]> bfsQueue = new ArrayDeque<>();
        boolean[][] visited = new boolean[607][607];
        int[] origin = new int[]{0,0};
        bfsQueue.addLast(origin);

        int moveNumber = 0;
        while (!bfsQueue.isEmpty()) {
            int breadth = bfsQueue.size();
            for (int i = 0; i < breadth; i++) {
                int[] current = bfsQueue.removeFirst();
                if (current[0] == x && current[1] == y) {
                    return moveNumber;
                }
                for (int[] move : EIGHT_DIRECTIONS) {
                    int[] next = new int[]{current[0] + move[0], current[1] + move[1]};
                    if (Arrays.equals(next, target)) {
                        return moveNumber + 1;
                    }
                    if (!visited[next[0] + 302][next[1] + 302]) {
                        visited[next[0] + 302][next[1] + 302] = true;
                        bfsQueue.addLast(next);
                    }
                }
            }
            moveNumber++;
        }
        return moveNumber;
    }

    public static void main(String[] args) {
        var solution = new MinimumKnightMoves();
        System.out.println(solution.minKnightMoves(5, 5));
    }
}
