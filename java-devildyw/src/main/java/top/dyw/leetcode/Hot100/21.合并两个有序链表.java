/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1, null);
        ListNode cur = dummyNode;
        ListNode p1 = list1, p2 = list2;
        while(p1!=null && p2!=null){
            if (p1.val <= p2.val) {
                cur.next = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
            }

            cur = cur.next;
        }

        if (p1!=null){
            cur.next = p1;
        }
        if (p2!=null) {
            cur.next = p2;
        }
        return dummyNode.next;
    }
}
// @lc code=end

