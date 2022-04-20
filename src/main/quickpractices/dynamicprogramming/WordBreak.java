package main.quickpractices.dynamicprogramming;

import java.util.*;

public class WordBreak {
    private Set<String> words;
    private int N;
    private Boolean[] memo;
    private String S;

    private boolean recur(int start) {
        if (start == N) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int i = start + 1; i <= N; i ++) {
            if (words.contains(S.substring(start, i)) && recur(i)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }


    public boolean wordBreak(String s, List<String> wordDict) {
        S = s;
        N = s.length();
        words = new HashSet<>(wordDict);
        memo = new Boolean[N];
        Arrays.fill(memo, null);
        return recur(0);
    }
}
