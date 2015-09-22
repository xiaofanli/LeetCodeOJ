package nju.ics.lixiaofan.algorithm;
/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedArrayToBinarySearchTree {
	public static void main(String[] args) {

	}
    public TreeNode sortedArrayToBST(int[] nums) {
    	if(nums.length == 0)
    		return null;
        return buildBST(nums, 0, nums.length-1);
    }
    
    public TreeNode buildBST(int[] nums, int l, int r){
    	int mid = (l+r)/2;
    	TreeNode root = new TreeNode(nums[mid]);
    	if(l < mid)
    		root.left = buildBST(nums, l, mid-1);
    	if(r > mid)
    		root.right = buildBST(nums, mid+1, r);
    	return root;
    }
    
    private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
