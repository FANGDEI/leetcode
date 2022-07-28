package com.dyw.leetcode.simple.arrays;

import java.util.HashSet;

/**
 * @author Devil
 * @date 2022-04-30-12:15
 * <p>
 * <p>
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 */
@SuppressWarnings("all")
public class L141环形链表 {
    /**
     * 哈希表做法
     * HashSet的add方法 会返回一个布尔值 如果集合中没有该元素那么返回true 并且将元素添加入集合 返回false则相反
     */
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> listNodes = new HashSet<>();
        while (head != null) {
            if (!listNodes.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针 如果是环形列表 那么当快指针和慢指针都进入 环形循环时 总有一刻 快指针会追上慢指针
     */
    public boolean hasCycle01(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}