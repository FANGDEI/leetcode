package com.feng.leetcode.hot100._03链表;

public class h24两两交换链表中的节点 {

    //画图显然
    class Solution {
        //更换当前cur和cur.next节点，注意总共有四个节点的参与
        //我们需要换位置的是第二个节点和第三个节点
        public ListNode swapPairs(ListNode head) {
            ListNode dummyNode = new ListNode(-1, head);
            ListNode cur = head;
            ListNode pre = dummyNode;

            while (cur != null && cur.next != null) {


                ListNode one = cur;
                ListNode two = cur.next;

                ListNode forthNode = two.next;
                pre.next = two;
                two.next = one;
                one.next = forthNode;

                pre = one;
                cur = one.next;

            }

            return dummyNode.next;
        }


    }
}
