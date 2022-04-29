package main.quickpractices.binarysearch;

import java.util.Arrays;

public class MissingNumber {

    public int[] search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{left, right};
    }

    public static void main(String[] args) {
        var solution = new MissingNumber();
        System.out.println(Arrays.toString(solution.search(new int[]{1, 3, 5, 6, 7}, 4)));
    }
}
