package nju.ics.lixiaofan.algorithm;
/*
Given an array of integers, every element appears three times except for one. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumberII {
	//precondition: Given an array of integers, every element appears k (k >1) times except for one, which appears p times(p>=1, p % k != 0).
	//hint: every integer is 32 bits
    public int singleNumber(int[] nums) {
		int x1 = 0;
		int x2 = 0;
		int mask = 0;

		for (int i : nums) {
			x2 ^= x1 & i;
			x1 ^= i;
			mask = ~(x1 & x2);
			x2 &= mask;
			x1 &= mask;
		}
		return x1 != 0 ? x1 : x2;
    }
}
