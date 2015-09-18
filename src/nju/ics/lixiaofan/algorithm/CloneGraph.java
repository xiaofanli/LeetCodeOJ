package nju.ics.lixiaofan.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


/*
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
*/
public class CloneGraph {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "0,1,2#1,2#2,2";
		String[] strs = str.split("#");
		System.out.println(strs.length);
	}

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node == null)
			return null;
		List<UndirectedGraphNode> list = new LinkedList<UndirectedGraphNode>();
		list.add(node);
		UndirectedGraphNode n, newn, newneighbor, head = null;
		HashMap<Integer, UndirectedGraphNode> t = new HashMap<Integer, UndirectedGraphNode>();
		boolean first = true;
		Set<UndirectedGraphNode> handled = new HashSet<UndirectedGraphNode>();
		while(!list.isEmpty()){
			n = list.remove(0);
			handled.add(n);
			if(t.containsKey(n.label)){
				newn = t.get(n.label);
			}
			else{
				newn = new UndirectedGraphNode(n.label);
				t.put(n.label, newn);
				if(first){
					first = false;
					head = newn;
				}
			}
			for(UndirectedGraphNode neighbor : n.neighbors){
				if(!handled.contains(neighbor) && !list.contains(neighbor))
					list.add(neighbor);
				if(t.containsKey(neighbor.label)){
					newneighbor = t.get(neighbor.label);
				}
				else{
					newneighbor = new UndirectedGraphNode(neighbor.label);
					t.put(neighbor.label, newneighbor);
				}
				newn.neighbors.add(newneighbor);
			}
		}
		return head;
	}
	
	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};

}
