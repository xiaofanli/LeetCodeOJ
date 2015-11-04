package nju.ics.lixiaofan.algorithm;

/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
public class JumpGameII {
    public int jump(int[] nums) {
        if(nums.length == 1)
            return 0;
        else if(nums[0] == 0)
            return Integer.MAX_VALUE;
        
        int l = 1, r = nums[0], step = 1, max = 0;
        while(true){
	        for(int i = l;i <= r;i++){
	        	if(max < i+nums[i]){
		        	max = i+nums[i];
		        	if(max >= nums.length-1)
		        		return step;
	        	}
	        }
	        if(max == r)
	        	return Integer.MAX_VALUE;
	        l = r + 1;
	        r = max;
	        step++;
        }
    }
}
