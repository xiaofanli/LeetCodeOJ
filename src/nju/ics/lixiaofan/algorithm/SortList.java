package nju.ics.lixiaofan.algorithm;

import nju.ics.lixiaofan.structure.ListNode;
/*
Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null)
            return null;
//      return quickSort(head, null);
        return mergeSort(head);
    }
    
    private ListNode mergeSort(ListNode head){
        if(head.next == null)
            return head;
        ListNode fast = head, slow = head, prev = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;
        ListNode l1 = mergeSort(head);
        ListNode l2 = mergeSort(slow);
        return mergeTwoLists(l1, l2);
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        else if(l2 == null)
            return l1;
        
        ListNode head = l1.val <= l2.val ? l1 : l2;
        ListNode p1 = l1, p2 = l2, tmp;
        while(p1 != null && p2 != null){
            if(p1.val <= p2.val){
                while(p1.next != null && p1.next.val <= p2.val)
                    p1 = p1.next;
                tmp = p1.next;
                p1.next = p2;
                p1 = tmp;
            }
            else{
                while(p2.next != null && p1.val > p2.next.val)
                    p2 = p2.next;
                tmp = p2.next;
                p2.next = p1;
                p2 = tmp;
            }
        }
        return head;
    }
    
    @SuppressWarnings("unused")
	private ListNode quickSort(ListNode head, ListNode tail){
        ListNode p = head.next, prev = head, newHead = head;
        int pivot = head.val;
        while(p != tail){
            if(p.val < pivot){
                ListNode tmp = p;
                while(p.next != tail && p.next.val < pivot)
                    p = p.next;
                prev.next = p.next;
                p.next = newHead;
                newHead = tmp;
                p = prev.next;
            }
            else{
                prev = p;
                p = p.next;
            }
        }
        if(newHead != head)
            newHead = quickSort(newHead, head);
        if(head.next != tail)
            head.next = quickSort(head.next, tail);
        
        return newHead;
    }
}
