package nju.ics.lixiaofan.algorithm;
/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
 */
public class ReverseInteger {
	public static void main(String[] args) {
		ReverseInteger ri = new ReverseInteger();
		System.out.println(ri.reverse(1534236469));
	}
    public int reverse(int x) {
        int result = 0;
        int a = Math.abs(x), bound = Integer.MAX_VALUE/10;
        while(a > 0){
        	if(result > bound)
        		return 0;
        	result = result*10 + a%10;
        	a /= 10;
        }
        return (x < 0) ? -result : result;
    }
}
