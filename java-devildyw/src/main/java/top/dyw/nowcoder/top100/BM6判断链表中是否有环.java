package top.dyw.nowcoder.top100;

/**
 * @author Devil
 * @since 2022-12-14-10:11
 */
@SuppressWarnings("all")
public class BM6判断链表中是否有环 {

    public static void main(String[] args) {
        System.out.println(new BM6判断链表中是否有环().hasCycle(null));
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        //快慢指针 相同起始位置 但是每次移动的距离不同 如果存在环快慢指针一定会相遇
        ListNode slow = head;
        ListNode fast = head;

        //如果能满足快指针的条件 那么慢指针也一定满足
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
