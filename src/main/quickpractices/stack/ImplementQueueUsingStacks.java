package main.quickpractices.stack;

import java.util.*;

public class ImplementQueueUsingStacks {
    private final Stack<Integer> stack;

    public ImplementQueueUsingStacks() {
        this.stack = new Stack<>();
    }

    public void push(int x) {
        Stack<Integer> temporary = new Stack<>();
        while (!this.stack.empty()) {
            temporary.push(this.stack.pop());
        }
        temporary.push(x);
        while (!temporary.empty()) {
            this.stack.push(temporary.pop());
        }
    }

    public int pop() {
        return this.stack.pop();
    }

    public int peek() {
        return this.stack.peek();
    }

    public boolean empty() {
        return this.stack.empty();
    }

    public static void main(String[] args) {
        var solution = new ImplementQueueUsingStacks();
        solution.push(1);
        solution.push(2);
        solution.push(3);
        solution.push(4);
        System.out.println(solution.pop());
    }
}
