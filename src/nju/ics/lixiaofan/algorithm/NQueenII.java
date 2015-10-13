package nju.ics.lixiaofan.algorithm;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.
 */
public class NQueenII {
    public int totalNQueens(int n) {
    	if(n < 2)
    		return n == 1 ? 1 : 0;
        int num = 0;
        boolean backtrack = false;
    	Stack<Coord> stack = new Stack<Coord>();
        Set<Integer> x = new HashSet<Integer>(), sum = new HashSet<Integer>(), diff = new HashSet<Integer>();
        stack.push(new Coord(0, 0));
        x.add(0);
        diff.add(0);
        while(!stack.isEmpty()){
//        	for(Coord c : stack)
//        		System.out.println(c.x+" "+c.y);
//        	System.out.println();
        	if(backtrack){
        		Coord c = stack.pop();
        		x.remove(c.x);
        		sum.remove(c.x+c.y);
        		diff.remove(c.x-c.y);
        		for(int i = c.x+1;i < n;i++)
        			if(x.contains(i) || sum.contains(i+c.y) || diff.contains(i-c.y))
        				continue;
        			else{
        				c.x = i;
        				stack.push(c);
        				x.add(c.x);
                		sum.add(c.x+c.y);
                		diff.add(c.x-c.y);
                		backtrack = false;
                		break;
        			}
        	}
        	else if(stack.size() == n-1){
        		for(int i = 0;i < n;i++)
        			if(x.contains(i) || sum.contains(i+n-1) || diff.contains(i-n+1))
        				continue;
        			else
        				num++;
        		backtrack = true;
        	}
        	else{
        		Coord c = stack.peek();
        		backtrack = true;
        		for(int i = 0;i < n;i++)
        			if(x.contains(i) || sum.contains(i+c.y+1) || diff.contains(i-c.y-1))
        				continue;
        			else{
        				stack.push(new Coord(i, c.y+1));
        				x.add(i);
                		sum.add(i+c.y+1);
                		diff.add(i-c.y-1);
                		backtrack = false;
                		break;
        			}
        		
        	}
        }
        return num;
    }
    
    private static class Coord{
		int x, y;
    	public Coord(int i, int j) {
    		x = i;
    		y = j;
		}
    }
}
