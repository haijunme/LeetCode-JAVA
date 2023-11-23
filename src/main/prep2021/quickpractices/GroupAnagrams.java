package main.prep2021.quickpractices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        HashMap<String, List<String>> cache = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String rearrangedStr = new String(chars);
            if (cache.get(rearrangedStr) == null) {
                cache.put(rearrangedStr, new ArrayList<>());
            }
            cache.get(rearrangedStr).add(str);
        }
        answer.addAll(cache.values());
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
