package main.prep2021.quickpractices.binarytree;

import main.shared.TreeNode;

import java.util.*;

public class BinaryTreeRightView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        Deque<TreeNode> bfs = new ArrayDeque<>();
        if (root != null) {
            bfs.add(root);
        }
        while (!bfs.isEmpty()) {
            int breadth = bfs.size();
            answer.add(bfs.peekLast().val);
            for (int i = 0; i < breadth; i++) {
                TreeNode current = bfs.removeFirst();
                if (current.left != null) {
                    bfs.addLast(current.left);
                }
                if (current.right != null) {
                    bfs.addLast(current.right);
                }
            }
        }
        return answer;
    }
}
