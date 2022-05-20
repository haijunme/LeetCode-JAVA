package main.quickpractices.array.twodimensional.interval;

import java.util.*;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new ArrayList<>();
        int[] modifiedInterval = new int[]{newInterval[0], newInterval[1]};
        boolean hasInserted = false;
        for (int[] existingInterval : intervals) {
            if (existingInterval[1] < modifiedInterval[0]) {
                merged.add(existingInterval);
            } else if (modifiedInterval[1] < existingInterval[0]) {
                if (!hasInserted) {
                    merged.add(modifiedInterval);
                    hasInserted = true;
                }
                merged.add(existingInterval);
            } else {
                modifiedInterval[0] = Math.min(modifiedInterval[0], existingInterval[0]);
                modifiedInterval[1] = Math.max(modifiedInterval[1], existingInterval[1]);
            }
        }
        if (!hasInserted) {
            merged.add(modifiedInterval);
        }

        int[][] reformattedAnswer = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++) {
            reformattedAnswer[i] = merged.get(i);
        }
        return reformattedAnswer;
    }

    public static void main(String[] args) {
        var solution = new InsertInterval();
        // in-place insert where there are overlaps
        System.out.println(Arrays.deepToString(solution.insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8})));
        // in-place insert where there are no overlaps
        System.out.println(Arrays.deepToString(solution.insert(new int[][]{{1,2},{3,5},{8,10},{12,16}}, new int[]{6,7})));
        // the new interval sits before the first existing interval
        System.out.println(Arrays.deepToString(solution.insert(new int[][]{{3,5},{6,7},{8,10},{12,16}}, new int[]{1,2})));
        // the new interval overlaps with the first interval
        System.out.println(Arrays.deepToString(solution.insert(new int[][]{{3,5},{6,7},{8,10},{12,16}}, new int[]{1,3})));
        // the new interval sits after the last existing interval
        System.out.println(Arrays.deepToString(solution.insert(new int[][]{{1,2},{3,5},{6,7},{8,10}}, new int[]{12,16})));
        // the new interval overlaps with the last interval
        System.out.println(Arrays.deepToString(solution.insert(new int[][]{{1,2},{3,5},{6,7},{8,10}}, new int[]{10,16})));
    }
}
