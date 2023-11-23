package main.prep2021.quickpractices.fundamental.sorting;

import java.util.Arrays;

public class BubbleSort {

    void bubbleSort(int[] input) {
        final int N = input.length;
        // iterate through each element
        for (int i = 0; i < N; i++) {
            // no need to do comparisons for big elements that have already been moved to the tail, hence the "-i"
            // because of "j" and "j+1", the exclusive upperbound is "N - 1"
            boolean alreadySorted = true;
            for (int j = 0; j < (N - 1) - i; j++) {
                if (input[j] > input[j + 1]) {
                    alreadySorted = false;
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
            if (alreadySorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        var solution = new BubbleSort();
        int[] input = new int[]{64, 34, 25, 12, 22, 11, 90};
        solution.bubbleSort(input);
        System.out.println(Arrays.toString(input));
    }
}
