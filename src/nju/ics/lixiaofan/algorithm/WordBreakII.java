package nju.ics.lixiaofan.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
 */
public class WordBreakII {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        boolean breakable = false;
        for(String word : wordDict)
            if(s.endsWith(word)){
                breakable = true;
                break;
            }
        return breakable ? breakWord(s, wordDict) : new LinkedList<String>();
    }
    
    private List<String> breakWord(String s, Set<String> wordDict) {
        List<String> res = new LinkedList<String>();
        for(String word : wordDict)
            if(s.startsWith(word)){
                if(s.length() == word.length())
                    res.add(word);
                else{
                    List<String> suffixes = breakWord(s.substring(word.length()), wordDict);
                    for(String suffix : suffixes)
                        res.add(word+" "+suffix);
                }
            }
        
        return res;
    }
}
