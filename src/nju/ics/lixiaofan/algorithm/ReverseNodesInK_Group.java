package nju.ics.lixiaofan.algorithm;

import nju.ics.lixiaofan.structure.ListNode;

/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodesInK_Group {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k < 2)
        	return head;
        
        ListNode p = head, q, r = head, r2, tmp, newHead = head;
        int count = k-1;
        while(count > 0){
    		r = r.next;
    		if(r == null)
    			return newHead;
    		count--;
        }
        newHead = r2 = r;
        while(true){
        	count = k;
        	while(count > 0){
        		r2 = r2.next;
        		if(r2 == null){
        			r2 = r.next;
        			break;
        		}
        		count--;
        	}
        	
        	q = p.next;
        	p.next = r2;
        	r = r.next;
        	while(q != r){
        		tmp = q.next;
        		q.next = p;
        		p = q;
        		q = tmp;
        	}
        	if(r2 == r)
        		break;
        	p = r;
        	r = r2;
        }
        return newHead;
    }
}
