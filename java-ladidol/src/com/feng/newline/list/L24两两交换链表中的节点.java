package com.feng.newline.list;

import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.list
 * @className: L24两两交换链表中的节点
 * @author: Ladidol
 * @description: 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 * 示例:输入：
 * head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * 解题: 可以分成三个步骤走:
 * 1. 前置节点指向后置节点,
 * 2. 后置节点指向当前节点,
 * 3. 当前节点指向后置节点的后置节点.
 *
 * 可以把一次交换分成三个步骤:
 * @date: 2022/7/2 20:26
 * @version: 1.0
 */
public class L24两两交换链表中的节点 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        //指针真神奇捏。

        ListNode newHead = new L24().swapPairs(head);

        while (newHead != null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

    static class L24 {
        public ListNode swapPairs(ListNode head) {
            if (head==null||head.next==null){//注意先判断存在head没有, 在判断next, 说实话这里可以直接省略的
                return head;
            }
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode pre = dummy;
            ListNode cur = head;


            while(pre.next != null && pre.next.next != null){
                //主要对当前节点和后置节点进行换位, 保留前置节点的角色
                ListNode tmp = cur.next.next;//暂存第三个节点
                pre.next = cur.next;//步骤一
                cur.next.next = cur;//步骤二
                cur.next = tmp;//步骤三
                pre = cur;
                cur = cur.next;
            }
            return dummy.next;
        }
    }
}
