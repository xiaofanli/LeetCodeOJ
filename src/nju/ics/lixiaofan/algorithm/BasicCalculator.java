package nju.ics.lixiaofan.algorithm;

import java.util.Stack;

/*
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
 */
public class BasicCalculator {
    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        Stack<String> stack = new Stack<String>();
        int i = 0, ans = 0, old, j;
        String op = "+";
        while(i < s.length()){
            switch(s.charAt(i)){
            case '(':
                stack.push(op);
                stack.push(String.valueOf(ans));
                ans = 0;
                op = "+";
                i++;
                break;
            case ')':
                old = Integer.parseInt(stack.pop());
                op = stack.pop();
                if(op.equals("+"))
                    ans += old;
                else if(op.equals("-"))
                    ans = old - ans;
                i++;
                break;
            case '+':
                op = "+";
                i++;
                break;
            case '-':
                op = "-";
                i++;
                break;
            default:
                j = i+1;
                while(j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9')
                    j++;
                if(op.equals("+"))
                    ans += Integer.parseInt(s.substring(i,j));
                else if(op.equals("-"))
                    ans -= Integer.parseInt(s.substring(i,j));
                i = j;
                break;
            }
        }
        return ans;
    }
}
