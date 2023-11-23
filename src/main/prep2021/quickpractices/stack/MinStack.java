package main.prep2021.quickpractices.stack;

import java.util.*;

public class MinStack {
    private static class Pair {
        private int val;
        private int min;

        private Pair(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }
    private List<Pair> data;

    public MinStack() {
        this.data = new ArrayList<>();
    }

    public void push(int val) {
        int min = val;
        if (!data.isEmpty()) {
            min = Math.min(data.get(data.size()-1).min, min);
        }
        data.add(new Pair(val, min));
    }

    public void pop() {
        data.remove(data.size()-1);
    }

    public int top() {
        return data.get(data.size()-1).val;
    }

    public int getMin() {
        return data.get(data.size()-1).min;
    }

    public static void main(String[] args) {
        var solution = new MinStack();
        solution.push(-2);
        solution.push(0);
        solution.push(-3);
        System.out.println(solution.getMin());
        solution.pop();
        solution.pop();
        System.out.println(solution.getMin());
    }
}
