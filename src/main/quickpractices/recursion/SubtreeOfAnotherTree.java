package main.quickpractices.recursion;

import main.shared.TreeNode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class SubtreeOfAnotherTree {

    private boolean compareTree(TreeNode root, TreeNode subRoot) {
        if (root == null) return subRoot == null;
        if (subRoot == null) return false;
        if (root.val != subRoot.val) return false;
        return compareTree(root.left, subRoot.left) && compareTree(root.right, subRoot.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        return compareTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static void main(String[] args) {
        TreeNode treeNodeExtra = new TreeNode(-1);
        TreeNode treeNode1 = new TreeNode(1, treeNodeExtra, null);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(4, treeNode1, treeNode2);

        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(3, treeNode4, treeNode5);


        TreeNode subNode1 = new TreeNode(1);
        TreeNode subNode2 = new TreeNode(2);
        TreeNode subNode4 = new TreeNode(4, subNode1, subNode2);

        var solution = new SubtreeOfAnotherTree();
        System.out.println(solution.isSubtree(treeNode3, subNode4));
    }
}
