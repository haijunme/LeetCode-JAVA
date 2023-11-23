package main.prep2021.quickpractices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfAPhoneNumber {
    private char[] digitChars;
    private List<String> result;
    private static final Map<Character, List<Character>> MAPPING = new HashMap<>();
    static {
        MAPPING.put('2', List.of('a', 'b', 'c'));
        MAPPING.put('3', List.of('d', 'e', 'f'));
        MAPPING.put('4', List.of('g', 'h', 'i'));
        MAPPING.put('5', List.of('j', 'k', 'l'));
        MAPPING.put('6', List.of('m', 'n', 'o'));
        MAPPING.put('7', List.of('p', 'q', 'r', 's'));
        MAPPING.put('8', List.of('t', 'u', 'v'));
        MAPPING.put('9', List.of('w', 'x', 'y', 'z'));
    }

    private void recur(int index, char[] combination) {
        if (index >= digitChars.length) {
            result.add(String.valueOf(combination));
            return;
        }
        char currentDigit = digitChars[index];
        for (Character character : MAPPING.get(currentDigit)) {
            combination[index] = character;
            recur(index + 1, combination);
        }
    }

    public List<String> letterCombinations(String digits) {
        digitChars = digits.toCharArray();
        result = new ArrayList<>();
        if (digits.length() > 0) recur(0, new char[digitChars.length]);
        return result;
    }

    public static void main(String[] args) {
        var solution = new LetterCombinationOfAPhoneNumber();
        System.out.println(solution.letterCombinations("23"));
        System.out.println(solution.letterCombinations("235"));
        System.out.println(solution.letterCombinations(""));
    }
}
