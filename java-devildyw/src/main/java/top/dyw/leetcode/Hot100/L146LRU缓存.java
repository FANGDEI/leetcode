package top.dyw.leetcode.Hot100;

import java.util.HashMap;
import java.util.Map;

public class L146LRU缓存 {
    int size;
    int capacity;
    Map<Integer, DlinkedNode> cache;
    DlinkedNode head;
    DlinkedNode tail;

    public L146LRU缓存(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        cache = new HashMap<Integer, DlinkedNode>(capacity);
        head = new DlinkedNode();
        tail = new DlinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DlinkedNode node = cache.get(key);
        if (node!=null) {
            moveToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        DlinkedNode node = cache.get(key);
        if (node!=null) {
            node.value = value;
            moveToHead(node);
        } else {
            DlinkedNode newNode = new DlinkedNode(key,value);
            cache.put(key, newNode);
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                int res = removeTail();
                cache.remove(res);
                --size;
            }
        }
    }

    class DlinkedNode {
        int key;
        int value;
        DlinkedNode prev;
        DlinkedNode next;

        public DlinkedNode() {}

        public DlinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private void addToHead(DlinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DlinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private int removeTail() {
        DlinkedNode res = tail.prev;
        removeNode(res);
        return res.key;
    }

    private void moveToHead(DlinkedNode node) {
        removeNode(node);
        addToHead(node);
    }
}
