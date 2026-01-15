package top.dyw.leetcode.Hot100;


public class L19删除链表的倒数第N个结点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1,head);
        ListNode pre = dummyNode, cur = dummyNode.next;
        while(n > 0) {
            cur = cur.next;
            n--;
        }


        while (cur!=null) {
            pre = pre.next;
            cur = cur.next;
        }

        pre.next = pre.next.next;

        return dummyNode.next;

    }
}
