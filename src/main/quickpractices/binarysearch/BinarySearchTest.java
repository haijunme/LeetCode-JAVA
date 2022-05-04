package main.quickpractices.binarysearch;

public class BinarySearchTest {

    public int bs(int[] array, int target) {
        int i = 0;
        int j = array.length-1;
        while (i <= j) {
            int mid = i + (j - i)/2;
            if (array[mid] > target) {
                j = mid -1;
            } else {
                i = mid + 1;
            }
        }
        return Math.min(Math.abs(target - array[i]), Math.abs(array[j] - target));
    }

    public static void main(String[] args) {
        var solution = new BinarySearchTest();
        System.out.println(solution.bs(new int[]{4,7,11,13}, 8));
    }
}
