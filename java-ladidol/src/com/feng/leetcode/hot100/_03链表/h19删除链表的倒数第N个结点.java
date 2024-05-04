package com.feng.leetcode.hot100._03链表;

public class h19删除链表的倒数第N个结点 {

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            //因为可能会删除第一个节点，所以用虚拟节点dummyNode
            ListNode dummyHead = new ListNode(-1);
            ListNode fast = new ListNode(-2);
            ListNode slow = new ListNode(-3);
            dummyHead.next = head;
            fast = dummyHead;
            slow = dummyHead;
            while (n-- > 0) {
                fast = fast.next;
            }
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = slow.next.next;
            return dummyHead.next;


        }
    }


}
