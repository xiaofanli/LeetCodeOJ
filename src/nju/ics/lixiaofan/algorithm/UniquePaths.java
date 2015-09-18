package nju.ics.lixiaofan.algorithm;
/*
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
Note: m and n will be at most 100.
 */
public class UniquePaths {
	public static void main(String[] args) {
		UniquePaths up = new UniquePaths();
		System.out.println(up.uniquePaths(100, 7));
	}
	//C^(m-1)_(m+n-2)
    public int uniquePaths(int m, int n) {
        if(m < 1 || n < 1)
        	return 0;
        if(m == 1 || n == 1)
        	return 1;
        
        int num = (m < n) ? m-1 : n-1;
        int limit = m+n-2-num;
        long deno = 1, nume = 1;
        for(int i = m+n-2;i > limit;i--){
        	deno *= i;
        	nume *= num;
        	num--;
        }
        
//        System.out.println(deno+"\t"+nume);
        return (int) (deno / nume);
    }
    
    
}
