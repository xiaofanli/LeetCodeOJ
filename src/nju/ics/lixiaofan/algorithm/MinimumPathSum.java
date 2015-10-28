package nju.ics.lixiaofan.algorithm;
/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid == null)
            return 0;
        int m = grid.length, n = grid[0].length;
        if(m == 0 || n == 0)
            return 0;
        int[][] min = new int[m][n];
        for(int i = 0;i < m;i++)
            for(int j = 0;j < n;j++)
                min[i][j] = Integer.MAX_VALUE;
        
        min[m-1][n-1] = grid[m-1][n-1];
        return minPathSum(0, 0, grid, min);
    }
    
    private int minPathSum(int x, int y, int[][] grid, int[][] min){
        if(min[x][y] != Integer.MAX_VALUE)
            return min[x][y];
        int sum = Integer.MAX_VALUE;
        if(x+1 < grid.length){
            if(min[x+1][y] == Integer.MAX_VALUE)
                min[x+1][y] = minPathSum(x+1, y, grid, min);
            sum = grid[x][y] + min[x+1][y];
        }
        if(y+1 < grid[0].length){
             if(min[x][y+1] == Integer.MAX_VALUE)
                min[x][y+1] = minPathSum(x, y+1, grid, min);
            sum = Math.min(sum, grid[x][y] + min[x][y+1]);
        }
        return sum;
    }
}
