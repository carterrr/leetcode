package redo;

import java.util.HashMap;
import java.util.Map;

public class LRU缓存_146 {
}
class LRUCache {
    // get put O1  -> hashMap
    // LRU  -> list
    Map<Integer, DoubleEndListNode> map;
    DoubleEndList list;
    int capacity;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        list = new DoubleEndList();
        this.capacity = capacity;
    }

    public int get(int key) {
        DoubleEndListNode node = map.get(key);
        if(node == null) return -1;
        int val = node.val;
        list.move2Head(node);
        return val;
    }

    public void put(int key, int value) {
        DoubleEndListNode node = map.get(key);
        if(node != null) {
            node.val = value;
            list.move2Head(node);
            return;
        }
        if(map.size() == capacity) {
            // remove tail
            DoubleEndListNode remove = list.removeLast();
            if(remove != null) {
                map.remove(remove.key);
            }
        }
        DoubleEndListNode newNode = new DoubleEndListNode(key, value);
        list.addHead(newNode);
        map.put(key, newNode);
    }

    // 双端链表用于将某个Node前后连接起来
    private class DoubleEndListNode{
        DoubleEndListNode prev;
        DoubleEndListNode next;
        int val;
        int key;

        DoubleEndListNode() {}
        DoubleEndListNode(int key, int val) {this.key = key; this.val = val;}
    }

    private class DoubleEndList{
        DoubleEndListNode head;
        DoubleEndListNode tail;
        DoubleEndList() {
            head = new DoubleEndListNode();
            tail = new DoubleEndListNode();
            head.next = tail;
            tail.prev = head;
        }

        public void move2Head(DoubleEndListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            addHead(node);
        }

        public DoubleEndListNode removeLast() {
            DoubleEndListNode remove = tail.prev;
            DoubleEndListNode last = tail.prev.prev;
            if(last == null) return null;
            last.next = tail;
            tail.prev = last;
            return remove;
        }

        public void addHead(DoubleEndListNode node) {
            node.next = head.next;
            node.prev = head;
            head.next = node;
            node.next.prev = node;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */