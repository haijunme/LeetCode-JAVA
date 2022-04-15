package main.quickpractices.array;

import java.util.*;

public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> intermediate = new ArrayList<>();
        for (int j : nums1) {
            map.putIfAbsent(j, 0);
            map.put(j, map.get(j) + 1);
        }
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                map.compute(num, (k, v) -> v - 1);
                intermediate.add(num);
            }
        }
        int[] answer = new int[intermediate.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = intermediate.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        var solution = new IntersectionOfTwoArraysII();
        System.out.println(Arrays.toString(solution.intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }
}