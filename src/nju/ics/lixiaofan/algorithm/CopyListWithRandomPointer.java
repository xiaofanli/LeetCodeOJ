package nju.ics.lixiaofan.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
        	return null;
    	HashMap<RandomListNode, Set<RandomListNode>> map = new HashMap<RandomListNode, Set<RandomListNode>>();
    	HashMap<RandomListNode, RandomListNode> map2 = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode p = head.next, newp = new RandomListNode(head.label), newHead = newp;
        if(head.random == null)
        	newp.random = null;
        else{
        	map.put(head.random, new HashSet<RandomListNode>());
        	map.get(head.random).add(newp);
        }
        map2.put(head, newp);
        
        while(p != null){
        	newp.next = new RandomListNode(p.label);
        	newp = newp.next;
        	if(p.random == null)
        		newp.random = null;
        	else{
        		if(!map.containsKey(p.random))
        			map.put(p.random, new HashSet<RandomListNode>());
        		map.get(p.random).add(newp);
        	}
        	map2.put(p, newp);
        	p = p.next;
        }
        
        for(Map.Entry<RandomListNode, Set<RandomListNode>> entry : map.entrySet()){
    		for(RandomListNode node : entry.getValue())
    			node.random = map2.get(entry.getKey());
        }
        return newHead;
    }
    
	public class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};
}
