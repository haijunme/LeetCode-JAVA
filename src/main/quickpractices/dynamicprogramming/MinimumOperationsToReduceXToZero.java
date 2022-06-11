package main.quickpractices.dynamicprogramming;

import java.util.*;

public class MinimumOperationsToReduceXToZero {
    public int minOperations(int[] nums, int x) {
        Map<Integer, Integer> leftToRight = new HashMap<>();
        int accumulativeLeft = 0;
        int minOperations = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            accumulativeLeft += nums[i];
            leftToRight.put(accumulativeLeft, i);
            if (accumulativeLeft == x) {
                minOperations = i + 1;
            }
        }
        int accumulativeRight = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            accumulativeRight += nums[i];
            if (accumulativeRight == x) {
                minOperations = Math.min(minOperations, nums.length - i);
            }
            int remaining = x - accumulativeRight;
            if (leftToRight.containsKey(remaining) && leftToRight.get(remaining) < i) {
                minOperations = Math.min(minOperations, nums.length - i + leftToRight.get(remaining) + 1) ;
            }
        }
        return minOperations == Integer.MAX_VALUE ? -1 : minOperations;
    }

    public static void main(String[] args) {
        var solution = new MinimumOperationsToReduceXToZero();
        System.out.println(solution.minOperations(new int[]{1,1,4,2,3}, 5));
        System.out.println(solution.minOperations(new int[]{5,6,7,8,9}, 4));
        System.out.println(solution.minOperations(new int[]{3,2,20,1,1,3}, 10));
    }
}
