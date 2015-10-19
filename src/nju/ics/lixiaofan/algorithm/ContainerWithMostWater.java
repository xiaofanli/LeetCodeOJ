package nju.ics.lixiaofan.algorithm;

public class ContainerWithMostWater {
	public static int maxArea(int[] height) {
        int result = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int area = (r - l) * Math.min(height[l], height[r]);
            result = Math.max(result, area);
            if (height[l] < height[r]) {
                do {
                    l++;
                } while (l < r && height[l-1] >= height[l]);
            } else {
                do {
                    r--;
                } while (r > l && height[r+1] >= height[r]);
            }
        }
        return result;
	}
}
