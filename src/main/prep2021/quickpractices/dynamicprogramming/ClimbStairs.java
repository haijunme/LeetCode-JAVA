package main.prep2021.quickpractices.dynamicprogramming;

public class ClimbStairs {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] memoized = new int[n + 1];
        memoized[1] = 1;
        memoized[2] = 2;
        for (int i = 3; i <= n; i++) {
            memoized[i] = memoized[i - 1] + memoized[i - 2];
        }
        return memoized[n];
    }

    public static void main(String[] args) {
        ClimbStairs solution = new ClimbStairs();
        System.out.println(solution.climbStairs(2));
    }
}
