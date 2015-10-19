package nju.ics.lixiaofan.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import nju.ics.lixiaofan.structure.TreeNode;

/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> result = new LinkedList<List<Integer>>();
    	if(root == null)
    		return result;
    	List<Integer> list = new LinkedList<Integer>();
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	queue.add(null);
    	while(!queue.isEmpty()){
    		TreeNode n = queue.poll();
    		if(n != null){
    			list.add(n.val);
    			if(n.left != null)
    				queue.add(n.left);
    			if(n.right != null)
    				queue.add(n.right);
    			if(queue.peek() == null){
    				queue.add(null);
    				queue.poll();
    				result.add(0, list);
    				list = new LinkedList<Integer>();
    			}
    		}
    	}
    	return result;
    }
}
