package nju.ics.lixiaofan.algorithm;
/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
 */
public class SortColors {
	public static void main(String[] args) {
		SortColors sc = new SortColors();
		int[] nums = {0,2,2,2,0,2,1,1};
		sc.sortColors(nums);
		for(int n : nums)
			System.out.print(n+" ");
	}
    public void sortColors(int[] nums) {
    	if(nums.length < 2)
    		return;
        int l, r;
        for(l = 0;l < nums.length;l++)
        	if(nums[l] != 0)
        		break;
        if(l == nums.length)
        	return;
        
        for(r = nums.length - 1;r >= l;r--)
        	if(nums[r] != 2)
        		break;
        if(r < l)
        	return;
        
        for(int i = l;i <= r;i++){
        	switch(nums[i]){
        	case 0:
        		nums[i] = nums[l];
        		nums[l] = 0;
        		for(l++;l <= r;l++){
        			if(nums[l] != 0)
        				break;
        		}
        		if(l > r)
        			return;
        		if(nums[i] == 2)
        			i--;
        		break;
        	case 2:
        		nums[i] = nums[r];
        		nums[r] = 2;
        		for(r--;r >= l;r--){
        			if(nums[r] != 2)
        				break;
        		}
        		if(l > r)
        			return;
        		if(nums[i] == 0)
        			i--;
        		break;
        	}
        }
    }
}
