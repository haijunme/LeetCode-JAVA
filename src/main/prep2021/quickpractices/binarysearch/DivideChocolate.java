package main.prep2021.quickpractices.binarysearch;

public class DivideChocolate {
    private int pieces;
    private int[] sweetness;

    public int maximizeSweetness(int[] sweetness, int k) {
        this.pieces = k + 1;
        this.sweetness = sweetness;

        int left = Integer.MAX_VALUE;
        int right = 0;
        for (int value : sweetness) {
            right += value;
            left = Math.min(value, left);
        }

        while (left <= right) {
            int mid = left + (right - left)/2;
            if (validMin(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private boolean validMin(int min) {
        int sum = 0;
        int cuts = 0;
        for (int value : sweetness) {
            sum += value;
            if (sum >= min) {
                cuts++;
                sum = 0;
            }
        }
        return cuts >= pieces;
    }

    public static void main(String[] args) {
        var solution = new DivideChocolate();
        System.out.println(solution.maximizeSweetness(new int[]{1,2,3,4,5,6,7,8,9}, 5));
    }
}
