package nju.ics.lixiaofan.algorithm;
/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int len = nums.length, len1 = len-1;
        int l = 0, r = len1, mid, offset = 0;
        //find the pivot first if exist
        if(nums[0] > nums[len1]){
            int last = nums[len1];
            while(l < r){
                mid = (l + r) / 2;
                if(nums[mid] > last)
                    l = mid + 1;
                else
                    r = mid;
            }
            offset = l;
            l = 0;
            r = len1;
        }
        int mid2;
        while(l < r){
            mid2 = (l + r) / 2;
            mid = (mid2 + offset) % len;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                r = mid2 - 1;
            else
                l = mid2 + 1;
        }
        mid = (l + offset) % len;
        return nums[mid] == target ? mid : -1;
    }
}
