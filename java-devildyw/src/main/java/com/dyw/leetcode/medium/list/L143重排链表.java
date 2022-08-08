package com.dyw.leetcode.medium.list;

import java.util.List;

/**
 * @author Devil
 * @since 2022-08-08-11:17
 *
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 */
@SuppressWarnings("all")
public class L143重排链表 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        new L143重排链表().reorderList(listNode);
        ListNode p = listNode;
        while (p!=null){
            System.out.println(p.val);
            p = p.next;
        }
    }


    /**
     * 寻找链表中点+链表逆序+合并链表
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head==null){
            return;
        }
        //寻找链表中点
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null; //将一个链表分为两个单链表
        //翻转l2链表
        l2 = reverseList(l2);
        //合并此时的l1和l2 交替
        mergeList(l1,l2);
    }

    /**
     * 交替合并链表
     * @param l1
     * @param l2
     */
    private void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1!=null&&l2!=null){
            l1_tmp = l1.next;
            l2_tmp = l2.next;
            //交替连接
            l1.next = l2;
            l1 = l1_tmp;
            //l1 -> l2.next -> l1.next 循环
            l2.next = l1;
            l2 = l2_tmp;
        }
    }

    /**
     * 翻转链表
     * @param l2
     * @return
     */
    private ListNode reverseList(ListNode l2) {
        //尾插法
        ListNode prev = null;
        ListNode curr = l2;
        while (curr!=null){
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * 快慢指针寻找中间结点
     * @param head
     * @return
     */
    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
