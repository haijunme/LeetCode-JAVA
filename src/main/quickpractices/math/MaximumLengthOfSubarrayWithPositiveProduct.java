package main.quickpractices.math;

public class MaximumLengthOfSubarrayWithPositiveProduct {
    private int getSubarrayMaxLength(int[] nums, int left, int right) {
        if (left > right) return 0;
        if (left == right) return nums[left] < 0 ? 0 : 1;
        int numberOfNegatives = 0;
        int firstNegative = Integer.MIN_VALUE;
        int lastNegative = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] < 0) {
                if (firstNegative == Integer.MIN_VALUE) firstNegative = i;
                lastNegative = i;
                numberOfNegatives ++;
            }
        }
        if (numberOfNegatives % 2 == 0) {
            return right - left + 1;
        }
        int totalLength = right - left + 1;
        return totalLength - Math.min(firstNegative - left + 1, right - lastNegative + 1);
    }

    public int getMaxLen(int[] nums) {
        int left = -1;
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                answer = Math.max(answer, getSubarrayMaxLength(nums, left + 1, i - 1));
                left = i;
            } else if (i == nums.length - 1) {
                answer = Math.max(answer, getSubarrayMaxLength(nums, left + 1, i));
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        var solution = new MaximumLengthOfSubarrayWithPositiveProduct();
        System.out.println(solution.getMaxLen(new int[]{1}));
    }
}
