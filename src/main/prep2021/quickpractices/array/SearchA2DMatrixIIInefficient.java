package main.prep2021.quickpractices.array;

import java.util.ArrayList;
import java.util.List;

public class SearchA2DMatrixIIInefficient {
    private int target;
    private int[][] matrix;

    private boolean search(List<Integer> rows, List<Integer> columns, boolean checkMin) {
        if (rows.size() == 1 && columns.size() == 1) {
            return matrix[rows.get(0)][columns.get(0)] == target;
        }
        if (rows.size() == 0 || columns.size() == 0) {
            return false;
        }
        List<Integer> keptRows = new ArrayList<>();
        List<Integer> keptColumns = new ArrayList<>();
        int top = rows.get(0);
        int left = columns.get(0);
        int bottom = rows.get(rows.size() - 1);
        int right = columns.get(columns.size() - 1);

        // optimize the following code with binary search
        for (int row : rows) {
            if (checkMin) {
                if (matrix[row][left] == target) {
                    return true;
                }
                if (matrix[row][left] < target) {
                    keptRows.add(row);
                }
            } else {
                if (matrix[row][right] == target) {
                    return true;
                }
                if (matrix[row][right] > target) {
                    keptRows.add(row);
                }
            }
        }

        for (int column : columns) {
            if (checkMin) {
                if (matrix[top][column] == target) {
                    return true;
                }
                if (matrix[top][column] < target) {
                    keptColumns.add(column);
                }
            } else {
                if (matrix[bottom][column] == target) {
                    return true;
                }
                if (matrix[bottom][column] > target) {
                    keptColumns.add(column);
                }
            }
        }
        return search(keptRows, keptColumns, !checkMin);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        this.target = target;
        this.matrix = matrix;
        List<Integer> rows = new ArrayList<>();
        List<Integer> columns = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            rows.add(i);
        }
        for (int j = 0; j < matrix[0].length; j++) {
            columns.add(j);
        }
        return search(rows, columns, true);
    }

    public static void main(String[] args) {
        var solution = new SearchA2DMatrixIIInefficient();
        System.out.println(solution.searchMatrix(new int[][]{
                        {1, 3,5}},
                -1));
    }
}
