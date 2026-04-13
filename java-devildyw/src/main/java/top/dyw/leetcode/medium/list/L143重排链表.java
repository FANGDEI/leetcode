package top.dyw.leetcode.medium.list;

/**
 * @author Devil
 * @since 2022-08-08-11:17
 *
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 */
@SuppressWarnings("all")
public class L143重排链表 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        new L143重排链表().reorderList(listNode);
        ListNode p = listNode;
        while (p!=null){
            System.out.println(p.val);
            p = p.next;
        }
    }


    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode l1 = head;
        ListNode l2 = slow.next;

        slow.next = null;
        l2 = reverseList(l2);

        while (l1!=null && l2 != null) {
            ListNode l1_temp = l1.next;
            ListNode l2_temp = l2.next;

            l1.next = l2;
            l2.next = l1_temp;

            l1 = l1_temp;
            l2 = l2_temp;
        }

    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head!=null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
