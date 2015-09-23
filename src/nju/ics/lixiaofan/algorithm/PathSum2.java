package nju.ics.lixiaofan.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import nju.ics.lixiaofan.structure.TreeNode;

/*
	Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
	
	For example:
	Given the below binary tree and sum = 22,
	              5
	             / \
	            4   8
	           /   / \
	          11  13  4
	         /  \    / \
	        7    2  5   1
	return
	[
	   [5,4,11,2],
	   [5,8,4,5]
	]
*/

public class PathSum2 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> paths = new LinkedList<List<Integer>>();
		if(root == null)
			return paths;
		List<Integer> path = new LinkedList<Integer>();
		Stack<Node> stack = new Stack<Node>();
		stack.push(new Node(root));
		int mysum = 0;
		while(!stack.isEmpty()){
			Node n = stack.peek();
			if(n.visited){
				stack.pop();
				path.remove(path.size()-1);
				mysum -= n.node.val;
				continue;
			}
			n.visited = true;
			boolean isLeaf = true;
			path.add(n.node.val);
			mysum += n.node.val;
			if(n.node.right != null){
				isLeaf = false;
				stack.push(new Node(n.node.right));
			}
			if(n.node.left != null){
				isLeaf = false;
				stack.push(new Node(n.node.left));
			}
			if(isLeaf && mysum == sum){
				

				List<Integer> newPath = new LinkedList<Integer>();
				newPath.addAll(path);
//				System.out.println(newPath.get(0));
				paths.add(newPath);
			}
		}
		
		return paths;
    }
	
	class Node {
		TreeNode node;
		boolean visited = false;
		public Node(TreeNode tr) {
			node = tr;
		}
	}
}
