package main.prep2021.quickpractices.stack;

import java.util.*;

public class EvaluateReversePolishNotation {
    private static final Set<String> OPERATORS = Set.of("/", "+", "-", "*");

    private int evaluate(String firstOperand, String secondOperand, String operator) {
        int first = Integer.parseInt(firstOperand);
        int second = Integer.parseInt(secondOperand);
        return switch (operator) {
            case "/" -> first / second;
            case "+" -> first + second;
            case "-" -> first - second;
            case "*" -> first * second;
            default -> throw new IllegalArgumentException();
        };
    }

    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        Deque<String> stack = new ArrayDeque<>();
        int result = 0;
        for (String token : tokens) {
            if (OPERATORS.contains(token)) {
                String secondOperand = stack.removeLast();
                String firstOperand = stack.removeLast();
                int newOperand = evaluate(firstOperand, secondOperand, token);
                stack.addLast(Integer.toString(newOperand));
                result = newOperand;
            } else {
                stack.addLast(token);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var solution = new EvaluateReversePolishNotation();
        String[] tokens = {"2","1","+","3","*"};
        System.out.println(solution.evalRPN(tokens));
    }
}
