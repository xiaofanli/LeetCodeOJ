package nju.ics.lixiaofan.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
        if(nums.length < 2)
        	return nums.length;
        int max = 1;
        Set<Integer> used = new HashSet<Integer>();
        Map<Integer, List<Interval>> imap = new HashMap<Integer, List<Interval>>();
        for(int n : nums){
        	if(used.contains(n))
        		continue;
        	else
        		used.add(n);
        	
        	if(imap.containsKey(n)){
        		List<Interval> list = imap.get(n);
        		if(list.size() == 1){
        			Interval in = list.get(0);
        			in.num++;
        			if(max < in.num)
        				max = in.num;
        			if(in.low == n){
        				in.low--;
        				if(!imap.containsKey(in.low))
        					imap.put(in.low, new LinkedList<Interval>());
        				imap.get(in.low).add(in);
        				imap.remove(n);
        			}
        			else{
        				in.high++;
        				if(!imap.containsKey(in.high))
        					imap.put(in.high, new LinkedList<Interval>());
        				imap.get(in.high).add(in);
        				imap.remove(n);
        			}
        		}
        		//two merges into one
        		else{
        			Interval in1 = list.get(0), in2 = list.get(1);
        			if(in1.high == in2.low){
        				in1.num = in1.num + in2.num + 1;
        				if(max < in1.num)
        					max = in1.num;
        				in1.high = in2.high;
        				imap.get(in2.high).add(in1);
        				imap.get(in2.high).remove(in2);
        			}
        			else{
        				in2.num = in1.num + in2.num + 1;
        				if(max < in2.num)
        					max = in2.num;
        				in2.high = in1.high;
        				imap.get(in1.high).add(in2);
        				imap.get(in1.high).remove(in1);
        			}
        		}
        	}
        	else{
        		Interval in = new Interval(1, n-1, n+1);
        		if(!imap.containsKey(n-1))
        			imap.put(n-1, new LinkedList<Interval>());
        		imap.get(n-1).add(in);
        		
        		if(!imap.containsKey(n+1))
        			imap.put(n+1, new LinkedList<Interval>());
        		imap.get(n+1).add(in);
        	}
        }
        return max;
    }
	
	class Interval{
		int num;
		int low, high;
		public Interval(int num, int low, int high) {
			this.num = num;
			this.low = low;
			this.high = high;
		}
	}
}
