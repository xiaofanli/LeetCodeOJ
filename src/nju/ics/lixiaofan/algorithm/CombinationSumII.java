package nju.ics.lixiaofan.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(candidates);
        combinationSum2(candidates, 0, target, path, res);
        return res;
    }
    
    private void combinationSum2(int[] candidates, int start, int target, List<Integer> path, List<List<Integer>> res) {
        if(start >= candidates.length || candidates[start] > target)
            return;
        
        for(int i = start;i < candidates.length;i++){
            if(i > start && candidates[i] == candidates[i-1])
                continue;
            if(candidates[i] > target)
                break;
            if(candidates[i] < target){
                path.add(candidates[i]);
                combinationSum2(candidates, i+1, target-candidates[i], path, res);
                path.remove(path.size()-1);
            }
            else{
                path.add(candidates[i]);
                res.add(new ArrayList<Integer>(path));
                path.remove(path.size()-1);
            }
        }
    }
}
