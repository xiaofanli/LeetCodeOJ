package nju.ics.lixiaofan.algorithm;

import java.util.LinkedList;
import java.util.List;

/*
Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<String>();
        if(nums.length == 0)
            return res;
        int l = 0, r;
        for(int i = 1;i < nums.length;i++){
            if(nums[i] != nums[i-1]+1){
                r = i-1;
                if(r > l)
                    res.add(nums[l]+"->"+nums[r]);
                else
                    res.add(""+nums[l]);
                l = i;
            }
        }
        r = nums.length-1;
        if(r > l)
            res.add(nums[l]+"->"+nums[r]);
        else
            res.add(""+nums[l]);
        return res;
    }
}
