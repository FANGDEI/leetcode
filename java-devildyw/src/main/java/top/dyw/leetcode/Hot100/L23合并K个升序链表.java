package top.dyw.leetcode.Hot100;

public class L23合并K个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        // 归并排序
        int n = lists.length;
        if (n==0) {
            return null;
        }
        int sublength = 1;
        while(sublength < n) {
            for (int i=0; i<n; i+=2*sublength) {
                ListNode head1 = lists[i];
                ListNode head2 = null;
                if (i+sublength<n) {
                    head2 = lists[i+sublength];
                }

                lists[i] = mergeList(head1, head2);
            }
            sublength <<= 1;
        }
        return lists[0];
    }

    public ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1, null);
        ListNode cur = dummyNode;

        while(l1!=null && l2!=null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1!=null) {
            cur.next = l1;
        }
        if (l2!=null) {
            cur.next = l2;
        }

        return dummyNode.next;
    }
}
