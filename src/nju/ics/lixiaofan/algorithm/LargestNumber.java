package nju.ics.lixiaofan.algorithm;

/*
 * Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {
	public static void main(String[] args) {
		LargestNumber ln = new LargestNumber();
		int[] nums = {3, 30, 34, 5, 9};
		System.out.println(ln.largestNumber(nums));
	}
    public String largestNumber(int[] nums) {
    	if(nums.length == 0)
    		return null;
    	if(nums.length == 1)
    		return String.valueOf(nums[0]);
    	
    	quickSort(nums, 0, nums.length-1);
        if(nums[0] == 0)
        	return "0";
        
        String s = "";
        for(int num : nums){
        	s += String.valueOf(num);
        }
        return s;
    }
    
    public boolean compare(int n1, int n2){
    	if(n1 == n2)
            return false;
        int s1 = 10;
        while(s1 <= n1)
            s1 *= 10;
        int s2 = 10;
        while(s2 <= n2)
            s2 *= 10;
        if(s1 == s2)
            return n1>n2;
        return (n2*s1+n1)<(n1*s2+n2);
    }
    
	int partition(int array[], int p, int r) {
		int x = array[r];
		int i = p - 1;
		int j;
		for (j = p; j < r; j++) {
			if (compare(array[j], x)) {
				i++;
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
			}
		}
		int temp = array[j];
		array[j] = array[i + 1];
		array[i + 1] = temp;
		return i + 1;
	}

	void quickSort(int[] array, int p, int r) {
		if (p < r) {
			int q = partition(array, p, r);
			quickSort(array, p, q - 1);
			quickSort(array, q + 1, r);
		}
	}
}
