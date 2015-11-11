package nju.ics.lixiaofan.algorithm;

import nju.ics.lixiaofan.structure.ListNode;
/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        ListNode p = head.next, q;
        while(p != null && p.val == head.val){
            do{
                p = p.next;
            }while(p != null && p.val == head.val);
            head = p;
            if(head == null)
                return null;
            p = head.next;
        }
        
        p = head;
        q = head.next;
        while(q != null){
            if(q.next != null && q.next.val == q.val){
                do{
                    q = q.next;
                }while(q.next != null && q.next.val == q.val);
                p.next = q.next;
                q = q.next;
            }
            else{
                p = q;
                q = q.next;
            }
        }
        
        return head;
    }
}
