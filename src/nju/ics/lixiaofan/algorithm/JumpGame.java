package nju.ics.lixiaofan.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
 */
public class JumpGame {
	public static void main(String[] args) {
		JumpGame jp = new JumpGame();
		int[] nums = {2,5,0,0};
		System.out.println(jp.canJump(nums));
	}
	
    public boolean canJump(int[] nums) {
//        boolean[] visited = new boolean[nums.length];
//    	Queue<Integer> queue = new LinkedList<Integer>();
//    	queue.add(0);
//    	int last = nums.length-1;
//    	while(!queue.isEmpty()){
//    		int idx = queue.poll();
//    		visited[idx] = true;
//    		
//    		if(idx+nums[idx] >= last)
//    			return true;
//    		else{
//    			for(int i = idx+nums[idx];i > idx;i--)
//    				if(!visited[i] && nums[i] > 0)
//    	    			queue.add(i);
//    		} 
//    	}
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
