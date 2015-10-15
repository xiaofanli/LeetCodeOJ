package nju.ics.lixiaofan.algorithm;

import nju.ics.lixiaofan.structure.TreeNode;
/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        dfs(root);
    }
    
    private TreeNode dfs(TreeNode root){
        if(root == null)
            return null;
        TreeNode tail1 = dfs(root.left);
        TreeNode tail2 = dfs(root.right);
        if(tail1 != null){
            tail1.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if(tail2 != null)
            return tail2;
        else if(tail1 != null)
            return tail1;
        else
            return root; 
    }
}
