package main.prep2021.quickpractices.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    private int[] nums;
    private int N;
    private final List<List<Integer>> answer = new ArrayList<>();

    private void recur(int index, List<Integer> combination) {
        answer.add(new ArrayList<>(combination));
        int lastNum = Integer.MIN_VALUE;
        for (int i = index; i < N; i++) {
            if (nums[i] != lastNum) {
                combination.add(nums[i]);
                recur(i + 1, combination);
                combination.remove(combination.size() - 1);
            }
            lastNum = nums[i];
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        this.N = nums.length;
        recur(0, new ArrayList<>());
        return answer;
    }

    public static void main(String[] args) {
        var solution = new SubsetsII();
        for (List<Integer> combination : solution.subsetsWithDup(new int[]{4,4,4,1,4})) {
            System.out.println(combination.toString());
        }
    }
}
