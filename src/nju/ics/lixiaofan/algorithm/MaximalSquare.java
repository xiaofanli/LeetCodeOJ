package nju.ics.lixiaofan.algorithm;

/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
 */
public class MaximalSquare {
	/*
	A DP solution
	It's actually to keep recording the max n*n window at each cell of the matrix.
	At each cell, we define that the dynamic programming status at that cell is - if I am the most right-bottom guy of a square, 
	how big the square I can build. With this definition, this status will be transferable to the guys, left, below, and right below me.
	 */
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int result = 0;
        int[][] count = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i ++) {
            count[i][0] = matrix[i][0] == '0' ? 0 : 1;
            result = Math.max(result, count[i][0]);
        }
        for(int i = 0; i < matrix[0].length; i ++) {
            count[0][i] = matrix[0][i] == '0' ? 0 : 1;
            result = Math.max(result, count[0][i]);
        }

        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == '0') {
                    count[i][j] = 0;
                    continue;
                }
				count[i][j] = Math.min(
						Math.min(count[i - 1][j - 1], count[i - 1][j]),
						count[i][j - 1]) + 1;
                result = Math.max(result, count[i][j]);
            }
        }
        return result * result;
    }
}
