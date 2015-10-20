package nju.ics.lixiaofan.algorithm;
/*
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class FindTheDuplicateNumber {
	//The idea is the same as Linked List Cycle II
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int count = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
            count++;
        }while(slow != fast);
        
        slow = fast = 0;
        for(int i = 0;i < count;i++)
            fast = nums[fast];
        
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return fast;
    }
}
