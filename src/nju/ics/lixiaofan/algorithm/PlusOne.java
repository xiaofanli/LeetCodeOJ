package nju.ics.lixiaofan.algorithm;
/*
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n-1;i >= 0;i--){
        	digits[i]++;
        	if(digits[i] < 10)
            	return digits;
        	else
        		digits[i] = 0;
        }
        int[] newdigits = new int[n+1];
        newdigits[0] = 1;
        for(int i = 1;i < newdigits.length;i++)
        	newdigits[i] = 0;
        
        return newdigits;
    }
}
