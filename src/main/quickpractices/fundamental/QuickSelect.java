package main.quickpractices.fundamental;

public class QuickSelect {

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int pivotIndex = low;
        for (int i = low; i <= high; i++) {
            if (array[i] < pivot) {
                int temp = array[i];
                array[i] = temp;
                array[pivotIndex] = temp;
                pivotIndex++;
            }
        }
        array[high] = array[pivotIndex];
        array[pivotIndex] = pivot;
        return pivotIndex;
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
        System.out.println(solution.quickSelect(new int[]{ 10, 4, 5, 8, 6, 11, 26}, 3));
    }
}
