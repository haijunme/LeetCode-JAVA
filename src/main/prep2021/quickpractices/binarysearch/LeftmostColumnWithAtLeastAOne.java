package main.prep2021.quickpractices.binarysearch;

import java.util.List;

public class LeftmostColumnWithAtLeastAOne {

    // This is the BinaryMatrix's API interface.
    // You should not implement it, or speculate about its implementation
    interface BinaryMatrix {
        public int get(int row, int col);
        public List<Integer> dimensions();
    }

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int leftMost = Integer.MAX_VALUE;
        List<Integer> dimensions = binaryMatrix.dimensions();
        final int M = dimensions.get(0);
        final int N = dimensions.get(1);
        for (int i = 0; i < M; i++) {
            int left = 0, right = N - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                int midVal = binaryMatrix.get(i, mid);
                if (midVal == 0) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (binaryMatrix.get(i, left) == 1) {
                leftMost = Math.min(leftMost, left);
            }
        }
        return leftMost == Integer.MAX_VALUE ? -1 : leftMost;
    }
}
