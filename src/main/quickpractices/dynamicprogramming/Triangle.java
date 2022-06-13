package main.quickpractices.dynamicprogramming;

import java.util.*;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int row = 1; row < triangle.size(); row++) {
            List<Integer> previousRow = triangle.get(row - 1);
            List<Integer> currentRow = triangle.get(row);

            currentRow.set(0, currentRow.get(0) + previousRow.get(0));
            for (int i = 1; i < currentRow.size() - 1; i++) {
                currentRow.set(i, Math.min(previousRow.get(i-1), previousRow.get(i)) + currentRow.get(i));
            }
            currentRow.set(currentRow.size() - 1, currentRow.get(currentRow.size() - 1) + previousRow.get(previousRow.size() - 1));
        }
        return Collections.min(triangle.get(triangle.size() - 1));
    }

    public static void main(String[] args) {
        var solution = new Triangle();
        System.out.println(solution.minimumTotal(Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3,4),
                Arrays.asList(6,5,7),
                Arrays.asList(4,1,8,3)
        )));
    }
}
