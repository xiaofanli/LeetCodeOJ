package nju.ics.lixiaofan.algorithm;

import java.util.Arrays;

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStack {
	public static void main(String[] args) {

	}
	int[] data = new int[32];
	int count = 0, min = Integer.MAX_VALUE;
    public void push(int x) {
        if(count >= data.length){
        	data = Arrays.copyOf(data, count*2);
        }
        data[count++] = x;
        if(x < min)
        	min = x;
    }

    public void pop() {
        if(count > 0)
        	count--;
        if(data[count] == min){
        	min = Integer.MAX_VALUE;
        	for(int i = 0;i < count;i++)
        		if(data[i] < min)
        			min = data[i];
        }
    }

    public int top() {
        if(count > 0)
        	return data[count-1];
        else
        	return -1;
    }

    public int getMin() {
        return min;
    }
}
