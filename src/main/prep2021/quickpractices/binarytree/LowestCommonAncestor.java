package main.prep2021.quickpractices.binarytree;

import main.shared.TreeNode;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left_res = lowestCommonAncestor(root.left, p, q);
        TreeNode right_res = lowestCommonAncestor(root.right, p, q);

        if (left_res != null && right_res != null) {
            return root;
        }
        return left_res != null ? left_res : right_res;
    }
}
