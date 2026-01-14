/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null || headB==null) {
            return null;
        }
        // 链表a 未相交链表节点数记为a 链表b相交链表节点数为b
        // 相交部分节点数为c
        // a+c = m b+c=n
        // 如果有相交的部分 且m != n 那么a!=b 那么有一个链表一定先到达终点
        // 这时在两个链表走到末尾时再分别走对方的路 就得到 a + c + b = b + c + a 所以一定同时经过相交的点 直到结束。
        // 并且及时没有相交的 也有m+n = n+m 到时同时为null 也不会出现死循环
        ListNode p1 = headA, p2 = headB;
        while(p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }

        return p1;
    }
}
// @lc code=end

