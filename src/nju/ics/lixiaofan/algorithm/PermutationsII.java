package nju.ics.lixiaofan.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
 */
public class PermutationsII {
	public static List<List<Integer>> permuteUnique(int[] nums) {
//	    Arrays.sort(nums);
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    permute(nums,0,nums.length,res);
	    return res;
	}
	
	private static void permute(int[] nums, int i, int j, List<List<Integer>> res){
	    if(i == j-1){
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        for(int x:nums) list.add(x);
	        res.add(list);
	        return;
	    }
	    HashSet<Integer> visited= new HashSet<Integer>();
	    for(int k=i;k<j;k++){
	        if(!visited.contains(nums[k])){
	            swap(nums,i,k);
	            permute(nums,i+1,j,res);
	            swap(nums,i,k);
	            visited.add(nums[k]);
	        }

	    }
	}
	
	private static void swap(int[] nums, int i,int j){
	    int tmp = nums[j];
	    nums[j] = nums[i];
	    nums[i] = tmp;
	}
    
}
