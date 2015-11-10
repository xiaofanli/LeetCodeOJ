package nju.ics.lixiaofan.algorithm;

import java.util.HashMap;
import java.util.Map;
/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */
public class LRUCache {
    private Map<Integer, Node> map = null;
    private Node head = null, tail = null;
    private int capacity = 0;
    public LRUCache(int capacity) {
        map = new HashMap<Integer, Node>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        if(node.prev != null){
            node.prev.next = node.next;
            if(node.next != null)
                node.next.prev = node.prev;
            else
                tail = node.prev;
            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;
        }
        return node.value;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            if(node.prev != null){
                node.prev.next = node.next;
                if(node.next != null)
                    node.next.prev = node.prev;
                else
                    tail = node.prev;
                node.prev = null;
                node.next = head;
                head.prev = node;
                head = node;
            }
        }
        else{
            Node node = new Node(key, value);
            if(map.size() < capacity){
                if(map.size() > 0){
                    node.next = head;
                    head.prev = node;
                    head = node;
                }
                else
                    head = tail = node;
            }
            else{
                map.remove(tail.key);
                node.next = head;
                head.prev = node;
                head = node;
                tail.prev.next = null;
                tail = tail.prev;
            }
            map.put(key, node);
        }
    }
    
    private class Node{
        int key, value;
        Node next = null, prev = null;
        
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}
