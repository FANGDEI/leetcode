package top.dyw.leetcode.Hot100;

import java.util.HashMap;
import java.util.Map;

public class L146LRU缓存 {
    class LRUCache {
        int size;
        int capacity;
        Map<Integer, DLinkedNode> map;
        DLinkedNode head;
        DLinkedNode tail;

        class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;

            public DLinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }

            public DLinkedNode() {}
        }

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            this.map = new HashMap<Integer, DLinkedNode>(capacity);
            this.head = new DLinkedNode();
            this.tail = new DLinkedNode();
            this.head.next = tail;
            this.tail.prev = head;
        }

        public int get(int key) {
            DLinkedNode node = map.get(key);
            if (node==null) {
                return -1;
            }

            moveToHead(node);
            return node.value;
        }

        private void addToHead(DLinkedNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addToHead(node);
        }

        private DLinkedNode removeTail() {
            DLinkedNode res = tail.prev;
            removeNode(res);
            return res;
        }

        public void put(int key, int value) {
            DLinkedNode node = map.get(key);
            if (node == null) {
                // 新增
                DLinkedNode newNode = new DLinkedNode(key, value);
                map.put(key, newNode);
                addToHead(newNode);
                ++size;
                if (size > capacity) {
                    DLinkedNode tail = removeTail();
                    map.remove(tail.key);
                    --size;
                }
            } else {
                node.value = value;
                moveToHead(node);
            }
        }
    }
}
