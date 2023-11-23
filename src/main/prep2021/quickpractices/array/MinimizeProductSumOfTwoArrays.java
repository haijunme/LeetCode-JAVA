package main.prep2021.quickpractices.array;

import java.util.Arrays;

public class MinimizeProductSumOfTwoArrays {
    public int minProductSum(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int answer = 0;
        for (int i = 0; i < nums1.length; i++) {
            answer += nums1[i] * nums2[nums2.length - 1 - i];
        }
        return answer;
    }

    public static void main(String[] args) {
        var solution = new MinimizeProductSumOfTwoArrays();
        System.out.println(solution.minProductSum(new int[]{2, 1, 4, 5, 7}, new int[]{3, 2, 4, 8, 6}));
    }
}
