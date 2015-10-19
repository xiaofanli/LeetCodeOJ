package nju.ics.lixiaofan.algorithm;
/*
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s == null)
        	return false;
        if(s.equals("") || s.length() == 1)
        	return true;
        char[] ch = s.toLowerCase().toCharArray();

        int h = 0, t = s.length() - 1;
        while(h <= t){
        	if(ch[h] < '0' || (ch[h] > '9' && ch[h] < 'a') || ch[h] > 'z'){
        		h++;
        		continue;
        	}
        	if(ch[t] < '0' || (ch[t] > '9' && ch[t] < 'a') || ch[t] > 'z'){
        		t--;
        		continue;
        	}
        	
        	if(ch[h] == ch[t]){
        		h++;
        		t--;
        	}
        	else
        		return false;
        }
        return true;
    }
}
