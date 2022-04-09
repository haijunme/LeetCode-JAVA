package main.quickpractices.dynamicprogramming;

public class FlipStringToMonotoneIncreasing {

//    public int minFlipsMonoIncr(String s) {
//        char[] digits = s.toCharArray();
//        int minFlip = Integer.MAX_VALUE;
//        for (int i = 0; i < digits.length; i++) {
//            int flipOne = 0;
//            int flipZero = 0;
//            for (int j = 0; j < i; j++) {
//                if (digits[j] == '1') flipOne++;
//                else flipZero++;
//            }
//            int flipBefore = digits[i] == '0' ? flipOne : Math.min(flipOne, flipZero);
//
//            int flipAfter = 0;
//            for (int j = i + 1; j < digits.length; j++) {
//                if (digits[j] != digits[i]) flipAfter++;
//            }
//            minFlip = Math.min(minFlip, flipBefore + flipAfter);
//        }
//        return minFlip == Integer.MAX_VALUE ? 0 : minFlip;
//    }

    public int minFlipsMonoIncr(String S) {
        int N = S.length();
        int totalZero = 0;
        int totalOne = 0;
        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == '0') totalZero++;
            else totalOne++;
        }

        int totalFlip = Integer.MAX_VALUE;
        int currentOne = 0;
        int currentZero = 0;
        for (int i = 0; i < N; i++) {
            if (i == 0 || i == N-1) {
                if (S.charAt(i) == '0') {
                    totalFlip = Math.min(totalFlip, totalOne);
                    currentZero++;
                } else {
                    totalFlip = Math.min(totalFlip, totalZero);
                    currentOne++;
                }
            } else {
                if (S.charAt(i) == '0') {
                    totalFlip = Math.min(totalFlip, currentOne + totalZero - currentZero - 1);
                    currentZero++;
                } else {
                    totalFlip = Math.min(totalFlip, Math.min(currentOne, currentZero) + totalZero - currentZero);
                    currentOne++;
                }
            }
        }
        return totalFlip;
    }

    public static void main(String[] args) {
        var solution = new FlipStringToMonotoneIncreasing();
        System.out.println(solution.minFlipsMonoIncr("100000001010000"));
    }
}
