package main.prep2021.quickpractices.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {
    private char[] S;
    private int N;
    private Map<Integer, Integer> memo;

    private int recur(int lastIncluded) {
        if (memo.containsKey(lastIncluded)) {
            return memo.get(lastIncluded);
        }
        if (lastIncluded == N - 1) {
            return 1;
        }
        int answer = 0;
        if (lastIncluded + 1 < N && S[lastIncluded + 1] != '0') {
            answer += recur(lastIncluded + 1);
        }
        if (lastIncluded + 2 < N) {
            if (S[lastIncluded + 1] != '0') {
                int charCode = Character.getNumericValue(S[lastIncluded + 1]) * 10 + Character.getNumericValue(S[lastIncluded + 2]);
                if (1 <= charCode && charCode < 27) {
                    answer += recur(lastIncluded + 2);
                }
            }
        }
        memo.put(lastIncluded, answer);
        return answer;
    }

    public int numDecodings(String s) {
        this.S = s.toCharArray();
        this.N = s.length();
        this.memo = new HashMap<>();
        return recur(-1);
    }

    public static void main(String[] args) {
        var solution = new DecodeWays();
        System.out.println(solution.numDecodings("11106"));
    }
}
