package nju.ics.lixiaofan.algorithm;

import java.util.LinkedList;
import java.util.Queue;

//Given preorder and inorder traversal of a tree, construct the binary tree.
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public static void main(String[] args) {
		ConstructBinaryTreeFromPreorderAndInorderTraversal cbt  = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
		int[] preorder = {1,3,5,2,4};
		int[] inorder = {5,3,1,4,2};
		TreeNode tn = cbt.buildTree(preorder, inorder);
		
		Queue<TreeNode> q = new LinkedList<ConstructBinaryTreeFromPreorderAndInorderTraversal.TreeNode>();
		q.add(tn);
		System.out.println("root: "+tn.val);
		while(!q.isEmpty()){
			TreeNode n = q.poll();
			if(n.left != null){
				q.add(n.left);
				System.out.println(n.val+" left: "+n.left.val);
			}
			if(n.right != null){
				q.add(n.right);
				System.out.println(n.val+" right: "+n.right.val);
			}
		}
	}
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	if(preorder.length != inorder.length)
    		return null;
    	if(preorder.length < 1)
    		return null;
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode build(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2){
    	TreeNode root = new TreeNode(preorder[l1]);
    	if(l1 == r1)
    		return root;
    	int idx;
    	for(idx = l2;idx <= r2;idx++)
    		if(inorder[idx] == root.val)
    			break;
    	int leftSize = idx - l2, rightSize = r2 - idx;
    	if(leftSize > 0)
    		root.left = build(preorder, l1+1, l1+leftSize, inorder, l2, idx-1);
    	if(rightSize > 0)
    		root.right = build(preorder, l1+leftSize+1, l1+leftSize+rightSize, inorder, idx+1, r2);
    	return root;
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
