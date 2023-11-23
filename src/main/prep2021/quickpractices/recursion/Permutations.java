package main.prep2021.quickpractices.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    private final List<List<Integer>> answer = new ArrayList<>();
    private int[] nums;
    private int maxSize;

    private void recur(List<Integer> possiblePermutation) {
        if (possiblePermutation.size() == maxSize) {
            answer.add(new ArrayList<>(possiblePermutation));
            return;
        }
        for (int i = 0; i < maxSize; i++) {
            if (!possiblePermutation.contains(nums[i])) {
                possiblePermutation.add(nums[i]);
                recur(possiblePermutation);
                possiblePermutation.remove(possiblePermutation.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        maxSize = nums.length;
        recur(new ArrayList<>());
        return answer;
    }

    public static void main(String[] args) {
        Permutations solution = new Permutations();
        int[] input = new int[]{1};
        List<List<Integer>> answer = solution.permute(input);
        for (List<Integer> possiblePermutation : answer) {
            System.out.println(possiblePermutation.toString());
        }
    }
}
