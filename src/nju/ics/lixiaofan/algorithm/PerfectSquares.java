package nju.ics.lixiaofan.algorithm;
/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */
public class PerfectSquares {
	//DP
    public int numSquares(int n) {
        int[] min = new int[n+1];
        for(int i = 1;i*i <= n;i++)
        	min[i*i] = 1;
        
        for(int i = 0;i <= n;i++){
        	if(min[i] != 1){
        		min[i] = Integer.MAX_VALUE;
        		for(int j = 1;j*j <= i;j++){
        			int num = 1 + min[i-j*j];
        			if(min[i] > num)
        				min[i] = num;
        		}
        	}
        }
        
        return min[n];
    }
}
