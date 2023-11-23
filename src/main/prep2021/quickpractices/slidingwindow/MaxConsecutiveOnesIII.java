package main.prep2021.quickpractices.slidingwindow;

import java.util.*;

public class MaxConsecutiveOnesIII {

    public int longestOnes(int[] nums, int k) {
        int max = 0;
        // indexes of zeroes we have kept so far
        Queue<Integer> zeroes = new LinkedList<>();
        int start = 0;

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];

            // we need to drop the left-most 0 to include the current 0
            if (current == 0) {
                if (k > 0) {
                    if (zeroes.size() == k) {
                        int leftMost = zeroes.poll();
                        start = leftMost + 1;
                    }
                    zeroes.add(i);
                } else {
                    start = i + 1;
                }
            }
            // negative results will always be smaller than 0
            max = Math.max(max, i - start + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        var solution = new MaxConsecutiveOnesIII();
        System.out.println(solution.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
}
