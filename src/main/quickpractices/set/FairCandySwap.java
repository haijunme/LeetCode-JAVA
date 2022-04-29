package main.quickpractices.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FairCandySwap {

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceSum = 0;
        Set<Integer> alice = new HashSet<>();
        for (int number : aliceSizes) {
            aliceSum += number;
            alice.add(number);
        }

        int bobSum = 0;
        for (int number : bobSizes) {
            bobSum += number;
        }

        // aliceSum + bobSum guaranteed to be even since there will be at least one answer;
        int equalShare = (aliceSum +  bobSum)/2;
        for (int number : bobSizes) {
            int aliceNumber = equalShare-(bobSum - number);
            if (alice.contains(aliceNumber)) {
                return new int[]{aliceNumber, number};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        var solution = new FairCandySwap();
        System.out.println(Arrays.toString(solution.fairCandySwap(new int[]{1, 1}, new int[]{2, 2})));
    }

}
