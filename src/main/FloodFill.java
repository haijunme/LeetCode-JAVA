package main;

import java.util.Arrays;

public class FloodFill {
    private int[][] visited;
    private int newColor;
    private int m;
    private int n;
    private int startingColor;

    public void dfsTraversal(int[][] image, int sr, int sc) {
        if (sr < 0 || sr >= m || sc < 0 || sc >= n
                || visited[sr][sc] == 1
                || image[sr][sc] != startingColor) {
            return;
        }
        image[sr][sc] = newColor;
        this.visited[sr][sc] = 1;
        dfsTraversal(image, sr - 1, sc);
        dfsTraversal(image, sr + 1, sc);
        dfsTraversal(image, sr, sc - 1);
        dfsTraversal(image, sr, sc + 1);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        m = image.length;
        n = image[0].length;
        visited = new int[m][n];
        this.startingColor = image[sr][sc];
        this.newColor = newColor;
        dfsTraversal(image, sr, sc);
        return image;
    }

    public static void main(String[] args) {
        FloodFill floodFill = new FloodFill();
        //int[][] result = floodFill.floodFill(new int[][]{{1,1,1},{1,1,0},{1,0,1}}, 1 , 1, 2);
        int[][] result = floodFill.floodFill(new int[][]{{0,0,0},{0,0,0}}, 0 , 0, 2);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
