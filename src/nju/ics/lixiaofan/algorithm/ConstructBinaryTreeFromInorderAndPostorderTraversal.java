package nju.ics.lixiaofan.algorithm;

import nju.ics.lixiaofan.structure.TreeNode;

/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || inorder.length != postorder.length)
            return null;
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    private TreeNode buildTree(int[] inorder, int l1, int r1, int[] postorder, int l2, int r2) {
        TreeNode root = new TreeNode(postorder[r2]);
        if(l1 == r1)
            return root;
        int i;
        for(i = l1;i <= r1;i++)
            if(inorder[i] == postorder[r2])
                break;
        
        if(i > l1)
            root.left = buildTree(inorder, l1, i-1, postorder, l2, l2+i-1-l1);
        if(i < r1)
            root.right = buildTree(inorder, i+1, r1, postorder, l2+i-l1, r2-1);
        return root;
    }
}
