package nju.ics.lixiaofan.algorithm;

/*
 * Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

Hint:
Could you do it in-place with O(1) extra space?
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
    	if(nums.length < 2)
    		return;
        k %= nums.length;
        if(k == 0)
        	return;
            int cur,last,i,j,index;
            int gcd=nums.length,b=k;
            while(b != 0) {
                i=gcd;
                gcd=b;
                b=i%b;
            }
            b=nums.length/gcd;
            for(i=0;i<gcd;++i)
                for(j=b,index=i,last=nums[i+nums.length-k];j>0;--j) {
                    cur=nums[index];
                    nums[index]=last;
                    index+=k;
                    if(index>=nums.length)index-=nums.length;
                    last=cur;
                }
    }
}
