package main.quickpractices.array;

import main.shared.TreeNode;

public class TrimABinarySearchTree {
    private int low;
    private int high;

    private TreeNode findFirstQualified(TreeNode root) {
        if (root == null) {
            return null;
        }
        int val = root.val;
        if (val < low) {
            return findFirstQualified(root.right);
        }
        if (val > high) {
            return findFirstQualified(root.left);
        }
        return root;
    }

    private TreeNode trim(TreeNode root) {
        TreeNode node = findFirstQualified(root);
        if (node == null) {
            return null;
        }
        node.left = trim(node.left);
        node.right = trim(node.right);
        return node;
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;
        return trim(root);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2, node1, null);
        TreeNode node4 = new TreeNode(4);
        TreeNode node0 = new TreeNode(0, null, node2);
        TreeNode node3 = new TreeNode(3, node0, node4);

        var solution = new TrimABinarySearchTree();
        TreeNode answer = solution.trimBST(node3, 1, 3);
        System.out.println(answer.val);
    }
}
