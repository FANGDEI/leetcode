package top.dyw.leetcode.Hot100;

public class L24两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(-1, head);
        ListNode pre = dummyNode;
        ListNode cur = dummyNode;

        while(true) {
            int n = 2;
            while(n>0 && cur != null) {
                cur = cur.next;
                n--;
            }

            if (cur==null) {
                break;
            }

            //开始反转
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

    public ListNode reverseList(ListNode tail) {
        ListNode head = null;
        while(tail != null) {
            ListNode next = tail.next;
            tail.next = head;
            head = tail;
            tail = next;
        }
        return head;
    }
}
