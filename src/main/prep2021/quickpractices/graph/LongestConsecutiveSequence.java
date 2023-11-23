package main.prep2021.quickpractices.graph;

import java.util.*;

public class LongestConsecutiveSequence {
    private int DFS(Map<Integer, Integer> graph, int start) {
        Stack<Integer> nodes = new Stack<>();
        nodes.add(start);
        int depth = 1;
        while (!nodes.isEmpty()) {
            int current = nodes.pop();
            if (graph.containsKey(current)) {
                nodes.push(graph.get(current));
                depth++;
            } else {
                break;
            }
        }
        return depth - 1;
    }

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> graph = new HashMap<>();
        // O(N) time complexity
        for (int number : nums) {
            // three O(1) operations
            graph.put(number, number + 1);
        }
        int max = 0;
        // DFS time complexity is O(V+E) and In our case, V = N, E = N, so O(2N)
        for (Integer node : graph.keySet()) {
            if (graph.containsKey(node - 1)) {
                continue;
            }
            max = Math.max(max, DFS(graph, node));
        }
        return max;
    }

    public static void main(String[] args) {
        var solution = new LongestConsecutiveSequence();
        System.out.println(solution.longestConsecutive(new int[]{}));
    }
}
