package main.quickpractices.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PermutationsII {
    private HashMap<Integer, Integer> unusedNums;
    private List<List<Integer>> answer;
    private int length;

    private void recur(List<Integer> permutation) {
        if (permutation.size() == this.length) {
            answer.add(new ArrayList<>(permutation));
            return;
        }

        for (Integer number : unusedNums.keySet()) {
            if (unusedNums.get(number) == 0) {
                continue;
            }
            permutation.add(number);
            unusedNums.put(number, unusedNums.get(number) - 1);
            recur(permutation);
            permutation.remove(permutation.size()-1);
            unusedNums.put(number, unusedNums.get(number) + 1);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.unusedNums = new HashMap<>();
        this.answer = new ArrayList<>();
        this.length = nums.length;
        // build up the map
        for (int num : nums) {
            unusedNums.putIfAbsent(num, 0);
            unusedNums.put(num, unusedNums.get(num) + 1);
        }
        // begin recursion
        recur(new ArrayList<>());
        return answer;
    }

    public static void main(String[] args) {
        var solution = new PermutationsII();
        var answer = solution.permuteUnique(new int[]{1,1});
        for (var permutation : answer) {
            System.out.println(permutation);
        }
    }
}
