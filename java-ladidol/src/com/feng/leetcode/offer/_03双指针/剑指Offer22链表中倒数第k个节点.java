package com.feng.leetcode.offer._03双指针;

public class 剑指Offer22链表中倒数第k个节点 {


    class Solution{
        /**
         * 先走k步
         * @param head
         * @param k
         * @return
         */
        public ListNode getKthFromEnd(ListNode head, int k) {

            ListNode fast = head, slow = head;
            while (fast != null && k > 0) {
                fast = fast.next;
                k--;
            }

            while (fast != null) {

                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
    }


}
