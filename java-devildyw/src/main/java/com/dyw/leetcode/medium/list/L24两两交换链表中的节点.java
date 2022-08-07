package com.dyw.leetcode.medium.list;

/**
 * @author Devil
 * @since 2022-08-07-12:48
 * <p>
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
@SuppressWarnings("all")
public class L24两两交换链表中的节点 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);

        ListNode li = new L24两两交换链表中的节点().swapPairs(listNode);
        while (li!=null){
            System.out.println(li.val);
            li = li.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head==null){
            return head;
        }
        ListNode newHead = new ListNode(0, head);
        ListNode p = newHead;
        while (p.next!=null&&p.next.next!=null){
            ListNode pre = p.next, cur = p.next.next;
            pre.next = cur.next;
            cur.next = pre;
            p.next = cur;
            p = p.next.next;
        }

        return newHead.next;
    }
}
