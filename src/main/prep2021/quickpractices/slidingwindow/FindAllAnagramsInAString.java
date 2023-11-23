package main.prep2021.quickpractices.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] characterCounter = new int[26];
        char[] pChars = p.toCharArray();
        for (Character character : pChars) {
            characterCounter[(int) character - (int) 'a'] += 1;
        }

        int[] tracking = new int[26];
        for (int i = 0; i <= s.length() - 1; i++) {
            tracking[(int) s.charAt(i) - (int) 'a'] ++;
            if (i >= p.length()) {
                tracking[(int) s.charAt(i - p.length()) - (int) 'a'] --;
            }
            if (Arrays.equals(tracking, characterCounter)) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var solution = new FindAllAnagramsInAString();
        System.out.println(solution.findAnagrams("abab", "ab"));
    }
}
