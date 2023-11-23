package main.prep2021.quickpractices;

public class SearchInRotatedSortedArray {
    public static int modifiedBinarySearch(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        int middle = (start + end) / 2;
        if (nums[middle] == target) {
            return middle;
        }
        if (nums[middle] < nums[end]) {
            if (nums[middle] < target && target < nums[end]) {
                return modifiedBinarySearch(nums, target, middle + 1, end);
            }
            return modifiedBinarySearch(nums, target, start, middle - 1);
        } else {
            if (nums[start] < target && target < nums[middle]) {
                return modifiedBinarySearch(nums, target, start, middle - 1);
             }
            return modifiedBinarySearch(nums, target, middle + 1, end);
        }
    }

    public static int search(int[] nums, int target) {
        return modifiedBinarySearch(nums, target, 0, nums.length - 1);
    }

    public static void main(String[] args) {
//        System.out.println(search(new int[]{4,5,6,0,1,2}, 4));
//        System.out.println(search(new int[]{4,5,6,0,1,2}, 5));
//        System.out.println(search(new int[]{4,5,6,0,1,2}, 6));
//        System.out.println(search(new int[]{4,5,6,0,1,2}, 0));
//        System.out.println(search(new int[]{4,5,6,0,1,2}, 1));
//        System.out.println(search(new int[]{4,5,6,0,1,2}, 2));
//
//        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 4));
//        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 5));
//        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 6));
//        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 7));
//        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));
//        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 1));
//        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 2));
        //7 0 1 2
        System.out.println(search(new int[]{1,3,5}, 4));
    }
}
