package nju.ics.lixiaofan.algorithm;

import java.util.Stack;

/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartitioningII {

	public static void main(String[] args) {
		PalindromePartitioningII pp2 = new PalindromePartitioningII();
		System.out.println(pp2.minCut("fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi"));
	}
	
	//DP
	public int minCut(String s) {
		int[][] p = new int[s.length()][s.length()];
        for(int i = 0;i < s.length();i++)
            for(int j = 0;j < s.length()-i;j++){
            	p[j][j+i] = 0xffff;
                if(s.charAt(j) == s.charAt(j+i))
                    p[j][j+i] = j+1 <= j+i-1 ? p[j+1][j+i-1] : 0;
            }


        for(int j = 1;j < s.length();j++)
            for(int i = 0;i < j;i++)
                p[0][j] = Math.min(p[0][j], p[0][i]+p[i+1][j]+1);


        return p[0][s.length()-1];
	}
}
