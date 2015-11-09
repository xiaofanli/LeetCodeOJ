package nju.ics.lixiaofan.algorithm;

import java.util.Arrays;

/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for(int i = 0;i < nums.length;i++){
            int start = i+1, end = nums.length-1;
            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if(sum == target)
                    return target;
                else if(sum < target){
                    if(res == Integer.MAX_VALUE || Math.abs(sum-target) < Math.abs(res-target))
                        res = sum;
                    start++;
                    while(start < end && nums[start] == nums[start-1])
                        start++;
                }
                else{
                    if(res == Integer.MAX_VALUE || Math.abs(sum-target) < Math.abs(res-target))
                        res = sum;
                    end--;
                    while(start < end && nums[end] == nums[end+1])
                        end--;
                }
            }
            while(i+1 < nums.length && nums[i+1] == nums[i])
                i++;
        }
        
        return res;
    }
}
