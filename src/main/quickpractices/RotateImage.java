package main.quickpractices;

import java.util.Arrays;

public class RotateImage {
    private int[][] matrix;

    public void fourWayRotate(int[] pos4, int[] pos3, int[] pos2, int[] pos1) {
        int temporary = matrix[pos4[0]][pos4[1]];
        matrix[pos4[0]][pos4[1]] = matrix[pos3[0]][pos3[1]];
        matrix[pos3[0]][pos3[1]] = matrix[pos2[0]][pos2[1]];
        matrix[pos2[0]][pos2[1]] =matrix[pos1[0]][pos1[1]];
        matrix[pos1[0]][pos1[1]] = temporary;
    }

    public void rotate(int[][] matrix) {
        this.matrix = matrix;
        int rowMaxLoop = matrix.length/2-1;
        for (int i = 0; i <= rowMaxLoop; i++) {
            for (int j = 0; i+j < matrix.length-1-i; j++) {
                int[] pos1 = new int[]{i, i+j};
                int[] pos2 = new int[]{i+j, matrix.length-1-i};
                int[] pos3 = new int[]{matrix.length-i-1, matrix.length-1-i-j};
                int[] pos4 = new int[]{matrix.length-i-1-j, i};
                fourWayRotate(pos4, pos3, pos2, pos1);
            }
        }
    }

    public static void main(String[] args) {
        var rotateImage = new RotateImage();
        int[][] matrix = new int[][]{
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25},
        };
        rotateImage.rotate(matrix);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
