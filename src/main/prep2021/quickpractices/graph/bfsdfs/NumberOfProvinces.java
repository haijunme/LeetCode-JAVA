package main.prep2021.quickpractices.graph.bfsdfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {

    private void bfs(int[][] isConnected, boolean[] visited, int i) {
        Queue<Integer> citiesToVisit = new LinkedList<>();
        citiesToVisit.add(i);
        while (!citiesToVisit.isEmpty()) {
            int currentCity = citiesToVisit.poll();
            if (visited[currentCity]) {
                continue;
            }
            visited[currentCity] = true;
            for (int j = 0; j < isConnected.length; j++) {
                if (j != currentCity && isConnected[currentCity][j] == 1) citiesToVisit.add(j);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        Arrays.fill(visited, false);
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i]) {
                continue;
            }
            count++;
            bfs(isConnected, visited, i);
        }
        return count;
    }

    public static void main(String[] args) {
        var solution = new NumberOfProvinces();
        System.out.println(solution.findCircleNum(new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}}));
    }
}
