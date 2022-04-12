package main.quickpractices.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    private int target;
    private List<List<Integer>> answer;
    private int[] candidates;
    private int N;

    private void recur(int index, List<Integer> sequence, int sum) {
        if (sum == target) {
            answer.add(new ArrayList<>(sequence));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = index; i < N; i ++) {
            sequence.add(candidates[i]);
            recur(i, sequence, sum + candidates[i]);
            sequence.remove(sequence.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.target = target;
        this.answer = new ArrayList<>();
        this.candidates = candidates;
        this.N = candidates.length;

        recur(0, new ArrayList<>(), 0);
        return answer;
    }

    public static void main(String[] args) {
        var solution = new CombinationSum();
        for (var sequence : solution.combinationSum(new int[]{2}, 1)) {
            System.out.println(sequence);
        }
    }
}
