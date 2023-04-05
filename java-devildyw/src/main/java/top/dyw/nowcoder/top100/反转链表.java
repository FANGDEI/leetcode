package top.dyw.nowcoder.top100;

/**
 * @author Devil
 * @since 2022-12-12-19:27
 */
@SuppressWarnings("all")
public class 反转链表 {

    public static void main(String[] args) {

    }


    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 双指针
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;

        while (cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        return prev;
    }

}
