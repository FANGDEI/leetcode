package com.feng.newline.list;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.list
 * @className: L142环形链表II
 * @author: Ladidol
 * @description: 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数
 * pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。
 * 注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 示例:
 * 输入：head = [3,2,0,-4], (pos = 1)
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * @date: 2023年2月22日21:18:07
 * @version: 1.0
 */
public class L142环形链表II {
    /**
     * 不难发现，用双指针来做， 快指针和慢指针如果速度有二倍关系就一定会相遇的。Vfast = 2 * Vslow， 有证明的。
     * https://programmercarl.com/0142.%E7%8E%AF%E5%BD%A2%E9%93%BE%E8%A1%A8II.html#%E6%80%9D%E8%B7%AF
     * 说实话有点复杂了.
     *
     * @param:
     * @return:
     * @Author: Ladidol
     */
    public class Solution1 {
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {// 有环
                    ListNode index1 = fast;
                    ListNode index2 = head;
                    // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
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
    //有一些取巧的方法，这里就不一一指出来了

}
