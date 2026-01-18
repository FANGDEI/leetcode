/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyNode = new ListNode(-1, head);
        ListNode pre = dummyNode, cur = dummyNode;

        while(cur != null) {
            int count = k;
            while(count>0 && cur != null) {
                count--;
                cur = cur.next;
            }

            if (cur == null) {
                break;
            }

            ListNode next = cur.next;
            cur.next = null;

            ListNode tail = pre.next;
            pre.next = reverseList(tail);

            tail.next = next;
            pre = tail;
            cur = tail;
        }

        return dummyNode.next;
    }

    public ListNode reverseList(ListNode tail) {
        ListNode head = null;
        while (tail != null) {
            ListNode next = tail.next;
            tail.next = head;
            head = tail;
            tail = next;
        }
        return head;
    }
}
// @lc code=end

