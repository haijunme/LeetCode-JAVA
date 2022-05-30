package main.quickpractices.graph;

import java.util.*;

public class ParallelCourses {
    public int minimumSemesters(int n, int[][] relations) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegrees = new int[n+1];
        for (int[] edge : relations) {
            graph.get(edge[0]).add(edge[1]);
            indegrees[edge[1]]++;
        }
        boolean[] visited = new boolean[n+1];
        visited[0] = true;

        Deque<Integer> topological = new ArrayDeque<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (i != 0 && indegrees[i] == 0) {
                topological.addLast(i);
                visited[i] = true;
            }
        }
        int semasters = 0;
        while (!topological.isEmpty()) {
            int breadth = topological.size();
            semasters++;
            for (int i = 0; i < breadth; i++) {
                int current = topological.removeFirst();
                for (int destination : graph.get(current)) {
                    indegrees[destination] --;
                }
            }
            for (int i = 0; i < indegrees.length; i++) {
                if (indegrees[i] == 0 && !visited[i]) {
                    topological.addLast(i);
                    visited[i] = true;
                }
            }
        }
        for (int indegree : indegrees) {
            if (indegree != 0) return -1;
        }
        return semasters;
    }

    public static void main(String[] args) {
        var solution = new ParallelCourses();
        System.out.println(solution.minimumSemesters(5, new int[][]{{1,2}}));
    }
}
