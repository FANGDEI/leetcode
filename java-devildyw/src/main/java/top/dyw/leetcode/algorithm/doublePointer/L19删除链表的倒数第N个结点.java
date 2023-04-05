package top.dyw.leetcode.algorithm.doublePointer;

/**
 * @author Devil
 * @since 2022-07-15-17:06
 * <p>
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
@SuppressWarnings("all")
public class L19删除链表的倒数第N个结点 {
    public static void main(String[] args) {

    }

    /**
     * 前后指针 截用前指针走过n个距离 再同时遍历前后指针使的前指针到达末尾后指针到达倒数第n个节点前一个节点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //自己初始化一个一个头结点
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;

        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}
