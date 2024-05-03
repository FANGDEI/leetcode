package com.feng.leetcode.hot100._03链表;

public class h142环形链表 {

    //复习一下
    public class Solution {
        /**
         * 参数：[head]
         * 返回值：com.feng.newline.list.ListNode
         * 作者： ladidol
         * 描述：快慢指针
         */
        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null) return null;
            ListNode fast = head;
            ListNode slow = head;
            //先遍历得到圈的接入点
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) break;
            }
            if (fast != slow) return null;
            fast = head;
            //最后重置fast指针，让他们再次相遇就行了
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
    }



}
