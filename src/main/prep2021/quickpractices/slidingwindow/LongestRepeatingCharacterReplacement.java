package main.prep2021.quickpractices.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    private static class NaiveHashmap {
        private boolean isWindowValid(Map<Character, Integer> occurrences, int k, int windowSize) {
            if (k == 0) {
                return occurrences.keySet().size() == 1;
            } else if (occurrences.keySet().size() > k + 1) {
                return false;
            }

            int max = 0;
            for (Map.Entry<Character, Integer> entry : occurrences.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                }
            }
            return windowSize - max <= k;
        }

        public int characterReplacement(String s, int k) {
            Map<Character, Integer> occurrences = new HashMap<>();
            int left = 0;
            int right = 0;
            int max = Integer.MIN_VALUE;
            while (right < s.length()) {
                char current = s.charAt(right);
                occurrences.put(current, occurrences.getOrDefault(current, 0) + 1);
                while (!isWindowValid(occurrences, k, right - left + 1)) {
                    char unwanted = s.charAt(left);
                    occurrences.put(unwanted, occurrences.get(unwanted) - 1);
                    occurrences.remove(unwanted, 0);
                    left++;
                }
                max = Math.max(max, right - left + 1);
                right++;
            }
            return max;
        }
    }

    public static void main(String[] args) {
        var solution = new NaiveHashmap();
        System.out.println(solution.characterReplacement("AABABBA", 0));
    }
}
