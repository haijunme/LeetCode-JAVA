package main.prep2021.quickpractices.recursion;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizingString {

    private void decreaseFrequencyAndUpdateQueue(
            Map<Character, Integer> frequencyCache,
            PriorityQueue<Character> maxHeap,
            Character character) {
        frequencyCache.put(character, frequencyCache.get(character) - 1);
        if (frequencyCache.get(character) > 0) maxHeap.add(character);
    }

    public String reorganizeString(String s) {
        Map<Character, Integer> frequencyCache = new HashMap<>();
        for (Character character : s.toCharArray()) {
            frequencyCache.putIfAbsent(character, 0);
            frequencyCache.put(character, frequencyCache.get(character) + 1);
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> frequencyCache.get(b) - frequencyCache.get(a));
        maxHeap.addAll(frequencyCache.keySet());

        StringBuilder answer = new StringBuilder();
        while (maxHeap.size() > 1) {
            Character mostUsed = maxHeap.poll();
            Character secondMostUsed = maxHeap.poll();
            answer.append(mostUsed).append(secondMostUsed);
            decreaseFrequencyAndUpdateQueue(frequencyCache, maxHeap, mostUsed);
            decreaseFrequencyAndUpdateQueue(frequencyCache, maxHeap, secondMostUsed);
        }

        if (!maxHeap.isEmpty()) {
            Character lastChar = maxHeap.poll();
            if (frequencyCache.get(lastChar) > 1) {
                return "";
            }
            answer.append(lastChar);
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        var solution = new ReorganizingString();
        System.out.println(solution.reorganizeString("aaabbc"));
    }
}
