package main.quickpractices;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            int currentNumber = nums[index];
            int desiredNumber = target - currentNumber;
            if (map.get(desiredNumber) == null) {
                map.put(currentNumber, index);
            } else {
                return new int[]{index, map.get(desiredNumber)};
            }
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 13}, 9)));
    }
}
