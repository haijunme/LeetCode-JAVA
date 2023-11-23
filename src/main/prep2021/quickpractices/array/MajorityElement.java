package main.prep2021.quickpractices.array;

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

    private static class BoyerMooreVotingAlgorithm {
        public int majorityElement(int[] nums) {
            int count = 0;
            Integer candidate = null;
            for (int num : nums) {
                if (count == 0) {
                    candidate = num;
                }
                count += (num == candidate) ? 1 : -1;
            }
            return candidate;
        }
    }
}
