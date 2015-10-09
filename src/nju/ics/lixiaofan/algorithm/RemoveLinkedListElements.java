package nju.ics.lixiaofan.algorithm;

import nju.ics.lixiaofan.structure.ListNode;

/*
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5

Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.
 */
public class RemoveLinkedListElements {
	public static void main(String[] args) {
		int[] vals = {6,6,6,6,6,6,6};
		ListNode head = new ListNode(vals[0]), p = head;
		int i = 1;
		while(i < vals.length){
			p.next = new ListNode(vals[i++]);
			p = p.next;
		}
		p.next = null;
		
		RemoveLinkedListElements rlle = new RemoveLinkedListElements();
		ListNode newHead = rlle.removeElements(head, 6);
		for(ListNode q = newHead;q != null;q = q.next)
			System.out.print(q.val+" ");
			
	}
    public ListNode removeElements(ListNode head, int val) {
    	if(head == null)
    		return null;
    	ListNode p = head , q = head, newHead = head;
    	while(q != null){
    		if(q.val == val){
    			if(p == q){
    				newHead = q = p = q.next;
    			}
    			else{
    				q = p.next = q.next;
    			}
    		}
    		else{
    			p = q;
    			q = q.next;
    		}
    	}
    	return newHead;
    }
}
