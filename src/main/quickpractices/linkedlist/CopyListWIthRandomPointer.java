package main.quickpractices.linkedlist;

import java.util.*;

public class CopyListWIthRandomPointer {
    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        List<Node> created = new ArrayList<>();
        Map<Node, Node> originalToCopyNodeMap = new HashMap<>();

        Node current = head;
        while (current != null) {
            Node newNode = new Node(current.val);
            created.add(newNode);
            originalToCopyNodeMap.put(current, newNode);
            current = current.next;
        }
        created.add(null);
        originalToCopyNodeMap.put(null, null);

        current = head;
        int i = 0;
        while (current != null) {
            created.get(i).next = created.get(i+1);
            created.get(i).random = originalToCopyNodeMap.get(current.random);
            current = current.next;
            i++;
        }
        return created.get(0);
    }

    public static void main(String[] args) {
        Node node4 = new Node(1, null);
        Node node3 = new Node(10, node4);
        Node node2 = new Node(11, node3);
        Node node1 = new Node(13, node2);
        Node node0 = new Node(7, node1);

        node0.random = null;
        node1.random = node0;
        node2.random = node4;
        node3.random = node2;
        node4.random = node0;

        var solution = new CopyListWIthRandomPointer();
        System.out.println(solution.copyRandomList(null));
    }
}
