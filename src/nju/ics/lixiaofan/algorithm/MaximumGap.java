package nju.ics.lixiaofan.algorithm;
/*
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 */
public class MaximumGap {
	/*
	 * pigion hole principle
	 * Suppose you have n pigeons with labels and you put them into m holes based on their label with each hole of the same size. Why bother putting pigeons into holes? Because you want to disregard the distance between pigeons within each one hole.
	 * Only when at least one hole is empty can we disregard the distance between pigeons within each one hole and compute the maximum gap solely by the distance between pigeons in adjacent holes. We make sure that at least one hole is empty by using m=n-1 (i.e. n-2 pigeons in n-1 holes => at least one hole is empty).
	 */
    public int maximumGap(int[] nums) {
        if(nums.length < 2)
            return 0;
            
        int maxE = Integer.MIN_VALUE, minE = Integer.MAX_VALUE;
        for(int n : nums){
            maxE = Math.max(maxE, n);
            minE = Math.min(minE, n);
        }
        
        double len = (double )(maxE - minE) / nums.length;
        int[] max = new int[nums.length+1], min = new int[nums.length+1];
        for(int i = 0;i < max.length;i++){
            max[i] = Integer.MIN_VALUE;
            min[i] = Integer.MAX_VALUE;
        }
        
        for(int n : nums){
            int idx = (int )((n - minE) / len);
            max[idx] = Math.max(max[idx], n);
            min[idx] = Math.min(min[idx], n);
        }
        
        int prev = max[0], maxGap = 0;
        for(int i = 1;i < max.length;i++){
            if(max[i] == Integer.MIN_VALUE)
                continue;
            maxGap = Math.max(maxGap, min[i] - prev);
            prev = max[i];
        }
        return maxGap;
    }
}
