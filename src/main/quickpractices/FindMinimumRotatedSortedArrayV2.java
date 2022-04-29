package main.quickpractices;

public class FindMinimumRotatedSortedArrayV2 {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        var soultion = new FindMinimumRotatedSortedArrayV2();
        System.out.println(soultion.findMin(new int[]{3,4,5}));
    }
}
