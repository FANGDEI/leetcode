package com.feng.newline.month._9_datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.datastructure
 * @className: L146LRU缓存
 * @author: Ladidol
 * @description: 请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字key 已经存在，则变更其数据值value ；如果不存在，则向缓存中插入该组key-value 。如果插入操作导致关键字数量超过capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 * 提示：
 * <p>
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 105
 * 最多调用 2 * 105 次 get 和 put
 * @date: 2022/9/8 11:33
 * @version: 1.0
 */
public class L146LRU缓存 {
    class LRUCache {

        class Node {
            int k, v;
            Node l, r;

            Node(int key, int value) {
                k = key;
                v = value;
            }
        }

        Map<Integer, Node> map;
        int n;
        // 双向链表
        Node head, tail;


        public LRUCache(int capacity) {
            n = capacity;
            // 双向链表初始化
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.r = tail;//头尾节点还不需要出现在圈子里面。
            tail.l = head;
            map = new HashMap<>();
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                refresh(node);
                return node.v;
            }
            return -1;
        }

        public void put(int key, int value) {// 会有删除尾部的情况。
            Node node = null;
            if (map.containsKey(key)) {
                node = map.get(key);
                node.v = value;
                refresh(node);
                map.put(key, node);
            } else {
                if (map.size() == n) {// 满了先删除。
                    Node del = tail.l;
                    delete(del);
                    map.remove(del.k);// node 中的key派上用场了。
                }
                node = new Node(key, value);
                refresh(node);
                map.put(key, node);
            }
        }

        void refresh(Node node) {//先删除，再加到头部。
            if (node.l!=null) //（这里新节点添加就不会delete了）
                delete(node);
            node.l = head;
            node.r = head.r;
            head.r.l = node;
            head.r = node;
        }

        void delete(Node node) {//这里应该node.l一定不会为空的。
            Node left = node.l;
            left.r = node.r;
            node.r.l = left;
        }
    }
}
