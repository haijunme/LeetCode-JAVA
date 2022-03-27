package java;

public class NumberOfIslands {
    private boolean[][] visited;
    private char[][] grid;

    public int dfs(int i, int j, int travelled) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return travelled;
        }
        if (visited[i][j]) {
            return travelled;
        }
        visited[i][j] = true;
        if (grid[i][j] == '0') {
            return travelled;
        }
        int newTravelled = travelled + 1;
        return dfs(i, j-1, newTravelled)
                + dfs(i, j+1, newTravelled)
                + dfs(i-1, j, newTravelled)
                + dfs(i+1, j, newTravelled);
    }

    public int numIslands(char[][] grid) {
        this.visited = new boolean[grid.length][grid[0].length];
        this.grid = grid;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                count += dfs(i, j, 0) > 0 ? 1 : 0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numberOfIslands.numIslands(grid));
    }
}
