package main.prep2021.quickpractices.binarysearch;

public class ArrangeCoins {

    public int arrangeCoins(int n) {
        if (n == 1) return 1;
        long left = 1;
        long right = n;
        while (left <= right) {
            long mid = left + (right - left)/2;
            long coinsNeeded = ((1 + mid) * mid)/2;

            if (coinsNeeded == n) {
                return (int)mid;
            } else if (coinsNeeded < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int)(left-1);
    }

    public static void main(String[] args) {
        var solution = new ArrangeCoins();
        System.out.println(solution.arrangeCoins(5));
    }
}
