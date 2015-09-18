package nju.ics.lixiaofan.algorithm;
//Implement int sqrt(int x). Compute and return the square root of x.
public class SqrtX {
	public static void main(String[] args) {
		SqrtX sqrtx = new SqrtX();
		System.out.println(sqrtx.mySqrt(2147483647));
	}
	int x, sqrtx;
    public int mySqrt(int x) {
    	if(x < 2)
    		return x;
    	this.x = x;
    	bsearch(1, x);
    	return sqrtx;
    }
    
    private void bsearch(int l, int r){
    	int mid = (int) (((long)l+r)/2);
    	System.out.println("mid:"+mid);
    	long square = (long)mid*mid;
    	System.out.println(square);
    	if(square == x)
    		sqrtx = mid;
    	else if(square < x){
    		if(l == mid)
    			sqrtx = mid;
    		else
    			bsearch(mid, r);
    	}
    	else{
    		bsearch(l, mid);
    	}
    }
}
