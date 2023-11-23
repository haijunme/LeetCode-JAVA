package main.prep2021.quickpractices;

import main.shared.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BoundaryOfBinaryTree {
    private final List<Integer> boundary = new ArrayList<>();
    private final List<Integer> leftBoundary = new ArrayList<>();
    private final List<Integer> leaves = new ArrayList<>();
    private final List<Integer> rightBoundary = new ArrayList<>();

    private void addLeaves(TreeNode node) {
        if(node == null) return;
        if(node.left == null && node.right == null) leaves.add(node.val);
        addLeaves(node.left);
        addLeaves(node.right);
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        boundary.add(root.val);
        TreeNode node = root.left;
        while (node != null) {
            if (node.left != null || node.right != null) {
                leftBoundary.add(node.val);
            }  else {
                leaves.add(node.val);
            }
            if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        node = root.right;
        while (node != null) {
            if (node.left != null || node.right != null) {
                rightBoundary.add(0, node.val);
            }  else {
                leaves.add(node.val);
            }
            if (node.right != null) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        boundary.addAll(leftBoundary);
        boundary.addAll(leaves);
        boundary.addAll(rightBoundary);
        return boundary;
    }
}
