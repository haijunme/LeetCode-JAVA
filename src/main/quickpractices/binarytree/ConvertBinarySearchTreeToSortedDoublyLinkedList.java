package main.quickpractices.binarytree;

import java.util.ArrayList;
import java.util.List;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {

    // Definition for a Node.
    private static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    private static class UsingAList {
        private void storeAllNodesByOrder(Node node, List<Node> nodes) {
            if (node == null) {
                return;
            }
            storeAllNodesByOrder(node.left, nodes);
            nodes.add(node);
            storeAllNodesByOrder(node.right, nodes);
        }


        public Node treeToDoublyList(Node root) {
            List<Node> orderedNodes = new ArrayList<>();
            if (root == null) {
                return null;
            }
            storeAllNodesByOrder(root, orderedNodes);
            Node firstNode = orderedNodes.get(0);
            int size = orderedNodes.size();
            if (size == 1) {
                firstNode.left = firstNode;
                firstNode.right = firstNode;
                return firstNode;
            }
            Node lastNode = orderedNodes.get(size - 1);
            firstNode.left = lastNode;
            firstNode.right = orderedNodes.get(1);
            lastNode.right = firstNode;
            lastNode.left = orderedNodes.get(size - 2);

            for (int i = 1; i < size - 1; i++) {
                Node current = orderedNodes.get(i);
                current.left = orderedNodes.get(i-1);
                current.right = orderedNodes.get(i+1);
            }
            return firstNode;
        }
    }

    // TODO recursive implementation
    private static class UsingRecursion {
//        public Node treeToDoublyList(Node root) {
//
//        }
    }

    public static void main(String[] args) {
        Node node3 = new Node(3);
        Node node1 = new Node(1);

        Node node2 = new Node(2, node1, node3);
        Node node6 = new Node(6);
        Node node5 = new Node(5, null, node6);
        Node node4 = new Node(4, node2, node5);

//        var solution = new UsingAList();
//        System.out.println(solution.treeToDoublyList(node4));
    }
}
