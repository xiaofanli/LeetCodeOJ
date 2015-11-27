package nju.ics.lixiaofan.algorithm;
/*Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].*/
public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length-1,  mid;
        int[] res = {-1, -1};
        while(l < r){
            mid = (l + r) / 2;
            if(nums[mid] < target)
                l = mid + 1;
            else if(nums[mid] > target)
                r = mid - 1;
            else
                r = mid;
        }
        if(nums[l] != target)
            return res;

        res[0] = l;
        l = 0;
        r = nums.length-1;
        while(l < r){
            mid = (l + r + 1) / 2;
            if(nums[mid] < target)
                l = mid + 1;
            else if(nums[mid] > target)
                r = mid - 1;
            else
                l = mid;
        }
        
        res[1] = l;
        return res;
    }
}
