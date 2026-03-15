package top.dyw.leetcode.Hot100;

public class L23合并K个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n==0) {
            return null;
        }

        int subLength = 1;
        while (subLength < n) {
            for (int i=0; i<n; i+=2*subLength) {
                if (i+subLength >= n) {
                    break;
                }
                ListNode head1 = lists[i];
                ListNode head2 = lists[i+subLength];

                lists[i] = mergeList(head1,head2);
            }

            subLength <<=1;
        }

        return lists[0];
    }

    public ListNode mergeList(ListNode head1, ListNode head2) {
        ListNode dummyNode = new ListNode(-1);

        ListNode cur = dummyNode;
        while (head1!=null && head2!=null) {
            if (head1.val < head2.val) {
                cur.next= new ListNode(head1.val);
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

        if (head2!=null) {
            cur.next = head2;
        }
        return dummyNode.next;
    }
}
