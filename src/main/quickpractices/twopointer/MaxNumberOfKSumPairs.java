package main.quickpractices.twopointer;

import java.util.*;

public class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        if (nums.length >= 10_000) {
            Arrays.parallelSort(nums);
        } else {
            Arrays.sort(nums);
        }
        int operationCount = 0;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int left = nums[i];
            int right = nums[j];
            if (left + right == k) {
                operationCount ++;
                i++;
                j--;
            } else if (left + right > k) {
                j--;
            } else {
                i++;
            }
        }
        return operationCount;
    }
}
