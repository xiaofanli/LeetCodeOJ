package nju.ics.lixiaofan.algorithm;
/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int l = 0, r = height.length-1, res = 0;
        while(r-l > 1){
            if(height[l] <= height[r]){
                for(int i = l+1;i <= r;i++)
                    if(height[i] < height[l])
                        res += height[l] - height[i];
                    else{
                        l = i;
                        break;
                    }
            }
            else{
                for(int i = r-1;i >= l;i--)
                    if(height[i] < height[r])
                        res += height[r] - height[i];
                    else{
                        r = i;
                        break;
                    }
            }
        }
        return res;
    }
}
