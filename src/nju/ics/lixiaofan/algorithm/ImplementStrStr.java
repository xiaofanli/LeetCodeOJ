package nju.ics.lixiaofan.algorithm;
/*
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class ImplementStrStr {

	//using KMP
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), k = needle.length();
        if(n<k) return -1;
        if(k==0) return 0;
        int[] lps = new int[k];
        buildPattern(lps,needle);
        int partialMatchLength = 0;
        for(int i=0;i<n;){
            if(haystack.charAt(i)==needle.charAt(partialMatchLength)){
                if(partialMatchLength==k-1) return i-partialMatchLength;
                partialMatchLength++;
                i++;
            }
            else{
                if(partialMatchLength>0) {
                    partialMatchLength = lps[partialMatchLength-1];
                }
                else i++;
            }

        }
        return -1;
    }

    public void buildPattern(int[] lps, String needle){
        lps[0] = 0;
        int i = 1, currLength = 0; //current length of longest prefix suffix
        while(i<lps.length){
            if(needle.charAt(i)==needle.charAt(currLength)){
                currLength++;
                lps[i] = currLength;
                i++;
            }
            else{
                if(currLength!=0) currLength = lps[currLength-1];
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}
