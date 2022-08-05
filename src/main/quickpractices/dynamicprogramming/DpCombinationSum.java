package main.quickpractices.dynamicprogramming;

import java.util.*;

public class DpCombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<List<Integer>>> dp = new ArrayList<>(target+1);
        for (int i = 0; i <= target; i++)
            dp.add(new ArrayList<>());
        dp.get(0).add(new ArrayList<>());

        for (int candidate : candidates) {
            for (int j = candidate; j <= target; j++) {
                for (List<Integer> comb : dp.get(j - candidate)) {
                    List<Integer> newComb = new ArrayList<>(comb);
                    newComb.add(candidate);
                    dp.get(j).add(newComb);
                }
            }
        }
        return dp.get(target);
    }

    public static void main(String[] args) {
        var solution = new DpCombinationSum();
        System.out.println(solution.combinationSum(new int[]{2}, 2));
    }
}
