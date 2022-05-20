package main.quickpractices.array;

import java.util.Arrays;

public class MajorityElement {

    private static class Sorting {
        public int majorityElement(int[] nums) {
            Arrays.parallelSort(nums);
            // N = 3, index = {0, 1, 2} => return 1
            // N = 4, index = {0, 1, 2, 3} => return 1
            return nums[(nums.length-1)/2];
        }
    }

    private static class ConstantSpace {
//        public int majorityElement(int[] nums) {
//
//        }
    }
}
