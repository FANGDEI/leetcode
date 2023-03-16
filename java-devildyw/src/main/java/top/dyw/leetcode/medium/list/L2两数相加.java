package top.dyw.leetcode.medium.list;

/**
 * @author Devil
 * @since 2022-08-03-18:52
 * <p>
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 */
@SuppressWarnings("all")
public class L2两数相加 {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tail = head;
        int add = 0;
        while (l1 != null || l2 != null|| add!=0) {
            int a1 = l1 == null ? 0 : l1.val;
            int a2 = l2 == null ? 0 : l2.val;
            int result = a1 + a2 + add;
            tail.next = new ListNode(result%10);
            tail = tail.next;
            add = result/10;

            if (l1!=null){
                l1 = l1.next;
            }
            if (l2!=null){
                l2 = l2.next;
            }
        }
        return head.next;
    }
}
