/*
 * Copyright (c) 2025. 贝壳找房（北京）科技有限公司
 */
package com.feng.leetcode.hot100._07排序;

import com.feng.leetcode.hot100._03链表.ListNode;
import java.util.List;

/**
 *
 * @author fengxiaoqiang
 * @since 2025/8/12 11:20
 */
public class h148排序链表 {

    class Solution {
        // 归并排序（分治，类似于快排）
        public ListNode sortList(ListNode head) {
            // 1、找到链表的中间结点 middleNode
            // 2、重新排序head和middleNode
            // 3、合并head和middleNode
            if (head == null || head.next == null) {
                return head;
            }
            ListNode middleNode = getMiddleNode(head);
            head = sortList(head);
            middleNode = sortList(middleNode);

            // 合并刚刚断开的
            return mergeTwoListsToSort(head, middleNode);
        }

        /**
         * 找到中点节点，同时断开两半
         * 
         * @param head
         * @return
         */
        private ListNode getMiddleNode(ListNode head) {
            // 记录前一个节点，方便分割
            ListNode pre = head;
            // 通过两倍速度，来得到中点
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                pre = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            pre.next = null;
            return slow;
        }

        /**
         * 归并两个有序链表
         * 
         * @param list1
         * @param list2
         * @return
         */
        private ListNode mergeTwoListsToSort(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode();
            ListNode cur = dummy;
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    cur.next = list1;
                    list1 = list1.next;
                } else {
                    cur.next = list2;
                    list2 = list2.next;
                }
                cur = cur.next;
            }
            cur.next = list1 == null ? list2 : list1;
            return dummy.next;
        }

    }

}
