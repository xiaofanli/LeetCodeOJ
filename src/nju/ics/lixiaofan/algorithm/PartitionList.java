package nju.ics.lixiaofan.algorithm;

import nju.ics.lixiaofan.structure.ListNode;

/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null)
            return head;
        ListNode h1 = null, t1 = null, h2 = null, p = head, q = null;
        
        while(p != null){
            if(p.val < x){
                if(h1 == null)
                    h1 = p;
                while(p.next != null && p.next.val < x)
                    p = p.next;
                
                if(t1 != null)
                    t1.next = q.next;
                t1 = p;
                if(q != null)
                    q.next = p.next;
                if(h2 != null)
                    p.next = h2;
            }
            else if(h2 == null)
                h2 = p;
            
            q = p;
            p = p.next;
        }
        
        return h1 != null ? h1 : h2;
    }
}
