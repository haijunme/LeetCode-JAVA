package main.prep2021.quickpractices;

public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start)/2;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        var solution = new FindPeakElement();
        System.out.println(solution.findPeakElement(new int[]{0, 1}));
    }
}
