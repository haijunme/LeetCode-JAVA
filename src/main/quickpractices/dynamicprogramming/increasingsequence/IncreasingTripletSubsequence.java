package main.quickpractices.dynamicprogramming.increasingsequence;

public class IncreasingTripletSubsequence {

    public class PolynomialDP {
        public boolean increasingTriplet(int[] nums) {
            boolean[] memo = new boolean[nums.length];
            memo[0] = false;
            for (int i = 1; i < nums.length; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] < nums[i]) {
                        if (memo[j]) return true;
                        memo[i] = true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        var solution = new IncreasingTripletSubsequence();
        var dynamicDP = solution.new PolynomialDP();
        System.out.println(dynamicDP.increasingTriplet(new int[]{1,2}));
    }
}
