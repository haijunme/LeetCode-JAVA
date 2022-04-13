package main.quickpractices.array;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSums {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> existingNums = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            int desired = target - currentNum;
            if (existingNums.get(desired) == null) {
                existingNums.put(currentNum, i);
            } else {
                return new int[]{existingNums.get(desired), i};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        var solution = new TwoSums();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{3,3}, 6)));
    }
}
