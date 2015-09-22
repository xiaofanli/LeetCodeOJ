package nju.ics.lixiaofan.algorithm;
/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class MissingNumber {
	public static void main(String[] args) {
		MissingNumber mn = new MissingNumber();
		int[] nums = {0, 3, 1};
		System.out.println(mn.missingNumber(nums));
	}
	
	//a^b^b = a
	public int missingNumber(int[] nums) {
	    int xor = 0, i = 0;
	    for (i = 0; i < nums.length; i++) {
	        xor ^= i ^ nums[i];
	    }

	    return xor ^ i;
	}
	
    public int missingNumber2(int[] nums) {
    	int n = nums.length;
    	int totalSum = n*(n+1)/2, sum = 0;
    	for(int x : nums)
    		sum += x;
    	return totalSum - sum;
    }
}
