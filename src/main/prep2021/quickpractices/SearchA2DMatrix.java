package main.prep2021.quickpractices;

import java.util.Arrays;

public class SearchA2DMatrix {
    private int[][] matrix;
    private int target;

    public boolean searchMatrix(int[][] matrix, int target) {
        this.matrix = matrix;
        this.target = target;
        int start = 0;
        int end = matrix.length - 1;
        boolean found = false;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int[] row = matrix[mid];
            if (row[0] > target) {
                end = mid - 1;
            } else if (row[row.length - 1] < target) {
                start = mid + 1;
            } else {
                found = Arrays.stream(row).anyMatch((it) -> it == target);
                break;
            }
        }
        return found;
    }

    public static void main(String[] args) {
        var solution = new SearchA2DMatrix();
//        int[][] matrix = new int[][]{
//                {1, 3, 5, 7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 60}};
        int [][] matrix = new int[][]{{1}};
        System.out.println(solution.searchMatrix(matrix, 13));
    }
}
