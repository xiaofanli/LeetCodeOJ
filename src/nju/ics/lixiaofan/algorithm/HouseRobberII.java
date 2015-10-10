package nju.ics.lixiaofan.algorithm;
/*
Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobberII {
    public int rob(int[] nums) {
    	int p = 0;
    	if(nums.length < 4){
    		for(int n : nums)
    			p = Math.max(p, n);
    		return p;
    	}
    	
    	return Math.max(nums[0]+rob(nums, 2, nums.length-2), rob(nums, 1, nums.length-1));
    }
    
    public int rob(int[] nums, int l, int r) {
        int p = 0, q = 0;
        for (int i = l;i <= r;i++) {
            int tmp = p;
            p = Math.max(p, q + nums[i]);
            q = tmp; 
        }
        return p;
    }
}
