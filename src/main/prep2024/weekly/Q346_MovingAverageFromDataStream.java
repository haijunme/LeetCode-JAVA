package main.prep2024.weekly;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q346_MovingAverageFromDataStream {
  public static class MovingAverage {
    private final Deque<Integer> slidingWindow;
    private final int maxSize;
    private int currentSum;

    public MovingAverage(int size) {
      slidingWindow = new ArrayDeque<>(size);
      maxSize = size;
      currentSum = 0;
    }

    public double next(int val) {
      if (slidingWindow.size() >= maxSize) {
        currentSum -= slidingWindow.removeFirst();
      }

      slidingWindow.addLast(val);
      currentSum += val;

      return ((double) currentSum)/slidingWindow.size();
    }
  }

  private static void testHelper(MovingAverage solution, int... input) {
    for (int j : input) {
      System.out.println(solution.next(j));
    }
  }

  public static void main(String[] args) {
    var solution = new MovingAverage(3);
    testHelper(solution, 1, 10, 3, 5);
  }
}
