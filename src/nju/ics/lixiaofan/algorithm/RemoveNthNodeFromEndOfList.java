package nju.ics.lixiaofan.algorithm;

import nju.ics.lixiaofan.structure.ListNode;

/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        for(int i = 0;i < n;i++)
            p = p.next;
        if(p == null)
            return head.next;
        
        ListNode q = head;
        while(p.next != null){
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return head;
    }
}
