package nju.ics.lixiaofan.algorithm;

import nju.ics.lixiaofan.structure.ListNode;

/*
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5

Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
    	if(head == null)
    		return null;
    	ListNode p = head , q = head, newHead = head;
    	while(q != null){
    		if(q.val == val){
    			if(p == q){
    				newHead = q = p = q.next;
    			}
    			else{
    				q = p.next = q.next;
    			}
    		}
    		else{
    			p = q;
    			q = q.next;
    		}
    	}
    	return newHead;
    }
}
