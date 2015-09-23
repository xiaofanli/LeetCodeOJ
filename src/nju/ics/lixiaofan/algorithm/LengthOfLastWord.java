package nju.ics.lixiaofan.algorithm;
/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0)
        	return 0;
        char[] array = s.toCharArray();
        int len = 0;
        for(int i = array.length-1;i >= 0;i--){
        	if(array[i] == ' '){
        		if(len == 0)
        			continue;
        		else
        			return len;
        	}
        	len++;
        }
        return len;
    }
}
