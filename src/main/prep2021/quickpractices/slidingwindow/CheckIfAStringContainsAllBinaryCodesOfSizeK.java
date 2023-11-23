package main.prep2021.quickpractices.slidingwindow;

import java.util.*;

public class CheckIfAStringContainsAllBinaryCodesOfSizeK {
    public boolean hasAllCodes(String s, int k) {
        int need = 1 << k;
        Set<String> got = new HashSet<>();

        for (int i = k; i <= s.length(); i++) {
            String a = s.substring(i - k, i);
            if (!got.contains(a)) {
                got.add(a);
                need--;
                // return true when found all occurrences
                if (need == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        var solution = new CheckIfAStringContainsAllBinaryCodesOfSizeK();
        System.out.println(solution.hasAllCodes("0110", 2));
    }
}
