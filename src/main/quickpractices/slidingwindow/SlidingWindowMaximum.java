package main.quickpractices.slidingwindow;

import java.util.*;

public class SlidingWindowMaximum {
    private int[] nums;

    private void cleanDeque(Deque<Integer> deque, int i, int k) {
        // index based check
        if (deque.peekFirst() != null && deque.peekFirst() <= i - k) {
            deque.removeFirst();
        }
        // value based check
        while (deque.peekLast() != null && nums[deque.peekLast()] < nums[i]) {
            deque.removeLast();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        // initialization
        int[] output = new int[nums.length - k + 1];
        // this deque will store indexes, not actual values
        Deque<Integer> deque = new ArrayDeque<>();
        this.nums = nums;

        // for the first sliding window
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            cleanDeque(deque, i, k);
            deque.add(i);
            max = Math.max(max, nums[i]);
        }
        int j = 0;
        output[j++] = max;
        // building up the final output
        for (int i = k; i < nums.length; i++) {
            cleanDeque(deque, i, k);
            deque.addLast(i);
            output[j++] = nums[deque.peekFirst()];
        }

        return output;
    }

    public static void main(String[] args) {
        var solution = new SlidingWindowMaximum();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
