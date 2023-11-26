package main.prep2024.weekly;

import java.util.List;
import java.util.stream.Stream;

public class Q624_MaximumDistanceInArrays {

  private <T> T getFirstItem(List<T> list) {
    return list.get(0);
  }

  private <T> T getLastItem(List<T> list) {
    return list.get(list.size() - 1);
  }

  private Integer getMaximum(Integer... numbers) {
    if (numbers.length == 0) {
      throw new IllegalArgumentException("The number of arguments must be greater than 0.");
    }

    return Stream.of(
        numbers
      )
      .max(Integer::compare)
      .get();
  }

  public int maxDistance(List<List<Integer>> arrays) {
    var firstList = getFirstItem(arrays);

    int pastMin = getFirstItem(firstList);
    int pastMax = getLastItem(firstList);
    int maxDistance = 0;

    for (List<Integer> list : arrays.subList(1, arrays.size())) {
      int currentMin = getFirstItem(list);
      int currentMax = getLastItem(list);

      maxDistance = getMaximum(
        maxDistance,
        Math.abs(pastMax - currentMin),
        Math.abs(currentMax - pastMin)
      );

      pastMin = Math.min(pastMin, currentMin);
      pastMax = Math.max(pastMax, currentMax);
    }

    return maxDistance;
  }

  public static void main(String[] args) {
    var solution = new Q624_MaximumDistanceInArrays();
    int answer = solution.maxDistance(
      List.of(List.of(1, 2, 3), List.of(4, 5), List.of(1, 2, 3)));
    System.out.println(answer);
  }
}
