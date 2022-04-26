package main.quickpractices.array;

public class CountBinarySubstrings {
    private char[] digits;
    private int N;
    private int count;

    private void expand(int i, int j) {
        char left = digits[i];
        char right = digits[j];
        while (i >=0 && j < N) {
            if (digits[i] == left && digits[j] == right) {
                count++;
                i--;
                j++;
            }  else {
                break;
            }
        }
    }

    public int countBinarySubstrings(String s) {
        digits = s.toCharArray();
        N = digits.length;

        for (int i = 0; i < N - 1; i++) {
            if (digits[i] != digits[i+1]) {
                expand(i, i+1);
            }
        }
        return count;
    }
}
