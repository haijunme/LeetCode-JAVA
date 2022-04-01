package main.casestudies.killprocesses;

import java.util.*;

public class KillProcessesV1 {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        graph.put(0, new ArrayList<>());
        for (Integer process : pid) {
            graph.put(process, new ArrayList<>());
        }
        for (int i = 0; i < ppid.size(); i ++) {
            graph.get(ppid.get(i)).add(pid.get(i));
        }
        Queue<Integer> toBeVisited = new LinkedList<>();
        toBeVisited.add(kill);
        result.add(kill);
        visited.add(kill);
        while (!toBeVisited.isEmpty()) {
            List<Integer> children = graph.get(toBeVisited.poll());
            for (Integer child : children) {
                if (!visited.contains(child)) {
                    visited.add(child);
                    result.add(child);
                    toBeVisited.add(child);
                }
            }
        }
        return result;
    }
}
