package main.prep2021.quickpractices;

import java.util.*;

public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0;
        int j = 0;
        List<int[]> result = new ArrayList<>();
        while (i < firstList.length && j < secondList.length) {
            int[] firstInterval = firstList[i];
            int[] secondInterval = secondList[j];
            if (firstInterval[1] < secondInterval[0]) {
                i++;
            } else if (secondInterval[1] < firstInterval[0]) {
                j++;
            } else {
                int[] interval = new int[]{
                        Math.max(firstInterval[0], secondInterval[0]),
                        Math.min(firstInterval[1], secondInterval[1])
                };
                result.add(interval);
                if (firstInterval[1] < secondInterval[1]) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        var solution = new IntervalListIntersections();
        int[][] result = solution.intervalIntersection(
                new int[][]{{0,2},{5,10},{13,23},{24,25}},
                new int[][]{{1,5},{8,12},{15,24},{25,26}}
        );
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
