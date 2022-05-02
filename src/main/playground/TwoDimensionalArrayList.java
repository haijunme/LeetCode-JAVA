package main.playground;

import java.util.*;

public class TwoDimensionalArrayList {

    public static void main(String[] args) {
        int[][] twoDArray = new int[][]{{1, 2}, {3, 4}};
        int[] firstPart = twoDArray[0];
        firstPart[0] += 1;
        System.out.println(Arrays.toString(firstPart));
        System.out.println(Arrays.toString(twoDArray[0]));

        List<List<Integer>> twoDArrayList = new ArrayList<>();
        twoDArrayList.add(Arrays.asList(1, 2, 3));

        List<Integer> firstPart2 = twoDArrayList.get(0);
        firstPart2.set(1, firstPart2.get(1) + 1);
        System.out.println(firstPart2);
        System.out.println(twoDArrayList.get(0));

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
    }
}
