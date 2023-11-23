package main.prep2021.quickpractices.binarysearch;

import java.util.*;

public class ShortestWordDistance {
    private final Map<String, List<Integer>> wordIndexes;

    public ShortestWordDistance(String[] wordsDict) {
        this.wordIndexes = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            String current = wordsDict[i];
            wordIndexes.putIfAbsent(current, new ArrayList<>());
            wordIndexes.get(current).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> word1Indexes =  wordIndexes.get(word1);
        List<Integer> word2Indexes =  wordIndexes.get(word2);
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        while (i < word1Indexes.size() && j < word2Indexes.size()) {
            Integer index1 = word1Indexes.get(i);
            Integer index2 = word2Indexes.get(j);
            min = Math.min(min, Math.abs(index1 - index2));
            if (index1 <= index2) {
                i ++;
            } else {
                j ++;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        var solution = new ShortestWordDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"});
     //   System.out.println(solution.shortest("coding", "practice"));
        System.out.println(solution.shortest("makes", "coding"));
    }
}
