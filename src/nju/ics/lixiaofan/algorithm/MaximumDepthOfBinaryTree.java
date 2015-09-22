package nju.ics.lixiaofan.algorithm;

/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree {
	public static void main(String[] args) {

	}
	
	int depth = 1;
    public int maxDepth(TreeNode root) {
        if(root == null)
        	return 0;
        traverse(root, 1);
        return depth;
    }
    
    private void traverse(TreeNode root, int d){
    	if(depth < d)
    		depth = d;
    	if(root.left != null)
    		traverse(root.left, d+1);
    	if(root.right != null)
    		traverse(root.right, d+1);
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
