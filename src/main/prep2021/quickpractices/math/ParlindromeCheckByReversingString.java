package main.prep2021.quickpractices.math;

public class ParlindromeCheckByReversingString {
    public int removePalindromeSub(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        String reversedString = new StringBuilder(s).reverse().toString();
        if (reversedString.equals(s)) {
            return 1;
        }
        return 2;
    }
}
