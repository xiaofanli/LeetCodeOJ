package nju.ics.lixiaofan.algorithm;

import nju.ics.lixiaofan.structure.ListNode;

/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {
	public static void main(String[] args) {
		ListNode h1 = new ListNode(3), h2 = new ListNode(2);
		h2.next = new ListNode(4);
		MergeTwoSortedLists a = new MergeTwoSortedLists();
		ListNode x = a.mergeTwoLists(h1, h2);
		while(x != null){
			System.out.println(x.val);
			x = x.next;
		}
	}
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        else if(l2 == null)
            return l1;
        
        ListNode head = l1.val <= l2.val ? l1 : l2;
        ListNode p1 = l1, p2 = l2, q1 = p1, q2 = p2;
        while(q1 != null && q2 != null){
            if(q1.val <= q2.val){
                while(q1 != null && q1.val <= q2.val){
                    p1 = q1;
                    q1 = q1.next;
                }
                p1.next = q2;
            }
            else{
                while(q2 != null && q1.val > q2.val){
                    p2 = q2;
                    q2 = q2.next;
                }
                p2.next = q1;
            }
        }
        return head;
    }
}
