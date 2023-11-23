package main.prep2021.quickpractices.backtracking;

import java.util.*;

public class FactorCombinations {

    private List<List<Integer>> answer;
    private int N;

    private void backtracking(List<Integer> combination, int target, int factor) {
        if (target == 1) {
            answer.add(new ArrayList<>(combination));
            return;
        }
        for (int i = factor; i <= target; i++) {
            if (i == N) continue;
            if (target % i == 0) {
                combination.add(i);
                backtracking(combination, target/i, i);
                combination.remove(combination.size()-1);
            }
        }
    }

    public List<List<Integer>> getFactors(int n) {
        this.answer = new ArrayList<>();
        this.N = n;
        backtracking(new ArrayList<>(), n, 2);
        return answer;
    }

    public static void main(String[] args) {
        var solution = new FactorCombinations();
        System.out.println(solution.getFactors(6));
    }
}
