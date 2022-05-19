package main.quickpractices.array.hashmap;

import java.util.*;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] sBrokenUp = s.split(" ");
        if (pattern.length() != sBrokenUp.length) {
            return false;
        }

        Map<Character, String> patternMapping = new HashMap<>();
        Set<String> mappedWords = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            Character character = pattern.charAt(i);
            String word = sBrokenUp[i];
            String occurred = patternMapping.get(character);
            if (occurred == null) {
                if (mappedWords.contains(word)) {
                    return false;
                } else {
                    mappedWords.add(word);
                    patternMapping.put(character, word);
                }
            } else if (!occurred.equals(word)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var solution = new WordPattern();
        System.out.println(solution.wordPattern("abba", "dog cat cat dog"));
    }
}
