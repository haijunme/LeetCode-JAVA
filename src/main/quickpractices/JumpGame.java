package main.quickpractices;

import java.util.Arrays;

public class JumpGame {

    private boolean dfs(int[] nums, int currentIndex, int[] possible) {
        if (currentIndex >= nums.length) {
            return false;
        }
        if (currentIndex == nums.length - 1) {
            return true;
        }
        if (possible[currentIndex] == 0) {
            return false;
        }
        int jumpDistance = nums[currentIndex];
        for (int i = currentIndex + 1; i <= currentIndex + jumpDistance; i++) {
            if (dfs(nums, i, possible)) {
                return true;
            } else {
                possible[i] = 0;
            }
        }
        possible[currentIndex] = 0;
        return false;
    }

    public boolean canJump(int[] nums) {
        int[] possible = new int[nums.length];
        Arrays.fill(possible, -1);
        return dfs(nums, 0, possible);
    }

    public static void main(String[] args) {
        var solution = new JumpGame();
        System.out.println(solution.canJump(new int[]{2}));
        System.out.println(solution.canJump(new int[]{2,3,1,1,4}));
    }
}
