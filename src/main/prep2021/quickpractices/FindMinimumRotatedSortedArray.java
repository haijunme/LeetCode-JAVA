package main.prep2021.quickpractices;

public class FindMinimumRotatedSortedArray {

    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int start = 0;
        int end = nums.length - 1;
        if (nums[start] < nums[end]) {
            return nums[start];
        }

        while (start <= end) {
            int mid = start + (end - start)/2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[0] < nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
