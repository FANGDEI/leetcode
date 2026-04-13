package top.dyw.leetcode.Hot100;

public class L2两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode p = dummyNode;
        int c = 0;
        while (l1!=null || l2!=null || c!=0) {
            int val1 = l1==null?0:l1.val;
            int val2 = l2==null?0:l2.val;

            l1 = l1==null?null:l1.next;
            l2 = l2==null?null:l2.next;

            int sum = val1 + val2 + c;
            p.next = new ListNode(sum%10);
            p = p.next;
            c = sum / 10;
        }

        return dummyNode.next;
    }
}
