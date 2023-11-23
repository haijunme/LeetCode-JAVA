package main.prep2021.quickpractices.graph.bfsdfs;

import java.util.Arrays;

public class NetworkDelayTime {
    private static final int UNREACHABLE = Integer.MAX_VALUE;
    private int[][] weightGraph;

    private int maxDelay(int start) {
        int[] adjacency = weightGraph[start];
        int followingWeight = 0;
        for (int end : adjacency) {
            if (weightGraph[start][end] != UNREACHABLE) {
                followingWeight = Math.max(followingWeight, weightGraph[start][end] + maxDelay(end));
            }
        }
        return 0;
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        weightGraph = new int[n+1][n+1];
        for (int[] adjacency : weightGraph) {
            Arrays.fill(adjacency, UNREACHABLE);
        }
        for (int[] time : times) {
            int start = time[0];
            int end = time[1];
            int delay = time[2];
            weightGraph[start][end] = delay;
        }
        return maxDelay(k);
    }

    public static void main(String[] args) {
        var solution = new NetworkDelayTime();
        System.out.println(solution.networkDelayTime(new int[][]{{2,1,1}, {2,3,1}, {3,4,1}},4,2));
    }
}
