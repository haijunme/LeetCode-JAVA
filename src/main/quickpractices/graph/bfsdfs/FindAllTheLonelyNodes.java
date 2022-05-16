package main.quickpractices.graph.bfsdfs;

import main.shared.TreeNode;

import java.util.*;


public class FindAllTheLonelyNodes {
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        while (!bfsQueue.isEmpty()) {
            int breadth = bfsQueue.size();
            for (int i = 0; i < breadth; i++) {
                TreeNode node = bfsQueue.remove();
                if (node.left != null && node.right != null) {
                    bfsQueue.add(node.left);
                    bfsQueue.add(node.right);
                } else if (node.left != null) {
                    bfsQueue.add(node.left);
                    answer.add(node.left.val);
                } else if (node.right != null) {
                    bfsQueue.add(node.right);
                    answer.add(node.right.val);
                }
            }
        }
        return answer;
    }
}
