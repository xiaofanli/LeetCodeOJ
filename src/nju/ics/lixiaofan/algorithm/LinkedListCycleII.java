package nju.ics.lixiaofan.algorithm;

import nju.ics.lixiaofan.structure.ListNode;

/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if(head==null) return head;
        ListNode cur = head;
        ListNode fast = head.next;
        // same as idea as LinkedList Cycle I, try to detect a loop
        while(fast != null && fast.next != null) {
            if(fast == cur) { // loop detected.
                fast = fast.next;
                int loopSize = 1;
                while(fast!=cur) { // find the loop size
                    fast = fast.next;
                    loopSize++;
                }
                fast = head;  // start from head again
                cur = head;
                for(int i = loopSize; i > 0; i--) { //this time, put fast node "loopSize" ahead
                    fast = fast.next;
                }
                while(cur!=fast){
                    cur=cur.next;
                    fast = fast.next;
                }
                return cur;
            }
            fast = fast.next.next;
            cur = cur.next;
        }
        return null;
    }
}
