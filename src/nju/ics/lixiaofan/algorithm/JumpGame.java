package nju.ics.lixiaofan.algorithm;

/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
    	if(nums.length == 1)
    		return true;
    	int cur = 0, max = -1;
    	while(cur >= 0){
    		if(nums[cur] > 0 && cur+nums[cur] > max){
    			max = cur+nums[cur];
    			if(max >= nums.length-1)
    				return true;
    			else
    				cur = max;
    		}
    		else
    			cur--;
    	}
    	return false;
    }
}
