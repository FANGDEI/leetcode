package com.feng.review.链表;

import com.feng.newline.list.ListNode;

import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.list
 * @className: L24两两交换链表中的节点
 * @author: Ladidol
 * @description: 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 * 示例:输入：
 * head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * <p>
 * 解题: 可以分成三个步骤走:
 * 1. 前置节点指向后置节点,
 * 2. 后置节点指向当前节点,
 * 3. 当前节点指向后置节点的后置节点.
 * <p>
 * 可以把一次交换分成三个步骤:
 * @date: 2023年2月22日20:59:20
 * @version: 1.0
 */
public class L24两两交换链表中的节点 {

    static class L24 {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {//注意先判断存在head没有, 在判断next, 说实话这里可以直接省略的
                return head;
            }
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode pre = dummy;
            ListNode cur = head;


            while (pre.next != null && pre.next.next != null) {
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

    //画图显然
    class Solution {
        //更换当前cur和cur.next节点，注意总共有四个节点的参与
        public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode pre = dummy;
            ListNode cur = dummy.next;

            while (cur != null && cur.next != null) {
                ListNode tmp = cur.next.next;
                pre.next = cur.next;
                cur.next.next = cur;
                cur.next  = tmp;
                //维护cur和pre；
                pre = cur;
                cur = cur.next;
            }
            return dummy.next;
        }
    }


}
