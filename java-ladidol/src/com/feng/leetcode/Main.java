package com.feng.leetcode;

import com.feng.newline.list.ListNode;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/4 19:40
 * @description: {}
 */
public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode reverse = new Main().reverse(head);



    }
    public ListNode reverse(ListNode head){
        ListNode dumpHead = new ListNode(-1);
        dumpHead.next = head;
        ListNode preNode = dumpHead;
        ListNode curNode = head;

        while(curNode.next!=null&&preNode.next!=null){
            ListNode tmp = curNode.next;
            curNode.next.next = preNode.next;
            preNode.next.next = tmp;
            preNode.next = curNode;

        }
        return dumpHead.next;
    }



}
