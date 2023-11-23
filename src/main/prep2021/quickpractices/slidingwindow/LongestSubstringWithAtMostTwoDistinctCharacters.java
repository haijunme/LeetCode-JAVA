package main.prep2021.quickpractices.slidingwindow;

import java.util.*;

public class LongestSubstringWithAtMostTwoDistinctCharacters {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> occurrences = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = Integer.MIN_VALUE;

        while (i <= j && j < s.length()) {
            char current = s.charAt(j);
            if (occurrences.get(current) != null) {
                occurrences.put(current, occurrences.get(current) + 1);
                max = Math.max(max, j - i + 1);
                j++;
            } else {
                if (occurrences.keySet().size() < 2) {
                    occurrences.put(current, 1);
                    max = Math.max(max, j - i + 1);
                    j++;
                } else {
                    char unwanted = s.charAt(i);
                    if (occurrences.get(unwanted) == 1) {
                        occurrences.remove(unwanted);
                    } else {
                        occurrences.put(unwanted, occurrences.get(unwanted) - 1);
                    }
                    i++;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        var solution = new LongestSubstringWithAtMostTwoDistinctCharacters();
        System.out.println(solution.lengthOfLongestSubstringTwoDistinct("ccaabbb"));
    }
}
