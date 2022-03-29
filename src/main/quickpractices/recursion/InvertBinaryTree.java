package main.quickpractices.recursion;

import main.shared.TreeNode;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);

        root.left = right;
        root.right = left;
        return root;
    }
}
