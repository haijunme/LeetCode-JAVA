package main.prep2021.quickpractices.binarytree;

import main.shared.TreeNode;
import java.util.*;

public class MaximumWidthOfBinaryTree {

    private static class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxWidth = 1;
        Deque<Pair> bfsQueue = new ArrayDeque<>();
        bfsQueue.add(new Pair(root, 0));
        while (!bfsQueue.isEmpty()) {
            maxWidth = Math.max(maxWidth, bfsQueue.getLast().index - bfsQueue.getFirst().index + 1);
            int breadth = bfsQueue.size();
            for (int i = 0; i < breadth; i++) {
                Pair current = bfsQueue.removeFirst();
                TreeNode node = current.node;
                int index = current.index;
                if (node.left != null) {
                    bfsQueue.addLast(new Pair(node.left, 2 * index));
                }
                if (node.right != null) {
                    bfsQueue.addLast(new Pair(node.right, 2 * index + 1));
                }
            }
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        TreeNode node6 = new TreeNode(9);
        TreeNode node5 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);
        TreeNode node3 = new TreeNode(2, null, node6);
        TreeNode node2 = new TreeNode(3, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);
        var solution = new MaximumWidthOfBinaryTree();
        System.out.println(solution.widthOfBinaryTree(node1));
    }
}
