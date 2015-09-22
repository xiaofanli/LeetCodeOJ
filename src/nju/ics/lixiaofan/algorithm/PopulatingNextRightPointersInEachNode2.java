package nju.ics.lixiaofan.algorithm;


/*
	Follow up for problem "Populating Next Right Pointers in Each Node".
	
	What if the given tree could be any binary tree? Would your previous solution still work?
	
	Note:
	
	You may only use constant extra space.
	For example,
	Given the following binary tree,
	         1
	       /  \
	      2    3
	     / \    \
	    4   5    7
	After calling your function, the tree should look like:
	         1 -> NULL
	       /  \
	      2 -> 3 -> NULL
	     / \    \
	    4-> 5 -> 7 -> NULL
*/
public class PopulatingNextRightPointersInEachNode2 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void connect(TreeLinkNode root) {
		if(root==null ) return;
	    if(root.left != null && root.right != null) root.left.next = root.right; // left.next = right if right exists
	    if(root.left != null && root.right == null) root.left.next = nextChild(root.next); // call nextChild if right == null
	    if(root.right != null) root.right.next = nextChild(root.next); 
	    connect(root.right); // take care here, the right must be finished before left, otherwise we will miss nodes;
	    connect(root.left);
	}
	public TreeLinkNode nextChild(TreeLinkNode node) {
	    while(node != null) {
	        if(node.left != null) return node.left;
	        if(node.right != null) return node.right;
	        node = node.next;
	    }
	    return null;
	}
	private static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}
}
