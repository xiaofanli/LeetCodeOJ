package nju.ics.lixiaofan.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import nju.ics.lixiaofan.structure.TreeNode;

/*Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?*/
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<Integer>();
        if(root == null)
            return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(0, node.val);
            if(node.left != null)
                stack.push(node.left);
            if(node.right != null)
                stack.push(node.right);
        }
        return res;
    }
}
