package nju.ics.lixiaofan.algorithm;
/*Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.*/
public class BitwiseANDOfNumbersRange {
	//[m = 0bxyz0acd, n=0bxyz1rst]: 0bxyz0111 & 0bxyz1000 = 0bxyz0000
    public int rangeBitwiseAnd(int m, int n) {
        int cnt = 0;
        while(m != n){
            m >>= 1;
            n >>= 1;
            cnt++;
        }
        return m << cnt;
    }
}
