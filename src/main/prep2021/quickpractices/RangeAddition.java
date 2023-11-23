package main.prep2021.quickpractices;

import java.util.Arrays;

public class RangeAddition {

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        Arrays.fill(result, 0);
        int[] modifier = new int[length];
        for (int[] update : updates) {
            if (update[0] - 1 >= 0) modifier[update[0]-1] -= update[2];
            modifier[update[1]] += update[2];
        }
        int totalModifier = 0;
        for (int i = result.length-1; i >= 0; i--) {
            totalModifier += modifier[i];
            result[i] += totalModifier;
        }
        return result;
    }

    public static void main(String[] args) {
        RangeAddition solution = new RangeAddition();
        System.out.println(Arrays.toString(solution.getModifiedArray(5, new int[][]{{1,3,2},{2,4,3},{0,2,-2}})));
    }
}
