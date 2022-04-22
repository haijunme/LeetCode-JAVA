package main.quickpractices;

import java.util.Objects;

public class BackspaceStringCompare {

    private String buildString(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char character : input.toCharArray()) {
            if (character == '#') {
                if (stringBuilder.length() >= 1) stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            } else {
                stringBuilder.append(character);
            }
        }
        return stringBuilder.toString();
    }

    public boolean backspaceCompare(String s, String t) {
        String sProcessed = this.buildString(s);
        String tProcessed = this.buildString(t);
        return Objects.equals(sProcessed, tProcessed);
    }

    public static void main(String[] args) {
        var solution = new BackspaceStringCompare();
        System.out.println(solution.backspaceCompare("###", "###"));
    }
}
