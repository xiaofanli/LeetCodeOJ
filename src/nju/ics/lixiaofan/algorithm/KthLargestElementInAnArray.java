package nju.ics.lixiaofan.algorithm;

import java.util.LinkedList;
import java.util.List;

/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ¡Ü k ¡Ü array's length.
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new LinkedList<Integer>();
        for(int n : nums){
        	if(list.size() < k)
        		insert(n, list);
        	else if(n > list.get(0)){
        		list.remove(0);
        		insert(n, list);
        	}
        }
        return (int) list.get(0);
    }
    
    private void insert(int n, List<Integer> list){
    	int l = 0, r = list.size()-1, mid, x;
    	while(l <= r){
    		mid = (l+r)/2;
    		x = list.get(mid);
    		if(n > x)
    			l = mid+1;
    		else if(n < x)
    			r = mid-1;
    		else{
    			list.add(mid, n);
    			return;
    		}
    	}
    	list.add(l, n);
    }
}
