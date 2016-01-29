package nju.ics.lixiaofan.algorithm;
/*Given a sorted positive integer array nums and an integer n, add/patch elements to the array such that any number in range [1, n] inclusive can be formed by the sum of some elements in the array. Return the minimum number of patches required.

Example 1:
nums = [1, 3], n = 6
Return 1.

Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
So we only need 1 patch.

Example 2:
nums = [1, 5, 10], n = 20
Return 2.
The two patches can be [2, 4].

Example 3:
nums = [1, 2, 2], n = 5
Return 0.*/
public class PatchingArray {
    public static int minPatches(int[] nums, int n) {
        int cnt = 0, r;
        long l, m = 0;//m is the maximum number that can be covered currently
        if(nums.length == 0 || nums[0] > 1){
            cnt++;//patch 1
            m += 1;
//            System.out.println(m);
            l = 2;
            r = nums.length > 0 ? Math.min(nums[0]-1, n) : n;
            while(l <= r){
                cnt++;
                m += l;
                l = m + 1;
//                System.out.println(m);
            }
            if(m >= n)
                return cnt;
        }
        for(int i = 0;i < nums.length;i++){
            m += nums[i];
//            System.out.println(m);
            l = m + 1;
            r = (i+1 < nums.length) ? Math.min(nums[i+1]-1, n) : n;
            while(l <= r){
                cnt++;
                m += l;
//                System.out.println(m);
                l = m + 1;
            }
            if(m >= n)
                return cnt;
        }
        return cnt;
    }
}
