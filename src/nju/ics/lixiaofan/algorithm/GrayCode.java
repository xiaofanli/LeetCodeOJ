package nju.ics.lixiaofan.algorithm;

import java.util.LinkedList;
import java.util.List;

/*
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<Integer>();
        int[] num = new int[(int) Math.pow(2,n)];
        num[0] = 0;
        result.add(num[0]);
        for(int i = 0;i < n;i++){
            int tmp = (int) Math.pow(2,i), tmp2 = 2*tmp-1;
            for(int j = tmp;j <= tmp2;j++){
                num[j] = num[tmp2-j] | (1<<i);
                result.add(num[j]);                
            }
        }
        return result;
    }
}
