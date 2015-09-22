package nju.ics.lixiaofan.algorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/*
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {
	public static void main(String[] args) {
		
	}
	public List<Integer> inorderTraversal(TreeNode root) {
		if(root == null)
			return new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        List<Integer> list = new LinkedList<Integer>();
        Set<TreeNode> visited = new HashSet<TreeNode>();
        while(!stack.isEmpty()){
        	TreeNode node = stack.pop();
        	if(visited.contains(node)){
        		list.add(node.val);
        	}
        	else{
        		visited.add(node);
        		if(node.right != null)
        			stack.push(node.right);
        		stack.push(node);
        		if(node.left != null)
        			stack.push(node.left);
        	}
        }
        return list;
    }
	
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
