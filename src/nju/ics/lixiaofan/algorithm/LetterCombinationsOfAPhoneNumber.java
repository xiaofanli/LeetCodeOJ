package nju.ics.lixiaofan.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        Map<Character, Set<String>> map = new HashMap<Character, Set<String>>();
        String[] tmp = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for(int i = 0;i < tmp.length;i++){
            Set<String> set = new HashSet<String>();
            map.put((char) ('2'+i), set);
            for(int j = 0;j < tmp[i].length();j++)
                set.add(String.valueOf(tmp[i].charAt(j)));
        }
        
        return letterCombinations(digits, map);
    }
    
    private List<String> letterCombinations(String digits, Map<Character, Set<String>> map) {
        List<String> res = new ArrayList<String>();
        if(digits == null || digits.equals(""))
            return res;
        else if(digits.length() == 1)
            res.addAll(map.get(digits.charAt(0)));
        else{
            List<String> suffixes = letterCombinations(digits.substring(1), map);
            for(String prefix : map.get(digits.charAt(0)))
                for(String suffix : suffixes)
                    res.add(prefix+suffix);
        }
        return res;
    }
}
