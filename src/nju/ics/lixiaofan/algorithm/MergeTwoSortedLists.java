package nju.ics.lixiaofan.algorithm;

import nju.ics.lixiaofan.structure.ListNode;

/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        else if(l2 == null)
            return l1;
        
        ListNode head = l1.val <= l2.val ? l1 : l2;
        ListNode p1 = l1, p2 = l2, tmp;
        while(p1 != null && p2 != null){
            if(p1.val <= p2.val){
                while(p1.next != null && p1.next.val <= p2.val)
                    p1 = p1.next;
                tmp = p1.next;
                p1.next = p2;
                p1 = tmp;
            }
            else{
                while(p2.next != null && p1.val > p2.next.val)
                    p2 = p2.next;
                tmp = p2.next;
                p2.next = p1;
                p2 = tmp;
            }
        }
        return head;
    }
}
