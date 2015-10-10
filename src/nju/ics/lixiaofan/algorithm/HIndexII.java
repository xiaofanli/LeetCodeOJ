package nju.ics.lixiaofan.algorithm;
/*
Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
 */
public class HIndexII {
    public int hIndex(int[] citations) {
        int h = 0;
        for(int i = citations.length-1;i >= 0;i--)
        	if(citations[i] > h)
        		h++;
        	else
        		break;
        return h;
    }
}
