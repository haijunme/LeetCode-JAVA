package main.prep2021.quickpractices.binarytree;

import main.shared.TreeNode;

import java.util.*;

public class FindLeavesOfBinaryTree {
    private List<List<Integer>> nodesByLevel = new ArrayList<>();
    private int maxLevel;

    private int arrangeNodesByLevel(TreeNode root) {
        if (root.left == null && root.right == null) {
            if (nodesByLevel.size() == 0) nodesByLevel.add(new ArrayList<>());
            nodesByLevel.get(0).add(root.val);
            return 0;
        }
        int leftLevel = 0;
        if (root.left != null) {
            leftLevel = arrangeNodesByLevel(root.left) + 1;
        }
        int rightLevel = 0;
        if (root.right != null) {
            rightLevel = arrangeNodesByLevel(root.right) + 1;
        }
        int currentLevel = Math.max(leftLevel, rightLevel);
        maxLevel = Math.max(currentLevel, maxLevel);
        if (nodesByLevel.size() == currentLevel) nodesByLevel.add(new ArrayList<>());
        nodesByLevel.get(currentLevel).add(root.val);
        return currentLevel;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        arrangeNodesByLevel(root);
        return nodesByLevel;
    }

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5, node4, null);
        TreeNode node2 = new TreeNode(2, null, node5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1, node2, node3);

        TreeNode singleNode = new TreeNode(1);
        var solution = new FindLeavesOfBinaryTree();
        System.out.println(solution.findLeaves(node1));
    }
}
