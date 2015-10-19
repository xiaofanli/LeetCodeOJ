package nju.ics.lixiaofan.algorithm;

import java.util.ArrayList;
import java.util.List;

/*
Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(divisor == 0)
        	return Integer.MAX_VALUE;
        else if(divisor == 1)
        	return dividend;
        else if(divisor == Integer.MIN_VALUE)
        	return dividend == divisor ? 1 : 0;
        if(dividend == 0)
        	return 0;
        int extra = 0;
        boolean isNegative = false;
        if(dividend < 0){
        	if(dividend == Integer.MIN_VALUE){
        		if(divisor == -1)
        			return Integer.MAX_VALUE;
        		dividend = Integer.MAX_VALUE;
        		extra = 1;
        	}
        	else
        		dividend = -dividend;
        	isNegative = true;
        }
        if(divisor < 0){
        	divisor = -divisor;
        	isNegative = !isNegative;
        }
        if(dividend < divisor)
        	return 0;
        
        int quotient = 0;
        int d = divisor, shift = 0,tmp, count;
        List<Integer> list = new ArrayList<Integer>();
        list.add(d);
        while(true){
        	tmp = d + d;
        	if(tmp < 0 || tmp > dividend)
        		break;
        	else{
        		shift++;
        		d = tmp;
        		list.add(d);
        	}
        }
        while(true){
	        count = 0;
	        while(true){
	        	dividend -= d;
	        	if(dividend < 0){
	        		dividend += d;
	        		for(int i = 0;i < shift;i++)
	        			count += count;
	        		quotient += count;
	        		break;
	        	}
	        	else
	        		count++;
	        }
	        shift--;
	        if(shift < 0)
	        	break;
	        d = list.get(shift);
        }
        if(extra > 0){
        	if(dividend+extra >= divisor)
        		quotient++;
        }
        
        return isNegative ? -quotient : quotient;
    }
}
