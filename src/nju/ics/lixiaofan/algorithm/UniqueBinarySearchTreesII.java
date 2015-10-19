package nju.ics.lixiaofan.algorithm;

import java.util.ArrayList;
import java.util.List;

import nju.ics.lixiaofan.structure.TreeNode;

/*
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.


OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

Here's an example:
   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
 */
public class UniqueBinarySearchTreesII {
	public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int m, int n){
        if(m > n) {
            List<TreeNode> result = new ArrayList<TreeNode>();
            result.add(null);
            return result;
        }
        List<TreeNode> roots = new ArrayList<TreeNode>();
        for(int i = m; i <= n; i++){
            List<TreeNode> left = generateTrees(m, i-1);
            List<TreeNode> right = generateTrees(i+1, n);
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    roots.add(root);
                }
            }

        }   
        return roots;
    }
}
