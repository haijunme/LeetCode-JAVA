package main.quickpractices.stack.monotonic;

import java.util.*;

public class TrappingRainWater {

    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int output = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int j = stack.pop();
                if (!stack.isEmpty()) {
                    int h = Math.min(height[i], height[stack.peek()]);
                    output += (h - height[j]) * (i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }

        return output;
    }

    public static void main(String[] args) {
        var solution = new TrappingRainWater();
        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
