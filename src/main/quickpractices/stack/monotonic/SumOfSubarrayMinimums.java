package main.quickpractices.stack.monotonic;

import java.util.Stack;

public class SumOfSubarrayMinimums {

    private static class NaiveBrutalForce {
        // O(N^2) time complexity
        private int sumSubarrayMins(int[] arr) {
            int totalSum = 0;
            // calculate the globally optimized solution when an array element is selected
            // as the end of a sub-array
            for (int i = 0; i < arr.length; i++) {
                int min = arr[i];
                int sumSoFar = min;
                for (int j = i - 1; j >= 0; j--) {
                    min = Math.min(arr[j], min);
                    sumSoFar += min;
                }
                totalSum += sumSoFar;
            }
            return totalSum;
        }
    }

    private static class StupidRecursion {
        private int recur(int[] arr, int end) {
            if (end < 0) return 0;
            int sum = 0;
            int current = arr[end];
            int firstSmaller = -1;
            for (int j = end - 1; j >= 0; j--) {
                if (arr[j] < current) {
                    firstSmaller = j;
                    break;
                }
            }
            sum += current * (end - firstSmaller) + recur(arr, firstSmaller);
            return sum;
        }

        private int sumSubarrayMins(int[] arr) {
            int totalSum = 0;
            for (int i = 0; i < arr.length; i++) {
                totalSum += recur(arr, i);
            }
            return totalSum;
        }
    }

    private static class ImprovedPolynomial {
        private int sumSubarrayMins(int[] arr) {
            int totalSum = arr[0];
            int[] memo = new int[arr.length];
            memo[0] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                int firstSmaller = -1;
                // the worst case scenario is still O(n^2)
                for (int j = i - 1; j >= 0; j--) {
                    if (arr[j] < arr[i]) {
                        firstSmaller = j;
                        break;
                    }
                }
                int currentSum = arr[i] * (i - firstSmaller) + (firstSmaller >= 0 ? memo[firstSmaller] : 0);
                memo[i] = currentSum;
                totalSum += currentSum;
            }
            return totalSum;
        }
    }

    private static class MonotonicStack {
        private int sumSubarrayMins(int[] arr) {
            Stack<Integer> stack = new Stack<>();
            int[] memo = new int[arr.length];
            int answer = 0;

            for (int i = 0; i < arr.length; i++) {
                int current = arr[i];
                while (!stack.empty() && arr[stack.peek()] > current) {
                    stack.pop();
                }
                int lastIndex = stack.empty() ? -1 : stack.peek();
                //  memoized = previous part
                int memoized = lastIndex < 0 ? 0 : memo[lastIndex];
                memo[i] = memoized + (i - lastIndex) * arr[i];
                answer = (answer + memo[i]) % 1_000_000_007;
                stack.push(i);
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        int[] sampleInput = new int[]{1,2,3};
//        var solution = new SumOfSubarrayMinimums();
//        System.out.println(solution.sumSubarrayMins(new int[]{3,1,2,4}));

//        var naiveBrutalForce = new NaiveBrutalForce();
//        System.out.println(naiveBrutalForce.sumSubarrayMins(sampleInput));
//
//        var stupidRecursion = new StupidRecursion();
//        System.out.println(stupidRecursion.sumSubarrayMins(sampleInput));

        var solution = new MonotonicStack();
        System.out.println(solution.sumSubarrayMins(sampleInput));
    }
}
