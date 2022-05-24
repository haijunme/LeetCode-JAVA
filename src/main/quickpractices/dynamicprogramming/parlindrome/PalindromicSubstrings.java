package main.quickpractices.dynamicprogramming.parlindrome;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int N = s.length(), answer = 0;
        boolean[][] memo = new boolean[N][N];
        // odd # palindrome - middle could be odd
        for (int i = 0; i < N; i++) {
            answer ++;
            memo[i][i] = true;
        }
        // even # palindromes = middle reduced to 2
        for (int i = 0; i < N - 1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                memo[i][i+1] = true;
                answer++;
            }
        }

        // check palindromes of all lengths
        for (int length = 3; length < s.length(); length++) {
            // eg. in the case of "abbcd", we check [0,2], [1,3], [2,4] then [0,3], [1,4], then [0, 5]
            for (int i = 0, j = i + length - 1; j < N; i++, j++) {
                memo[i][j] = memo[i+1][j-1] && (s.charAt(i) == s.charAt(j));
                answer += (memo[i][j]) ? 1 : 0;
            }
        }
        return answer;
    }
}
