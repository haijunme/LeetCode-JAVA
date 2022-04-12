package main.quickpractices.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < nums.length; i ++) {
            List<List<Integer>> temporary = new ArrayList<>();
            int currentNum = nums[i];
            temporary.add(Arrays.asList(currentNum));
            for (List<Integer> oldComb : answer) {
                List<Integer> newComb = new ArrayList<>(oldComb);
                newComb.add(currentNum);
                temporary.add(newComb);
            }
            answer.addAll(temporary);
        }

        answer.add(Collections.emptyList());
        return answer;
    }

    public static void main(String[] args) {
        var solution = new Subsets();
        for (List<Integer> combination : solution.subsets(new int[]{0})) {
            System.out.println(combination.toString());
        }
    }
}
