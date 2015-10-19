package nju.ics.lixiaofan.algorithm;
/*
Given an array of size n, find the majority element. The majority element is the element that appears more than n/2 times.

You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int k = nums.length/2+1;
        int[] cnt = new int[32];
        int mark;
        for(int n : nums){
        	mark = 1;
        	for(int i = 0;i < 32;i++){
        		if((n&mark) != 0)
        			cnt[i]++;
        		mark <<= 1;
        	}
        }
        
        int result = 0;
        for(int i = 0;i < 32;i++)
        	if(cnt[i] >= k)
        		result |= (1<<i);
        return result;
    }
    /*
    Moore Voting Algorithm
    int majorityElement(int[] nums) {
        int major, counts = 0, n = nums.size();
        for (int i = 0; i < n; i++) {
            if (!counts) {
                major = nums[i];
                counts = 1;
            }
            else counts += (nums[i] == major) ? 1 : -1;
        }
        return major;
    }
    */
}
