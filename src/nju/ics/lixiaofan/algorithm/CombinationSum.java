package nju.ics.lixiaofan.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
 */
public class CombinationSum {
	public static void main(String[] args) {
		CombinationSum a = new CombinationSum();
		int[] candidates = {1, 2, 3};
		List<List<Integer>> res = a.combinationSum(candidates, 7);
		for(List<Integer> list : res){
			for(int i : list)
				System.out.print(i+" ");
			System.out.println();
		}
	}
	
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	Arrays.sort(candidates);
        return combinationSum(candidates, target, 0);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target, int start) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <target) {
                for (List<Integer> ar : combinationSum(candidates, target - candidates[i], i)) {
                    ar.add(0, candidates[i]);
                    res.add(ar);
                }
            } else if (candidates[i] == target) {
                List<Integer> lst = new ArrayList<>();
                lst.add(candidates[i]);
                res.add(lst);
            } else
                break;
        }
        return res;
    }
}
