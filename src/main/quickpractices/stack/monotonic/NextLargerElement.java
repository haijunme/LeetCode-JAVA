package main.quickpractices.stack.monotonic;

import java.util.*;

public class NextLargerElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> cache = new HashMap<>();
        Stack<Integer> monotonic = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int current = nums2[i];
            while (!monotonic.isEmpty() && monotonic.peek() < current) {
                monotonic.pop();
            }
            int nextGreater = monotonic.isEmpty() ? -1 : monotonic.peek();
            cache.put(current, nextGreater);
            monotonic.push(current);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = cache.getOrDefault(nums1[i], -1);
        }
        return result;
    }

    public static void main(String[] args) {
        var solution = new NextLargerElement();
        System.out.println(Arrays.toString(solution.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
        System.out.println(Arrays.toString(solution.nextGreaterElement(new int[]{2,4}, new int[]{1, 2, 3, 4})));
    }
}
