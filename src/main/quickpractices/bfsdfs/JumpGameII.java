package main.quickpractices.bfsdfs;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameII {

    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        final int LAST_INDEX = nums.length - 1;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[LAST_INDEX + 1];
        queue.add(0);
        visited[0] = true;
        int jumps = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                int starting = queue.remove();
                int jumpLength = nums[starting];
                for (int j = 1; j <= jumpLength; j++) {
                    int destination = starting + j;
                    if (destination >= LAST_INDEX) {
                        return jumps + 1;
                    }
                    if (!visited[destination]) {
                        visited[destination] = true;
                        queue.add(destination);
                    }
                }
            }
            jumps++;
        }
        throw new RuntimeException("I should always be able to reach the end!");
    }

    public static void main(String[] args) {
        var solution = new JumpGameII();
        System.out.println(solution.jump(new int[]{2,3,1,1,4}));
    }
}
