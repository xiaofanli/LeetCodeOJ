package nju.ics.lixiaofan.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
 */

public class PascalsTriangleII {

	public static void main(String[] args) {
		PascalsTriangleII p = new PascalsTriangleII();
		List<Integer> list = p.getRow(40);
		for(Integer i : list){
			System.out.println(i);
		}
	}

	public List<Integer> getRow(int rowIndex) {
		if(rowIndex < 0)
			return null;
		List<Integer> row = new ArrayList<Integer>();
		for(int i = 0;i < rowIndex;i++)
			row.add(0);
		row.add(1);
		
		for(int i = rowIndex;i > 0;i--){
			row.set(i-1, 1);
			for(int j = i;j < rowIndex;j++){
				row.set(j, row.get(j)+row.get(j+1));
			}
		}
		
        return row;
    }
}
