package top.dyw.leetcode.Hot100;

public class L2两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1, null);
        ListNode cur = dummyNode;
        int c = 0;
        while (l1 != null || l2 != null || c!=0) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;

            int sum = val1 + val2 + c;
            cur.next = new ListNode(sum%10, null);
            cur = cur.next;
            c = sum / 10;


            if (l1!=null) {
                l1 = l1.next;
            }

            if (l2!=null) {
                l2 = l2.next;
            }
        }

        return dummyNode.next;
    }
}
