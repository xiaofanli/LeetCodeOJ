package nju.ics.lixiaofan.algorithm;

import java.util.Stack;

/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/
public class WordSearch {
	public boolean exist(char[][] board, String word) {
		if(word == null || word.equals(""))
			return false;
		Stack<Char> stack = new Stack<Char>();
		boolean[][] isInUse = new boolean[board.length][board[0].length];
		for(int i = 0;i < board.length;i++)
			for(int j = 0;j < board[0].length;j++){
				isInUse[i][j] = false;
				if(word.charAt(0) == board[i][j])
					stack.push(new Char(word.charAt(0), i , j));
			}
		
		Char ch;
		int idx = 0;
		while(!stack.isEmpty()){
			ch = stack.peek();
			if(ch.visited){
				stack.pop();
				idx--;
				isInUse[ch.row][ch.col] = false;
				continue;
			}
			isInUse[ch.row][ch.col] = ch.visited = true;
			idx++;
			if(idx == word.length())
				return true;
			
			char nextc = word.charAt(idx);
			if(ch.row > 0 && !isInUse[ch.row-1][ch.col] && nextc == board[ch.row-1][ch.col])
				stack.add(new Char(nextc, ch.row-1, ch.col));
			if(ch.row < board.length-1 && !isInUse[ch.row+1][ch.col] && nextc == board[ch.row+1][ch.col])
				stack.add(new Char(nextc, ch.row+1, ch.col));	
			if(ch.col > 0 && !isInUse[ch.row][ch.col-1] && nextc == board[ch.row][ch.col-1])
				stack.add(new Char(nextc, ch.row, ch.col-1));
			if(ch.col < board[0].length-1 && !isInUse[ch.row][ch.col+1] && nextc == board[ch.row][ch.col+1])
				stack.add(new Char(nextc, ch.row, ch.col+1));
		}
		return false;
	}
	
	class Char{
		public Char(char c, int i, int j) {
			this.c = c;
			row = i;
			col = j;
			visited = false;
		}
		char c;
		int row, col;
		boolean visited;
	}
}
