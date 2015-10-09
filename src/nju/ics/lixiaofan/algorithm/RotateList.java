package nju.ics.lixiaofan.algorithm;

import nju.ics.lixiaofan.structure.ListNode;

/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0)
        	return head;
        
        int len = 1;
        ListNode rear = head;
        while(rear.next != null){
        	rear = rear.next;
        	len++;
        }
        if(len == 1)
        	return head;
        
        k %= len;
        if(k == 0)
        	return head;
        
        rear.next = head;
        for(len -= k;len > 0;len--)
        	rear = rear.next;
        head = rear.next;
        rear.next = null;
        return head;
    }
}
