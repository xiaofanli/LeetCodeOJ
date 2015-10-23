package nju.ics.lixiaofan.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> cur = null, prev = null;
        for(int i = 0;i < numRows;i++){
            cur = new ArrayList<Integer>();
            cur.add(1);
            if(prev != null){
                for(int j = 1;j < prev.size();j++)
                    cur.add(prev.get(j-1)+prev.get(j));
                cur.add(1);
            }
            res.add(cur);
            prev = cur;
        }
        
        return res;
    }
}
