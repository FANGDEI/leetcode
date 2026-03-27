package top.dyw.leetcode.medium.list;

/**
 * @author Devil
 * @since 2022-08-04-12:10
 *
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 */
@SuppressWarnings("all")
public class L82删除排序链表中的重复元素II {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head==null) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1, head);

        ListNode cur = dummyNode.next;
        while (cur.next!=null && cur.next.next!=null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next!=null && cur.next.val==x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }
}
