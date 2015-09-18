package nju.ics.lixiaofan.algorithm;

/*
Reverse a singly linked list.
 */
public class ReverseLinkedList {
	public static void main(String[] args) {

	}
    public ListNode reverseList(ListNode head) {
    	if(head == null || head.next == null)
    		return head;
    	ListNode p = head, q = head.next, r;
    	head.next = null;
    	while(q != null){
    		r = q.next;
    		q.next = p;
    		p = q;
    		q = r;
    	}
    	return p;
    }
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
}
