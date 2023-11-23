package main.prep2021.quickpractices.array;

import java.util.*;

public class LongestArithmeticSubsequence {
    public int longestArithSeqLength(int[] nums) {
        int maxLen = 0;
        int n = nums.length;
        Map<Integer,int[]> dp = new HashMap<>();
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                int diff = nums[i] - nums[j];
                dp.computeIfAbsent(diff, k -> new int[n]);
                dp.get(diff)[i] = dp.get(diff)[j] + 1;
                maxLen = Math.max(maxLen, dp.get(diff)[i]);
            }
        }
        return maxLen + 1;
    }

    public static void main(String[] args) {
        var solution = new LongestArithmeticSubsequence();
        System.out.println(solution.longestArithSeqLength(new int[]{44,46,22,68,45,66,43,9,37,30,50,67,32,47,44,11,15,4,11,6,20,64,54,54,61,63,23,43,3,12,51,61,16,57,14,12,55,17,18,25,19,28,45,56,29,39,52,8,1,21,17,21,23,70,51,61,21,52,25,28}));
    }
}
