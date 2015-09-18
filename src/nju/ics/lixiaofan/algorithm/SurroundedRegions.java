package nju.ics.lixiaofan.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
 */
public class SurroundedRegions {
	public static void main(String[] args) {
		char[][] board = {
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', },
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', },
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', },
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', },
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', },
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', },
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', },
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', },
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', },
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', },
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', },
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', },
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', },
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', },
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', },
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', },
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', },
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', },
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', },
				{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', } };		
		SurroundedRegions sr = new SurroundedRegions();
//		long start = System.currentTimeMillis();
		sr.solve(board);
//		System.out.println(System.currentTimeMillis() - start);
//		System.out.println(sum);
		for(int i = 0;i < board.length;i++){
			for(int j = 0;j < board[0].length;j++){
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	static long sum = 0;
    public void solve(char[][] board) {
    	if(board.length == 0 || board[0].length == 0)
    		return;
    	int h = board.length, w = board[0].length;
        Queue<Grid> queue = new LinkedList<Grid>();
        for(int i = 0;i < h;i++){
        	if(board[i][0] == 'O'){
        		board[i][0] = '.';
        		queue.add(new Grid(i, 0));
        	}
        	if(board[i][w-1] == 'O'){
        		board[i][w-1] = '.';
        		queue.add(new Grid(i, w-1));
        	}
        }
    	for(int j = 0;j < w;j++){
    		if(board[0][j] == 'O'){
    			board[0][j] = '.';
    			queue.add(new Grid(0, j));
    		}
    		if(board[h-1][j] == 'O'){
    			board[h-1][j] = '.';
    			queue.add(new Grid(h-1, j));
    		}
    	}
        
        int x, y;
        while(!queue.isEmpty()){
        	Grid grid = queue.poll();
        	x = grid.x;
        	y = grid.y;
//        	System.out.println(x+" "+y);
//        	start = System.currentTimeMillis();
        	if(x > 0 && board[x-1][y] == 'O'){
        		board[x-1][y] = '.';
        		queue.add(new Grid(x-1, y));
        	}
        	if(x < h-1 && board[x+1][y] == 'O'){
        		board[x+1][y] = '.';
        		queue.add(new Grid(x+1, y));
        	}
        	if(y > 0 && board[x][y-1] == 'O'){
        		board[x][y-1] = '.';
        		queue.add(new Grid(x, y-1));
        	}
        	if(y < w-1 && board[x][y+1] == 'O'){
        		board[x][y+1] = '.';
        		queue.add(new Grid(x, y+1));
        	}
//        	sum += System.currentTimeMillis() - start;
        }
//        sum += System.currentTimeMillis() - start;
        
        for(int i = 0;i < h;i++)
        	for(int j = 0;j < w;j++)
        		if(board[i][j] == '.')
        			board[i][j] = 'O';
        		else if(board[i][j] == 'O')
        			board[i][j] = 'X';
    }
    
    class Grid{
    	int x, y;
    	public Grid(int a, int b) {
    		x = a;
    		y = b;
		}
    }
}
