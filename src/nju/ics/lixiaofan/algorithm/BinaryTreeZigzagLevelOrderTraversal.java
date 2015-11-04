package nju.ics.lixiaofan.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import nju.ics.lixiaofan.structure.TreeNode;

/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        boolean positive = true;
        List<Integer> list = new LinkedList<Integer>();
        while(!q.isEmpty()){
            TreeNode n = q.poll();
            if(n == null){
                positive = !positive;
                res.add(list);
                if(!q.isEmpty()){
                   q.add(null);
                   list = new LinkedList<Integer>();
                }
            }
            else{
                if(positive)
                    list.add(n.val);
                else
                    list.add(0, n.val);
                    
                if(n.left != null)
                    q.add(n.left);
	            if(n.right != null)
	                q.add(n.right);
            }
        }
        return res;
    }
}
