package nju.ics.lixiaofan.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import nju.ics.lixiaofan.structure.TreeNode;

/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
 */
public class BinaryTreeRightSideView {
	//BFS
    public List<Integer> rightSideView(TreeNode root) {
    	List<Integer> view = new LinkedList<Integer>();
    	if(root == null)
    		return view;
    	boolean rightmost = true;
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	queue.add(null);
    	while(!queue.isEmpty()){
    		TreeNode n = queue.poll();
    		if(n == null){
    			rightmost = true;
    			continue;
    		}
    		if(rightmost){
    			view.add(n.val);
    			rightmost = false;
    		}
    		
    		if(n.right != null)
    			queue.add(n.right);
    		if(n.left != null)
    			queue.add(n.left);
    		
    		if(queue.peek() == null)
    			queue.add(null);
    	}
    	return view;
    }
}
