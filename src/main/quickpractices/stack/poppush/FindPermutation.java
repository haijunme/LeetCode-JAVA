package main.quickpractices.stack.poppush;

import java.util.*;

public class FindPermutation {
    private static final char I = 'I';

    public int[] findPermutation(String s) {
        Deque<Integer> stack = new ArrayDeque<>(s.length() + 1);
        int[] answer = new int[s.length() + 1];
        int n = 1;
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            stack.addLast(n++);
            if (character == 'I') {
                while (!stack.isEmpty()) {
                    answer[index++] = stack.pollLast();
                }
            }
        }
        stack.addLast(n);
        while (!stack.isEmpty()) {
            answer[index++] =  stack.pollLast();
        }
        return answer;
    }

    public static void main(String[] args) {
        var solution = new FindPermutation();
        System.out.println(Arrays.toString(solution.findPermutation("I")));
    }
}
