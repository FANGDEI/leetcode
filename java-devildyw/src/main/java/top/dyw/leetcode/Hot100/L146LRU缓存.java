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

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            this.map = new HashMap<Integer, DLinkedNode>(capacity);
            this.head = new DLinkedNode(-1, -1, null, null);
            this.tail = new DLinkedNode(-1,-1, null, null);
            this.head.next = tail;
            this.tail.prev = head;
        }

        public int get(int key) {
            // get 去map里面找 如果找到了就就放到双向链表末尾
            if (map.containsKey(key)) {
                DLinkedNode node = map.get(key);
                // 断开 并接到末尾
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.prev = tail.prev;
                node.next = tail;
                tail.prev.next = node;
                tail.prev = node;
                return node.value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            // 先判断是否存在
            if (map.containsKey(key)) {
                DLinkedNode node = map.get(key);
                // 断开 并接到末尾
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.prev = tail.prev;
                node.next = tail;
                tail.prev.next = node;
                tail.prev = node;
                node.value = value;
            } else {
                // 不存在直接接到末尾
                DLinkedNode newNode = new DLinkedNode(key, value, null, null);
                newNode.prev = tail.prev;
                newNode.next = tail;
                tail.prev.next = newNode;
                tail.prev = newNode;
                map.put(key, newNode);
                size++;
                if (size > capacity) {
                    //剔除节点
                    DLinkedNode deleteNode = head.next;
                    map.remove(deleteNode.key);
                    head.next = deleteNode.next;
                    deleteNode.next.prev = head;
                    size--;
                }
            }
        }

        class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;

            public DLinkedNode(int key, int value, DLinkedNode prev, DLinkedNode next) {
                this.key = key;
                this.value = value;
                this.prev = prev;
                this.next = next;
            }
        }
    }
}
