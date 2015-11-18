package nju.ics.lixiaofan.algorithm;

import nju.ics.lixiaofan.structure.ListNode;

/*
Given a singly linked list L: L0��L1������Ln-1��Ln,
reorder it to: L0��Ln��L1��Ln-1��L2��Ln-2����

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return;
        
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode tail = slow, tmp, tmp2;
        fast = tail.next;
        tail.next = null;
        while(fast != null){
            tmp = fast.next;
            fast.next = slow;
            slow = fast;
            fast = tmp;
        }
        
        fast = head;
        while(slow != tail){
            tmp = slow.next;
            tmp2 = fast.next;
            slow.next = fast.next;
            fast.next = slow;
            slow = tmp;
            fast = tmp2;
        }
    }
}
