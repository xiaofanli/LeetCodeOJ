package nju.ics.lixiaofan.algorithm;

import nju.ics.lixiaofan.structure.TreeNode;

/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ¡Ü k ¡Ü BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Hint:

Try to utilize the property of a BST.
What if you could modify the BST node's structure?
The optimal runtime complexity is O(height of BST).
 */
public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        TreeNode cur = root, prev;
        while(cur != null){
            if(cur.left != null){
                prev = cur.left;
                while(prev.right != null && prev.right != cur)
                    prev = prev.right;
                if(prev.right == null){
                    prev.right = cur;
                    cur = cur.left;                    
                }
                else{
                    if(--k == 0)
                        return cur.val;
                    prev.right = null;
                    cur = cur.right;
                }
            }
            else{
                if(--k == 0)
                    return cur.val;
                cur = cur.right;
            }
        }
        return Integer.MIN_VALUE;
    }
}
