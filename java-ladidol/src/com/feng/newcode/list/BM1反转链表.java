package com.feng.newcode.list;

import com.feng.newline.list.ListNode;

public class BM1反转链表 {

    public class Solution {
        /**
         * 通过tmp节点保存下一个节点，进行从前往后一个节点一个节点的放入新的列表
         *
         * @param head
         * @return
         */
        public ListNode ReverseList(ListNode head) {
            ListNode newHead = null;
            while (head != null) {
                ListNode tmp = head.next;
                head.next = newHead;
                newHead = head;
                head = tmp;
            }
            return newHead;
        }
    }

}
