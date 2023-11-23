package main.prep2021.quickpractices.binarytree;

import main.shared.TreeNode;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
    private Map<Integer, List<Integer>> treeNodesByColumns;
    private int leftMostColumn = 0;
    private int rightMostColumn = 0;

    private static class Pair {
        private int column;
        private TreeNode node;
        private Pair(int column, TreeNode node) {
            this.column = column;
            this.node = node;
        }
    }

    private void addNode(Deque<Pair> bfsQueue, int column, TreeNode node) {
        bfsQueue.add(new Pair(column, node));
        treeNodesByColumns.putIfAbsent(column, new ArrayList<>());
        treeNodesByColumns.get(column).add(node.val);
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        treeNodesByColumns = new HashMap<>();
        if (root == null) {
            return new ArrayList<>();
        }

        Deque<Pair> bfsQueue = new ArrayDeque<>();
        addNode(bfsQueue, 0, root);
        while (!bfsQueue.isEmpty()) {
            int breadth = bfsQueue.size();
            for (int i = 0; i < breadth; i++) {
                Pair parent = bfsQueue.removeFirst();
                if (parent.node.left != null) {
                    int leftColumn = parent.column - 1;
                    leftMostColumn = Math.min(leftColumn, leftMostColumn);
                    addNode(bfsQueue, leftColumn, parent.node.left);
                }
                if (parent.node.right != null) {
                    int rightColumn = parent.column + 1;
                    rightMostColumn = Math.max(rightColumn, rightMostColumn);
                    addNode(bfsQueue, rightColumn, parent.node.right);
                }
            }
        }

        List<List<Integer>> answer = new ArrayList<>();
        for (int i = leftMostColumn; i <= rightMostColumn; i++) {
            if (treeNodesByColumns.containsKey(i)) {
                answer.add(treeNodesByColumns.get(i));
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(1);

        TreeNode node5 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);

        TreeNode node3 = new TreeNode(8, node6, node7);
        TreeNode node2 = new TreeNode(9, node4, node5);

        TreeNode node1 = new TreeNode(3, node2, node3);

        var solution = new BinaryTreeVerticalOrderTraversal();
        for (List<Integer> nodes : solution.verticalOrder(node1)) {
            System.out.println(nodes.toString());
        }
    }
}
