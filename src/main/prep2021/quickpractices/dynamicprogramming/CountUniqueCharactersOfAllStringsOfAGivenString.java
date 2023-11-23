package main.prep2021.quickpractices.dynamicprogramming;

import java.util.*;

public class CountUniqueCharactersOfAllStringsOfAGivenString {

    public int uniqueLetterString(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[][] dp = new int[26][2];

        for (int i = 0; i < 26; i ++) {
            Arrays.fill(dp[i], -1);
        }
        // using bottom up DP approach
        // dp[charIndex][0] representing value from previous position
        // dp[charIndex][1] representing value from current position
        int res = 0;
        for (int i = 0; i < s.length(); i ++) {
            int charIndex = s.charAt(i) - 'A';
            dp[charIndex][0] = dp[charIndex][1];
            dp[charIndex][1] = i;
            // dynamically calculating increase from last position to current position for all chars
            // for example,
            // for "A",  dp value dp[0][0] = -1; dp[0][1] = 0
            // for "AB", dp value will be:
            //      dp[0][0]: -1 (from last position),  dp[0][1]: 0
            //      dp[1][0]: -1, dp[1][1] = 1;
            // for "AA" dp value would be:
            //      dp[0][0]: 0 (copy from dp[0][1] of last position),  dp[0][1]: 1
            int tmp = 0;
            for (int j = 0; j < 26; j ++) {
                tmp += (dp[j][1] - dp[j][0]);
            }
            res += tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        var solution = new CountUniqueCharactersOfAllStringsOfAGivenString();
        System.out.println(solution.uniqueLetterString("AB"));
    }
}
