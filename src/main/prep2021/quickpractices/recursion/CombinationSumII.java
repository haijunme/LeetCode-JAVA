package main.prep2021.quickpractices.recursion;

import java.util.*;

public class CombinationSumII {
    private TreeMap<Integer, Integer> unused;
    private List<List<Integer>> answer;
    private int target;
    private void recur(List<Integer> combination, int sum, int index) {
        if (sum == target) {
            answer.add(new ArrayList<>(combination));
        }
        if (sum > target) {
            return;
        }
        int i = 0;
        for (Integer num : unused.keySet()) {
            if (i < index || unused.get(num) == 0) {
                i++;
                continue;
            }
            int count = unused.get(num);
            combination.add(num);
            unused.put(num, count - 1);
            recur(combination, sum + num, i);
            combination.remove(combination.size()-1);
            unused.put(num, count);
            i++;
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         this.unused = new TreeMap<>();
         this.answer = new ArrayList<>();
         this.target = target;
        // populate map
        for (int num : candidates) {
            unused.putIfAbsent(num, 0);
            unused.computeIfPresent(num, (k, v) -> v + 1);
        }
        // begin recursion
        recur(new ArrayList<>(), 0, 0);
        return answer;
    }

    public static void main(String[] args) {
        var solution = new CombinationSumII();
        for (List<Integer> combination : solution.combinationSum2(new int[]{2}, 1)) {
            System.out.println(combination);
        }
    }
}
