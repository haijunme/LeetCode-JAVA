package main.quickpractices.binarysearch;

public class MissingElementInSortedArray {
    private int[] nums;

    private int missingCount(int j) {
        return nums[j]-nums[0]-j;
    }


    public int missingElement(int[] nums, int k) {
        int N = nums.length;
        this.nums = nums;

        int i = 0;
        int j = N-1;

        if (this.missingCount(j) < k) {
            return nums[j] + k - this.missingCount(j);
        }

        while (i < j) {
            int mid = i + (j-i)/2;
            int missingCount = this.missingCount(mid);
            if (missingCount >= k) {
                j = mid;
            } else {
                i = mid+1;
            }
        }
        return nums[i-1] + (k - missingCount(i-1));
    }
}
