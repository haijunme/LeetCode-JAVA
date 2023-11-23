package main.prep2021.quickpractices.array.stringcharacters;

public class LongestParlindrome {

    public int longestPalindrome(String s) {
        int[] charCount = new int[128];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i)] ++;
        }
        int answer = 0;
        for (int count : charCount) {
            answer += count / 2 * 2;
            if (answer % 2 == 0 && count % 2 == 1) {
                answer += 1;
            }
        }
        return answer;
    }
}
