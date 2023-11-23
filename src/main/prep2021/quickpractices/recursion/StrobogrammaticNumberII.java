package main.prep2021.quickpractices.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrobogrammaticNumberII {
    private int N = 0;

    private static final List<int[]> NUMBER_PAIRS = Arrays.asList(
            new int[]{1, 1}, new int[]{0, 0}, new int[]{8, 8},
            new int[]{6, 9}, new int[]{9, 6}
    );

    public List<String> findStrobogrammatic(int n) {
        if (this.N == 0) {
            this.N = n;
        }
        if (n == 0) {
            return Arrays.asList("");
        }
        if (n == 1) {
            return Arrays.asList("0", "1", "8");
        }
        List<String> nMinusTwoThStrings = findStrobogrammatic(n - 2);
        List<String> nthStrings = new ArrayList<>();
        for (String string : nMinusTwoThStrings) {
            for (int[] pair : NUMBER_PAIRS) {
                if (pair[0] == 0 && n == N) {
                    continue;
                }
                nthStrings.add(pair[0] + string + pair[1]);
            }
        }
        return nthStrings;
    }

    public static void main(String[] args) {
        var solution = new StrobogrammaticNumberII();
        solution.N = 0;
        //System.out.println(solution.findStrobogrammatic(1));
        //System.out.println(solution.findStrobogrammatic(3));
//        System.out.println(solution.findStrobogrammatic(3));
        System.out.println(solution.findStrobogrammatic(4));
    }
}
