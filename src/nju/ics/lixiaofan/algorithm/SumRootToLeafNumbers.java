package nju.ics.lixiaofan.algorithm;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
 */
public class SumRootToLeafNumbers {
	public static void main(String[] args) {

	}
    public int sumNumbers(TreeNode root) {
        if(root == null)
        	return 0;
        int sum = 0, val = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Set<TreeNode> visited = new HashSet<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
        	TreeNode node = stack.peek();
        	if(visited.contains(node)){
        		stack.pop();
        		val /= 10;
        		continue;
        	}
        	visited.add(node);
        	val = val*10+node.val;
        	if(node.left == null && node.right == null){
        		sum += val;
        		continue;
        	}
        	if(node.right != null)
        		stack.push(node.right);
        	if(node.left != null)
        		stack.push(node.left);
        }
        
        return sum;
    }
    
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
