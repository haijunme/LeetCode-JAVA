package main.prep2021.quickpractices.array;

import java.util.Arrays;

public class ValidAnagram {

    // O(nlogn)
    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }

    public static void main(String[] args) {
        var solution = new ValidAnagram();
        System.out.println(solution.isAnagram("rat", ""));
    }
}
