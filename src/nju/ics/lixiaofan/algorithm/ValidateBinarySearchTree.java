package nju.ics.lixiaofan.algorithm;

import nju.ics.lixiaofan.structure.TreeNode;
/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        return isValid(root) != null;
    }
    
    private int[] isValid(TreeNode root){
        if(root == null)
            return null;
        int[] ret = {root.val, root.val};
        if(root.left == null && root.right == null)
            return ret;
            
        if(root.left != null){
            int[] tmp = isValid(root.left);
            if(tmp == null || tmp[1] >= root.val)
                return null;
            ret[0] = tmp[0];
        }
        if(root.right != null){
            int[] tmp = isValid(root.right);
            if(tmp == null || tmp[0] <= root.val)
                return null;
            ret[1] = tmp[1];
        }
        return ret;
    }
}
