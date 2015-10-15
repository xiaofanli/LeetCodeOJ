package nju.ics.lixiaofan.algorithm;

import nju.ics.lixiaofan.structure.ListNode;

/*
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode p = head, q = p.next;
        while(q != null){
            if(p == q)
                return true;
            p = p.next;
            q = q.next;
            if(q == null)
                return false;
            q = q.next;
        }
        return false;
    }
}
