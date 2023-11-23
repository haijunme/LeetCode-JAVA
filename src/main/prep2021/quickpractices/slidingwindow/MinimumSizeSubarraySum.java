package main.prep2021.quickpractices.slidingwindow;

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, left = 0, right = 0, minLength = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        var solution = new MinimumSizeSubarraySum();
        System.out.println(solution.minSubArrayLen(4, new int[]{1,4,4}));
    }
}
