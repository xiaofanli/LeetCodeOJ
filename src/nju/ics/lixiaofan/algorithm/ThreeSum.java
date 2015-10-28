package nju.ics.lixiaofan.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ¡Ü b ¡Ü c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] num) {
	    ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();       
	    Arrays.sort(num);
	    for (int i=0; i < num.length; i++) {
	        int start = i + 1, end = num.length-1;
	        while (start < end) {// Two pointers
	            int sum = num[i] + num[start] + num[end];                   
	            if (sum == 0) {     
	                result.add(Arrays.asList(num[i], num[start], num[end]));
	                start++; end--;
	                while((start < end) && num[start] == num[start-1]) start++;     // remove duplicates
	                while((start < end) && num[end] == num[end+1]) end--;
	            }
	            else if (sum < 0) {
	                start++;       
	                while((start < end) && num[start] == num[start-1]) start++;     // remove duplicates
	            } else {            
	                end--;
	                while((start < end) && num[end] == num[end+1]) end--;           // remove duplicates                
	            }      
	        }           
	        while (i+1 < num.length && num[i+1] == num[i])                          // remove duplicates
	            i++;            
	    }        
	    return result;
	}
}
