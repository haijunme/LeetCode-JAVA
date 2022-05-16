package main.quickpractices.graph;

import java.util.*;

public class GrahValidTree {
    private static class TrackParent {
        public boolean validTree(int n, int[][] edges) {
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int[] edge : edges) {
                int left = edge[0];
                int right = edge[1];
                graph.putIfAbsent(left, new ArrayList<>());
                graph.putIfAbsent(right, new ArrayList<>());
                graph.get(left).add(right);
                graph.get(right).add(left);
            }
            // key: children node, value: parent node
            Map<Integer, Integer> parents = new HashMap<>();
            parents.put(0, -1);
            Stack<Integer> dfs = new Stack<>();
            dfs.add(0);
            int visited = 0;
            while (!dfs.isEmpty()) {
                visited++;
                Integer current = dfs.pop();
                if (!graph.containsKey(current)) {
                    continue;
                }
                for (Integer neighbour : graph.get(current)) {
                    if (Objects.equals(parents.get(current), neighbour)) {
                        continue;
                    }
                    if (parents.containsKey(neighbour)) {
                        return false;
                    }
                    parents.put(neighbour, current);
                    dfs.push(neighbour);
                }

            }
            return visited == n;
        }
    }

    public static void main(String[] args) {
        var solution = new TrackParent();
        System.out.println(solution.validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
    }
}
