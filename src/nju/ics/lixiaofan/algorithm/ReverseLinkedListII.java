package nju.ics.lixiaofan.algorithm;

import nju.ics.lixiaofan.structure.ListNode;

/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ¡Ü m ¡Ü n ¡Ü length of list.
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	ListNode newHead = head, l = null, p = head;
    	int idx = 1;
    	for(;idx < m;idx++){
    		l = p;
    		p = p.next;
    	}
    	ListNode mp = p, q = p.next, tmp;
    	while(idx < n){
    		tmp = q.next;
    		q.next = p;
    		p = q;
    		q = tmp;
    		idx++;
    	}
    	
    	if(l == null)
    		newHead = p;
    	else
    		l.next = p;
    	
    	mp.next = q;
    	return newHead;
    }
}
