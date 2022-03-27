package main.casestudies.combinations;

import java.util.ArrayList;
import java.util.List;

public class CombinationsV2 {
    private final List<List<Integer>> answer = new ArrayList<>();
    int n;
    int k;

    private void recur(int number, int current, List<Integer> combination) {
        if (combination.size() == k) {
            answer.add(new ArrayList<>(combination));
            return;
        }

        for (int i = number; i <= n; i++) {
            combination.add(i);
            recur(i + 1, current + 1, combination);
            combination.remove(combination.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        recur(1, 1, new ArrayList<>());
        return answer;
    }

    public static void main(String[] args) {
        CombinationsV2 solution = new CombinationsV2();
        List<List<Integer>> answer = solution.combine(4, 3);
        for (List<Integer> combination : answer) {
            System.out.println(combination.toString());
        }
//        List<List<Integer>> answer = solution.combine(1, 1);
//        for (List<Integer> combination : answer) {
//            System.out.println(combination.toString());
//        }
    }
}
