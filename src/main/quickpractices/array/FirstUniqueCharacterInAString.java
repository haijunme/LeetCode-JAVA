package main.quickpractices.array;

import java.util.*;

public class FirstUniqueCharacterInAString {

    //    public int firstUniqChar(String s) {
//        Map<Character, Integer> count = new HashMap<>();
//        Map<Character, Integer> firstSeen = new HashMap<>();
//        PriorityQueue<Character> minHeap = new PriorityQueue<>(Comparator.comparingInt(firstSeen::get));
//        for (int i = 0; i < s.length(); i++) {
//            char character = s.charAt(i);
//            minHeap.remove(character);
//            count.putIfAbsent(character, 0);
//            firstSeen.putIfAbsent(character, i);
//            count.computeIfPresent(character, (k, v) -> v + 1);
//            if (count.get(character) == 1) {
//                minHeap.add(character);
//            }
//        }
//        return minHeap.size() == 0 ? -1 : firstSeen.get(minHeap.peek());
//    }
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        var solution = new FirstUniqueCharacterInAString();
        System.out.println(solution.firstUniqChar("aabb"));
    }
}
