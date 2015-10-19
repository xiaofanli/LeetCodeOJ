package nju.ics.lixiaofan.algorithm;
/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums.length == 0)
        	return -1;
        if(nums.length == 1)
        	return  nums[0] == target ? 0 : -1;
        if(nums.length == 2)
        	return  nums[0] == target ? 0 : (nums[1] == target ? 1 : -1);
        
        int l = 0, r = nums.length-1;
        if(nums[l] > nums[r]){
        	int rvalue = nums[nums.length-1];
        	//descending
        	if(nums[1] < nums[0] && nums[1] > rvalue){
        		int mid;
        		while(true){
        			mid = (l+r)/2;
	        		if(nums[mid] == target)
	        			return mid;
	        		else if(l >= r)
	        			return -1;
	        		else if(nums[mid] < target)
	        			r = mid - 1;
	        		else
	        			l = mid + 1;
        		}
        	}
        	if(target >= nums[l]){
        		int mid;
        		while(true){
	        		mid = (l+r)/2;
	        		if(nums[mid] == target)
	        			return mid;
	        		else if(l >= r)
	        			return -1;
	        		else if(nums[mid] > target || nums[mid] <= rvalue)
	        			r = mid - 1;
	        		else
	        			l = mid + 1;
        		}	
        	}
        	else if(target <= nums[r]){
        		int mid;
        		while(true){
	        		mid = (l+r)/2;
	        		if(nums[mid] == target)
	        			return mid;
	        		else if(l >= r)
	        			return -1;
	        		else if(nums[mid] > target && nums[mid] <= rvalue)
	        			r = mid - 1;
	        		else
	        			l = mid + 1;
        		}	
        	}
        	else
        		return -1;
        }
        else{
        	//ascending
        	if(nums[1] > nums[0] && nums[1] < nums[nums.length-1]){
        		int mid;
        		while(true){
        			mid = (l+r)/2;
	        		if(nums[mid] == target)
	        			return mid;
	        		else if(l >= r)
	        			return -1;
	        		else if(nums[mid] > target)
	        			r = mid - 1;
	        		else
	        			l = mid + 1;
        		}
        	}
        	if(target >= nums[r]){
        		int mid;
        		while(true){
	        		mid = (l+r)/2;
	        		if(nums[mid] == target)
	        			return mid;
	        		else if(l >= r)
	        			return -1;
	        		else if(nums[mid] > target || nums[mid] <= nums[0])
	        			l = mid - 1;
	        		else
	        			r = mid + 1;
        		}	
        	}
        	else if(target <= nums[l]){
        		int mid;
        		while(true){
	        		mid = (l+r)/2;
	        		if(nums[mid] == target)
	        			return mid;
	        		else if(l >= r)
	        			return -1;
	        		else if(nums[mid] > target && nums[mid] <= nums[0])
	        			l = mid - 1;
	        		else
	        			r = mid + 1;
        		}	
        	}
        	else
        		return -1;
        }
    }
}
