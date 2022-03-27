package main;

import java.util.Arrays;

public class TwoSumsII {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int currentSum = numbers[left] + numbers[right];
            if (currentSum == target) {
                return new int[]{left, right};
            } else if (currentSum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        TwoSumsII twoSumsII = new TwoSumsII();
        System.out.println(Arrays.toString(twoSumsII.twoSum(new int[]{2,3,4}, 6)));
    }
}
