package nju.ics.lixiaofan.algorithm;
/*Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note: 
(1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
(2) 0 �� n �� 500, 0 �� nums[i] �� 100

Example:

Given [3, 1, 5, 8]

Return 167

    nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
   coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167*/
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n+2];
        newNums[0] = newNums[n+1] = 1;
        for(int i = 0;i < n;i++)
            newNums[i+1] = nums[i];
        
        int[][] dp = new int[n+2][n+2];
        for(int len = 1;len <= n;len++){
            int lbound = n - len + 2;
            for(int l = 1;l < lbound;l++){
                int r = l + len - 1, max = 0;
                for(int i = l;i <= r;i++)
                     max = Math.max(max, newNums[i]*newNums[l-1]*newNums[r+1] + dp[l][i-1] + dp[i+1][r]);//select i as the last one
                dp[l][r] = max;
            }
        }
        return dp[1][n];
    }
}
