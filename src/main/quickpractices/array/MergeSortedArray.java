package main.quickpractices.array;

import java.util.Arrays;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (p2 < 0) {
                break;
            } else if (p1 < 0) {
                nums1[i] = nums2[p2--];
            } else {
                int number1 = nums1[p1];
                int number2 = nums2[p2];
                if (number1 >= number2) {
                    nums1[i] = number1;
                    p1--;
                } else {
                    nums1[i] = number2;
                    p2--;
                }
            }
        }
    }

    public static void main(String[] args) {
        var solution = new MergeSortedArray();
        int[] nums1 = new int[]{0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        solution.merge(nums1, 0, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
