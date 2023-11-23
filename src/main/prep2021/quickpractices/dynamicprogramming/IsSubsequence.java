package main.prep2021.quickpractices.dynamicprogramming;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        if (s.equals(t)) return true;
        if (tChars.length == 0) return false;
        if (sChars.length == 0) return true;

        char sequenceStart = sChars[0];
        for (int i = 0; i < tChars.length; i ++) {
            if (tChars[i] != sequenceStart) {
                continue;
            }
            int k = 1;
            for (int j = i + 1; j < tChars.length; j++) {
                if (k == sChars.length) return true;
                if (sChars[k] == tChars[j]) {
                    k ++;
                }
            }
            if (k == sChars.length) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        IsSubsequence solution = new IsSubsequence();
        System.out.println(solution.isSubsequence("b", "ab"));
    }
}
