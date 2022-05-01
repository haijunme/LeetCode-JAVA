package main.quickpractices.slidingwindow;

import java.util.*;

public class ProductOfTwoRunLengthEncodedArrays {

    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> answer = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < encoded1.length && j < encoded2.length) {
            int[] first = encoded1[i];
            int[] second = encoded2[j];

            int product = first[0] * second[0];
            int count = Math.min(first[1], second[1]);

            if (answer.isEmpty()) {
                answer.add(Arrays.asList(product, count));
            } else {
                List<Integer> last = answer.get(answer.size()-1);
                if (last.get(0) == product) {
                    last.set(1, last.get(1) + count);
                } else {
                    answer.add(Arrays.asList(product, count));
                }
            }

            first[1] -= count;
            second[1] -= count;

            if (first[1] == 0) {
                i++;
            }
            if (second[1] == 0) {
                j++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        var solution = new ProductOfTwoRunLengthEncodedArrays();
        System.out.println(solution.findRLEArray(
                new int[][]{{1,3}, {2,1}, {3,2}},
                new int[][]{{2,3}, {3,3}}
        ));
    }
}
