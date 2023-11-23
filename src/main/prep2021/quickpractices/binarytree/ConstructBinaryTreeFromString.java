package main.prep2021.quickpractices.binarytree;

public class ConstructBinaryTreeFromString {
    //@formatter:off
    private static class TreeNode {
        int val; TreeNode left, right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val; this.left = left; this.right = right;
        }
    }
    //@formatter:on
    public TreeNode str2tree(String s) {
        if (s.length() == 0) return null;
        int openingCount = 0, closingCount = 0;
        boolean hasFoundRoot = false;
        int sign = 1;
        StringBuilder rootValueBuilder = new StringBuilder();
        TreeNode leftNode = null, rightNode = null;
        int left = -1;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '-' && !hasFoundRoot) {
                sign = -1;
            } else if (Character.isDigit(current) && !hasFoundRoot) {
                rootValueBuilder.append(current);
            } else if (current == '(') {
                hasFoundRoot = true;
                if (left == -1) left = i + 1;
                openingCount++;
            } else if (current == ')') {
                closingCount++;
                if (openingCount == closingCount) {
                    TreeNode node = str2tree(s.substring(left, i));
                    if (leftNode == null) leftNode = node;
                    else rightNode = node;
                    openingCount = (closingCount = 0);
                    left = -1;
                }
            }
        }
        return new TreeNode(Integer.parseInt(rootValueBuilder.toString()) * sign, leftNode, rightNode);
    }

    public static void main(String[] args) {
        var solution = new ConstructBinaryTreeFromString();
        TreeNode node = solution.str2tree("-4(22(3)(137))(6(5)(7))");
        System.out.println(node);
    }
}
