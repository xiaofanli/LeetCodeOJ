package nju.ics.lixiaofan.algorithm;
/*** Implement pow(x, n). ***/
public class MyPow {
    public double myPow(double x, int n) {
    	if(n == 0)
    		return 1;
    	else if(x == 0)
    		return n < 0 ? Double.POSITIVE_INFINITY : 0;
    	else if(x == 1)
    		return 1;
    	else if(x == -1)
    		return (n&1) == 0 ? 1 : -1;
    	
    	long m = n < 0 ? -n : n; 
    	double ans = 1;
    	while(m != 0){
    		if((m & 1) == 1)
    			ans *= x;
    		x *= x;
    		m >>= 1;
    	}
    	return n > 0 ? ans : 1/ans;
    }
}
