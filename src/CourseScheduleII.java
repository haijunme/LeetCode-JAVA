import java.util.*;

public class CourseScheduleII {
    HashMap<Integer, List<Integer>> graph = new HashMap<>();
    int[] indegrees;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[]{};
        }

        int[] answer = new int[numCourses];
        if (prerequisites.length == 0) {
            for (int i = 0; i < numCourses; i++) {
                answer[i] = i;
            }
            return answer;
        }

        indegrees = new int[numCourses];
        for (int[] prepreq : prerequisites) {
            int src = prepreq[1];
            int dest = prepreq[0];
            graph.computeIfAbsent(src, key -> new ArrayList<>());
            graph.get(src).add(dest);
            indegrees[dest] ++;
        }

        Queue<Integer> topological = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                topological.add(i);
            }
        }

        int insert = 0;
        while (!topological.isEmpty()) {
            int node = topological.remove();
            answer[insert++] = node;
            if (graph.get(node) == null) {
                continue;
            }
            for (int neighbour : graph.get(node)) {
                indegrees[neighbour] -= 1;
                if (indegrees[neighbour] == 0) {
                    topological.add(neighbour);
                }
            }
        }

        if (insert < numCourses) {
            return new int[]{};
        }

        return answer;
    }

    public static void main(String[] args) {
        CourseScheduleII courseScheduleII = new CourseScheduleII();
        System.out.println(Arrays.toString(courseScheduleII.findOrder(
                2,
                new int[][]{{1, 0}})));
        System.out.println(Arrays.toString(courseScheduleII.findOrder(
                4,
                new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
        System.out.println(Arrays.toString(courseScheduleII.findOrder(
                1,
                new int[][]{})));
        System.out.println(Arrays.toString(courseScheduleII.findOrder(
                3,
                new int[][]{{0, 2}, {1, 0}, {2, 1}})));
    }
}
