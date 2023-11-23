package main.prep2021.quickpractices.slidingwindow;

import java.util.*;

public class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> lastIndex = new HashMap<>();
        int[] prefixSums = new int[nums.length];
        int left = -1;
        int answer = (prefixSums[0] = nums[0]);
        lastIndex.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            prefixSums[i] = prefixSums[i-1] + current;
            if (lastIndex.containsKey(current)) {
                left = Math.max(left, lastIndex.get(current));
            }
            answer = Math.max(prefixSums[i] - (left != -1 ? prefixSums[left] : 0), answer);
            lastIndex.put(current, i);
        }
        return answer;
    }

    public static void main(String[] args) {
        var solution = new MaximumErasureValue();
        System.out.println(solution.maximumUniqueSubarray(new int[]{558,508,782,32,187,103,370,607,619,267,984,10}));
    }
}
