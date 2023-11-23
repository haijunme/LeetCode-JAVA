package main.prep2021.quickpractices.dynamicprogramming.greedy;

import java.util.Arrays;

public class MaximumUnitsOnATruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int maxUnits = 0;
        for (int[] box : boxTypes) {
            if (truckSize >= box[0]) {
                maxUnits += box[0] * box[1];
                truckSize -= box[0];
            } else {
                maxUnits += truckSize * box[1];
                truckSize = 0;
            }
            if (truckSize == 0) break;
        }
        return maxUnits;
    }

    public static void main(String[] args) {
        var solution = new MaximumUnitsOnATruck();
        System.out.println(solution.maximumUnits(
                new int[][]{{5,10},{2,5},{4,7},{3,9}},
                7));
    }
}
