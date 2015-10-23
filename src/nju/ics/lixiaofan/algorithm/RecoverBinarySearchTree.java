package nju.ics.lixiaofan.algorithm;

import nju.ics.lixiaofan.structure.TreeNode;

/*
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 */
public class RecoverBinarySearchTree {
    // Morris Traversal
    public void recoverTree(TreeNode root) {
        TreeNode pre = null;
        TreeNode first = null, second = null;
        TreeNode temp = null;
        while(root != null){
            if(root.left != null){
                // connect threading for root
                temp = root.left;
                while(temp.right != null && temp.right != root)
                    temp = temp.right;
                // the threading already exists
                if(temp.right != null){
                    if(pre != null && pre.val > root.val){
                        if(first == null)
                            first = pre;
                        second = root;
                    }
                    temp.right = null;
                    pre = root;
                    root = root.right;
                }
                else{
                    // construct the threading
                    temp.right = root;
                    root = root.left;
                }
            }
            else{
                if(pre != null && pre.val > root.val){
                    if(first == null)
                        first = pre;
                    second = root;
                }
                pre = root;
                root = root.right;
            }
        }
        // swap two node values;
        if(first != null && second != null){
            int t = first.val;
            first.val = second.val;
            second.val = t;
        }
    }
}
