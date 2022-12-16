package com.dyw.nowcoder.top100;

/**
 * @author Devil
 * @since 2022-12-15-12:16
 */
@SuppressWarnings("all")
public class BM9删除链表的倒数第n个节点 {

    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode cur = dummyNode;

        while (n-->0){
            cur = cur.next;
        }

        while (cur.next!=null){
            cur = cur.next;
            pre = pre.next;
        }

        pre.next = pre.next.next;

        return dummyNode.next;

    }

    class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
