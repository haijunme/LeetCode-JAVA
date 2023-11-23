package main.prep2021.casestudies.longestpalindromicsubstring;

public class LongestPalindromicSubstringV1 {
    private boolean isPalindrome(char[] charArray, int i, int j) {
        while (i <= j) {
            if (charArray[i] != charArray[j]) return false;
            i++;
            j--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int maxLength = 1;
        int left = 0;
        int right = 0;
        for (int i = 0; i < charArray.length; i ++) {
            char starting = charArray[i];
            for (int j = i + maxLength; j < charArray.length; j ++) {
                if (charArray[j] != starting) {
                    continue;
                }
                if (isPalindrome(charArray, i, j) && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    left = i;
                    right = j;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = left; i <= right; i++) {
            builder.append(charArray[i]);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        LongestPalindromicSubstringV1 solution = new LongestPalindromicSubstringV1();
        System.out.println(solution.longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }
}
