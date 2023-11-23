package main.prep2021.quickpractices.binarysearch;

import java.util.*;

public class ShortestDistanceToTargetColor {

    private Map<Integer, List<Integer>> mapping;

    private int search(int[] query) {
        int startingIndex = query[0];
        int targetNumber = query[1];

        List<Integer> list = mapping.get(targetNumber);
        if (list.size() == 0) {
            return -1;
        }

        int left = 0;
        int right = list.size()-1;

        if (startingIndex < list.get(left)) {
            return list.get(left) - startingIndex;
        }
        if (startingIndex > list.get(right)) {
            return startingIndex - list.get(right);
        }

        while (left < right) {
            int mid = left + (right - left)/2;
            int midVal = list.get(mid);
            if (midVal == startingIndex) {
                return 0;
            } else if (midVal < startingIndex) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return Math.min(startingIndex - list.get(left-1), list.get(right) - startingIndex);
    }


    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        final int N = queries.length;
        // pre-processing
        final List<Integer> ones = new ArrayList<>(N/3);
        final List<Integer> twos = new ArrayList<>(N/3);
        final List<Integer> threes = new ArrayList<>(N/3);

        for (int i = 0; i < colors.length; i ++) {
            int color = colors[i];
            if (color == 1) {
                ones.add(i);
            } else if (color == 2) {
                twos.add(i);
            } else {
                threes.add(i);
            }
        }

        mapping = new HashMap<>();
        mapping.put(1, ones);
        mapping.put(2, twos);
        mapping.put(3, threes);

        List<Integer> answer = new ArrayList<>(queries.length);
        for (int i = 0; i < N; i++) {
            answer.add(search(queries[i]));
        }

        return answer;
    }

    public static void main(String[] args) {
        var solution = new ShortestDistanceToTargetColor();
        System.out.println(solution.shortestDistanceColor(new int[]{1,1,2,1,3,2,2,3,3}, new int[][]{{1,3},{2,2},{6,1}}));
        //System.out.println(solution.shortestDistanceColor(new int[]{1,2}, new int[][]{{0,3}}));
    }
}
