package main.quickpractices.graph;

import java.util.*;
import main.shared.Node;

public class CloneGraph {

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (node.neighbors.isEmpty()) {
            return new Node(node.val);
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> seen = new HashSet<>();
        seen.add(node.val);
        Deque<Node> bfs = new ArrayDeque<>();
        bfs.add(node);

        while (!bfs.isEmpty()) {
            int breadth = bfs.size();
            for (int i = 0; i < breadth; i++) {
                Node current = bfs.removeFirst();
                graph.putIfAbsent(current.val, new ArrayList<>());
                for (Node neighbour : current.neighbors) {
                    graph.get(current.val).add(neighbour.val);
                    if (!seen.contains(neighbour.val)) {
                        bfs.addLast(neighbour);
                        seen.add(neighbour.val);
                    }
                }
            }
        }
        List<Node> newNodes = new ArrayList<>();
        for (int i = 0; i < graph.keySet().size(); i++) {
            newNodes.add(new Node(i+1));
        }
        Node answer = new Node(-1);
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            if (entry.getKey() == node.val) {
                answer = newNodes.get(entry.getKey()-1);
            }
            for (Integer connected : entry.getValue()) {
                newNodes.get(entry.getKey()-1).neighbors.add(newNodes.get(connected-1));
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        var solution = new CloneGraph();
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node1 = new Node(1);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        System.out.println(solution.cloneGraph(node1));
    }
}
