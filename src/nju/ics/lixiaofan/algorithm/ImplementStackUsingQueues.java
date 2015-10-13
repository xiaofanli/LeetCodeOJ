package nju.ics.lixiaofan.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/*
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */
public class ImplementStackUsingQueues {
    Queue<Integer> q = new LinkedList<Integer>();
    Integer cache = null;
    // Push element x onto stack.
    public void push(int x) {
        int size = q.size();
        q.add(x);
        if(cache != null){
            q.add(cache);
            cache = null;            
        }
        for(int i = 0;i < size;i++)
            q.add(q.poll());
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(cache != null)
            cache = null;
        else
            q.poll();
    }

    // Get the top element.
    public int top() {
        if(cache == null)
            cache = q.poll();
        return cache;            
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return cache == null && q.isEmpty();
    }
}
