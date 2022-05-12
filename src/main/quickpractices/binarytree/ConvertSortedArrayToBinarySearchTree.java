package main.quickpractices.binarytree;

import main.shared.TreeNode;

import java.util.*;

public class ConvertSortedArrayToBinarySearchTree {

    private TreeNode construct(int[] nums, int left, int right) {
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        if (left > right) {
            return null;
        }
        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = construct(nums, left, mid - 1);
        root.right = construct(nums, mid + 1, right);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return construct(nums, 0, nums.length-1);
    }

    public static void main(String[] args) {
        var solution = new ConvertSortedArrayToBinarySearchTree();
        TreeNode node = solution.sortedArrayToBST(new int[]{1, 3});
        System.out.println(node.val);
    }
}
