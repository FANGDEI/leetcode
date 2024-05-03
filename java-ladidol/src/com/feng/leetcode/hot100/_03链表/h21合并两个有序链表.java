package com.feng.leetcode.hot100._03链表;

public class h21合并两个有序链表 {


    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode preHead = new ListNode(-1);
            ListNode pre = preHead;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    pre.next = l1;
                    l1 = l1.next;
                } else {
                    pre.next = l2;
                    l2 = l2.next;
                }
                //移动pre指针
                pre = pre.next;
            }
            //对于一边走完的情况
            pre.next = l1 == null ? l2 : l1;
            return preHead.next;
        }
    }

}
