package main.quickpractices.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyCache = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> frequencyCache.get(b) - frequencyCache.get(a));
        for (int currentNum : nums) {
            frequencyCache.putIfAbsent(currentNum, 0);
            frequencyCache.computeIfPresent(currentNum, (key, value) -> value + 1);
        }
        maxHeap.addAll(frequencyCache.keySet());

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.remove();
        }
        return result;
    }

    public static void main(String[] args) {
        var solution = new TopKFrequentElements();
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1,1,1,2,2,3}, 2)));
    }
}
