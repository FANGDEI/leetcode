package com.feng.leetcode.hot100._03链表;


public class h206反转链表 {

    class Solution1 {
        public ListNode reverseList(ListNode head) {
            return reverseListNode(null, head);

        }

        public ListNode reverseListNode(ListNode pre, ListNode cur) {
            if (cur == null) {
                return pre;//最后一个节点
            }
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
            return reverseListNode(pre, cur);

        }


    }


    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode next;
            while (head != null) {
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            return pre;
        }
    }


    class Solution2 {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode next;
            while (head!=null){
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            return pre;
        }


    }


}
