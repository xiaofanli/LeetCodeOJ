package nju.ics.lixiaofan.algorithm;

import java.util.HashSet;
import java.util.Set;

/*
Given an array of integers, find if the array contains any duplicates.
Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 */
public class ContainsDuplicate {
	public static void main(String[] args) {

	}
    public boolean containsDuplicate(int[] nums) {
    	Set<Integer> hash = new HashSet<Integer>();
    	for(int n : nums)
    		if(hash.contains(n))
    			return true;
    		else
    			hash.add(n);
		return false;
    }
}
