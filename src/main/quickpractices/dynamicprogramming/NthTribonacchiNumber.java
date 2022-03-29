package main.quickpractices.dynamicprogramming;

public class NthTribonacchiNumber {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;

        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 1;
        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i-1] + memo[i-2] + memo[i-3];
        }
        return memo[n];
    }

    public static void main(String[] args) {
        NthTribonacchiNumber nthTribonacchiNumber = new NthTribonacchiNumber();
        System.out.println(nthTribonacchiNumber.tribonacci(25));
    }
}
