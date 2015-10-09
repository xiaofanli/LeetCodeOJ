package nju.ics.lixiaofan.algorithm;
/*
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.

Follow up: 
Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 */
public class GameOfLife {
	public static void main(String[] args) {
		GameOfLife a = new GameOfLife();
		int[][] board = { 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 1, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		
		for(int i = 0;i < 10;i++){
			a.gameOfLife(board);
			for(int[] row : board){
				for(int n : row)
					System.out.print((n == 1 ? "X " : "  "));
				System.out.println();
			}
		}
		
	}
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length, count;
    	for(int i = 0;i < m;i++)
    		for(int j = 0;j < n;j++){
    			count = 0;
    			for(int x = i-1;x <= i+1;x++)
					for(int y = j-1;y <= j+1;y++){
						if(x < 0 || x >= m || y < 0 || y >= n || x == i && y == j)
							continue;
						if(board[x][y] == 1 || board[x][y] == -2)
							count++;
					}
    			switch (board[i][j]) {
				case 0:
					if(count == 3)
						board[i][j] = -1;
					break;
				case 1:
					if(count < 2 || count > 3)
						board[i][j] = -2;
					break;
				}
    		}
    	for(int i = 0;i < m;i++)
    		for(int j = 0;j < n;j++)
    			if(board[i][j] < 0)
    				board[i][j] += 2;
    }
}
