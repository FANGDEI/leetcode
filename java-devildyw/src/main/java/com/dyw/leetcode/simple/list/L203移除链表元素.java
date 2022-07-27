package com.dyw.leetcode.simple.list;

/**
 * @author Devil
 * @since 2022-07-17-10:54
 * <p>
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * <img src="https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/image-20220717112144591.png">
 */
@SuppressWarnings("all")
public class L203移除链表元素 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(6);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next.next = new ListNode(6);

        ListNode listNode1 = new L203移除链表元素().removeElements(listNode, 6);
        while (listNode1 != null) {
            System.out.println(listNode1.val + " ");
            listNode1 = listNode1.next;
        }
    }

    /**
     * 迭代
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode Head = new ListNode(0, head);
        ListNode prev = Head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return Head.next;
    }
}
