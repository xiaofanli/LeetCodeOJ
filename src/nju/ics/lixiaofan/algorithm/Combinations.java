package nju.ics.lixiaofan.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> result = new LinkedList<List<Integer>>();
    	if(k < 1 || k > n)
    		return result;
    	
    	Stack<Integer> stack = new Stack<Integer>();
    	int next = 1;
    	while(true){
    		if(stack.size()+n-next+1 < k){
    			if(stack.isEmpty())
    				return result;
    			else
    				next = stack.pop() + 1;
    		}
    		else if(stack.size() == k){
    			List<Integer> list = new ArrayList<Integer>();
    			result.add(list);
    			list.addAll(stack);
    			next = stack.pop() + 1;
    		}
    		else
    			stack.push(next++);
    	}
    }
}
