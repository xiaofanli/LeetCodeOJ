package nju.ics.lixiaofan.algorithm;
/*Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.*/
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        int res2 = 2, res3 = 3, res5 = 5;
        int i2 = 0, i3 = 0, i5 = 0, min;
        for(int i = 1;i < n;i++){
            min = Math.min(res2, Math.min(res3, res5));
            nums[i] = min;
            if(min == res2)
                res2 = 2 * nums[++i2];
            if(min == res3)
                res3 = 3 * nums[++i3];
            if(min == res5)
                res5 = 5 * nums[++i5];
        }
        
        return nums[n-1];
    }
}
