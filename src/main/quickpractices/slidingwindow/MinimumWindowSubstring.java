package main.quickpractices.slidingwindow;

import java.util.*;

public class MinimumWindowSubstring {
    private boolean hasFoundAllCharacters(Collection<Integer> valueSet) {
        for (Integer count : valueSet) {
            if (count > 0) return false;
        }
        return true;
    }


    public String minWindow(String s, String t) {
        // create a map to track the requirement
        Map<Character, Integer> requirement = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Character current = t.charAt(i);
            requirement.put(current, requirement.getOrDefault(current, 0) + 1);
        }

        // create a deque to track indexes, peekFirst() will give the start while peekLast() will give the
        // end
        Deque<Integer> deque = new ArrayDeque<>();

        String answer = "";
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i ++) {
            Character current = s.charAt(i);

            if (requirement.containsKey(current)) {
                deque.addLast(i);
                requirement.put(current, requirement.get(current) - 1);
            }

            while (hasFoundAllCharacters(requirement.values()) && !deque.isEmpty()) {
                Integer start = deque.peekFirst();
                Integer end = deque.peekLast();
                if (end - start + 1 < minLength) {
                    minLength = end - start + 1;
                    answer = s.substring(start, end+1);
                }
                Integer removed = deque.pollFirst();
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
