package nju.ics.lixiaofan.algorithm;

import java.util.LinkedList;
import java.util.Queue;

import nju.ics.lixiaofan.structure.TreeNode;

/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null)
        	return 0;
        int depth = 1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
        	TreeNode node = queue.poll();
        	if(node == null){
        		depth++;
        		queue.add(null);
        		continue;
        	}
        	if(node.left == null && node.right == null)
        		return depth;
        	if(node.left != null)
        		queue.add(node.left);
        	if(node.right != null)
        		queue.add(node.right);
        }
		return -1;
    }
}
