package com.dyw.leetcode.medium.list;

import java.util.HashSet;

/**
 * @author Devil
 * @since 2022-08-03-19:10
 * <p>
 * 给定一个链表的头节点 head，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * <p>
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * <p>
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 不允许修改 链表。
 */
@SuppressWarnings("all")
public class L142环形链表II {
    public static void main(String[] args) {

    }

    /**
     * 使用 hash表存储链表节点 每次遍历都去与hash表比较是否之前遍历过
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = head;

        while (cur != null) {
            if (set.contains(cur)) {
                return cur;
            } else {
                set.add(cur);
            }
            cur = cur.next;
        }
        return null;
    }

    /**
     * <img src="https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/202209051128584.png">
     * 由图可知 如果fast指针和slow指针相遇 那么 slow指针走过的节点数为 x+y， fast走过的节点数为 x+y+n(y+z)
     * <p>
     * 因为 fast 是 slow 走的速度的两倍 所以路径也是2倍关系 得到该关系 (x+y)*2 = x+y+n(y+z)
     * <p>
     * 两边消掉一个x+y 得到 x+y = n(y+z)
     * <p>
     * 将x 单独放在左边 x = n(y+z)-y
     * <p>
     * 右边再提出一个y+z --> x = (n-1)(y+z)+z
     * <p>
     * 因为fast和slow至少要一圈才能相遇 所以这里 n 一定是大于等于 1的
     * <p>
     * n取1 得到 x = z
     * <p>
     * 这就意味着 <strong>从头结点出发一个指针，从相遇节点 也出发一个指针，这两个指针每次只走一个节点， 那么当这两个指针相遇的时候就是 环形入口的节点。</strong>
     *
     * <img src="https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/202209051137879.gif">
     *
     * @param head
     * @return
     */
    public ListNode detectCycle01(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { //有环 且这里算是第一次相遇
                ListNode index1 = fast;
                ListNode index2 = head;
                //两个指针，从头结点和相遇节点，各走一步，直到相遇，相遇点即为入口
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }

}
