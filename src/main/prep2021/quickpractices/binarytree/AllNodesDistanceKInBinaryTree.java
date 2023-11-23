package main.prep2021.quickpractices.binarytree;

import main.shared.TreeNode;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {
    Map<TreeNode,TreeNode> map;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        map=new HashMap<>();
        dfs(root,null);
        Queue<TreeNode> q=new LinkedList<>();
        q.add(target);
        Set<TreeNode> vis=new HashSet<>();
        int dist=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                TreeNode cur=q.poll();
                if(vis.contains(cur)) continue;
                vis.add(cur);
                if(dist==k){
                    res.add(cur.val);
                }else{
                    if( cur.left!=null && !vis.contains(cur.left)){
                        q.add(cur.left);
                    }
                    if(cur.right!=null && !vis.contains(cur.right)){
                        q.add(cur.right);
                    }
                    TreeNode par=map.get(cur);
                    if( par!=null && !vis.contains(par)){
                        q.add(par);
                    }
                }
            }
            dist++;
        }
        return res;
    }
    void dfs(TreeNode root,TreeNode par){
        if(root==null) return;
        map.put(root,par);
        dfs(root.left,root);
        dfs(root.right,root);
    }

    public static void main(String[] args) {
//        TreeNode node8 = new TreeNode(8);
//        TreeNode node0 = new TreeNode(0);
//        TreeNode node1 = new TreeNode(1, node0, node8);
//
//        TreeNode node7 = new TreeNode(7);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node2 = new TreeNode(2, node7, node4);
//
//        TreeNode node6 = new TreeNode(6);
//        TreeNode node5 = new TreeNode(5, node6, node2);

        TreeNode node3 = new TreeNode(3);

        var solution = new AllNodesDistanceKInBinaryTree();
        System.out.println(solution.distanceK(node3, node3, 3));
    }
}
