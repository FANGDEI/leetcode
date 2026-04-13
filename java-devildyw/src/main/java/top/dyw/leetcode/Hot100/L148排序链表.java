package top.dyw.leetcode.Hot100;

public class L148排序链表 {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            length++;
        }

        ListNode dummyNode = new ListNode(-1,head);

        int subLength = 1;
        while (subLength < length) {
            ListNode pre = dummyNode;
            cur = dummyNode.next;
            while (cur != null) {
                ListNode head1 = cur;
                for (int i=1; i<subLength&&cur.next!=null; i++) {
                    cur = cur.next;
                }
                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                for (int i=1; i<subLength&&cur!=null; i++) {
                    cur = cur.next;
                }

                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;
                }

                pre.next = mergeList(head1, head2);

                cur = next;
                while (pre.next != null) {
                    pre = pre.next;
                }
            }
            subLength<<=1;
        }
        return dummyNode.next;

    }

    public ListNode mergeList(ListNode head1, ListNode head2) {
        ListNode dummyNode = new ListNode(-1);

        ListNode cur = dummyNode;
        while (head1!=null && head2!=null) {
            if (head1.val < head2.val) {
                cur.next = new ListNode(head1.val);
                head1 = head1.next;
            } else {
                cur.next = new ListNode(head2.val);
                head2 = head2.next;
            }

            cur = cur.next;
        }

        if (head1!=null) {
            cur.next = head1;
        }

        if (head2!= null) {
            cur.next = head2;
        }

        return dummyNode.next;
    }
}
