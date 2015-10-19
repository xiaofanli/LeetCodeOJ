package nju.ics.lixiaofan.algorithm;

import java.util.HashMap;

/*
Given an array of integers, find out whether there are two distinct indices i and j in the array such that
the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
 */
public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    	if(t > k){
	    	for(int i = 0;i < nums.length - 1;i++){
	    		int jLimit = nums.length-1-k < i ? nums.length-1 : i+k;
	    		for(int j = i+1;j <= jLimit;j++){
	    			if(Math.abs((long)nums[i]-nums[j]) <= t)
	    				return true;
	    		}
	    	}
    	}
    	else{
	    	HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
	    	for(int i = 0;i < nums.length;i++)
	    		for(int v = nums[i];v <= nums[i]+t;v++){
	    			System.out.println(i+"\t"+v);
	    			if(hash.containsKey(v)){
	    				if(Math.abs(i-hash.get(v)) <= k)
	    					return true;
	    				else
	    					hash.put(v, i);
	    			}
	    			else
	    				hash.put(v, i);
	    		}
    	}
		return false;
    }
}
