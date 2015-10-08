package nju.ics.lixiaofan.algorithm;
/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class UniqueBinarySearchTrees {
	//DP
    public int numTrees(int n) {
        int[] nums = new int[n+1];
        nums[1] = 1;
        for(int i = 2;i <= n;i++){
        	nums[i] = nums[i-1];
        	double ub = (i-1)/2.0;
        	for(int j = 1;j < ub;j++)
        		nums[i] += nums[j] * nums[i-1-j];
        	nums[i] += nums[i];
        	if(i % 2 == 1)
        		nums[i] += nums[(int) ub] * nums[(int) ub];
        }
        
        return nums[n];
    }
}
