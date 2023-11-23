package main.prep2021.quickpractices.array;

public class CountSortedVowelStrings {

    public int countVowelStrings(int n) {
        return countVowelStringUtil(n, 2);
    }

    int countVowelStringUtil(int n, int vowels) {
        if (n == 1)
            return vowels;
        if (vowels == 1)
            return 1;
        return countVowelStringUtil(n - 1, vowels) + countVowelStringUtil(n, vowels - 1);
    }

    public static void main(String[] args) {
        var solution = new CountSortedVowelStrings();
        System.out.println(solution.countVowelStrings(3));
    }
}
