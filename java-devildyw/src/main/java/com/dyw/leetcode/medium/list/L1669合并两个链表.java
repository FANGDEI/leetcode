package com.dyw.leetcode.medium.list;

import com.dyw.leetcode.medium.tree.L199二叉树的右视图;

/**
 * @author Devil
 * @since 2023-01-30-10:49
 */
@SuppressWarnings("all")
public class L1669合并两个链表 {

    public static void main(String[] args) {
        ListNode rootnode = new ListNode(0);
        rootnode.next = new ListNode(1);
        rootnode.next.next = new ListNode(2);
        rootnode.next.next.next = new ListNode(3);
        rootnode.next.next.next.next = new ListNode(4);
        rootnode.next.next.next.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1000000);
        list2.next = new ListNode(1000001);
        list2.next.next = new ListNode(1000002);
        ListNode listNode = new L1669合并两个链表().mergeInBetween(rootnode, 3, 4, list2);

        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummyNode = new ListNode(0,list1);

        ListNode prev = dummyNode;
        int index = 0;
        while (index<a){
            prev = prev.next;
            index++;
        }
        ListNode beh = prev;
        while (index<=b){
            beh = beh.next;
            index++;
        }

        prev.next = list2;

        ListNode p2 = list2;
        while (p2.next!=null){
            p2 = p2.next;
        }

        p2.next = beh.next;

        return dummyNode.next;
    }
}
