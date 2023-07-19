package com.feng.leetcode.offer._03双指针;

public class 剑指Offer18删除链表的节点 {


    //递归帅的一批
    class Solution {
        public ListNode deleteNode(ListNode head, int val) {
            if (head == null) return null;
            if (head.val == val) return head.next;
            head.next =  deleteNode(head.next, val);//更新下一个节点
            return head;
        }
    }
}
