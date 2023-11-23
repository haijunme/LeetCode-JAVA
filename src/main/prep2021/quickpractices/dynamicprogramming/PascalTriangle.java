package main.prep2021.quickpractices.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.singletonList(1));
        for (int i = 1; i < numRows; i ++) {
            result.add(i, new ArrayList<>());
            result.get(i).add(1);
            for (int j = 1; j < i; j++) {
                int topLeft =  result.get(i-1).get(j-1);
                int topRight = result.get(i-1).get(j);
                result.get(i).add(topLeft + topRight);
            }
            result.get(i).add(1);
        }
        return result;
    }

    public static void main(String[] args) {
        PascalTriangle solution = new PascalTriangle();
        List<List<Integer>> result = solution.generate(5);
        for (List<Integer> row : result)  {
            System.out.println(row.toString());
        }
    }
}
