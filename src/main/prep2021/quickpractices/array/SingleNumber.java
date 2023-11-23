package main.prep2021.quickpractices.array;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            answer ^= nums[i];
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
