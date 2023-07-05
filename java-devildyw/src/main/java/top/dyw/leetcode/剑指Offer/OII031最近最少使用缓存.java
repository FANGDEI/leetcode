package top.dyw.leetcode.剑指Offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Devildyw
 * @date 2023/07/05 11:59
 **/
@SuppressWarnings("all")
public class OII031最近最少使用缓存 {

    public static void main(String[] args) {

    }

    /**
     * LRU:最近最少使用缓存：Least Recently Used Cache 也就是说最近最少使用的缓存会被优先淘汰
     * 可以用栈来想 新加入的或者被命中的缓存就放在栈顶，栈底就是最近最少使用的缓存，如果超过容量了优先淘汰栈底元素
     *
     *
     * 哈希表+双向链表
     */
    class LRUCache {

        //定义双向链表
        class DLinkedNode{
            //根据题目要求定义的值区域
            int key;
            int value;
            //前驱
            DLinkedNode prev;
            //后继
            DLinkedNode next;

            public DLinkedNode(){}

            public DLinkedNode(int _key, int _value){
                key = _key;
                value = _value;
            }
        }

        //定义变量
        private Map<Integer,DLinkedNode> cache = new HashMap<>();

        private int size;

        private int capacity;

        private DLinkedNode head,tail;

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            //使用伪头部
            head = new DLinkedNode();
            tail = new DLinkedNode();

            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node==null){
                return -1;
            }

            //如果key存在，先通过哈希表定位，再移到表头
            moveToHead(node);
            return node.value;
        }

        //将命中的节点移动到链表头部
        private void moveToHead(DLinkedNode node) {
            //移除节点，再将节点添加到头部
            removeNode(node);
            addToHead(node);
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

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);
            if (node==null){
                //如果key不存在,创建一个新的节点
                DLinkedNode newNode = new DLinkedNode(key,value);
                //添加进hash表
                cache.put(key,newNode);
                //添加至双向链表的头部
                addToHead(newNode);
                //size++
                size++;
                if (size>capacity){
                    //如果超出容量，，删除双向链表的尾部节点
                    DLinkedNode tail = removeTail();
                    //删除hash表中的项
                    cache.remove(tail.key);
                    --size;
                }
            }else{
                node.value = value;
                moveToHead(node);
            }
        }

        //移除尾部元素
        private DLinkedNode removeTail() {
            DLinkedNode prev = tail.prev;
            removeNode(prev);
            return prev;
        }
    }
}
