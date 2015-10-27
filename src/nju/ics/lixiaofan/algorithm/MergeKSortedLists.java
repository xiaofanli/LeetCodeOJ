package nju.ics.lixiaofan.algorithm;

import java.util.ArrayList;
import java.util.List;

import nju.ics.lixiaofan.structure.ListNode;

public class MergeKSortedLists {
	public static void main(String[] args) {
		ListNode[] lists = new ListNode[4];
		ListNode node;
		int[][] nums = {{-8,-7,-6,-3,-2,-2,0,3},{-10,-6,-4,-4,-4,-2,-1,4},{-10,-9,-8,-8,-6},{-10,0,4}};
		for(int i = 0;i < nums.length;i++){
			node = lists[i] = new ListNode(nums[i][0]);
			for(int j = 1;j < nums[i].length;j++){
				node.next = new ListNode(nums[i][j]);
				node = node.next;
			}
		}
		
		MergeKSortedLists a = new MergeKSortedLists();
		node = a.mergeKLists(lists);
		while(node != null){
			System.out.print(node.val+" ");
			node = node.next;
		}
		System.out.println();
	}
	
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        List<ListNode> window = new ArrayList<ListNode>();
        for(ListNode list : lists)
            insert(list, window);
        if(window.size() == 0)
            return null;
        
        ListNode head = null, tail = null;
        head = tail = window.remove(0);
        if(tail.next != null)
            insert(tail.next, window);
        
        while(window.size() > 1){
            tail.next = window.remove(0);
            
            tail = tail.next;
            if(tail.next != null)
                insert(tail.next, window);
        }    
        if(window.size() > 0)
            tail.next = window.remove(0);
        
        return head;
    }
    
    private void insert(ListNode node, List<ListNode> window){
        if(node == null)
            return;
        int l = 0, r = window.size()-1, mid;
        while(l <= r){
            mid = (l + r) / 2;
            if(window.get(mid).val > node.val)
                r = mid - 1;
            else if(window.get(mid).val < node.val)
                l = mid + 1;
            else{
            	l = mid;
            	break;
            }
        }
        window.add(l, node);
    }
}
