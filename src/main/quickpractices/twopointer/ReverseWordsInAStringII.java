package main.quickpractices.twopointer;

import java.util.Arrays;

public class ReverseWordsInAStringII {
    private void reverseSubpart(char[] s, int left, int right) {
        int i = left;
        int j = right;
        while (i <= j) {
            char temporary = s[i];
            s[i] = s[j];
            s[j] = temporary;
            i++;
            j--;
        }
    }

    public void reverseWords(char[] s) {
        // reverse the whole string
       reverseSubpart(s, 0, s.length - 1);
        // then we reverse each substring
        int left = 0;
        for (int right = 0; right < s.length; right++) {
            if (s[right] == ' ') {
                reverseSubpart(s, left, right - 1);
                left = right + 1;
            }
        }
        reverseSubpart(s, left, s.length - 1);
    }

    public static void main(String[] args) {
        var solution = new ReverseWordsInAStringII();
        char[] input = new char[] {'a','b','c'};
        solution.reverseWords(input);
        System.out.println(Arrays.toString(input));
    }
}
