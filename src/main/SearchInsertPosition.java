package main;

public class SearchInsertPosition {

    public int searchIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                if (mid == nums.length - 1) {
                    return nums.length;
                }
                if (mid < nums.length - 1 && target < nums[mid + 1]) {
                    return mid + 1;
                }
                start = mid + 1;
            }
            if (nums[mid] > target) {
                if (mid == 0) {
                    return 0;
                }
                if (target > nums[mid-1]) {
                    return mid;
                }
                end = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        System.out.println(searchInsertPosition.searchIndex(new int[] {1}, 0));
        System.out.println(searchInsertPosition.searchIndex(new int[] {1}, 7));
    }
}
