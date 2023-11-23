package main.prep2021.quickpractices.counting;

public class PairOfSongsWithTotalDurationsDivisibleBySixty {

    public int numPairsDivisibleBy60(int[] time) {
        int[] remainders = new int[60];
        int count = 0;
        for (int t : time) {
            if (t % 60 == 0) {
                // "+0" if not finding the other part for a pair
                count += remainders[0];
            } else {
                // same as above
                count += remainders[60 - t % 60];
            }
            remainders[t % 60]++;
        }
        return count;
    }

    public static void main(String[] args) {
        var solution = new PairOfSongsWithTotalDurationsDivisibleBySixty();
        System.out.println(solution.numPairsDivisibleBy60(new int[]{60,60,60}));
    }
}
