package main.quickpractices.bfsdfs;

import java.util.*;

public class NumberOfOperationsToMakeNetworkConnected {
    private Map<Integer, List<Integer>> graph;
    private boolean[] visited;

    private int dfs(int start) {
        if (visited[start] || !graph.containsKey(start)) {
            return 0;
        }
        visited[start] = true;
        int result = 1;
        for (Integer destination : graph.get(start)) {
            result += dfs(destination);
        }
        return result;
    }

    public int makeConnected(int n, int[][] connections) {
        int totalCablesAvailable = connections.length;
        visited = new boolean[n];

        // construct the graph
        graph = new HashMap<>();
        for (int[] edge : connections) {
            int start = edge[0];
            int end = edge[1];
            graph.putIfAbsent(start, new ArrayList<>());
            graph.putIfAbsent(end, new ArrayList<>());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        int cablesKept = 0;
        int disconnectedGraphCount = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                disconnectedGraphCount++;
                int temporary =  dfs(i);
                cablesKept += temporary > 0 ? temporary - 1 : 0;
            }
        }
        int movedCables = totalCablesAvailable - (cablesKept + (disconnectedGraphCount - 1));
        return movedCables >= 0 ? disconnectedGraphCount - 1 : -1;
    }

    public static void main(String[] args) {
        var solution = new NumberOfOperationsToMakeNetworkConnected();
        System.out.println(solution.makeConnected(6, new int[][]{
                {0,1},{0,2},{0,3},{1,2}
        }));
    }
}
