package main.quickpractices.graph;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Queue<Integer> starts = new ArrayDeque<>();

        for (int[] pair : prerequisites) {
            int end = pair[0];
            int start = pair[1];
            graph.putIfAbsent(start, new ArrayList<>());
            graph.get(start).add(end);
            indegrees[end] ++;
        }

        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) starts.add(i);
        }

        while (!starts.isEmpty()) {
            int count = starts.size();
            for (int i = 0; i < count; i++) {
                int start = starts.poll();
                if (graph.get(start) == null) {
                    continue;
                }
                for (Integer end : graph.get(start)) {
                    indegrees[end] --;
                    if (indegrees[end] == 0) {
                        starts.add(end);
                    }
                }
            }
        }

        for (int indegree : indegrees) {
            if (indegree != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        var solution = new CourseSchedule();
        System.out.println(solution.canFinish(2, new int[][]{{0,1}}));
    }
}
