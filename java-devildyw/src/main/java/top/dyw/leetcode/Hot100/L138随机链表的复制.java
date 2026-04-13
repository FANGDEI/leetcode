package top.dyw.leetcode.Hot100;

public class L138随机链表的复制 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyNode = new ListNode(-1, head);
        ListNode pre = dummyNode;
        ListNode cur = dummyNode;

        while (cur != null) {
            int n = k;
            while (cur != null && n-->0) {
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
            cur = tail;
            pre = tail;
        }

        return dummyNode.next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head!=null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }

        return newHead;
    }
}
