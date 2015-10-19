package nju.ics.lixiaofan.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
 */
public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
		if(s == null)
			return null;
		
		List<List<String>> list = new LinkedList<List<String>>();
		if(s.length() < 2){
			list.add(new LinkedList<String>());
			list.get(0).add(s);
			return list;
		}
		char[] chs = s.toCharArray();

		Stack<Integer> stack = new Stack<Integer>();
		int start = 0, end = s.length(), rear;
		rear = getPalRear(start, end, chs);
		stack.push(rear);
		while(true){
			start = stack.peek();
			if(start == s.length()){
				List<String> strList = new LinkedList<String>();
				int begin = 0;
				for(int idx : stack){
					strList.add(s.substring(begin, idx));
					begin = idx;
				}
				list.add(strList);
				do {
					stack.pop();
					end--;
					if(stack.isEmpty()){
						if(end > 0){
							start = 0;
							break;
						}
						else
							return list;
					}
				} while (end == stack.peek());
				if(start != 0)
					start = stack.peek();
			}

			rear = getPalRear(start, end, chs);
			stack.push(rear);
			end = s.length();
		}
    }
	
	public int getPalRear(int start, int end, char[] s){
		if(end > s.length)
			return -1;
		int rear = end, i = rear - 1, j = start;
		while(i >= j){
			if(s[i] == s[j]){
				j++;
				i--;
			}
			else{
				rear--;
				i = rear - 1;
				j = start;
			}
		}
		
		return rear;
	}
}
