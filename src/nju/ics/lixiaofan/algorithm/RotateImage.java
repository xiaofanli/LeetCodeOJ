package nju.ics.lixiaofan.algorithm;
/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
 */
public class RotateImage {
	//(i, j) -> (n-1-j, i)
    public void rotate(int[][] matrix) {
        int n = matrix.length, ub1 = (n-1)/2, ub2 = ub1 - n%2, tmp;
        for(int i = 0;i <= ub1;i++)
        	for(int j = 0;j <= ub2;j++){
        		tmp = matrix[j][i];
        		matrix[j][i] = matrix[n-1-i][j];
        		matrix[n-1-i][j] = matrix[n-1-j][n-1-i];
        		matrix[n-1-j][n-1-i] = matrix[i][n-1-j];
        		matrix[i][n-1-j] = tmp;
        	}
    }
}
