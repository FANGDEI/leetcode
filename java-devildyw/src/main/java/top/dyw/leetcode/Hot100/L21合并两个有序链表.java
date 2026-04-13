package top.dyw.leetcode.Hot100;

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
public class L21合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode();
        ListNode p = newHead;

        while (list1!=null && list2!=null) {
            if (list1.val < list2.val) {
                p.next = new ListNode(list1.val);
                list1 = list1.next;

            } else {
                p.next = new ListNode(list2.val);
                list2 = list2.next;
            }

            p = p.next;
        }

        if (list1!=null) {
            p.next = list1;
        }

        if (list2!=null) {
            p.next = list2;
        }

        return newHead.next;
    }
}
// @lc code=end
