package nju.ics.lixiaofan.algorithm;

public class AddTwoNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode ph = new ListNode(2), p = ph;
		p.next = new ListNode(4);
		p = p.next;
		p.next = new ListNode(3);
		
		ListNode qh = new ListNode(5), q = qh;
		q.next = new ListNode(6);
		q = q.next;
		q.next = new ListNode(4);
		
		ListNode r = addTwoNumbers(ph, qh);
		for(ListNode a = r;a != null; a = a.next)
			System.out.println(a.val);
	}


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

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}