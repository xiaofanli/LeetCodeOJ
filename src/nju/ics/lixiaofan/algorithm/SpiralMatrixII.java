package nju.ics.lixiaofan.algorithm;
/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int x = 0, y = 0, xmin = 0, xmax = n-1, ymin = 0, ymax = n-1, dir = 0, size = n*n;
        for(int i = 1;i <= size;i++){
            mat[y][x] = i;
            switch(dir){
            case 0:
                if(x+1 > xmax){
                    dir = 1;
                    y++;
                    ymin++;
                }
                else
                    x++;
                break;
            case 1:
                if(y+1 > ymax){
                    dir = 2;
                    x--;
                    xmax--;
                }
                else
                    y++;
                break;
            case 2:
                if(x-1 < xmin){
                    dir = 3;
                    y--;
                    ymax--;
                }
                else
                    x--;
                break;
            case 3:
                if(y-1 < ymin){
                    dir = 0;
                    x++;
                    xmin++;
                }
                else
                    y--;
                break;
            }
        }
        return mat;
    }
}
