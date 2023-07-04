package com.feng.leetcode.offerII._04链表;

import com.feng.newline.list.ListNode;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/6/15 17:20
 * @description: {}
 */
public class 剑指OfferII024反转链表 {


    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode dummy = null;
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
            }
            return pre;
        }
    }
}
