package nju.ics.lixiaofan.algorithm;

import java.util.LinkedList;
import java.util.List;

/*
	Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
	Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
	
	Initially, all next pointers are set to NULL.
	
	Note:
	
	You may only use constant extra space.
	You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
	For example,
	Given the following perfect binary tree,
	         1
	       /  \
	      2    3
	     / \  / \
	    4  5  6  7
	After calling your function, the tree should look like:
	         1 -> NULL
	       /  \
	      2 -> 3 -> NULL
	     / \  / \
	    4->5->6->7 -> NULL
	
*/
public class PopulatingNextRightPointersInEachNode {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}


	
    public void connect(TreeLinkNode root) {
    	if(root == null)
    		return;
        int depth = 0, num = 0;
        List<TreeLinkNode> list = new LinkedList<TreeLinkNode>();
        list.add(root);
        
        while(!list.isEmpty()){
        	TreeLinkNode node = list.remove(0);
        	if(node.left != null)
        		list.add(node.left);
        	if(node.right != null)
        		list.add(node.right);
        	
        	if(num > 0){
        		node.next = list.get(0);
        		num--;
        	}
        	else{
        		depth++;
        		num = (int) (Math.pow(2, depth) - 1);
        	}
        }
    }

    private static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}
}
