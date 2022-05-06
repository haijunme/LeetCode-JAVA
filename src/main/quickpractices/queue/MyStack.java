package main.quickpractices.queue;

import java.util.*;

public class MyStack {
    private final Queue<Integer> queue;

    public MyStack() {
        this.queue = new LinkedList<>();
    }

    public void push(int x) {
        Queue<Integer> temporary = new LinkedList<>();
        while (!queue.isEmpty()) {
            temporary.add(queue.remove());
        }
        this.queue.add(x);
        while (!temporary.isEmpty()) {
            this.queue.add(temporary.remove());
        }
    }

    public int pop() {
        return this.queue.remove();
    }

    public int top() {
        return this.queue.peek();
    }

    public boolean empty() {
        return this.queue.isEmpty();
    }
}
