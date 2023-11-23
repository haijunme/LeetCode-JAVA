package main.prep2021.quickpractices;

import java.util.*;

public class RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> answer = new HashSet<>();
        if (s.length() < 10) {
            return new ArrayList<>();
        }
        Set<String> cache = new HashSet<>(); 
        for (int i = 10; i <= s.length(); i++) {
            String subpart = s.substring(i-10, i);
            if (!cache.add(subpart)) {
                answer.add(subpart);
            }
        }
        return new ArrayList<>(answer);
    }

    public static void main(String[] args) {
        var solution = new RepeatedDNASequences();
        System.out.println(solution.findRepeatedDnaSequences("AAAAAAAAAAAAA"));
    }
}
