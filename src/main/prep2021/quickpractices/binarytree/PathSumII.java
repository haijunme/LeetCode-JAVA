package main.prep2021.quickpractices.binarytree;

import java.util.*;
import main.shared.TreeNode;

public class PathSumII {
    private List<List<Integer>> answer;

    private boolean isLeaf(TreeNode root) {
        return root != null && root.left == null && root.right == null;
    }

    private void findPaths(TreeNode root, int targetSum, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        int remaining = targetSum - root.val;
        if (isLeaf(root) && remaining == 0) {
            answer.add(new ArrayList<>(path));
        }
        findPaths(root.left, remaining, path);
        findPaths(root.right, remaining, path);
        path.remove(path.size()-1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.answer = new ArrayList<>();
        findPaths(root, targetSum, new ArrayList<>());
        return answer;
    }
}
