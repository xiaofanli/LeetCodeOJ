package nju.ics.lixiaofan.algorithm;
/*
You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that
adjacent houses have security system connected and it will automatically contact the police 
if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {
	public static void main(String[] args) {
		int[] nums = {1,2};
		System.out.println(rob(nums));
	}
    
	//a classical DP solution: p: the solution to subarray [0..i-1], q: the solution to subarray [0..i-2]
    public static int rob(int[] nums) {
        int p = 0, q = 0;
        for (int n: nums) {
            int tmp = p;
            p = Math.max(p, q + n);
            q = tmp; 
        }
        return p;
    }
}
