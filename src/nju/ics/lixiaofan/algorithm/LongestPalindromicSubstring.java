package nju.ics.lixiaofan.algorithm;
/*Given a string S, find the longest palindromic substring in S. 
You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.*/
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String res = s.substring(0, 1);
        char[] ch = s.toCharArray();
        for(int i = 0;i < ch.length;){
            int l = i - 1, r = i + 1;
            while(r < ch.length && ch[i] == ch[r])
                r++;
            i = r;//key step to skip duplicated chars
            while(l >= 0 && r < ch.length && ch[l] == ch[r]){
                l--;
                r++;
            }
            if(r-l-1 > res.length())
                res = s.substring(l+1, r);
        }
        return res;
    }
}
