package main.quickpractices.array;

public class MedianOfTwoSortedArrayLinear {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int M = nums1.length;
        final int N = nums2.length;
        if (M + N == 0) {
            return 0.0;
        }
        // populate merged
        int[] merged = new int[M + N];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < M && j < N) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }
        // if nums2 already exhausted
        while (i < M) {
            merged[k++] = nums1[i++];
        }
        // if nums 1 already exhausted
        while (j < N) {
            merged[k++] = nums2[j++];
        }

        // return result
        if ((M + N) % 2 != 0) {
            return (double) merged[(M + N - 1)/2];
        } else {
            int mid = (M + N) / 2;
            return (merged[mid - 1] + merged[mid]) / 2.0;
        }
    }

    public static void main(String[] args) {
        var solution = new MedianOfTwoSortedArrayLinear();
        System.out.println(solution.findMedianSortedArrays(new int[]{}, new int[]{}));
    }
}
