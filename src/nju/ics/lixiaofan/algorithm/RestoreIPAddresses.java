package nju.ics.lixiaofan.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        List<String> res = new LinkedList<String>();
        boolean backtrack = false;
        int len = s.length(), i = len-9;
        if(len < 4 || len > 12)
            return res;
        if(i == 3 && Integer.parseInt(s.substring(0,i)) > 255)
            return res;
        else if(i < 1)
            i = 1;
        if(i > 1 && s.startsWith("0"))
        	return res;
        stack.push(i);
        while(!stack.isEmpty()){
            if(backtrack){
                int r = stack.pop();
                int h = stack.isEmpty() ? 0 : stack.peek();
                if(r-h < 3 && r < len){
                	if(len-r-1 < 3-stack.size() || s.substring(h,h+1).equals("0") || r-h == 2 && Integer.parseInt(s.substring(h,r+1)) > 255)
                        continue;
                    stack.push(r+1);
                    backtrack = false;
                }
            }
            else if(stack.size() == 3){
                backtrack = true;
                int tmp = stack.peek();
                if(len-tmp > 1 && s.substring(tmp,tmp+1).equals("0"))
                    continue;                    
                if(len-tmp < 3 || Integer.parseInt(s.substring(tmp,len)) < 256){
                	int h = 0;
                	String addr = "";
                	for(int r : stack){
                		addr += s.substring(h, r)+".";
                		h = r;
                	}
                	addr += s.substring(tmp, len);
                	res.add(addr);
                }
            }
            else{
                int r = stack.peek();
                i = len-r-3*(3-stack.size());
                if(i > 1 && s.substring(r,r+i).startsWith("0") || i == 3 && Integer.parseInt(s.substring(r,r+i)) > 255){
                    backtrack = true;
                    continue;
                }
                if(i < 1)
                    i = 1;
                stack.push(r+i);
            }
        }
        
        return res;
    }
}
