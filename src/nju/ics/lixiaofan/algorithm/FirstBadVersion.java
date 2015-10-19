package nju.ics.lixiaofan.algorithm;
/*
You are a product manager and currently leading a team to develop a new product.
Unfortunately, the latest version of your product fails the quality check.
Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version.
You should minimize the number of calls to the API.
 */

public class FirstBadVersion {
	//binary search
    public int firstBadVersion(int n) {
        long l = 1, r = n;
        int mid, ver = n;
        while(l <= r){
        	mid = (int) ((l+r)/2);
        	if(isBadVersion(mid)){
        		ver = mid;
        		r = mid - 1;
        	}
        	else{
        		l = mid + 1;
        	}
        }
        return ver;
    }

    int firstBadVersion = 1702766719;
	private boolean isBadVersion(int mid) {
		return mid >= firstBadVersion;
	}
}
