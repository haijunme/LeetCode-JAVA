package main.quickpractices.fundamental.sorting;

import java.util.Arrays;

public class InsertionSort {

    void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            /* Move elements of arr[0..i-1], that are greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] data = {5,7,6};
        var is = new InsertionSort();
        is.sort(data);
        System.out.println(Arrays.toString(data));
    }
}
