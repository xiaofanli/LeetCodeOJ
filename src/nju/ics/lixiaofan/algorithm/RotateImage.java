package nju.ics.lixiaofan.algorithm;
/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
 */
public class RotateImage {
	public static void main(String[] args) {
		RotateImage a = new RotateImage();
		int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
		a.rotate(mat);
		for(int[] row : mat){
			for(int n : row)
				System.out.print(n+" ");
			System.out.println();
		}
	}
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
