package main.prep2021.quickpractices;

import java.util.*;

public class GenerateParentheses {
    private int n = 0;

    private void recur(List<String> result, int opening, int closing, int index, char[] chars) {
        if (index == n*2) {
            result.add(String.valueOf(chars));
        }
        if (opening < n) {
            chars[index] = '(';
            recur(result, opening + 1, closing, index + 1, chars);
        }
        if (closing < opening) {
            chars[index] = ')';
            recur(result, opening, closing + 1, index + 1, chars);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        this.n = n;
        char[] chars = new char[n*2];
        recur(result, 0, 0, 0, chars);
        return result;
    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        System.out.println(generateParentheses.generateParenthesis(3).toString());
    }
}
