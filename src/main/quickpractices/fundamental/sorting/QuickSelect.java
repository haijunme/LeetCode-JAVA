package main.quickpractices.fundamental.sorting;

public class QuickSelect {

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int insertion = low;
        for (int i = low; i <= high; i++) {
            if (array[i] < pivot) {
                int temp = array[i];
                array[i] = array[insertion];
                array[insertion] = temp;
                insertion++;
            }
        }
        array[high] = array[insertion];
        array[insertion] = pivot;
        return insertion;
    }

    private int findKth(int[] array, int low, int high, int targetIndex) {
        int pivot = partition(array, low, high);

        if (pivot == targetIndex) {
            return array[pivot];
        } else if (pivot < targetIndex) {
            return findKth(array, pivot+1, high, targetIndex);
        } else {
            return findKth(array, low, pivot-1, targetIndex);
        }
    }

    public int quickSelect(int[] array, int k) {
        return findKth(array, 0, array.length-1, k-1);
    }

    public static void main(String[] args) {
        var solution = new QuickSelect();
        System.out.println(solution.quickSelect(new int[]{ 6, 7, 8, 3, 4, 2, 5}, 3));
    }
}
