package main.prep2021.quickpractices;

import java.util.ArrayList;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class PopulateNextRightPointersInEachNodeII {

    private void connectAndTraversal(ArrayList<Node> nodes) {
        if (nodes.isEmpty()) return;
        ArrayList<Node> nextLevel = new ArrayList<>();
        for (int i = 0; i <= nodes.size()-1; i++) {
            nodes.get(i).next = i == nodes.size() - 1 ? null : nodes.get(i+1);
            if (nodes.get(i).left != null) nextLevel.add(nodes.get(i).left);
            if (nodes.get(i).right != null) nextLevel.add(nodes.get(i).right);
        }
        connectAndTraversal(nextLevel);
    }

    public Node connect(Node root) {
        Node sentinel = new Node(Integer.MIN_VALUE, root, null, null);
        ArrayList<Node> nodes = new ArrayList<>();
        nodes.add(sentinel);
        connectAndTraversal(nodes);
        return sentinel.left;
    }

    public static void main(String[] args) {
        Node node5= new Node(5);
        Node node4= new Node(4);
        Node node2= new Node(2, node4, node5, null);

        Node node7= new Node(7);
        Node node3= new Node(3, null, node7, null);

        Node node1 = new Node(1, node2, node3, null);
        var solution = new PopulateNextRightPointersInEachNodeII();
        Node left = solution.connect(node1);
        while (left != null) {
            Node head = left;
            while (head != null) {
                System.out.print(head.val);
                head = head.next;
            }
            left = left.left;
            System.out.println("------");
        }
    }
}
