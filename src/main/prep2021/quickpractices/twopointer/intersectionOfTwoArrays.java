package main.prep2021.quickpractices.twopointer;

import java.util.*;

public class intersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        List<Integer> answer = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            int number1 = nums1[i];
            int number2 = nums2[j];

            if (number1 == number2) {
                answer.add(number1);
                i++;
                j++;
            } else if (number1 >= number2) {
                j++;
            } else {
                i++;
            }
        }

        int[] finalAnswer = new int[answer.size()];
        for (int k = 0; k < answer.size(); k++) {
            finalAnswer[k] = answer.get(k);
        }
        return finalAnswer;
    }

    public static void main(String[] args) {
        var solution = new intersectionOfTwoArrays();
        System.out.println(Arrays.toString(solution.intersection(new int[]{1,2,2,1}, new int[]{2,2})));
    }
}
