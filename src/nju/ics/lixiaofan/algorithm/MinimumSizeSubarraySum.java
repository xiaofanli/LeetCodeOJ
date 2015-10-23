package nju.ics.lixiaofan.algorithm;
/*
Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ¡Ý s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        int l = 0, r = 0, sum = 0;
        while(l < nums.length){
            if(sum >= s){
                min = Math.min(min, r-l);
                if(min == 1)
                    return min;
                sum -= nums[l++];
            }
            else{
                if(r-l >= min-1)
                    sum -= nums[l++];
                else if(r < nums.length)
                    sum += nums[r++];
                else
                    break;
            }
        }
        return min != Integer.MAX_VALUE ? min : 0;
    }
}
