package nju.ics.lixiaofan.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.*/
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int l = -1, r, min = Integer.MAX_VALUE;
        String res = "";
        HashMap<Character, int[]> count = new HashMap<Character, int[]>();
        HashSet<Character> set = new HashSet<Character>();
        Queue<Integer> trace = new LinkedList<Integer>();
        for(char c : t.toCharArray()){
            int[] v = count.get(c);
            if(v == null)
            	count.put(c, new int[]{1});
            else
                v[0]++;
            set.add(c);
        }
        
        HashSet<Character> left = new HashSet<Character>(set);
        int size = s.length();
        for(int i = 0;i < size;i++){
            char c = s.charAt(i);
            if(set.contains(c)){
                trace.add(i);
                r = i + 1;
                if(l < 0)
                    l = trace.poll();
                int[] v = count.get(c);
                v[0]--;
                if(v[0] == 0){
                    left.remove(c);
                    if(left.isEmpty()){
                        if(r - l < min){
                            min = r - l;
                            res = s.substring(l, r);
                        }
                        c = s.charAt(l);
                        v = count.get(c);
                        while(v[0] < 0){
                            v[0]++;
                            l = trace.poll();
                            if(r - l < min){
                                min = r - l;
                                res = s.substring(l, r);
                            }
                            c = s.charAt(l);
                            v = count.get(c);
                        }
                        v[0]++;
                        left.add(c);
                        l = !trace.isEmpty() ? trace.poll() : -1;
                    }
                }
            }
        }
        return res;
    }
}
