package main.prep2021.playground;

import java.util.Arrays;
import java.util.List;

public class MoreComplicatedSortingBehavior {

    public static void main(String[] args) {
//        int[][] sample = new int[][]{{0, 1}, {1,1}, {1,0}, {0,0}};
//        Arrays.sort(sample, (a, b) -> {
//            if (a[0] != b[0]) {
//                return a[0] - b[0];
//            } else {
//                return a[1] - b[1];
//            }
//        });
//        for (int[] pair : sample) {
//            System.out.println(Arrays.toString(pair));
//        }
//        int [][] sample2 = new int[][]{{0,0},{0,1},{1,0},{1,1}};
//        System.out.println(Arrays.equals(sample, sample2));
//        System.out.println(Arrays.deepEquals(sample, sample2));
//
        List<List<Integer>> test = Arrays.asList(
                Arrays.asList(0,1),
                Arrays.asList(1,1)
        );

        List<List<Integer>> test2 = Arrays.asList(
                Arrays.asList(0,1),
                Arrays.asList(1,1)
        );

        System.out.println(test.hashCode() == test2.hashCode());
    }
}
