package main.quickpractices.dynamicprogramming;

public class GetMaximumInGeneratedArray {
    public int getMaximumGenerated(int n) {
        if (n < 2) return n;
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        int max = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                memo[i] = memo[i / 2];
            } else {
                memo[i] = memo[i / 2] + memo[i / 2 + 1];
            }
            max = Math.max(memo[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        GetMaximumInGeneratedArray solution = new GetMaximumInGeneratedArray();
        System.out.println(solution.getMaximumGenerated(7));
    }
}
