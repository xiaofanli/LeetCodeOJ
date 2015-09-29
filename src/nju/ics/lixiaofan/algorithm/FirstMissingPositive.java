package nju.ics.lixiaofan.algorithm;
/*
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
    	if(nums.length == 0)
        	return 1;
    	
    	for(int i = 0;i < nums.length;i++)
    		if(nums[i] < 1 || nums[i] > nums.length)
    			nums[i] = nums.length+1;
    	
    	for(int i = 0;i < nums.length;i++){
    		int x = Math.abs(nums[i]);
    		if(x == nums.length+1)
    			continue;
    		if(nums[x-1] > 0)
    			nums[x-1] = -nums[x-1];
    	}
    	
    	for(int i = 0;i < nums.length;i++)
    		if(nums[i] > 0)
    			return i+1;
    	
    	return nums.length+1;
    }
}
