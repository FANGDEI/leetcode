package top.dyw.leetcode.Hot100;

public class L82删除排序链表中的重复元素II {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1, head);
        ListNode prev = dummyNode;

        while (prev.next!=null && prev.next.next!=null) {
            if (prev.next.val == prev.next.next.val) {
                int x = prev.next.val;
                ListNode cur = prev.next;
                while (cur!=null && cur.val == x) {
                    cur = cur.next;
                }
                prev.next = cur;
            } else {
                prev = prev.next;
            }
        }

        return dummyNode.next;
    }
}
