package nju.ics.lixiaofan.algorithm;

import nju.ics.lixiaofan.structure.ListNode;

public class AddTwoNumbers {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int sum,  c = 0;
		ListNode p = l1, q = l2, head = new ListNode(-1), ret = head;
		int v1 = p.val, v2 = q.val;
		while(true){
			sum = v1 + v2 + c;
			ret.next = new ListNode(sum % 10);
			ret = ret.next;
			c = sum / 10;
			
			p = p.next;
			q = q.next;
			if(p != null)		
				v1 = p.val;
			else
				break;
			
			if(q != null)			
				v2 = q.val;
			else
				break;
		}
		ListNode z;
		if(p != null)
			z = p;
		else if(q != null)
			z = q;
		else{
			if(c > 0)
				ret.next = new ListNode(c);
			return head.next;
		}
		v1 = z.val;
		while(c > 0){
			sum = v1 + c;
			ret.next = new ListNode(sum % 10);
			ret = ret.next;
			c = sum / 10;
			
			z = z.next;
			if(z != null)
				v1 = z.val;
			else{
				if(c > 0){
					ret.next = new ListNode(c);
					return head.next;
				}
			}
		}
		if(z != null){
			ret.next = z;
		}
		return head.next;
	}
}