package main.quickpractices.binarysearch;

public class GuessNumberHigherOrLower {

    // Stub function
    private int guess(int x) {
        return Integer.compare(x, 6);
    }

    public int guessNumber(int n) {
        if (n == 1) return 1;

        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left)/2;
            int guessResult = guess(mid);
            if (guessResult == 0) {
                return mid;
            } else if (guessResult < 0) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }
}
