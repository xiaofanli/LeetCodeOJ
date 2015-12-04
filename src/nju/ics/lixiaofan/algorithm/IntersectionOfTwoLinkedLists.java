package nju.ics.lixiaofan.algorithm;

import nju.ics.lixiaofan.structure.ListNode;

/*Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 ¡ú a2
                   	¨K
                     c1 ¡ú c2 ¡ú c3
                   	¨J            
B:     b1 ¡ú b2 ¡ú b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.*/
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        int lenA = 0, lenB = 0;
        ListNode p = headA;
        while(p != null){
            lenA++;
            p = p.next;
        }
        p = headB;
        while(p != null){
            lenB++;
            p = p.next;
        }
        if(lenA > lenB){
            for(int i = 0;i < lenA - lenB;i++)
                headA = headA.next;
        }
        else{
            for(int i = 0;i < lenB - lenA;i++)
                headB = headB.next;
        }
        
        while(headA != null){
            if(headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
