package com.dyw.leetcode.algorithm.doublePointer;


/**
 * @author Devil
 * @since 2022-07-15-16:39
 * <p>
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 */
@SuppressWarnings("all")
public class L876链表的中间结点 {
    public static void main(String[] args) {

    }

    /**
     * 快慢指针法 slow指针每次走1 而fast指针每次走2 这样当fast走到末尾时slow刚好走到中间节点
     * 其他方法还有：转化为数组解法 两次遍历（第一次记录节点数目）法 这些都会就不解释了
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        //因为fast每次走两步 所以这里需要判断两个情况
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
