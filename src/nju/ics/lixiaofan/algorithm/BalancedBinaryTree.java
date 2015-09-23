package nju.ics.lixiaofan.algorithm;

import java.util.LinkedList;
import java.util.Queue;

import nju.ics.lixiaofan.structure.TreeNode;

/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree 
in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class BalancedBinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.left.left.left = new TreeNode(7);
		
		BalancedBinaryTree bbt = new BalancedBinaryTree();
		System.out.println(bbt.isBalanced(root));
	}
	
	boolean balanced = true;

	public boolean isBalanced(TreeNode root) {
		// getDepth(root);
		// return balanced;
		if (root == null) {
			return true;
		}
		Queue<TreeNode> Que = new LinkedList<TreeNode>();
		Que.add(root);
		boolean flag = false, flag2 = false;

		while (!Que.isEmpty()) {
			int Size = Que.size();
			if (flag)
				flag2 = true;
			while (Size != 0) {
				Size--;
				TreeNode cur = Que.poll();
				if (cur.left != null) {
					if (flag2)
						return false;
					Que.add(cur.left);
				} else {
					flag = true;
				}
				if (cur.right != null) {
					if (flag2)
						return false;
					Que.add(cur.right);
				} else {
					flag = true;
				}
			}

		}

		return true;
	}
}
