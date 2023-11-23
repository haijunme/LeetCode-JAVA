package main.prep2021.quickpractices.stack.monotonic;

import java.util.*;

public class SumOfSubarrayRanges {
    private long getResult(int[] nums, Deque<Integer> maxIndex, long[] memo, int i) {
        int lastIndex = maxIndex.isEmpty() ? - 1 : maxIndex.peekLast();
        long previous = lastIndex < 0 ? 0 : memo[lastIndex];
        memo[i] = previous + ((long)(i - lastIndex)) * nums[i];
        maxIndex.addLast(i);
        return memo[i];
    }

    private long getAllRangeMaximum(int[] nums) {
        Deque<Integer> maxIndex = new ArrayDeque<>();
        long[] memo = new long[nums.length];
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!maxIndex.isEmpty() && nums[maxIndex.peekLast()] < nums[i]) {
                maxIndex.removeLast();
            }
            result += getResult(nums, maxIndex, memo, i);
        }
        return result;
    }

    private long getAllRangeMinimum(int[] nums) {
        Deque<Integer> minIndex = new ArrayDeque<>();
        long[] memo = new long[nums.length];
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!minIndex.isEmpty() && nums[minIndex.peekLast()] > nums[i]) {
                minIndex.removeLast();
            }
            result += getResult(nums, minIndex, memo, i);
        }
        return result;
    }

    public long subArrayRanges(int[] nums) {
        return getAllRangeMaximum(nums) - getAllRangeMinimum(nums) ;
    }

    public static void main(String[] args) {
        var solution = new SumOfSubarrayRanges();
        System.out.println(solution.subArrayRanges(new int[]{4,-2,-3,4,1}));
    }
}
