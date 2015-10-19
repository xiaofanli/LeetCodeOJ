package nju.ics.lixiaofan.algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
 */
public class UniquePathsII {
	//bfs
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1)
        	return 0;
        int h = obstacleGrid.length, w = obstacleGrid[0].length;
        Queue<Cell> queue = new LinkedList<Cell>();
        HashMap<Integer, Integer> weight = new HashMap<Integer, Integer>();
        queue.add(new Cell(0, 0));
        while(!queue.isEmpty()){
        	int size = queue.size();
        	weight.clear();
        	while(size > 0){
        		Cell cell = queue.poll();
        		if(cell.x == h-1 && cell.y == w-1)
        			return cell.w;
        		size--;
        		if(cell.x+1 < h && obstacleGrid[cell.x+1][cell.y] == 0){
        			int key = (cell.x+1)*w+cell.y;
        			if(weight.containsKey(key))
        				weight.put(key, weight.get(key)+cell.w);
        			else
        				weight.put(key, cell.w);
        		}
        		if(cell.y+1 < w && obstacleGrid[cell.x][cell.y+1] == 0){
        			int key = cell.x*w+cell.y+1;
        			if(weight.containsKey(key))
        				weight.put(key, weight.get(key)+cell.w);
        			else
        				weight.put(key, cell.w);
        		}
        	}
        	for(Map.Entry<Integer, Integer> entry : weight.entrySet()){
        		queue.add(new Cell(entry.getKey()/w, entry.getKey()%w, entry.getValue()));
        	}
        }
        return 0;
    }
    
    class Cell{
    	int x,y;
    	int w = 1;
    	public Cell(int a, int b) {
    		x = a;
    		y = b;
		}
    	public Cell(int a, int b, int w) {
    		x = a;
    		y = b;
    		this.w = w;
		}
    }
}
