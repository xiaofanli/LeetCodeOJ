package nju.ics.lixiaofan.algorithm;

import java.util.LinkedList;
import java.util.List;

/*
	Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
	
	For example,
	Given the following matrix:
	
	[
	 [ 1, 2, 3 ],
	 [ 4, 5, 6 ],
	 [ 7, 8, 9 ]
	]
	You should return [1,2,3,6,9,8,7,4,5].
*/
public class SpiralMatrix {
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new LinkedList<Integer>();
		if(matrix.length == 0)
			return list;
		int tb = 0, bb = matrix.length-1, lb = 0, rb = matrix[0].length-1;
		int x = -1, y = 0, state = 0;
		int totalNum = matrix.length * matrix[0].length;
		while(list.size() < totalNum){
			switch(state){
			case 0:
				if(x < rb){
					x++;
					list.add(matrix[y][x]);
				}
				else{
					state = 1;
					tb++;
				}
				break;
			case 1:
				if(y < bb){
					y++;
					list.add(matrix[y][x]);
				}
				else{
					state = 2;
					rb--;
				}
				break;
			case 2:
				if(x > lb){
					x--;
					list.add(matrix[y][x]);
				}
				else{
					state = 3;
					bb--;
				}
				break;
			case 3:
				if(y > tb){
					y--;
					list.add(matrix[y][x]);
				}
				else{
					state = 0;
					lb++;
				}
				break;
			}
		}
		
		return list;
    }

}
