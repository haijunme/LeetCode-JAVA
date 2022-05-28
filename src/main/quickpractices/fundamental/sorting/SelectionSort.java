package main.quickpractices.fundamental.sorting;

import java.util.Arrays;

public class SelectionSort {

    void selectionSort(int[] input) {
        for (int i = 0; i < input.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[minIndex]) {
                    minIndex = j;
                }
            }
            int temporary = input[i];
            input[i] = input[minIndex];
            input[minIndex] = temporary;
        }
    }

    public static void main(String[] args) {
        var solution = new SelectionSort();
        int[] input = new int[]{64, 34, 25, 12, 22, 11, 90};
        solution.selectionSort(input);
        System.out.println(Arrays.toString(input));
    }
}
