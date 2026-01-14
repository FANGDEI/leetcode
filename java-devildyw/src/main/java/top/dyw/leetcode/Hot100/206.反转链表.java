/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
    public ListNode reverseList(ListNode head) {
        if (head==null){
            return null;
        }
        
        ListNode cur = head, tail = null;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = tail;
            tail = cur;
            cur = next;
        }
        return tail;
    }
}
// @lc code=end

