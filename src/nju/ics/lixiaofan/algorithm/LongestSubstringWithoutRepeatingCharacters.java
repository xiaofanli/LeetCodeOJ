package nju.ics.lixiaofan.algorithm;

import java.util.HashSet;
import java.util.Set;


/*
	Given a string, find the length of the longest substring without repeating characters. 
	
	For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
	
	For "bbbbb" the longest substring is "b", with the length of 1.
*/
public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> chs = new HashSet<Integer>();
		int a = 's', b = 's';
		chs.add(a);
		System.out.println(chs.contains(b));
	}
	
	public int lengthOfLongestSubstring(String s) {
		if(s == null || s.equals(""))
			return 0;
        int maxLen = 0;
        Set<Character> chs = new HashSet<Character>();
        char c;
        int head = 0;
        for(int i = 0;i < s.length();i++){
        	c = s.charAt(i);
        	if(chs.contains(c)){
        		while(s.charAt(head) != c){
        			chs.remove(s.charAt(head));
        			head++;
        		}
        		//remove c & add new c
    			head++;
        	}
        	else{
        		chs.add(c);
        		if(chs.size() > maxLen)
        			maxLen = chs.size();
        	}
        }
        
        return maxLen;
    }
}
