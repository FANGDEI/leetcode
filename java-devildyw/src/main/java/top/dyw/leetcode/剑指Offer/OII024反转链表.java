package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/06/13 19:59
 **/
@SuppressWarnings("all")
public class OII024反转链表 {

    public static void main(String[] args) {

    }

    /**
     * 两种做法 之一：反转指针法，该法的空间复杂度很低
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
