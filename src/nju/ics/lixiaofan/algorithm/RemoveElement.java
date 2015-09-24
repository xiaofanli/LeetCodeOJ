package nju.ics.lixiaofan.algorithm;
/*
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
       int cnt = 0;
       for(int i = 0;i < nums.length;i++){
    	   if(nums[i] == val){
    		   cnt++;
    		   nums[i] = val+1;
    	   }
    	   else if(cnt > 0)
    		   nums[i-cnt] = nums[i];
       }
       return nums.length - cnt;
    }
}
