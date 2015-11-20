package nju.ics.lixiaofan.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
All words have the same length.
All words contain only lowercase alphabetic characters.*/
public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> res = new ArrayList<List<String>>();
        Map<String, Set<String>> map = new HashMap<String, Set<String>>();
        Set<String> set1 = new HashSet<String>(), set2 = new HashSet<String>(), set;
        set1.add(beginWord);
        set2.add(endWord);
        boolean found = false, flip = false;
        while(!found){
            if(set1.isEmpty())
            	break;
            if(set1.size() > set2.size()){
            	set = set1;
            	set1 = set2;
            	set2 = set;
            	flip = !flip;
            	continue;
            }
            wordList.removeAll(set1);
            wordList.removeAll(set2);
            
            set = new HashSet<String>();
            for(String s : set1)
            	for(int i = 0;i < s.length();i++){
            		char[] chars = s.toCharArray();
            		for(char c = 'a';c <= 'z';c++){
            			chars[i] = c;
            			String word = String.valueOf(chars);
            			String	key = flip ? word : s;
            			String	val = flip ? s : word;
            			if(set2.contains(word)){
            				found = true;
            				if(!map.containsKey(key))
            					map.put(key, new HashSet<String>());
            				map.get(key).add(val);
            			}
            			else if(wordList.contains(word)){
            				set.add(word);
            				if(!map.containsKey(key))
            					map.put(key, new HashSet<String>());
            				map.get(key).add(val);
            			}
            		}
            	}
            
            set1 = set2;
            set2 = set;
            flip = !flip;
        }
        
        List<String> path = new ArrayList<String>();
        path.add(beginWord);
        genRes(beginWord, endWord, path, map, res);
        return res;
    }
    
    private void genRes(String beginWord, String endWord, List<String> path, Map<String, Set<String>> map, List<List<String>> res) {
    	if(map.containsKey(beginWord))
	    	for(String s : map.get(beginWord)){
	        	path.add(s);
	        	if(s.equals(endWord))
	        		res.add(new ArrayList<String>(path));
	        	else
	        		genRes(s, endWord, path, map, res);
	            path.remove(path.size()-1);
	        }    
    }
}
