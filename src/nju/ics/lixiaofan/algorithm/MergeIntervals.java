package nju.ics.lixiaofan.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 */
public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		if(intervals.isEmpty())
			return new LinkedList<Interval>();
		List<Double> list = new ArrayList<Double>();
		for(Interval i : intervals){
			double key = (i.end < 0) ? i.end-0.5 : i.end+0.5;
			list.add((double) i.start);
			list.add(key);
		}
		
		Collections.sort(list);
		List<Interval> ret = new LinkedList<Interval>();
		int start = Integer.MIN_VALUE;
		int count = 0;
		for(double p : list){
			int intp = (int) p;
			if(p-intp == 0){
				count++;
				if(start == Integer.MIN_VALUE)
					start = intp;
			}
			else{
				count--;
				if(count == 0){
					ret.add(new Interval(start, intp));
					start = Integer.MIN_VALUE;
				}
			}
				
		}
		return ret;
	}
	
	public static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
	 
}
