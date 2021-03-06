package nju.ics.lixiaofan.algorithm;

import java.util.Arrays;

/*Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?*/
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
    	//DP solution: using nums to restore the tails
        int len = 0, idx;
        for(int n : nums){
            if(len == 0 || nums[len-1] < n)
                nums[len++] = n;
            else if((idx = Arrays.binarySearch(nums, 0, len, n)) < 0){//if not found, return -(insert point)-1
                nums[-idx-1] = n;
            }
        }
        return len;
    }
}
