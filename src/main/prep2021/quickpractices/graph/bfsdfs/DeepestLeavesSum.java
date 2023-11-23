package main.prep2021.quickpractices.graph.bfsdfs;

import main.shared.TreeNode;
import java.util.*;

public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        int latestLevelSum = 0;
        Deque<TreeNode> bfs = new ArrayDeque<>();
        bfs.addLast(root);
        while (!bfs.isEmpty()) {
            latestLevelSum = 0;
            int breadth = bfs.size();
            for (int i = 0; i < breadth; i++) {
                TreeNode current = bfs.removeFirst();
                latestLevelSum += current.val;
                if (current.left != null) {
                    bfs.addLast(current.left);
                }
                if (current.right != null) {
                    bfs.addLast(current.right);
                }
            }
        }
        return latestLevelSum;
    }
}
