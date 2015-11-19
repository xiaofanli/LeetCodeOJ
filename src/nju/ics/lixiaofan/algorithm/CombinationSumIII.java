package nju.ics.lixiaofan.algorithm;

import java.util.ArrayList;
import java.util.List;

/*Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]*/
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        combinationSum3(k, n, 1, path, res);
        return res;
    }
    
    private void combinationSum3(int k, int n, int start, List<Integer> path, List<List<Integer>> res) {
        if(start > Math.min(9, n))
            return;
        if(k == 1){
            if(n < 10){
                path.add(n);
                res.add(new ArrayList<Integer>(path));
                path.remove(path.size()-1);
            }
            else
                return;
        }
        else{
            int ub = Math.min(9, n/k);
            for(int i = start;i <= ub;i++){
                path.add(i);
                combinationSum3(k-1, n-i, i+1, path, res);
                path.remove(path.size()-1);
            }
        }
    }
}
