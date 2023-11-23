package main.prep2021.quickpractices.binarysearch;

import main.shared.TreeNode;

public class ClosestBinarySearchTreeValue {

    public int closestValue(TreeNode root, double target) {
        int answer = root.val;
        while (root != null) {
            int val = root.val;
            answer = Math.abs(val - target) <= Math.abs(answer - target) ? val : answer;
            root = target < val ? root.left : root.right;
        }
        return answer;
    }

    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node2 = new TreeNode(2, node1, node3);
//
//        TreeNode node5= new TreeNode(5);
//        TreeNode node4 = new TreeNode(4, node2, node5);

        TreeNode node1 = new TreeNode(1);
        var solution = new ClosestBinarySearchTreeValue();
        System.out.println(solution.closestValue(node1, 3.714286));
    }
}
