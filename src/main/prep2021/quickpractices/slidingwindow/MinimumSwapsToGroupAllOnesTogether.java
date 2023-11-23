package main.prep2021.quickpractices.slidingwindow;

public class MinimumSwapsToGroupAllOnesTogether {

    public int minSwaps(int[] data) {
        int windowSize = 0;
        for (int number : data) {
            if (number == 1) windowSize++;
        }

        if (windowSize == 0 || windowSize == data.length) {
            return 0;
        }

        int zeroes = 0;
        int minSwaps = Integer.MAX_VALUE;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 0) zeroes++;
            if (i >= windowSize) {
                if (data[i - windowSize] == 0) zeroes--;
            }
            if (i >= windowSize - 1) {
                minSwaps= Math.min(minSwaps, zeroes);
            }
        }
        return minSwaps;
    }

    public static void main(String[] args) {
        var solution = new MinimumSwapsToGroupAllOnesTogether();
        System.out.println(solution.minSwaps(new int[]{1,1,0,0,0,0}));
    }
}
