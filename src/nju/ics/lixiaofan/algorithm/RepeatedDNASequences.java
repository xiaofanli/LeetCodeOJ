package nju.ics.lixiaofan.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s == null || s.length() <= 10)
            return new ArrayList<String>();
            
        Set<String> res = new HashSet<String>();
        Set<String> visited = new HashSet<String>();
        for(int i = 0;i <= s.length()-10;i++){
            String str = s.substring(i,i+10);
            if(!visited.contains(str))
                visited.add(str);
            else if(!res.contains(str))
                res.add(str);
        }    
        return new ArrayList<String>(res);
    }
}
