package nju.ics.lixiaofan.algorithm;

import java.util.LinkedList;
import java.util.List;

import nju.ics.lixiaofan.structure.TreeNode;

/*
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
    	List<String> paths = new LinkedList<String>();
    	if(root == null)
    		return paths;
    	dfs(root, ""+root.val, paths);
    	return paths;
    }
    
    private void dfs(TreeNode root, String path, List<String> paths){
    	//it's a leaf
    	if(root.left == null && root.right == null){
    		paths.add(path);
    		return;
    	}
    	if(root.left != null)
    		dfs(root.left, path+"->"+root.left.val, paths);
    	if(root.right != null)
    		dfs(root.right, path+"->"+root.right.val, paths);
    }
}
