package nju.ics.lixiaofan.algorithm;

import nju.ics.lixiaofan.structure.ListNode;
import nju.ics.lixiaofan.structure.TreeNode;

/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        ListNode slow = head, fast = head, prev = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        if(prev == null)
            head = null;
        else
            prev.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
