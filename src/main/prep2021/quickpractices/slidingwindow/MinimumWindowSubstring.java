package main.prep2021.quickpractices.slidingwindow;

import java.util.*;

public class MinimumWindowSubstring {
    private boolean hasFoundAllCharacters(Collection<Integer> valueSet) {
        for (Integer count : valueSet) {
            if (count > 0) return false;
        }
        return true;
    }

    public String minWindow(String s, String t) {
        // Create a map to track the requirement.
        Map<Character, Integer> requirement = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Character current = t.charAt(i);
            requirement.put(current, requirement.getOrDefault(current, 0) + 1);
        }

        // Create a deque to track indexes. For any acceptable string,
        // peekFirst() will give the start while peekLast() will give the
        // end.
        Deque<Integer> indexes = new ArrayDeque<>();

        String answer = "";
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i ++) {
            Character current = s.charAt(i);

            if (requirement.containsKey(current)) {
                indexes.addLast(i);
                requirement.put(current, requirement.get(current) - 1);
            }

            // Attempt to reduce the size of our window to get the min value.
            while (hasFoundAllCharacters(requirement.values()) && !indexes.isEmpty()) {
                Integer start = indexes.peekFirst();
                Integer end = indexes.peekLast();
                if (end - start + 1 < minLength) {
                    minLength = end - start + 1;
                    answer = s.substring(start, end+1);
                }
                Integer removed = indexes.pollFirst();
                requirement.put(s.charAt(removed), requirement.get(s.charAt(removed)) + 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        var solution = new MinimumWindowSubstring();
        System.out.println(solution.minWindow("cabwefgewcwaefgcf", "cae"));
    }
}
