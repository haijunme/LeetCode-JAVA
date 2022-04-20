package main.quickpractices.dynamicprogramming.kadane;

/**
 * Modified Kadane
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int answer = max;

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int minProduct = current * min;
            int maxProduct = current * max;
            min = Math.min(current, Math.min(minProduct, maxProduct));
            max = Math.max(current, Math.max(minProduct, maxProduct));
            answer = Math.max(answer, max);
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
