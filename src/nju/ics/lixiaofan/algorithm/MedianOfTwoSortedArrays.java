package nju.ics.lixiaofan.algorithm;
/*
There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. 
The overall run time complexity should be O(log (m+n)).
 */
public class MedianOfTwoSortedArrays {
	/*
	 * If you solve the k-th minmum value of two sorted arrays, you solve this problem.This is a classical problem of "Divide and conquer".
	 * Here is another more simple and more neat solution.
	 * Cosider chosing first x numbers from A and k - x numbers from B.
	 * if these k numbers are the k minmum numbers of A and B, x must satisfies that A[x + 1] >= B[k - x] and B[k - x + 1] >= A[x] (for better explanation index is base-1). 
	 * So this x is what we want.
	 * Obviously, if A[x + 1] < B[k - x + 1] then x must be smaller, else if B[k - x] < A[x] then x must be greater. A nice two-value definition for binary search :)
	 * To simplify edge cases, we cosider each array indefinite, with value of INTMIN when index < 1 and INTMAX when index > n.
	 */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        
        int total = nums1.length + nums2.length;
        if(total % 2 > 0)
            return findKth((total+1)/2, nums1, nums2);
        else
            return ((double )findKth(total/2, nums1, nums2)+findKth(total/2+1, nums1, nums2)) * 0.5;
    }
    
    private int findKth(int k, int[] nums1, int[] nums2){
        int l = 0, r = nums1.length+1, x;
        while(l <= r){
            x = (l + r) / 2;
            if(v(x, nums1) > v(k-x+1, nums2))
                r = x - 1;
            else if(v(k-x, nums2) > v(x+1, nums1))
                l = x + 1;
            else
                return Math.max(v(x, nums1), v(k-x, nums2));
        }
        return 0;//never executed
    }
    
    private final int v(int x, int[] nums){
        return x < 1 ? Integer.MIN_VALUE : (x > nums.length ? Integer.MAX_VALUE : nums[x-1]);
    }
}
