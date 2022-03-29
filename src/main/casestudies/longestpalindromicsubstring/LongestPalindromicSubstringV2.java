package main.casestudies.longestpalindromicsubstring;

public class LongestPalindromicSubstringV2 {
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
        return s.substring(left, right+1);
    }
}
