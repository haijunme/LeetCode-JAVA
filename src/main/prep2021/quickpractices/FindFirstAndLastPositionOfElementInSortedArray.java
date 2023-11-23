package main.prep2021.quickpractices;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    private int target = 0;
    private int left = -1;
    private int right = -1;

    private void updateLeftOrRight(int index) {
        if (left == -1) {
            left = index;
        } else {
            left = Math.min(left, index);
        }
        right = Math.max(right, index);
    }

    public void binarySearch(int[] nums, int start, int end) {
        if (start > end) {
            return;
        }

        int mid = start + (end - start)/2;
        if (nums[mid] == target) {
            updateLeftOrRight(mid);
        }
        binarySearch(nums, start, mid-1);
        binarySearch(nums, mid+1, end);
    }

    public int[] searchRange(int[] nums, int target) {
        this.target = target;
        binarySearch(nums, 0, nums.length - 1);
        return new int[]{left, right};
    }

    public static void main(String[] args) {
        var solution = new FindFirstAndLastPositionOfElementInSortedArray();
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5,7,7,8,8,10}, 6)));
        System.out.println(Arrays.toString(solution.searchRange(new int[]{}, 0)));
    }
}
