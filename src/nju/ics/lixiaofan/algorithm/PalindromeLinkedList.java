package nju.ics.lixiaofan.algorithm;

import nju.ics.lixiaofan.structure.ListNode;

/*
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        int num = 0;
        ListNode p = head, q, r;
        while(p != null){
            num++;
            p = p.next;
        }
        if(num < 2)
            return true;
        
        int half = (num - 1) / 2;
        q = p = head;
        r = head.next;
        head.next = null;
        for(int i = 0;i < half;i++){
        	//change link direction from start to the middle
            q = p;
            p = r;
            r = r.next;
            p.next = q;
        }
        
        if(num % 2 == 1)
            p = p.next;
        while(p != null){
            if(p.val != r.val)
                return false;
            p = p.next;
            r = r.next;
        }
        return true;
    }
}
