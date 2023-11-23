package main.prep2021.quickpractices.graph.bfsdfs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathToGetFood {
    private char[][] grid;

    private int[] getStartingLocation() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '*') {
                    return new int[]{i, j};
                }
            }
        }
        throw new RuntimeException("Invalid Grid Input: There must be one starting position");
    }

    private char getCharFromGrid(int[] position) {
        return grid[position[0]][position[1]];
    }

    private void markPositionAsVisited(int[] position) {
        grid[position[0]][position[1]] = 'X';
    }

    private boolean isPositionValid(int[] position) {
        int x = position[0];
        int y = position[1];
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && getCharFromGrid(position) != 'X';
    }

    public int getFood(char[][] grid) {
        this.grid = grid;
        Queue<int[]> positions = new LinkedList<>();
        positions.add(getStartingLocation());
        int steps = 0;
        while (!positions.isEmpty()) {
            int size = positions.size();
            for (int i = 0; i < size; i++) {
                int[] currentPosition = positions.poll();
                if (currentPosition == null || !isPositionValid(currentPosition)) {
                    continue;
                }
                if (getCharFromGrid(currentPosition) == '#') {
                    return steps;
                }
                markPositionAsVisited(currentPosition);
                int x = currentPosition[0];
                int y = currentPosition[1];
                positions.add(new int[]{x + 1, y});
                positions.add(new int[]{x - 1, y});
                positions.add(new int[]{x, y + 1});
                positions.add(new int[]{x, y - 1});
            }
            steps++;
        }

        return -1;
    }

    public static void main(String[] args) {
        var solution = new ShortestPathToGetFood();
        char[][] testInput = new char[][]{
                {'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', '*', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'O', '#', 'O', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'X'}
        };
        System.out.println(solution.getFood(testInput));
    }
}
