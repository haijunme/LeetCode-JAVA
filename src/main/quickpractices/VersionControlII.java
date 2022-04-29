package main.quickpractices;

import java.util.Arrays;
import java.util.function.Predicate;

public class VersionControlII {

    public int[] midGoodGoRight(int n, Predicate<Integer> predicate)    {
        if (n == 1) {
            return new int[]{1, 1};
        }

        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left)/2;
           // boolean midGood = predicate.test(mid);
            if (mid < 2) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{left, right};
    }

    public int[] midGoodGoLeft(int n, Predicate<Integer> predicate)    {
        if (n == 1) {
            return new int[]{1, 1};
        }

        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left)/2;
            //boolean midGood = predicate.test(mid);
            if (mid >= 2) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{left, right};
    }

    public static void main(String[] args) {
        VersionControlII versionControlII = new VersionControlII();
        System.out.println(Arrays.toString(versionControlII.midGoodGoRight(4, (a) -> a < 2)));
        System.out.println(Arrays.toString(versionControlII.midGoodGoLeft(4, (a) -> a >= 2)));
    }
}
