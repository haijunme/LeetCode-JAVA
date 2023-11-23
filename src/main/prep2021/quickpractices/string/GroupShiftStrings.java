package main.prep2021.quickpractices.string;

import java.util.*;

public class GroupShiftStrings {
    public List<List<String>> groupStrings(String[] strings) {
        Map<Integer, List<String>> stringsByPattern = new HashMap<>();
        for (String string : strings) {
            int[] charCodes = new int[string.length()];
            for (int i = 0; i < string.length(); i++) {
                charCodes[i] = string.charAt(i) - 'a';
            }
            for (int i = 1; i < charCodes.length; i ++) {
                int current = charCodes[i];
                int derivation = (current - charCodes[0] + 26) % 26;
                charCodes[i] = derivation;
            }
            charCodes[0] = 0;
            int hashCode = Arrays.hashCode(charCodes);
            stringsByPattern.putIfAbsent(hashCode, new ArrayList<>());
            stringsByPattern.get(hashCode).add(string);
        }
        return new ArrayList<>(stringsByPattern.values());
    }

    public static void main(String[] args) {
        var solution = new GroupShiftStrings();
        System.out.println(solution.groupStrings(new String[]{"ba", "ab"}));
    }
}
