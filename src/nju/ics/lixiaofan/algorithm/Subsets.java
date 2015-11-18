package nju.ics.lixiaofan.algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * Given a set of distinct integers, nums, return all possible subsets.
 * 
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * 
 * For example,
 * If nums = [1,2,3], a solution is:
 * 
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>(), copy = new LinkedList<List<Integer>>();
        res.add(new LinkedList<Integer>());
        Arrays.sort(nums);
        for(int n : nums){
            for(List<Integer> list : res){
                List<Integer> newList = new LinkedList<Integer>(list);
                newList.add(n);
                copy.add(newList);
            }
            res.addAll(copy);
            copy.clear();            
        }
        
        return res;
    }
}
