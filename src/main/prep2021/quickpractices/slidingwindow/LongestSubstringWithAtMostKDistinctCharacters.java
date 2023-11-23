package main.prep2021.quickpractices.slidingwindow;

import java.util.*;

public class LongestSubstringWithAtMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if (n * k == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;

        Map<Character, Integer> rightmostPosition = new LinkedHashMap<>();

        int maxLength = 1;

        while (right < n) {
            Character character = s.charAt(right);
            rightmostPosition.put(character, right++);

            if (rightmostPosition.size() == k + 1) {
                Map.Entry<Character, Integer> leftmost =
                        rightmostPosition.entrySet().iterator().next();
                rightmostPosition.remove(leftmost.getKey());
                left = leftmost.getValue() + 1;
            }

            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
}
