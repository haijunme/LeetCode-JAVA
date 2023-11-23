package main.prep2021.quickpractices.math;

import java.util.*;

public class TheKthFactorOfN {
    public int kthFactor(int n, int k) {
        List<Integer> firstHalf = new ArrayList<>(100);
        List<Integer> secondHalf = new ArrayList<>(100);
        Set<Integer> seen = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            if (n/i*i == n && !seen.contains(n/i)) {
                seen.add(i);
                firstHalf.add(i);
                if (i != n/i) secondHalf.add(n/i);
            }
        }
        if (firstHalf.size() + secondHalf.size() < k) {
            return -1;
        } else if (k <= firstHalf.size()) {
            return firstHalf.get(k - 1);
        } else {
            // {12, 6, 4}
            // 5th element = 2nd element
            return secondHalf.get(secondHalf.size() + firstHalf.size() - k);
        }
    }

    public static void main(String[] args) {
        var solution = new TheKthFactorOfN();
        System.out.println(solution.kthFactor(12, 1));
        System.out.println(solution.kthFactor(12, 2));
        System.out.println(solution.kthFactor(12, 3));
        System.out.println(solution.kthFactor(12, 4));
        System.out.println(solution.kthFactor(12, 5));
        System.out.println(solution.kthFactor(12, 6));
        System.out.println(solution.kthFactor(12, 7));
    }
}
