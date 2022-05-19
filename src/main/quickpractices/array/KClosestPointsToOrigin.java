package main.quickpractices.array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    // sqrt(x^2 + y^2) and sqrt(a^2 + b^2)
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (a,b) -> a[0]*a[0] + a[1]*a[1] - b[0]*b[0] - b[1]*b[1]);
        queue.addAll(Arrays.asList(points));
        int[][] answer = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] current = queue.remove();
            answer[i][0] = current[0];
            answer[i][1] = current[1];
        }
        return answer;
    }

    public static void main(String[] args) {
        var solution = new KClosestPointsToOrigin();
        System.out.println(Arrays.deepToString(solution.kClosest(new int[][]{
                {3, 3}, {5, -1}, {-2, 4}
        }, 2)));
    }
}
