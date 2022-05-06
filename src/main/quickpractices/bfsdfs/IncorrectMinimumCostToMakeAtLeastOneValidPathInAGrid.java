package main.quickpractices.bfsdfs;

import java.util.*;

public class IncorrectMinimumCostToMakeAtLeastOneValidPathInAGrid {
    private Map<Integer, List<int[]>> graphs;
    private Map<Integer, List<Integer>> graphAdjacency;
    private int[][] grid;
    private boolean[][] cellVisited;
    private int M;
    private int N;

    private boolean isCellValid(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N && !cellVisited[x][y];
    }

    private boolean isCellIndepedent(int x, int y) {
        boolean result = true;
        if (isCellValid(x - 1, y )) {
            result = result && grid[x - 1][y] != 3;
        }
        if (isCellValid(x + 1, y )) {
            result = result && grid[x + 1][y] != 4;
        }
        if (isCellValid(x, y - 1)) {
            result = result && grid[x][y - 1] != 1;
        }
        if (isCellValid(x, y + 1)) {
            result = result && grid[x][y + 1] != 2;
        }
        return result;
    }

    private void storeGraph(int subgraphId, int x, int y) {
        List<int[]> graphMembers = new ArrayList<>();
        Queue<int[]> bfsQueue = new LinkedList<>();
        bfsQueue.add(new int[]{x, y});
        graphMembers.add(bfsQueue.peek());
        cellVisited[x][y] = true;

        while (!bfsQueue.isEmpty()) {
            int[] cell = bfsQueue.remove();
            int cellX = cell[0];
            int cellY = cell[1];
            int direction = grid[cellX][cellY];
            if (direction == 1) {
                cellY++;
            } else if (direction == 2) {
                cellY--;
            } else if (direction == 3) {
                cellX++;
            } else {
                cellX--;
            }
            if (isCellValid(cellX, cellY)) {
                int[] newCell = new int[]{cellX, cellY};
                cellVisited[cellX][cellY] = true;
                bfsQueue.add(newCell);
                graphMembers.add(newCell);
            }
        }
        graphs.put(subgraphId, graphMembers);
    }

    private boolean areAdjacent(int graph1, int graph2) {
        List<int[]> graph1Members = graphs.get(graph1);
        List<int[]> graph2Members = graphs.get(graph2);
        for (int[] member1 : graph1Members) {
            for (int[] member2 : graph2Members) {
                if (Math.abs(member1[0] - member2[0]) + Math.abs(member1[1] - member2[1]) == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private void buildGraphAdjacency() {
        List<Integer> subgraphs = new ArrayList<>(graphs.keySet());
        for (int i = 1; i <= subgraphs.size(); i++) {
            for (int j = i + 1; j <= subgraphs.size(); j++) {
                if (graphs.containsKey(i) && graphs.containsKey(j) && areAdjacent(i, j)) {
                    graphAdjacency.putIfAbsent(i, new ArrayList<>());
                    graphAdjacency.get(i).add(j);
                }
            }
        }
    }

    public int minCost(int[][] grid) {
        this.M = grid.length;
        this.N = grid[0].length;
        this.graphAdjacency = new HashMap<>();
        this.graphs = new HashMap<>();
        this.cellVisited = new boolean[M][N];
        this.grid = grid;
        int subgraphId = 1;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!cellVisited[i][j] && isCellIndepedent(i, j)) {
                    storeGraph(subgraphId++, i, j);
                }
            }
        }
        if (graphs.size() <= 2) {
            return graphs.size() - 1;
        }
        buildGraphAdjacency();

        // Another BFS for the shortest path
        Queue<Integer> bfsQueue = new LinkedList<>();
        boolean[] subgraphVisited = new boolean[subgraphId];
        subgraphVisited[1] = true;
        bfsQueue.add(1);
        int depth = 0;
        while (!bfsQueue.isEmpty()) {
            depth ++;
            int breadth = bfsQueue.size();
            for (int i = 0; i < breadth; i ++) {
                int current = bfsQueue.remove();
                if (!graphAdjacency.containsKey(current)) {
                    continue;
                }
                for (Integer adjacentGraph : graphAdjacency.get(current)) {
                    if (adjacentGraph == subgraphId - 1) {
                        return depth;
                    }
                    if (!subgraphVisited[adjacentGraph]) {
                        subgraphVisited[adjacentGraph] = true;
                        bfsQueue.add(adjacentGraph);
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        var solution = new IncorrectMinimumCostToMakeAtLeastOneValidPathInAGrid();
        System.out.println(solution.minCost(new int[][]{
                {2,2,2},
                {2,2,2}
        }));
    }
}
