package com.dyw.leetcode.simple.list;

/**
 * @author Devil
 * @since 2022-07-19-10:46
 *
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
@SuppressWarnings("all")
public class L206反转链表 {
    public static void main(String[] args) {

    }

    /**
     * 头插法法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode();
        newHead.next = null;

        while (head != null){
            ListNode node = new ListNode(head.val);
            node.next = newHead.next;
            newHead.next = node;
            head = head.next;
        }

        return head.next;
    }
}
