package main.prep2021.quickpractices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSums {
    List<List<Integer>> result = new ArrayList<>();

    private void twoSum(int[] nums, int base, int startingIndex) {
        int left = startingIndex;
        int right = nums.length-1;
        while (left < right) {
            int sum = base + nums[left] + nums[right];
            if (sum > 0) {
                right --;
            } else if (sum < 0) {
                left ++;
            } else {
                result.add(List.of(base, nums[left], nums[right]));
                while (left + 1 < nums.length && nums[left] == nums[left+1]) {
                    left++;
                }
                left++;
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int lastNumber = Integer.MIN_VALUE;
        for (int i = 0; i <= nums.length-3; i++) {
            int currentNumber = nums[i];
            if (currentNumber != lastNumber) {
                twoSum(nums, currentNumber, i+1);
                lastNumber = currentNumber;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var solution = new ThreeSums();
        var result = solution.threeSum(new int[]{1,2,-3,-3});
        for (List<Integer> triplet : result) {
            System.out.println(triplet.toString());
        }
    }
}
