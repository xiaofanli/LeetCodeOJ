package nju.ics.lixiaofan.algorithm;
/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapNodesInPairs {
	public static void main(String[] args) {

	}
    public ListNode swapPairs(ListNode head) {
    	if(head == null || head.next == null)
    		return head;
    	ListNode newHead = head.next, p = head, q = newHead, tmp;
    	while(true){
    		tmp = q.next;
    		q.next = p;
    		if(tmp == null){
    			p.next = null;
    			break;
    		}
    		else if(tmp.next == null){
    			p.next = tmp;
    			break;
    		}
    		else{
    			p.next = tmp.next;
    			p = tmp;
    			q = tmp.next;
    		}
    	}
    	return newHead;
    }
    
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
