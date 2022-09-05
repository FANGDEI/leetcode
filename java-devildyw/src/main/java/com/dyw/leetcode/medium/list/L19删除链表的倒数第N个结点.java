package com.dyw.leetcode.medium.list;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 * @author Devil
 * @since 2022-09-05-10:17
 */
@SuppressWarnings("all")
public class L19删除链表的倒数第N个结点 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        System.out.println(new L19删除链表的倒数第N个结点().removeNthFromEnd(listNode, 2));
    }

    /**
     * 双指针
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //涉及到节点删除 最好使用虚拟头结点 辅助
        ListNode dummy = new ListNode(0,head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        //先让 快指针走 n步 这样当快慢指针一起走的时候 快指针到达末尾时 满指针也到达了倒数第n的位置
        while (n-->0){
            fast = fast.next;
        }

        //记住 待删除节点slow的上一个节点
        ListNode prev = null;
        //快慢指针一起走
        while (fast!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        //当fast走到了 null时 slow刚好指向倒数第n的位置

        //上一节点的next指针绕过 待删除节点 slow 直接指向slow
        prev.next = slow.next;
        return dummy.next;
    }
}
