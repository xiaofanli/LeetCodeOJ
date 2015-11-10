package nju.ics.lixiaofan.algorithm;

import java.util.LinkedList;
import java.util.List;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        return generateParenthesis(n, n);
    }
    
    private List<String> generateParenthesis(int l, int r) {
        List<String> res = new LinkedList<String>(), tmp;
        if(l < r){
            if(l > 0){
                tmp = generateParenthesis(l-1, r);
                for(String s : tmp)
                    res.add("("+s);
            }
            if(r > 1){
                tmp = generateParenthesis(l, r-1);
                for(String s : tmp)
                    res.add(")"+s);
            }
            else
                res.add(")");
        }
        else if(l == r){
            tmp = generateParenthesis(l-1, r);
            for(String s : tmp)
                res.add("("+s);
        }
        return res;
    }
}
