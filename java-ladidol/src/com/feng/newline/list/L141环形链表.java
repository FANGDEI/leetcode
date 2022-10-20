package com.feng.newline.list;

import java.util.List;

/**
 * @author: ladidol
 * @date: 2022/10/8 14:39
 * @description: 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
 * 评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例2：
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * 提示：
 * <p>
 * 链表中节点的数目范围是 [0, 104]
 * -105 <= Node.val <= 105
 * pos 为 -1 或者链表中的一个 有效索引 。
 */
public class L141环形链表 {
    public class Solution1 {
        /**
         * 参数：[head]
         * 返回值：boolean
         * 作者： ladidol
         * 描述：和环形链表II一样的
         */
        public boolean hasCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            if (fast == null || fast.next == null) return false;//只有一个节点的情况。
            fast = fast.next.next;
            slow = slow.next;

            while (fast != null && fast.next != null) {
                if (fast == slow) {
                    return true;
                }
                fast = fast.next.next;
                slow = slow.next;
            }
            return false;
        }
    }

    //快慢指针
    public class Solution {
        /**
         * 参数：[head]
         * 返回值：boolean
         * 作者： ladidol
         * 描述：复习一下2022年10月18日13:08:17
         */
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) return false;
            ListNode fast = head;
            ListNode slow = head;
            slow = slow.next;
            fast = fast.next.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) return true;
            }
            return false;
        }
    }


}