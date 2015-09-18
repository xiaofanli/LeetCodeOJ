package nju.ics.lixiaofan.algorithm;

import java.util.Stack;

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
	public static void main(String[] args) {
	}
    public boolean isValid(String s) {
        if(s == null || s.length() == 0)
        	return true;
        else if(s.length() % 2 == 1)
        	return false;
        
        Stack<Character> stack = new Stack<Character>();
        for(int i= 0;i < s.length();i++){
        	char c = s.charAt(i);
        	switch(c){
        	case '(':case '[':case '{':
        		stack.push(c);
        		break;
        	case ')':
        		if(stack.isEmpty() || stack.pop() != '(')
        			return false;
        		break;
        	case ']':
        		if(stack.isEmpty() || stack.pop() != '[')
        			return false;
        		break;
        	case '}':
        		if(stack.isEmpty() || stack.pop() != '{')
        			return false;
        		break;
        	}
        }
        return stack.isEmpty();
    }
}
