package nju.ics.lixiaofan.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NQueens {
	public List<String[]> solveNQueens(int n) {
		if(n == 0){
			return null;
		}
		else if(n == 1){
			List<String[]> result = new LinkedList<String[]>();
			String[] board = {"Q"};
			result.add(board);
			return result;
		}
			
		List<String[]> result = new LinkedList<String[]>();
		Stack<Coord> coord = new Stack<Coord>();
		String[] board = new String[n];
		coord.push(new Coord(0, 0));
		board[0] = "Q";
		for(int i = 0;i < n-1;i++)
			board[0] = board[0].concat(".");
		int y = 1;
		while(!coord.isEmpty()){
			Coord c = coord.peek();
			if(y == c.y){
				coord.pop();
				c.x++;
				if(c.x == n){
					y--;
					continue;
				}
			}
			else{
				c = new Coord(0, y);
			}
			boolean found = true;
			for(int x = c.x;x < n;x++){
				found = true;
				for(Coord co : coord)
					if (co.x == x || Math.abs(x - co.x) == Math.abs(y - co.y)) {
						found = false;
						break;
					}
				if(found){
					board[y] = "";
					for(int i = 0;i < x;i++)
						board[y] = board[y].concat(".");
					board[y] = board[y].concat("Q");
					for(int i = x+1;i < n;i++)
						board[y] = board[y].concat(".");
					
					c.x = x;
					coord.push(c);
					if(y < n-1){
						y++;
					}
					else{
						result.add(board.clone());
					}
					break;
				}
			}
			if(!found){
				y--;
			}
		}
		return result;
	}
	
	private class Coord{
		public Coord(int i, int j) {
			x = i;
			y = j;
		}

		public int x, y;
	}
}
