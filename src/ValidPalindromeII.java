public class ValidPalindromeII {

    public boolean helper(char[] characters, int i, int j, int skip) {
        if (i > j || skip > 1) {
            return false;
        }
        while (i <= j) {
            if (characters[i] != characters[j]) {
                return helper(characters, i+1, j, skip + 1) || helper(characters, i, j-1, skip + 1);
            }
            i++;j--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        char[] characters = s.toCharArray();
        int i = 0;
        int j = characters.length - 1;
        return helper(characters, i, j, 0);
    }

    public static void main(String[] args) {
        ValidPalindromeII validPalindromeII = new ValidPalindromeII();
        //System.out.println(validPalindromeII.validPalindrome("aba"));
        //System.out.println(validPalindromeII.validPalindrome("abba"));
        //System.out.println(validPalindromeII.validPalindrome("ab"));
        //System.out.println(validPalindromeII.validPalindrome("abca"));
        System.out.println(validPalindromeII.validPalindrome("a"));
    }
}
