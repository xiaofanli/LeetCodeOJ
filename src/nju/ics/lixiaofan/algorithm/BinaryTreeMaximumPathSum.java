package nju.ics.lixiaofan.algorithm;

import nju.ics.lixiaofan.structure.TreeNode;

/*
Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
 */
public class BinaryTreeMaximumPathSum {
	int max = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
        getMaxSum(root);
		return max;
    }
	
	private int getMaxSum(TreeNode root){
		if(root == null)
			return 0;
		int left = getMaxSum(root.left);
		int right = getMaxSum(root.right);
		int sum = root.val;
		if(left > 0)
			sum += left;
		if(right > 0)
			sum += right;
		if(sum > max)
			max = sum;
		
		left = Math.max(left, right);
		if(left > 0)
			return left + root.val;
		else
			return root.val;
	}
}
