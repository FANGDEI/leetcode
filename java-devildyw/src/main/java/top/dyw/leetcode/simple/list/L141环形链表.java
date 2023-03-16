package top.dyw.leetcode.simple.list;

/**
 * @author Devil
 * @since 2022-07-17-10:19
 * <p>
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递。仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 */
@SuppressWarnings("all")
public class L141环形链表 {
    public static void main(String[] args) {

    }

    /**
     * 快慢指针, 快慢指针速度不同又因为如果是环形列表 通过这种关系最后快慢指针一定会相遇了 所以判断最后快慢指针是否相遇判断。
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        //防止出现空链表情况 同时也要检测head.next是否为空 不仅防止出现空指针异常 也可以提前判断是否是环形链表
        if (head == null || head.next == null) {
            return false;
        }
        ListNode cur = head, pre = head.next;
        while (pre != null && pre.next != null) {
            if (cur.val == pre.val) {
                return true;
            }
            pre = pre.next;
            cur = cur.next.next;
        }
        return false;
    }
}
