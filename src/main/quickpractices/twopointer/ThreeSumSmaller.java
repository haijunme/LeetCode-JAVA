package main.quickpractices.twopointer;

import java.util.Arrays;

public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        final int N = nums.length;
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int left = i + 1, right = N - 1;
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] < target) {
                    answer += right - left++;
                } else {
                    right --;
                }
            }
        }
        return answer;
    }
}
