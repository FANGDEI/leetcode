package com.jirafa.leetcode.algorithm.剑指;

import com.jirafa.leetcode.utils.ListNode;

public class 剑指24 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next==null)
            return head;
        ListNode newNode = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return newNode;
    }
}
