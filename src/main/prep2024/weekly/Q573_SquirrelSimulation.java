package main.prep2024.weekly;

public class Q573_SquirrelSimulation {

  private int[][] generateDistanceMatrix(int[][] matrix, int[] startingPosition) {
    return new int[][]{{1, 2}, {2, 3}};
  }

  public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
    // Use BFS to get the distances of all nuts relative to the squirrel.

    // Use BFS to get the distances of all nuts relative to the tree.

    // Locate the first nut.
    // Result = D(Squirrel, Nut1) + D(Tree, Nut1) for the smallest possibility.

    // Calculate the back and forth for all other nuts.
    // Result = 2*D(Tree, Nut2) + 2*D(Tree,Nut3)...
    return 0;
  }
}
