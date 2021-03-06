package nju.ics.lixiaofan.algorithm;

import java.util.HashMap;
import java.util.Map;

/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        if(pattern == null || str == null)
            return false;
        if(pattern.equals("") && str.equals(""))
            return true;
        String[] words = str.split(" ");
        if(words.length != pattern.length())
            return false;
        Map<Character, String> map = new HashMap<Character, String>();
        for(int i = 0;i < pattern.length();i++){
            char key = pattern.charAt(i);
            if(!map.containsKey(key)){
                if(map.values().contains(words[i]))
                    return false;
                map.put(key, words[i]);
            }
            else if(!map.get(key).equals(words[i]))
                return false;
        }
        return true;
    }
}
