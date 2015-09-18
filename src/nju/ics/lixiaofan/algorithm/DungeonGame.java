package nju.ics.lixiaofan.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/*
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.


Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

-2 (K)	-3		3
-5		-10		1
10		30		-5 (P)

Notes:

The knight's health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 */
public class DungeonGame {
	public static void main(String[] args) {
		int[][] d = { { -2, -3, 3 }, { -5, -10, 1 }};
		DungeonGame dg = new DungeonGame();
		System.out.println(dg.calculateMinimumHP(d));
	}
	
	int m, n;
	int[][] minhp, dungeon;
	public int calculateMinimumHP(int[][] dungeon) {
		m = dungeon.length;
		n = dungeon[0].length;
		if(m == 1 && n == 1)
			return dungeon[0][0] < 0 ? 1-dungeon[0][0] : 1;
			
		minhp = new int[m][n];
		this.dungeon = dungeon;
		for(int i = 0;i < m;i++)
			for(int j = 0;j < n;j++){
				minhp[i][j] = 0;
			}
		
		return calMinHP(0, 0);
    }
	
	public int calMinHP(int x, int y){
		if(x == m-1 && y == n-1){
			return dungeon[x][y] < 0 ? 1-dungeon[x][y] : 1;
		}
		
		if(x < m-1 && minhp[x+1][y] == 0)
			minhp[x+1][y] = calMinHP(x+1, y);
		if(y < n-1 && minhp[x][y+1] == 0)
			minhp[x][y+1] = calMinHP(x, y+1);
		
		if(x == m-1){
			return (dungeon[x][y] > 0 && minhp[x][y+1] <= dungeon[x][y]) ? 1 : minhp[x][y+1]-dungeon[x][y];
		}
		else if(y == n-1){
			return (dungeon[x][y] > 0 && minhp[x+1][y] <= dungeon[x][y]) ? 1 : minhp[x+1][y]-dungeon[x][y];
		}
		else{
			int min = minhp[x+1][y] < minhp[x][y+1] ? minhp[x+1][y] : minhp[x][y+1];
			return (dungeon[x][y] > 0 && min <= dungeon[x][y]) ? 1 : min-dungeon[x][y];
		}
	}
}
