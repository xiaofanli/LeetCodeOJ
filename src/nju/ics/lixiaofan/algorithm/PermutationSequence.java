package nju.ics.lixiaofan.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
The set [1,2,3,бн,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
 */
public class PermutationSequence {
	public static void main(String[] args) {
		PermutationSequence ps = new PermutationSequence();
		System.out.println(ps.getPermutation(6, 6));
	}

	public String getPermutation(int n, int k) {
		if(k < 1)
			return null;
		int[] f = new int[n+1];
		calcF(f, n);
		if(k > f[n])
			return null;
		String[] p = new String[n];
		List<String> nums = new ArrayList<String>();
		for(int i = 1;i < n+1;i++)
			nums.add(i+"");
		if(k == 1){
			String s = "";
			for(String str : nums)
				s = s.concat(str);
			return s;
		}
		int value = k-1;
		for(int i = 0;i < n-1;i++){
			int range = f[n-i-1];
			int idx = value / range;
			p[i] = nums.remove(idx);
			value %= range;
		}
		p[n-1] = nums.get(0);
		
		String s = "";
		for(String str : p)
			s = s.concat(str);
		return s;
	}
	
	public void calcF(int[] f, int n){
		f[0] = 1;
		for(int i = 1;i <= n;i++)
			f[i] = f[i-1] * i;
	}
}
