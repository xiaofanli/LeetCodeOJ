package nju.ics.lixiaofan.algorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Examples:
"()())()" -> ["()()()", "(())()"]
"(a)())()" -> ["(a)()()", "(a())()"]
")(" -> [""]
 */
public class RemoveInvalidParentheses {
	//BFS
	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new LinkedList<String>();
		if (s == null)
			return res;

		Queue<String> q = new LinkedList<String>();
		Set<String> visited = new HashSet<String>();
		q.add(s);
		visited.add(s);
		boolean found = false;
		while (!q.isEmpty()) {
			String str = q.poll();
			if (isValid(str)) {
				found = true;
				res.add(str);
			} 
			else if (!found) {
				for (int i = 0; i < str.length(); i++)
					if (str.charAt(i) == '(' || str.charAt(i) == ')'){
						String substr = str.substring(0, i) + str.substring(i + 1);
						if(!visited.contains(substr)){
							q.add(substr);
							visited.add(substr);
						}
					}
			}
		}
		return res;
	}

	private boolean isValid(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				count++;
			else if (s.charAt(i) == ')') {
				count--;
				if (count < 0)
					return false;
			}
		}
		return count == 0;
	}
}
