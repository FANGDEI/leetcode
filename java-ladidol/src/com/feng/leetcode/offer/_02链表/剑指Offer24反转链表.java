package com.feng.leetcode.offer._02链表;

public class 剑指Offer24反转链表 {

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode dummy = new ListNode(-1);
            while (head != null) {
                ListNode tmp = head.next;
                head.next = dummy.next;//更新当前节点新next；
                dummy.next = head;//当前头结点
//                head = head.next;//这里不能用head.next了
                head = tmp;
            }

            return dummy.next;
        }
    }


}
