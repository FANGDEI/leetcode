package top.dyw.leetcode.Hot100;

public class L234回文链表 {

    public boolean isPalindrome(ListNode head) {
        if (head==null || head.next==null) {
            return true;
        }
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //反转slow链表
        ListNode halfReverseHead = reverseList(slow);
        ListNode cur = head;
        while (cur!=null) {
            if (cur.val != halfReverseHead.val) {
                return false;
            }
            cur = cur.next;
            halfReverseHead = halfReverseHead.next;
        }

        return true;
    }

    public ListNode reverseList(ListNode slow) {
        ListNode head = null;
        while(slow != null) {
            ListNode next = slow.next;
            slow.next = head;
            head = slow;
            slow = next;
        }

        return head;
    }
}
