package nju.ics.lixiaofan.algorithm;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

/*
	Given an array of strings, return all groups of strings that are anagrams.

	Note: All inputs will be in lower-case.
 */

public class Anagrams {
	public static List<String> anagrams(String[] strs) {
		List<String> list = new LinkedList<String>();
		Hashtable<Integer, List<String>> hashtable = new Hashtable<Integer, List<String>>();
		for(String str : strs){
			int hashcode = 0;
			if(str.equals(""))
				hashcode = str.hashCode();
			else{
				for(int i = 0;i < str.length();i++)
					hashcode += FNVHash(str.substring(i, i+1));
			}
			if(str == "duh" || str == "ill"){
				System.out.println(hashcode);
			}
			if(!hashtable.containsKey(hashcode)){
				hashtable.put(hashcode, new LinkedList<String>());
			}
			hashtable.get(hashcode).add(str);
		}
		
		for(List<String> l : hashtable.values())
			if(l.size() > 1){
				list.addAll(l);
			}
		
		return list;
    }
	
	public static int FNVHash(String key) {  
        final int p = 16777619;  
        int hash = (int) 2166136261L;  
        int n = key.length();  
        for (int i = 0; i < n; i++)  
            hash = (hash ^ key.charAt(i)) * p;  
        hash += hash << 13;  
        hash ^= hash >> 7;  
        hash += hash << 3;  
        hash ^= hash >> 17;  
        hash += hash << 5;  
        return (hash & 0x7FFFFFFF);  
    }
}
