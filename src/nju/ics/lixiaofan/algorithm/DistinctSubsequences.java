package nju.ics.lixiaofan.algorithm;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        //prefixNums stores the numbers of t's prefixes occur when we iterate through s.
        int[] prefixNums = new int[t.length()];
        for(char c : s.toCharArray())
            for(int i = t.length()-1;i >= 0;i--)
                if(t.charAt(i) == c){
                    //we calculate prefixNums backwards to avoid new value influencing the calculation of next value,
                    //otherwise we need a temp array to restore the previous values.
                    prefixNums[i] += i > 0 ? prefixNums[i-1] : 1;
                }
        
        return prefixNums[t.length()-1];
    }
}
