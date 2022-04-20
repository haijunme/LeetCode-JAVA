package main.quickpractices.dynamicprogramming.increasingsequence;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence {

    public int findNumberOfLIS(int[] nums) {
        int maxLen = 1;
        int[] length = new int[nums.length];// LIS length till index i
        int[] count = new int[nums.length];// max LIS count till index i
        Arrays.fill(length,1);// Default length at index = 1
        Arrays.fill(count,1);// Default count at index = 1

        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i;j++){ //Check with all prev nums, if they produce LIS ?
                if(nums[i] > nums[j]){ // Can for LIS
                    //As now its a new LIS length, check if new LIS length greater than existing ?
                    int newLISLengthEndingAtI = length[j]+1;
                    int existingLISLengthEndingAtI = length[i];
                    if(newLISLengthEndingAtI > existingLISLengthEndingAtI){// Found greater length
                        length[i] = newLISLengthEndingAtI;
                        count[i] = count[j];
                    }
                    else if(newLISLengthEndingAtI == existingLISLengthEndingAtI){
                        count[i] += count[j];
                    }
                }
            }
            maxLen = Math.max(maxLen,length[i]);
        }
        int maxCount = 0;
        for(int i=0;i < nums.length;i++) if(length[i] == maxLen) maxCount += count[i];
        return maxCount;
    }

    public static void main(String[] args) {

    }
}

