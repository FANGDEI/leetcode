package com.feng.leetcode.hot100._03链表;

import java.util.HashSet;
import java.util.Set;

public class h141环形链表 {

    //快慢指针
    public class Solution222 {
        /**
         * 参数：[head]
         * 返回值：boolean
         * 作者： ladidol
         * 描述：复习一下2022年10月18日13:08:17
         */
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) return false;
            ListNode fast = head;
            ListNode slow = head;
            slow = slow.next;
            fast = fast.next.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) return true;
            }
            return false;
        }
    }

    public class Solution {
        public boolean hasCycle(ListNode head) {
            Set<ListNode> set = new HashSet<ListNode>();
            while (head != null) {
                if (!set.add(head)) {
                    return true;
                }
                head = head.next;
            }
            return false;
        }
    }


}
