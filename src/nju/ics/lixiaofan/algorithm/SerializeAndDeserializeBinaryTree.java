package nju.ics.lixiaofan.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import nju.ics.lixiaofan.structure.TreeNode;

/*Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.*/
public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return null;
        ArrayList<Integer> data = new ArrayList<Integer>();
        data.add(root.val);
        int nullCnt = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left != null){
                queue.add(node.left);
                for(int i = 0;i < nullCnt;i++)
                    data.add(null);
                data.add(node.left.val);
                nullCnt = 0;
            }
            else
                nullCnt++;
            if(node.right != null){
                queue.add(node.right);
                for(int i = 0;i < nullCnt;i++)
                    data.add(null);
                data.add(node.right.val);
                nullCnt = 0;
            }
            else
                nullCnt++;
        }
        return data.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null)
            return null;
        String[] strs = data.substring(1,data.length()-1).split(", ");
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int i = 1;
        while(i < strs.length){
            TreeNode node = queue.poll();
            if(!strs[i].equals("null")){
                node.left = new TreeNode(Integer.parseInt(strs[i]));
                queue.add(node.left);
            }
            if(++i >= strs.length)
                break;
            if(!strs[i].equals("null")){
                node.right = new TreeNode(Integer.parseInt(strs[i]));
                queue.add(node.right);
            }
            ++i;
        }
        
        return root;
    }
}
