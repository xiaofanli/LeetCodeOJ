package nju.ics.lixiaofan.algorithm;
/*
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
		int x = 0;

		for (int i : nums) {
			x ^= i;
		}
		return x;
    }
}
