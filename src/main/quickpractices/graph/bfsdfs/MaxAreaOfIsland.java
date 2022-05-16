package main.quickpractices.graph.bfsdfs;

public class MaxAreaOfIsland {
    private int m;
    private int n;
    private int[][] visited;
    private int area = 0;
    private int maxArea = 0;

    private void dfs(int[][] grid, int row, int column) {
        if (row < 0 || row >= m || column < 0 || column >= n || visited[row][column] == 1) {
            return;
        } else if (grid[row][column] == 0) {
            visited[row][column] = 1;
            return;
        } else {
            visited[row][column] = 1;
            area ++;
            dfs(grid, row - 1, column);
            dfs(grid, row + 1, column);
            dfs(grid, row, column - 1);
            dfs(grid, row, column + 1);
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(grid, i, j);
                maxArea = Math.max(area, maxArea);
                area = 0;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        int[][] grid = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland.maxAreaOfIsland(grid));
    }
}
