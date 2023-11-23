package main.prep2021.quickpractices.prefixsum;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    private static class ThreePass {
        private int[] getMemo(int[] nums) {
            int[] memo = new int[nums.length];
            Arrays.fill(memo, 1);
            return memo;
        }

        public int[] productExceptSelf(int[] nums) {
            int[] leftProduct = getMemo(nums);
            for (int i = 1; i < nums.length; i++) {
                leftProduct[i] = leftProduct[i-1] * nums[i-1];
            }
            int[] rightProduct = getMemo(nums);
            for (int i = nums.length - 2; i >= 0; i--) {
                rightProduct[i] = rightProduct[i + 1] * nums[i + 1];
            }

            int[] answer = getMemo(nums);
            for (int i = 0; i < nums.length; i++) {
                answer[i] = leftProduct[i] * rightProduct[i];
            }
            return answer;
        }
    }

    private static class OneArray {
        private int[] getMemo(int[] nums) {
            int[] memo = new int[nums.length];
            Arrays.fill(memo, 1);
            return memo;
        }

        public int[] productExceptSelf(int[] nums) {
            int[] answer = getMemo(nums);
            for (int i = 1; i < nums.length; i++) {
                answer[i] = answer[i-1] * nums[i-1];
            }
            int rightProduct = 1;
            // nums: {1,2,3,4}
            // answer: {24,12,8,6}
            // rightProduct = 24
            for (int i = nums.length - 2; i >= 0; i--) {
                rightProduct *= nums[i+1];
                answer[i] *= rightProduct;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        var solution = new ThreePass();
        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
