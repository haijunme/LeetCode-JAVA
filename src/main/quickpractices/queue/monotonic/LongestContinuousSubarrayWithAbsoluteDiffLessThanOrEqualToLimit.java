package main.quickpractices.queue.monotonic;

import java.util.Deque;
import java.util.ArrayDeque;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int start = 0, end = 0;
        int maxSubArrayLen = 0;
        Deque<Integer> minDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();
        for (end = 0; end < n; end++) {
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[end]) {
                minDeque.removeLast();
            }
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[end]) {
                maxDeque.removeLast();
            }
            minDeque.addLast(end);
            maxDeque.addLast(end);
            while (start < end && nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                start++;
                while (!maxDeque.isEmpty() && maxDeque.peekFirst() < start) {
                    maxDeque.removeFirst();
                }
                while (!minDeque.isEmpty() && minDeque.peekFirst() < start) {
                    minDeque.removeFirst();
                }
            }
            maxSubArrayLen = Math.max(maxSubArrayLen, end - start + 1);
        }

        return maxSubArrayLen;
    }

    public static void main(String[] args) {
        var solution = new LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit();
        System.out.println(solution.longestSubarray(new int[]{8,2,4,7}, 4));
    }
}
