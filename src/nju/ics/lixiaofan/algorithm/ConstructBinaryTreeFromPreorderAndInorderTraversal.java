package nju.ics.lixiaofan.algorithm;

import nju.ics.lixiaofan.structure.TreeNode;

//Given preorder and inorder traversal of a tree, construct the binary tree.
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
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
}
