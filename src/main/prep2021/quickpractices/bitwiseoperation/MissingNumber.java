package main.prep2021.quickpractices.bitwiseoperation;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int answer = 0;
        for (int number : nums) {
            answer ^= number;
        }
        for (int i = 0; i <= nums.length; i++) {
            answer ^= i;
        }
        return answer;
    }
}
