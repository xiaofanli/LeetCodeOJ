package nju.ics.lixiaofan.algorithm;

import nju.ics.lixiaofan.structure.ListNode;

/*
Reverse a singly linked list.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
    	if(head == null || head.next == null)
    		return head;
    	ListNode p = head, q = head.next, r;
    	head.next = null;
    	while(q != null){
    		r = q.next;
    		q.next = p;
    		p = q;
    		q = r;
    	}
    	return p;
    }
}
