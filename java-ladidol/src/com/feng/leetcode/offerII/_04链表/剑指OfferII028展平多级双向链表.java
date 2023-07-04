package com.feng.leetcode.offerII._04链表;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/6/16 17:36
 * @description: {}
 */
public class 剑指OfferII028展平多级双向链表 {

    class Solution {
        /**
         * 先序遍历
         */
        List<Node> list = new LinkedList<>();

        public Node flatten(Node head) {
            //dfs，类比树的先序遍历
            dfs(head);
            for (int i = 0; i < list.size() - 1; i++) {
                Node pre = list.get(i);
                Node cur = list.get(i + 1);
                pre.next = cur;
                cur.prev = pre;
                pre.child = null;
//                pre.next = null;//注意把最后一个值null

            }
            return head;
        }

        void dfs(Node node) {
            if (node == null) return;
            list.add(node);
            dfs(node.child);//左
            dfs(node.next);//右
//            node.child = null;//注意需要把node的child置空
        }

    }

    /**
     * 双向链表，val 有child 和前后指针。
     */
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    ;


}
