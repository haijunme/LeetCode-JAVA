package main.casestudies.combinations;

import java.util.ArrayList;
import java.util.List;

public class CombinationsV1 {
    private final List<List<Integer>> answer = new ArrayList<>();
    int n;
    int k;

    private void recur(int number, int current, List<Integer> combination) {
        if (current > k) {
            if (combination.size() == k) {
                answer.add(combination);
            }
            return;
        }
        for (int i = number + 1; i <= n; i++) {
            ArrayList<Integer> temp = new ArrayList<>(combination);
            temp.add(i);
            recur(i, current + 1, temp);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        for (int i = 1; i <= n; i ++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(i);
            recur(i,2, temp);
        }
        return answer;
    }

    public static void main(String[] args) {
        CombinationsV1 solution = new CombinationsV1();
        //List<List<Integer>> answer = solution.combine(4, 3);
//        for (List<Integer> combination : answer) {
//            System.out.println(combination.toString());
//        }

        List<List<Integer>> answer = solution.combine(1, 1);
        for (List<Integer> combination : answer) {
            System.out.println(combination.toString());
        }
    }
}
