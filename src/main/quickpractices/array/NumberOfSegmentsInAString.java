package main.quickpractices.array;

import java.util.*;

public class NumberOfSegmentsInAString {

    public int countSegments(String s) {
        s = s + " ";
        boolean isPreviousCharNonspace = false;
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == ' ') {
                if (isPreviousCharNonspace) {
                    answer ++;
                    isPreviousCharNonspace = false;
                }
            } else {
                isPreviousCharNonspace = true;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        var solution = new NumberOfSegmentsInAString();
        System.out.println(solution.countSegments("Hello, my nae is John               "));
    }
}
