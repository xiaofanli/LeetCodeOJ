package nju.ics.lixiaofan.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ¡Ü b ¡Ü c ¡Ü d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }
    
    private List<List<Integer>> kSum(int[] nums, int target, int start, int k){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length - start < k)
        	return res;
        int min = 0, max = 0;
        for(int i = start, j = nums.length-1;i < start+k;i++, j--){
            min += nums[i];
            max += nums[j];
        }
        if(min > target || max < target)
            return res;
        for(int i = start;i < nums.length;i++){
            if(i > start && nums[i] == nums[i-1])
                continue;
            if(nums[i] > 0 && nums[i] > target)
            	break;
            if(k > 1){
                List<List<Integer>> sub = kSum(nums, target-nums[i], i+1, k-1);
                for(List<Integer> list : sub)
                    list.add(0, nums[i]);
                res.addAll(sub);
            }
            else if(nums[i] == target){
                List<Integer> list = new LinkedList<Integer>();
                list.add(nums[i]);
                res.add(list);
                break;
            }
        }
        return res;
    }
}
