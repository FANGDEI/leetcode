package com.dyw.leetcode.剑指Offer;

/**
 * @author Devil
 * @since 2023-03-01-10:08
 */
@SuppressWarnings("all")
public class O24反转链表 {

    public static void main(String[] args) {

    }

    /**
     * 改变指针指向的方法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        //临时节点用于记录顺序的下一个节点
        ListNode temp = null;
        //前驱节点用于记录反转前的前驱 也是最后反转后的头结点
        ListNode prev = null;
        ListNode cur = head;
        while (cur!=null){
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        return prev;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList01(ListNode head) {

        ListNode prev = null;
        ListNode temp = null;
        ListNode cur = head;

        while (cur!=null){
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }


}
