package main.quickpractices.unionfind;

import java.awt.image.ImageProducer;
import java.util.*;

public class SmallestStringWithSwaps {
    private String s;
    private char[] charArray;

    private void dfs(Integer start, Map<Integer, List<Integer>> connected, Set<Integer> visited) {
        if (visited.contains(start)) {
            return;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited.add(start);

        List<Integer> indice = new ArrayList<>();
        List<Character> character = new ArrayList<>();
        indice.add(start);
        character.add(s.charAt(start));

        while (!stack.isEmpty()) {
            Integer current = stack.pop();
            List<Integer> connectedNodes = connected.get(current);
            for (Integer index : connectedNodes) {
                if (!visited.contains(index)) {
                    visited.add(index);
                    indice.add(index);
                    stack.push(index);
                    character.add(s.charAt(index));
                }
            }
        }

        character.sort(Comparator.comparingInt(a -> (int) a));
        indice.sort(Comparator.comparingInt(a -> a));
        for (int i = 0; i < character.size(); i++) {
            charArray[indice.get(i)] = character.get(i);
        }
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        this.s = s;
        this.charArray = s.toCharArray();
        Map<Integer, List<Integer>> connected = new HashMap<>();

        for (List<Integer> pair : pairs) {
            Integer start = pair.get(0);
            Integer end = pair.get(1);

            if (connected.get(start) == null) {
                connected.put(start, new ArrayList<>());
            }
            if (connected.get(end) == null) {
                connected.put(end, new ArrayList<>());
            }
            connected.get(start).add(end);
            connected.get(end).add(start);
        }

        Set<Integer> visited = new HashSet<>();
        for (Integer start : connected.keySet()) {
            dfs(start, connected, visited);
        }
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        var solution = new SmallestStringWithSwaps();
        System.out.println(solution.smallestStringWithSwaps("cba", List.of(
                List.of(0, 1),
                List.of(1,2)
        )));
    }
}
