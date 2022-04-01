package main.casestudies.killprocesses;

import java.util.*;

public class KillProcessesV2 {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        graph.put(0, new ArrayList<>());
        for (Integer process : pid) {
            graph.put(process, new ArrayList<>());
        }
        for (int i = 0; i < ppid.size(); i++) {
            graph.get(ppid.get(i)).add(pid.get(i));
        }
        Queue<Integer> toBeVisited = new LinkedList<>();
        toBeVisited.add(kill);
        result.add(kill);
        while (!toBeVisited.isEmpty()) {
            List<Integer> children = graph.get(toBeVisited.poll());
            for (Integer child : children) {
                result.add(child);
                toBeVisited.add(child);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        KillProcessesV2 solution = new KillProcessesV2();
        System.out.println(solution.killProcess(Arrays.asList(1, 3, 10, 5), Arrays.asList(3, 0, 5, 3), 5));
        System.out.println(solution.killProcess(Arrays.asList(1), Arrays.asList(0), 1));
    }
}
