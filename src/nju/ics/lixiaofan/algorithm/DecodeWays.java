package nju.ics.lixiaofan.algorithm;

/*
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
 */
public class DecodeWays {
	int[] n;
    public int numDecodings(String s) {
    	if(s.length() == 0 || s.startsWith("0"))
    		return 0;
    	if(s.length() == 1)
    		return 1;
    	if(s.length() == 2){
    		int value = Integer.parseInt(s);
    		int offset = s.endsWith("0") ? 0 : 1;
    		return value > 26 ? offset : offset+1;
    	}
    	
    	n = new int[s.length()+1];
    	for(int i = 0;i < n.length;i++)
    		n[i] = -1;
    	
    	return num(s);
    }
    
    public int num(String s){
    	if(s.length() == 0 || s.startsWith("0")){
    		return 0;
    	}
    	if(s.length() == 1)
    		return 1;
    	if(s.length() == 2){
    		if(n[2] == -1){
	    		int value = Integer.parseInt(s);
	    		int offset = s.endsWith("0") ? 0 : 1;
	    		n[2] = value > 26 ? offset : offset+1;
    		}
    		return n[2];
    	}
    	
    	if(n[s.length()] == -1){
	    	int prefixValue = Integer.parseInt(s.substring(0, 2));
	    	if(prefixValue > 26){
	    		n[s.length()] = s.charAt(1) == '0' ? 0 : num(s.substring(1));
	    	}
	    	else
	    		n[s.length()] = s.charAt(1) == '0' ? num(s.substring(2)) : num(s.substring(1)) + num(s.substring(2));
    	}
    	return n[s.length()];
    }
}
