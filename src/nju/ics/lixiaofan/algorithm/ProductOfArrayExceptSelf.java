package nju.ics.lixiaofan.algorithm;
/*
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        output[0] = 1;
        for(int i = 0;i < nums.length-1;i++)
            output[i+1] = output[i] * nums[i];
        
        int p = 1;
        for(int i = nums.length-1;i > 0;i--){
            p *= nums[i];        
            output[i-1] *= p;
        }
        return output;
    }
}
