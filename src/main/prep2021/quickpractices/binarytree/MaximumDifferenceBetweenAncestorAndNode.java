package main.prep2021.quickpractices.binarytree;

import main.shared.TreeNode;

public class MaximumDifferenceBetweenAncestorAndNode {
    //@formatter:off
    private static class Pair {
        int min;
        int max;
        private Pair(int min, int max) {
            this.min = min; this.max = max;
        }
    }
    //@formatter:on
    int result;

    private Pair getMinMaxChildren(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return new Pair(root.val, root.val);
        }
        Pair leftResult = getMinMaxChildren(root.left);
        Pair rightResult = getMinMaxChildren(root.right);
        Pair localResult;
        if (leftResult == null) {
            localResult = new Pair(rightResult.min, rightResult.max);
        } else if (rightResult == null) {
            localResult = new Pair(leftResult.min, leftResult.max);
        } else {
            localResult = new Pair(
                    Math.min(leftResult.min, rightResult.min),
                    Math.max(leftResult.max, rightResult.max)
            );
        }
        result = Math.max(
                result,
                Math.max(Math.abs(root.val - localResult.min), Math.abs(root.val - localResult.max)));
        localResult.min = Math.min(localResult.min, root.val);
        localResult.max = Math.max(localResult.max, root.val);
        return localResult;
    }

    public int maxAncestorDiff(TreeNode root) {
        getMinMaxChildren(root);
        return result;
    }

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6, node4, node7);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3, node1, node6);

        TreeNode node13 = new TreeNode(13);
        TreeNode node14 = new TreeNode(14, node13, null);
        TreeNode node10 = new TreeNode(10, null, node14);

        TreeNode node8 = new TreeNode(8, node3, node10);
        var solution = new MaximumDifferenceBetweenAncestorAndNode();
        System.out.println(solution.maxAncestorDiff(node8));
    }
}
