package com.feng.leetcode.offerII._04链表;

import com.feng.newline.list.ListNode;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/6/14 17:08
 * @description: {}
 */
public class 剑指OfferII021删除链表的倒数第n个结点 {
    class Solution {

        /**
         * 注意用虚拟头结点，来保存头结点的信息
         * @param head
         * @param n
         * @return
         */
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode right = new ListNode(-1);
            ListNode left = new ListNode(-2);//right - left = n；
            ListNode dummy = new ListNode(-3);
            dummy.next = head;
            right = dummy;
            left= dummy;
            while(n-->0){
                right = right.next;
            }
            while(right.next!=null){
                left = left.next;
                right = right.next;
            }
            left.next = left.next.next;//删除倒数第n个节点。
            return dummy.next;
        }
    }
}
