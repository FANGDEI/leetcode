package com.feng.leetcode.offer._03双指针;

public class 剑指Offer52两个链表的第一个公共节点 {

    //浪漫做法
    public class Solution {
        /**
         * a的长度+b的长度固定
         * 先走a再走b
         * 先走b再走a 总会在一个相等点相遇，要么是一个节点要么是尾部null
         *
         *
         * @param headA
         * @param headB
         * @return
         */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA == null || headB == null) return null;
            ListNode n1 = headA;
            ListNode n2 = headB;

            while(n1 != n2){
                n1 = n1 == null ? headB : n1.next;
                n2 = n2 == null ? headA : n2.next;
            }
            return n1;
        }
    }
}
