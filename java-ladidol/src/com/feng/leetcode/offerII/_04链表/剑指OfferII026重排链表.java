package com.feng.leetcode.offerII._04链表;

import com.feng.newline.list.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/6/16 16:45
 * @description: {}
 */
public class 剑指OfferII026重排链表 {

    //我选择双端队列
    class Solution {
        /**
         * @param head
         */
        public void reorderList(ListNode head) {
            //先用双端队列，存入listNode
            Deque<ListNode> deque = new ArrayDeque<>();
            ListNode cur = head;
            while (cur != null) {
                deque.offer(cur);
                cur = cur.next;
            }
            cur = head;
            //理解题也，就是一个是最前的节点，下一个节点就是最后一个节点，注意对每一个cur.next切断关系
            for (int i = 0; !deque.isEmpty(); i++) {
                cur.next = i % 2 == 0 ? deque.pollFirst() : deque.pollLast();
                cur = cur.next;
                cur.next = null;//藕断丝也断。
            }
        }
    }


}
