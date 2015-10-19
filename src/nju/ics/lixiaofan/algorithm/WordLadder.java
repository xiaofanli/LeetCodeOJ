package nju.ics.lixiaofan.algorithm;

import java.util.HashSet;
import java.util.Set;

/*
 Given two words (beginWord and endWord), and a dictionary, find the length of shortest transformation sequence from beginWord to endWord, 
 such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the dictionary
 For example,

 Given:
 start = "hit"
 end = "cog"
 dict = ["hot","dot","dog","lot","log"]
 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.

 Note:
 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.


 */
public class WordLadder {
	public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
		if(isLadder(beginWord, endWord))
			return 2;
		Set<String> set = new HashSet<String>(), newSet = new HashSet<String>(), dict = new HashSet<String>();
		dict.addAll(wordDict);
		for(String word : wordDict){
			if(word.equals(beginWord) || word.equals(endWord))
				dict.remove(word);
			else if(isLadder(beginWord, word))
				set.add(word);
		}
		if(set.isEmpty())
			return 0;
		long c, sum=0;
		int len = 3;
		while(!set.isEmpty()){
			for(String end : set)
				if(isLadder(end, endWord)){
					System.out.println("sum1: " + sum);
					return len;
				}
			
			len++;
			newSet.clear();
			
			for(String word : set)
				for(String another : dict){
					c = System.currentTimeMillis();
					if(isLadder(word, another)){
						
						newSet.add(another);
						
					}
					sum += System.currentTimeMillis() - c;
				}
			
			dict.removeAll(newSet);
			set.clear();
			set.addAll(newSet);
			
		}
		return 0;
    }
	
	long z, sum = 0;
	public boolean isLadder(String s1, String s2){
		z = System.currentTimeMillis();
		int count = 0;
		for(int i = 0;i < s1.length();i++)
			if(s1.charAt(i) != s2.charAt(i)){
				count++;
				if(count > 1)
					return false;
			}
		sum += System.currentTimeMillis() - z;
		return count == 1;
	}
}
