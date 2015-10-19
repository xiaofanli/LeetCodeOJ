package nju.ics.lixiaofan.algorithm;

import java.util.Set;
/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {
	public boolean wordBreak(String s, Set<String> wordDict) {
	    if (s == null && wordDict == null)
	        return true;
	    if (s == null || wordDict == null)
	        return false;
	    //dp[i] represents if s.substring(0, i+1) is breakable.
	    boolean[] dp = new boolean[s.length()+1];
	    dp[0] = true;
	    for (int i = 1; i <= s.length(); i++) {
	        for (int j = 0; j < i; j++) {
	            if (dp[j] && wordDict.contains(s.substring(j, i)))
	                dp[i] = true;
	        }
	    }
	    return dp[s.length()];
	}
}
