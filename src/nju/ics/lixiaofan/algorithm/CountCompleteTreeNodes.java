package nju.ics.lixiaofan.algorithm;

import nju.ics.lixiaofan.structure.TreeNode;

/*
Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 */
public class CountCompleteTreeNodes {
	//binary search
    public int countNodes(TreeNode root) {
        if(root == null)
        	return 0;
        
        int depth = 0;
        TreeNode tmp = root;
        while(tmp != null){
        	depth++;
        	tmp = tmp.left;
        }
        
        TreeNode p = root, q = p.left;
        int d = 1, cnt = 0;
        while(q != null){
        	for(int i = 0;i < depth-d-1;i++)
        		q = q.right;
        	
        	if(q == null)
        		p = p.left;
        	else{
        		cnt += 1<<(depth-d-1);
        		if(p.right == null)
        			break;
        		p = p.right;
        		
        	}
        	d++;
        	q = p.left;
        }
        if(d == depth && p != null)
        	cnt++;
        
        return (1<<(depth-1))-1+cnt;
    }
}
