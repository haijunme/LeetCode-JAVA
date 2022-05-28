package main.quickpractices.fundamental.sorting;

import java.util.Arrays;

public class MergeSort {

    void merge(int[] array, int left, int mid, int right) {
        // mid included in the first half
        int[] first = new int[mid - left + 1];
        int[] second = new int[right - mid];

        System.arraycopy(array, left, first, 0, first.length);
        System.arraycopy(array, mid + 1, second, 0, second.length);
        int i = 0, j = 0, k = left;
        while (i < first.length && j < second.length) {
            if (first[i] <= second[j]) {
                array[k++] = first[i++];
            } else {
                array[k++] = second[j++];
            }
        }
        while (i < first.length) {
            array[k++] = first[i++];
        }
        while (j < second.length) {
            array[k++] = second[j++];
        }
    }

    void sort(int[] array, int left, int right) {
        // if left == right, then we have broken everything down to size 1
        if (left < right) {
            int mid = left + (right - left)/2;
            sort(array, left, mid);
            sort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    public static void main(String[] args) {
        var solution = new MergeSort();
        var array = new int[]{12,11,13,5,6,7};
        solution.sort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
