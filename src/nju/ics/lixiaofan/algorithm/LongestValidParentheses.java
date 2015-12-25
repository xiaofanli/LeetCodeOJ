package nju.ics.lixiaofan.algorithm;
/*Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.*/
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        char[] ch = s.toCharArray();
        int slen = ch.length;
        int l = 0, r = slen-1;
		while (l < slen && ch[l] == ')')
			l++;
        if(l == slen)
            return 0;
            
        while(l <= r && ch[r] == '(')
            r--;
        if(l > r)
            return 0;
        
        int max = 0, len = 0, cnt = 0, start = -1;
        for(int i = l;i <= r;i++){
            if(ch[i] == '('){
                cnt++;
                len++;
                if(start < 0)
                    start = i;
            }
            else{
                cnt--;
                if(cnt < 0){
                    len = cnt = 0;
                    start = -1;
                }
                else{
                    len++;
                    if(cnt == 0)
                        max = Math.max(max, len);
                }
            }
        }
        
        if(cnt > 0){
        	//traverse the substring reversely
            len = cnt = 0;
            for(int i = r;i >= start;i--){
                if(ch[i] == ')'){
                    cnt++;
                    len++;
                }
                else{
                    cnt--;
                    if(cnt < 0)
                        len = cnt = 0;
                    else{
                        len++;
                        if(cnt == 0)
                            max = Math.max(max, len);
                    }
                }
            }
        }
        
        return max;
    }
}
