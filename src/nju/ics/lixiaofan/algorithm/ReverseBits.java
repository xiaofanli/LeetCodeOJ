package nju.ics.lixiaofan.algorithm;
/*
Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?
 */
public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
		n = n << 16 | n >>> 16;
		n = (n & 0x00ff00ff) << 8 | ((n >> 8) & 0x00ff00ff);
		n = (n & 0x0f0f0f0f) << 4 | ((n >> 4) & 0x0f0f0f0f);
		n = (n & 0x33333333) << 2 | ((n >> 2) & 0x33333333);
		n = (n & 0x55555555) << 1 | ((n >> 1) & 0x55555555);
        return n;        
    }
}
