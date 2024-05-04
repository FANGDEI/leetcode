package com.feng.leetcode.hot100._03链表;

public class h25K个一组翻转链表 {


    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode tail = head;
            for (int i = 0; i < k; i++) {
                //剩余数量小于k的话，则不需要反转。
                if (tail == null) {
                    return head;
                }
                tail = tail.next;
            }
            // 反转前 k 个元素
            ListNode newHead = reverse(head, tail);
            //下一轮的开始的地方就是tail
            head.next = reverseKGroup(tail, k);

            return newHead;
        }

        public ListNode reverse(ListNode head, ListNode tail) {
            ListNode pre = null;
            ListNode next;
            while (head != tail) {
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            return pre;
        }


    }


}
