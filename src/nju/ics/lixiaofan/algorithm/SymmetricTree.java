package nju.ics.lixiaofan.algorithm;

import java.util.LinkedList;
import java.util.Queue;

import nju.ics.lixiaofan.structure.TreeNode;
/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmetricTree {
	public boolean isSymmetricIter(TreeNode root) {
		if(root == null)
    		return true;
		else if(root.left == null)
        	return root.right == null;
        else if(root.right == null)
        		return false;
        Queue<TreeNode> lq = new LinkedList<TreeNode>(), rq = new LinkedList<TreeNode>();
        lq.add(root.left);
        rq.add(root.right);
        while(!lq.isEmpty()){
        	TreeNode l = lq.poll();
        	TreeNode r = rq.poll();
        	if(l.val != r.val)
        		return false;
        	if(l.left == null){
       		 if(r.right != null)
       			 return false;
	       	}
	       	else{
	       		if(r.right == null)
	       			return false;
	       		else{
	       			lq.add(l.left);
	       			rq.add(r.right);
	       		}
	       	}
       	
	   		if (l.right == null) {
	   			if (r.left != null)
	   				return false;
	   		} 
	   		else {
	   			if (r.left == null)
	   				return false;
	   			else{
	   				lq.add(l.right);
	       			rq.add(r.left);
	   			}
	   		}
        }
        return true;
	}
	
    public boolean isSymmetricRecur(TreeNode root) {
    	if(root == null)
    		return true;
        if(root.left == null && root.right == null)
        	return true;
        else if(root.left != null && root.right != null)
        	return isSymmetric(root.left, root.right);
        else
        	return false;
    }
    
    private boolean isSymmetric(TreeNode left, TreeNode right){
    	if(left.val != right.val)
    		return false;
    	boolean s1 = false, s2 = false;
    	if(left.left == null){
    		 if(right.right != null)
    			 return false;
    		 else
    			 s1 = true;
    	}
    	else{
    		if(right.right == null)
    			return false;
    		else
    			s1 = isSymmetric(left.left, right.right);
    	}
    	
		if (left.right == null) {
			if (right.left != null)
				return false;
			else
				s2 = true;
		} 
		else {
			if (right.left == null)
				return false;
			else
				s2 = isSymmetric(left.right, right.left);
		}
    	
    	return s1 && s2;
    }
}
