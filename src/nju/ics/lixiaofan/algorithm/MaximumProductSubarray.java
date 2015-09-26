package nju.ics.lixiaofan.algorithm;

/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
    	if(nums.length == 0)
    		return 0;
    	else if(nums.length == 1)
    		return nums[0];
    	int cnt = 0;
    	int p1 = 1, p2 = 1, ret = Integer.MIN_VALUE;
    	
    	for(int i = 0;i < nums.length;i++){
    		if(nums[i] == 0){
    			ret = Math.max(ret, 0);
    			cnt = 0;
    			continue;
    		}
    		switch (cnt) {
			case 0:
				cnt++;
				p1 = nums[i];
				ret = Math.max(ret, p1);
				break;
			case 1:
				if(p1 < 0){
					p2 = nums[i];
					ret = Math.max(ret, p2);
					cnt++;
				}
				p1 *= nums[i];
				ret = Math.max(ret, p1);
				break;
			default:
				p1 *= nums[i];
				p2 *= nums[i];
				ret = Math.max(ret, Math.max(p1, p2));
				break;
			}
    	}
    	return ret;
    }
}
