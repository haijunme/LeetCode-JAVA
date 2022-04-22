package main.quickpractices;

import java.util.Stack;

public class ValidParenthesis {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char character : s.toCharArray()) {
            if (stack.empty()) {
                stack.push(character);
                continue;
            }

            Character top = stack.peek();
            if (character == '(' || character == '{' || character == '[') {
                stack.push(character);
                continue;
            }

            if (character == ')') {
                if (top == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (character == '}') {
                if (top == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (character == ']') {
                if (top == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
