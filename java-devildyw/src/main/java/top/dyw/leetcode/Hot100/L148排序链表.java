package top.dyw.leetcode.Hot100;

public class L148排序链表 {
    public ListNode sortList(ListNode head) {
        // 合并两个有序链表
        ListNode dummyNode = new ListNode(-1, head);
        ListNode cur = head;
        int length = 0;
        while(cur!=null) {
            length++;
            cur = cur.next;
        }


        int sublength = 1;
        while (sublength < length) {
            ListNode pre = dummyNode;
            cur = dummyNode.next;
            while (cur!=null) {
                ListNode head1 = cur;
                for (int i=1; i<sublength&&cur.next!=null; i++) {
                    cur = cur.next;
                }
                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                for (int i = 1; i<sublength&&cur!=null; i++) {
                    cur = cur.next;
                }

                ListNode next = null;
                if (cur!=null) {
                    next = cur.next;
                    cur.next = null;
                }

                // 至此断开了两个链表了 开始merge
                pre.next = mergeList(head1, head2);
                // 进入下一个循环
                cur = next;

                while (pre.next!=null) {
                    pre = pre.next;
                }
            }
            sublength <<= 1;
        }
        return dummyNode.next;
    }

    public ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1, null);
        ListNode cur = dummyNode;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }

        return dummyNode.next;
    }
}
