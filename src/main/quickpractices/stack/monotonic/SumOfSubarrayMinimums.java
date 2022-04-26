package main.quickpractices.stack.monotonic;

import java.util.*;

public class SumOfSubarrayMinimums {

    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] memo = new int[arr.length];
        int answer = 0;

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            while (!stack.empty() && arr[stack.peek()] > current) {
                stack.pop();
            }
            int lastIndex = stack.empty() ? -1 : stack.peek();
            int memoized = lastIndex < 0 ? 0 : memo[lastIndex];
            memo[i] = memoized + (i - lastIndex) * arr[i];
            answer = (answer + memo[i]) % 1_000_000_007;
            stack.push(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        var solution = new SumOfSubarrayMinimums();
        System.out.println(solution.sumSubarrayMins(new int[]{3,1,2,4}));
    }
}
