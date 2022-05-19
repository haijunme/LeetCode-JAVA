package main.quickpractices.array;

import java.util.*;

public class ContainsDuplicate {
    private static class Sorting {
        public boolean containsDuplicate(int[] nums) {
            Arrays.sort(nums);
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i-1]) {
                    return true;
                }
            }
            return false;
        }
    }

    private static class UsingHashSet {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> seen = new HashSet<>();
            for (int number : nums) {
                if (!seen.add(number)) {
                    return true;
                }
            }
            return false;
        }
    }
}
