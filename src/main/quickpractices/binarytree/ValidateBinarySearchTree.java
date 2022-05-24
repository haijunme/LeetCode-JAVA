package main.quickpractices.binarytree;

import main.shared.TreeNode;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return recurCheck(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean recurCheck(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return recurCheck(root.left, min, root.val) && recurCheck(root.right, root.val, max);
    }
}
