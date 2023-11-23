package main.prep2021.quickpractices.math;

public class MinimumHealthToBeatGame {
    public long minimumHealth(int[] damage, int armor) {
        long sum = 0;
        int maxUse = 0;
        for (int n : damage) {
            sum += n;
            maxUse = Math.max(maxUse, Math.min(armor, n));
        }
        return sum + 1 - maxUse;
    }
}
