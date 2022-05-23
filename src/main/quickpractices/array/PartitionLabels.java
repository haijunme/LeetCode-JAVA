package main.quickpractices.array;

import java.util.*;

public class PartitionLabels {
    private static final char BASE_CHAR = 'a';

    public List<Integer> partitionLabels(String s) {
        List<Integer> answer = new ArrayList<>();
        int[] totalCounts = new int[26];
        // O(N)
        for (int i = 0; i < s.length(); i++) {
            totalCounts[s.charAt(i) - BASE_CHAR] ++;
        }
        int[] subpartCount = new int[26];

        for (int i = 0; i < s.length(); i++) {
            subpartCount[s.charAt(i) - BASE_CHAR] ++;
            boolean createPartition = true;
            for (int j = 0; j < 26; j++) {
                if (subpartCount[j] != 0 && subpartCount[j] != totalCounts[j]) {
                    createPartition = false;
                    break;
                }
            }
            if (createPartition) {
                int partitionSize = 0;
                for (int j = 0; j < 26; j++) {
                    partitionSize += subpartCount[j];
                    subpartCount[j] = 0;
                }
                answer.add(partitionSize);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        var solution = new PartitionLabels();
        System.out.println(solution.partitionLabels("a").toString());
    }
}
